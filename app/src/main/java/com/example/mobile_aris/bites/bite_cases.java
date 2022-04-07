package com.example.mobile_aris.bites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.mobile_aris.Appointments;
import com.example.mobile_aris.MainActivity;
import com.example.mobile_aris.MyannouncementRecyclerViewAdapter;
import com.example.mobile_aris.R;
import com.example.mobile_aris.announcementModel;
import com.example.mobile_aris.bite_case_file;
import com.example.mobile_aris.models.bite;
import com.example.mobile_aris.my_pets;
import com.example.mobile_aris.user_profile;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class bite_cases extends AppCompatActivity {
    RecyclerView recyclerView;
    biteAdpater biteAdpater;
    ArrayList<bite> each_bite = new ArrayList<bite>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bite_recycle);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.bitecases);
        recyclerView = findViewById(R.id.bite_recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        biteAdpater = new biteAdpater(getApplicationContext());
        recyclerView.setAdapter(biteAdpater);
        getAll();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.appointments:
                        startActivity(new Intent(getApplicationContext(), Appointments.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.bitecases:
                        return true;

                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), user_profile.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.mypets:
                        startActivity(new Intent(getApplicationContext(), my_pets.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
    public void getAll() {
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                "https://aris-backend.herokuapp.com/api/bitecase/all", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONArray data = response.getJSONArray("cases");
                    for (int i = 0; i < data.length(); i++) {
                        JSONObject jsonObject = data.getJSONObject(i);
                        JSONObject jsonObject1 = new JSONObject(jsonObject.getString("history_of_exposure"));
                        bite each = new bite(
                                jsonObject1.getString("place"),
                                jsonObject.getString("createdAt"),
                                jsonObject.getString("status_of_vaccination"),
                                jsonObject.getString("patient_status"),
                                jsonObject.getString("vaccine"),
                                jsonObject.getString("classification"),
                                jsonObject.getString("_id"),
                                Integer.parseInt(jsonObject.getString("exposure_category")),
                                Integer.parseInt(jsonObject.getString("bite_case_no")),
                                jsonObject.getString("clinic"),
                                jsonObject.getString("user")
                        );
                        each_bite.add(each);
                    }

                    biteAdpater.setmValues(each_bite);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("JSON Exception", String.valueOf(error));
            }
        }){

            //This is for Headers If You Needed
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjYyMzE2M2Q0MjU5ZDhkOTE2NTg4MTE3NiIsImlhdCI6MTY0OTI0NTIyOSwiZXhwIjoxNjQ5Njc3MjI5fQ.Ia5trMMzwuux8ioa9fYtfkFEmMGtJb4OZftvwTJCraI");
                return params;
            }
        };
        requestQueue.add(jsonObjectRequest);
    }
}
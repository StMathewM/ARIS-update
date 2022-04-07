package com.example.mobile_aris.bites;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile_aris.MyannouncementRecyclerViewAdapter;
import com.example.mobile_aris.R;
import com.example.mobile_aris.announcementModel;
import com.example.mobile_aris.databinding.FragmentItemBinding;
import com.example.mobile_aris.models.bite;

import java.util.ArrayList;

public class biteAdpater  extends RecyclerView.Adapter<biteAdpater.ViewHolder>{

    ArrayList<bite> bitemodel = new ArrayList<bite>();
    Context context;
    public biteAdpater(ArrayList<bite> items) {
        bitemodel = items;
    }



    public ArrayList<bite> getmValues() {
        return bitemodel;
    }

    public biteAdpater(Context context) {
        this.context =  context;
    }


    public void setmValues(ArrayList<bite> mValues) {
        this.bitemodel = mValues;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public biteAdpater.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bite_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull biteAdpater.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.a.setText(String.valueOf(bitemodel.get(position).getBite_case_no()));
        holder.b.setText(bitemodel.get(position).getLocation().toString());
        holder.c.setText(bitemodel.get(position).getCreatedAt().toString());
        holder.d.setText(bitemodel.get(position).getExposure_category().toString());
        holder.e.setText(bitemodel.get(position).getStatus_of_vaccination().toString());

        holder.f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BiteDetailActivity.class);
                intent.putExtra("_id", bitemodel.get(position).get_id().toString());
                intent.putExtra("user", bitemodel.get(position).getUser_id().toString());
                intent.putExtra("clinic", bitemodel.get(position).getClinic_id().toString());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bitemodel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public announcementModel mItem;
        TextView a,b,c,d,e;
        CardView f;


        public ViewHolder(@NonNull View ItemView) {
            super(ItemView);
            a = (TextView) ItemView.findViewById(R.id.bitecaseno);
            b = (TextView) ItemView.findViewById(R.id.location);
            c = (TextView) ItemView.findViewById(R.id.dater);
            d = (TextView) ItemView.findViewById(R.id.cat);
            e = (TextView) ItemView.findViewById(R.id.stat);
            f = (CardView) ItemView.findViewById(R.id.bite_card);

        }

    }
}

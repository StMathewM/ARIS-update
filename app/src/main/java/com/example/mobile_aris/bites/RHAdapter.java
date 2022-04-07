package com.example.mobile_aris.bites;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile_aris.R;
import com.example.mobile_aris.announcementModel;
import com.example.mobile_aris.models.bite;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RHAdapter extends RecyclerView.Adapter<RHAdapter.ViewHolder>{
    ArrayList<hreport> hrprt = new ArrayList<hreport>();
    Context context;
    public RHAdapter(ArrayList<hreport> items) {
        hrprt = items;
    }



    public ArrayList<hreport> getmValues() {
        return hrprt;
    }

    public RHAdapter(Context context) {
        this.context =  context;
    }


    public void setmValues(ArrayList<hreport> hrprt) {
        this.hrprt = hrprt;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RHAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.healt_card,parent,false);
        return new RHAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RHAdapter.ViewHolder holder, int position) {
        holder.a.setText(hrprt.get(position).getUsername());
        holder.b.setText(hrprt.get(position).getDescription());
        holder.c.setText(hrprt.get(position).getR_createdAt());
        holder.d.setText(hrprt.get(position).getAdmin());
        holder.e.setText(hrprt.get(position).getText());
        holder.f.setText(hrprt.get(position).getCreatedAt());
        Picasso.get().load(hrprt.get(position).getPhoto()).into(holder.g);

    }

    @Override
    public int getItemCount() {
        return hrprt.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public announcementModel mItem;
        TextView a,b,c,d,e,f;
        ImageView g;


        public ViewHolder(@NonNull View ItemView) {
            super(ItemView);
            a = (TextView) ItemView.findViewById(R.id.username);
            b = (TextView) ItemView.findViewById(R.id.desc);
            c = (TextView) ItemView.findViewById(R.id.date_hr);
            d = (TextView) ItemView.findViewById(R.id.admin);
            e = (TextView) ItemView.findViewById(R.id.text_reply);
            f = (TextView) ItemView.findViewById(R.id.createdAt);
            g = (ImageView) ItemView.findViewById(R.id.upro);
        }

    }
}

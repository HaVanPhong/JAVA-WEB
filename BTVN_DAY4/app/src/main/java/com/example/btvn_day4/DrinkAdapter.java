package com.example.btvn_day4;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DrinkAdapter extends RecyclerView.Adapter<DrinkAdapter.ViewHolder> {
    List<Drink> list;
    Context context;
    iOnClick iOnClick;
    int quantum;

    public com.example.btvn_day4.iOnClick getiOnClick() {
        return iOnClick;
    }

    public void setiOnClick(com.example.btvn_day4.iOnClick iOnClick) {
        this.iOnClick = iOnClick;
    }

    public DrinkAdapter(List<Drink> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.custom_drink, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Drink d = list.get(position);
        holder.imgAvt.setImageResource(d.getAvt());
        holder.tvName.setText(d.getName() + "");
        holder.tvCore.setText(d.getCore() + "");
        holder.tvCount.setText(d.getCount() +"");

        holder.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iOnClick.iOnClickName(d);
            }
        });
        holder.imgAvt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iOnClick.iOnClickImage(d);
            }
        });

        holder.tvTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iOnClick.iOnClickTru(d);
                holder.tvCount.setText(String.valueOf(Integer.parseInt(holder.tvCount.getText().toString()) - 1));
            }
        });
        holder.tvCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iOnClick.iOnClickCong(d);
                holder.tvCount.setText(String.valueOf(Integer.parseInt(holder.tvCount.getText().toString()) + 1));
            }
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAvt;
        TextView tvName, tvCount, tvCore, tvTru, tvCong;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvt = itemView.findViewById(R.id.imgAvt);
            tvName = itemView.findViewById(R.id.tvNameDrink);
            tvCount = itemView.findViewById(R.id.tvCount);
            tvCore = itemView.findViewById(R.id.tvCore);
            tvTru = itemView.findViewById(R.id.tvTru);
            tvCong = itemView.findViewById(R.id.tvCong);

        }
    }
}

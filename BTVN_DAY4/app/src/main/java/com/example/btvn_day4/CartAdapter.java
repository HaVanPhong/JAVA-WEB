package com.example.btvn_day4;

import android.content.Context;
import android.telecom.PhoneAccount;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    List<Drink> listCart;
    Context context;
    onClickCart onClickCart;


    public CartAdapter(List<Drink> listCart, Context context) {
        this.listCart = listCart;
        this.context = context;
    }


    public com.example.btvn_day4.onClickCart getOnClickCart() {
        return onClickCart;
    }

    public void setOnClickCart(com.example.btvn_day4.onClickCart onClickCart) {
        this.onClickCart = onClickCart;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.custom_item_cart, parent, false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }
//    mà thêm gì vào lítview á
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Drink d=listCart.get(position);
        holder.imgAvt.setImageResource(d.getAvt());
        holder.tvName.setText(d.getName()+"");
        holder.tvCore.setText(d.getCore()+"");
        holder.tvSoLuong.setText(d.getCount()+"");
        holder.lnItemCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCart.onclickCart(d);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listCart.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAvt;
        TextView tvName, tvCore, tvSoLuong;
        RelativeLayout lnItemCart;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvt=itemView.findViewById(R.id.imgAvt);
            tvName=itemView.findViewById(R.id.tvNameDrink);
            tvSoLuong=itemView.findViewById(R.id.tvSoLuong);
            tvCore=itemView.findViewById(R.id.tvCore);
            lnItemCart=itemView.findViewById(R.id.lnItemCart);


        }

    }
}

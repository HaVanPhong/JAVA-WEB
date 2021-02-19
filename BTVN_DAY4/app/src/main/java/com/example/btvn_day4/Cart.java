package com.example.btvn_day4;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart extends AppCompatActivity {
    TextView tvPriceCart;
    RecyclerView rcCart;


    Button btnOrder;

    int price;

    ImageView imgBck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        AnhXa();

        List<Drink> listCart;

        Toast.makeText(Cart.this, "Rượu bia gì hư người!", Toast.LENGTH_SHORT).show();
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Your Cart");
        actionBar.setDisplayHomeAsUpEnabled(true);
//        actionBar.hide();


        Intent intent= getIntent();
        price=intent.getIntExtra("Price", 0);
        tvPriceCart.setText(price+"");

//
//        listCart.add(new Drink(R.drawable.bia, 0, 90, "Bia Hơi"));
//        listCart.add(new Drink(R.drawable.bia, 0, 500, "Bia Hơi"));

//
        listCart= intent.getParcelableArrayListExtra( "listCart");

        CartAdapter cartAdapter=new CartAdapter(listCart, Cart.this);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(Cart.this,  RecyclerView.VERTICAL, false);
        rcCart.setLayoutManager(layoutManager);
        rcCart.setAdapter(cartAdapter);

        cartAdapter.setOnClickCart(new onClickCart() {
            @Override
            public void onclickCart(Drink drink) {
                Toast.makeText(Cart.this, drink.getName()+"\nSố lượng: "+drink.getCount()+"\nTổng tiền: "+drink.getCount()*drink.getCore()+"$", Toast.LENGTH_SHORT).show();
            }
        });
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Cart.this, "Đặt hàng thành công !", Toast.LENGTH_SHORT).show();
                listCart.removeAll(listCart);
                CartAdapter cartAdapter=new CartAdapter(listCart, Cart.this);
                RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(Cart.this,  RecyclerView.VERTICAL, false);
                rcCart.setLayoutManager(layoutManager);
                rcCart.setAdapter(cartAdapter);
                price=0;
                tvPriceCart.setText(price+"");
                Intent intent1=new Intent(Cart.this, MainActivity.class);
                intent1.putExtra("Price", price);
                intent1.putParcelableArrayListExtra("listCard", (ArrayList<? extends Parcelable>) listCart);
//                startActivity(intent1);

            }
        });
//        imgBck.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent1=new Intent(Cart.this, MainActivity.class);
//                startActivity(intent1);
//            }
//        });


    }
    public void AnhXa(){
        tvPriceCart=findViewById(R.id.tvPriceCart);
        rcCart=findViewById(R.id.rcCart);
        btnOrder=findViewById(R.id.btnOrder);
//        imgBck=findViewById(R.id.imgBck) ;
    }
}
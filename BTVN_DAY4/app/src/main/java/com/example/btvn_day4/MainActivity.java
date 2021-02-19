package com.example.btvn_day4;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.telecom.PhoneAccountHandle;
import android.view.View;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycleView;


    TextView tvTatolCount, tvPrice;
    //    TextView tvCount;
    int monney = 0;
    TextView edtName;

    int cart = 0;

    ImageView imgCart;

    List<Drink> list = new ArrayList<>();

    List<Drink> listCart = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();

        Intent intent = getIntent();
        String user = intent.getStringExtra("User");
        boolean checkLogin = intent.getBooleanExtra("checkLogin", false);
        if (checkLogin)
            Toast.makeText(MainActivity.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
        edtName.setText(user);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        list.add(new Drink(R.drawable.bia, 100, "Bia Chai"));
        list.add(new Drink(R.mipmap.ruoudua, 120, "Rượu Dừa"));
        list.add(new Drink(R.mipmap.strongbow, 160, "StrongBow"));
        list.add(new Drink(R.mipmap.biacorona, 130, "Bia Corona"));
        list.add(new Drink(R.mipmap.ipa, 160, "Bia IPA"));
        list.add(new Drink(R.mipmap.ruouremymatri, 150, "Rượu Matri"));
        list.add(new Drink(R.mipmap.nencoc, 110, "Cốc bia tươi"));
        list.add(new Drink(R.mipmap.nengai, 90, "Mỹ Nhân Tửu"));
        list.add(new Drink(R.mipmap.nene, 500, "Bia Bom"));



        DrinkAdapter drinkAdapter = new DrinkAdapter(list, MainActivity.this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
        recycleView.setLayoutManager(layoutManager);
        recycleView.setAdapter(drinkAdapter);

        drinkAdapter.setiOnClick(new iOnClick() {
            @Override
            public void iOnClickImage(Drink drink) {
                Toast.makeText(MainActivity.this, drink.getAvt(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void iOnClickName(Drink drink) {
                Toast.makeText(MainActivity.this, drink.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void iOnClickTru(Drink drink) {
                //tính tổng tiền
                monney -= drink.getCore();
                tvPrice.setText(monney + "");
                //tính số loại hàng
                drink.setCount(drink.getCount() - 1);
                if (drink.getCount() < 1) {
                    cart -= 1;
                    listCart.remove(listCart.size() - 1);
                }
                tvTatolCount.setText(cart + "");

                Toast.makeText(MainActivity.this, "Bạn vừa bỏ 1 " + drink.getName() + " ra khỏi giỏ hàng\nSố lượng: " + drink.getCount() + "\nTổng tiền: " + drink.getCount() * drink.getCore() + "$", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void iOnClickCong(Drink drink) {
                //tính tổng tiền
                monney += drink.getCore();
                tvPrice.setText(monney + "");
                //tính số loại hàng

                drink.setCount(drink.getCount() + 1);
                if (drink.getCount() == 1) {
                    cart += 1;
                    listCart.add(drink);
                } else if (drink.getCount() < 1) {
                    cart -= 1;
                }

                tvTatolCount.setText(cart + "");
                Toast.makeText(MainActivity.this, "Bạn vừa thêm " + drink.getName() + " vào giỏ hàng\nSố lượng: " + drink.getCount() + "\nTổng tiền: " + drink.getCount() * drink.getCore() + "$", Toast.LENGTH_SHORT).show();

            }


        });

        imgCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, Cart.class);

                intent1.putExtra("Price", monney);
                intent1.putParcelableArrayListExtra("listCart", (ArrayList<? extends Parcelable>) listCart);
                startActivity(intent1);

            }
        });


    }

    public void AnhXa() {
        recycleView = findViewById(R.id.recycleView);
        edtName = findViewById(R.id.edtName);
        tvTatolCount = findViewById(R.id.tvTatalCount);
        tvPrice = findViewById(R.id.tvPrice);
        imgCart = findViewById(R.id.imgCart);

    }


}
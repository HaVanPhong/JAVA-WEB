package com.example.btvn_day4;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login extends AppCompatActivity {
    EditText edtUsername, edtPassword;
    Button btnLogin;
    CheckBox checked;
    String user, pass;
    boolean checkLogin=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        //bỏ thanh status
        int uiOptions= View.SYSTEM_UI_FLAG_FULLSCREEN;
        View decorView=getWindow().getDecorView();
        decorView.setSystemUiVisibility(uiOptions);

        AnhXa();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user=edtUsername.getText().toString();
                pass=edtPassword.getText().toString();
//                String regexUser ="[a-zA-Z0-9_-]{6,12}$";
//                if (user.matches(regexUser)==false){
//                    Toast.makeText(Login.this, "UserName cần: có 6-12 kí tự, không có khoảng trắng và Không có dấu", Toast.LENGTH_SHORT).show();
//                }
                boolean check=false;
                if (pass.length()<6){
                    Toast.makeText(Login.this, "Mật khẩu cần có trên 6 kí tự", Toast.LENGTH_SHORT).show();
                }else
                if (!pass.matches(".*[A-Z].*")){
                    Toast.makeText(Login.this, "Mật khẩu cần có ít nhất 1 kí tự in hoa", Toast.LENGTH_SHORT).show();
                }
                else{
                    check=true;
                }

                Intent intent=new Intent(Login.this, MainActivity.class);
                intent.putExtra("User", user);
                intent.putExtra("checkLogin", checkLogin);
                if (check) startActivity(intent);



            }
        });



    }
    public  void AnhXa(){
        edtUsername=findViewById(R.id.edtUsername);
        edtPassword=findViewById(R.id.edtPassword);
        btnLogin=findViewById(R.id.btnLogin);
        checked=findViewById(R.id.checked);
    }
}
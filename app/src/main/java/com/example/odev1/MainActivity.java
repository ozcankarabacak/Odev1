package com.example.odev1;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);



    }
    public void on_button_click(View v){
        EditText user_name = (EditText)findViewById(R.id.user_name);
        EditText pw = (EditText)findViewById(R.id.password);
        Button loginBtn = (Button)findViewById(R.id.login);
        if(user_name.getText().toString().equals("admin") && pw.getText().toString().equals("password")) {
            Intent i = new Intent(MainActivity.this, SignIn.class);
            startActivity(i);
        }else{
            Toast.makeText(v.getContext(), "Kullanıcı adı ya da şifre hatalı!", Toast.LENGTH_LONG).show();
        }
    }


}

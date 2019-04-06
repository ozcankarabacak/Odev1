package com.example.odev1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowInfoPerson extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info_person);
        Intent i = getIntent();
        ((TextView)findViewById(R.id.person_info)).setText(i.getStringExtra("person_info"));



    }
}

package com.example.odev1;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Calendar;

public class SignIn extends Activity {

    private EditText ad;
    private EditText soyad;
    private EditText dYeri ;
    private EditText dTarihi;
    private EditText tel;
    private EditText email;
    private EditText tc;
    private Button kaydet;
    private Button sil;
    ImageView resim;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bdate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Calendar c = Calendar.getInstance();
                final int day = c.get(Calendar.DAY_OF_MONTH);
                final int month = c.get(Calendar.MONTH);
                final int year = c.get(Calendar.YEAR);

                final DatePickerDialog dpd = new DatePickerDialog(SignIn.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int bYear, int bMonth, int bDay) {
                        bMonth += 1;
                        String bDate = String.format("%02d/%02d/%d", bDay, bMonth, bYear);
                        ((EditText) findViewById(R.id.bdate)).setText(bDate);
                    }
                }, year, month, day);
                dpd.show();
            }
        });
        ad = (EditText)findViewById(R.id.name);
        soyad = (EditText)findViewById(R.id.surname);
        dYeri = (EditText)findViewById(R.id.place);
        dTarihi = (EditText)findViewById(R.id.bdate);
        tel = (EditText)findViewById(R.id.tel);
        email = (EditText)findViewById(R.id.email);
        tc = (EditText)findViewById(R.id.ssn);
        kaydet = (Button)findViewById(R.id.saveBtn);
        sil = (Button)findViewById(R.id.deleteBtn);

        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (((EditText) findViewById(R.id.ssn)).getText().toString().length() < 11) {
                    Toast.makeText(v.getContext(), "TC No 11 haneden oluşmalıdır!", Toast.LENGTH_LONG).show();
                }else{
                    Intent i = new Intent(SignIn.this, ShowInfoPerson.class);
                    String pInfo = String.format("Ad: %s\nSoyad: %s\nDoğum Yeri: %s\nDoğum Tarihi: %s\nTelefon: %s\nE-mail: %s\nTC: %s", ad.getText().toString(), soyad.getText(),
                            dYeri.getText(), dTarihi.getText(), tel.getText(), email.getText(), tc.getText());
                    i.putExtra("person_info", pInfo);
                    i.putExtra("person_tel", tel.getText().toString());
                    startActivity(i);
                }
            }
        });
        sil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ad.setText("");
                soyad.setText("");
                dYeri.setText("");
                dTarihi.setText("");
                tel.setText("");
                email.setText("");

            }
        });
    }
}

package com.example.apoorva.niscair;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
public class form extends AppCompatActivity {
    EditText e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e15, e16, e17, e19, e20, e21, e23, e24, e25;
    RadioButton rb1, rb2;
    Button btnAgree;
    LoginDataBaseAdapter ldata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_form);
        getIntent();

        ldata = new LoginDataBaseAdapter(this);
        ldata = ldata.open();
        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e1);
        e3 = (EditText) findViewById(R.id.e1);
        e4 = (EditText) findViewById(R.id.e1);
        e5 = (EditText) findViewById(R.id.e1);
        e6 = (EditText) findViewById(R.id.e1);
        e7 = (EditText) findViewById(R.id.e1);
        e8 = (EditText) findViewById(R.id.e1);
        e9 = (EditText) findViewById(R.id.e1);
        e10 = (EditText) findViewById(R.id.e1);
        e11 = (EditText) findViewById(R.id.e1);
        e12 = (EditText) findViewById(R.id.e1);
        e13 = (EditText) findViewById(R.id.e1);

        e15 = (EditText) findViewById(R.id.e1);
        e16 = (EditText) findViewById(R.id.e1);
        e17 = (EditText) findViewById(R.id.e1);

        e19 = (EditText) findViewById(R.id.e1);
        e20 = (EditText) findViewById(R.id.e1);
        e21 = (EditText) findViewById(R.id.e1);

        e23 = (EditText) findViewById(R.id.e1);
        e24 = (EditText) findViewById(R.id.e1);
        e25 = (EditText) findViewById(R.id.e1);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        btnAgree = (Button) findViewById(R.id.buttonAgree);
        btnAgree.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String title = e1.getText().toString();
                String dates = e2.getText().toString();
                String name = e3.getText().toString();
                String add1 = e4.getText().toString();
                String add2 = e5.getText().toString();
                String add3 = e6.getText().toString();
                String pin = e7.getText().toString();
                String email_add = e8.getText().toString();
                String mobile = e9.getText().toString();
                String telephone = e10.getText().toString();
                String deg1 = e11.getText().toString();
                String uni1 = e15.getText().toString();
                String y1 = e19.getText().toString();
                String deg2 = e12.getText().toString();
                String uni2 = e16.getText().toString();
                String y2 = e20.getText().toString();
                String deg3 = e13.getText().toString();
                String uni3 = e17.getText().toString();
                String y3 = e21.getText().toString();
                String spons_add = e23.getText().toString();
                String pre_desi = e24.getText().toString();
                String pre_period = e25.getText().toString();
                ldata.insertEntry1(title, dates, name, add1, add2, add3, pin, email_add, mobile, telephone, deg1, uni1, y1, deg2, uni2, y2, deg3, uni3, y3, spons_add, pre_desi, pre_period);
                Toast.makeText(getApplicationContext(), "Details Submitted", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), userhome.class);
                startActivity(i);
            }
        });
    }

        @Override
        protected void onDestroy()
        {
            super.onDestroy();
            ldata.close();
        }
}


package com.example.apoorva.niscair;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.apoorva.niscair.R.id.e1;

public class payment extends AppCompatActivity {
    EditText e2, e3, e4, e5;
    Button btnPay;
    LoginDataBaseAdapter ldata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_payment);
        getIntent();

        ldata = new LoginDataBaseAdapter(this);
        ldata = ldata.open();
        e2 = (EditText)findViewById(R.id.editText2);
        e3 = (EditText)findViewById(R.id.editText3);
        e4 = (EditText)findViewById(R.id.editText4);
        e5 = (EditText)findViewById(R.id.editText5);
        btnPay = (Button)findViewById(R.id.buttonPay);
        btnPay.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                String utr = e2.getText().toString();
                String date = e3.getText().toString();
                String amnt = e4.getText().toString();
                String place = e5.getText().toString();
                ldata.insertEntry2(utr,date,amnt,place);
                Toast.makeText(getApplicationContext(),"Details Submitted",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(),userhome.class);
                startActivity(i);
            }
        });
    }
    }

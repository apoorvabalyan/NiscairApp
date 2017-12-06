package com.example.apoorva.niscair;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class userhome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_userhome);
        getIntent();
    }
    public void infoHowApplyMethod(View view)
    {
        Intent intent = new Intent(this,form.class);
        startActivity(intent);
    }
    public void paymentMethod(View view)
    {
        Intent intent = new Intent(this,payment.class);
        startActivity(intent);
    }
    public void mainRedirectMethod(View view)
    {
        Intent intent = new Intent(this,homeScreen.class);
        startActivity(intent);
    }
}

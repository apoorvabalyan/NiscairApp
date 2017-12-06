package com.example.apoorva.niscair;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class homeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home_screen);
        getIntent();
    }
    public void aboutMethod(View view)
    {
        Intent intent = new Intent(this,about.class);
        startActivity(intent);
    }
    public void contactMethod(View view)
    {
        Intent intent = new Intent(this,contact.class);
        startActivity(intent);
    }
    public void courseMethod(View view)
    {
        Intent intent = new Intent(this,course.class);
        startActivity(intent);
    }
    public void loginMethod(View view)
    {
        Intent intent = new Intent(this,alreadyregister.class);
        startActivity(intent);
    }
}

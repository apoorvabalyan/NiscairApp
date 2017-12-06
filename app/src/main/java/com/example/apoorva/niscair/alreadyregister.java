package com.example.apoorva.niscair;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class alreadyregister extends AppCompatActivity {
    Button loginBtn;
    EditText emailEdit,passEdit;
    LoginDataBaseAdapter ldata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_alreadyregister);
        getIntent();
        ldata = new LoginDataBaseAdapter(this);
        ldata = ldata.open();
        //Get references of Buttons and Edittexts
        loginBtn = (Button)findViewById(R.id.button);
        emailEdit = (EditText)findViewById(R.id.edit1);
        passEdit = (EditText)findViewById(R.id.edit2);
        loginBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
               String email = emailEdit.getText().toString();
               String pass = passEdit.getText().toString();
                //Fetch the data from the database
                String storedPass = ldata.getSingleEntry(email);
                if(pass.equals(storedPass))
                {
                    Toast.makeText(getApplicationContext(),"Login Successfull!!",Toast.LENGTH_SHORT).show();
                    userhomeMethod(v);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Wrong Credentials",Toast.LENGTH_LONG).show();
                    return;
                }
            }
        });
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        ldata.close();
    }
    public void forgetMethod(View view)
    {
        Intent intent = new Intent(this,forget.class);
        startActivity(intent);
    }
    public void userhomeMethod(View view)
    {
        Intent intent = new Intent(this,userhome.class);
        startActivity(intent);
    }
}

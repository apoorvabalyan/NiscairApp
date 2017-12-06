package com.example.apoorva.niscair;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class newuser extends AppCompatActivity {
    EditText emailEdit,passEdit,confirmPassEdit;
    Button createAccount;
    LoginDataBaseAdapter ldata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_newuser);
        getIntent();
        //Get the instance of database adapter
        ldata = new LoginDataBaseAdapter(this);
        ldata = ldata.open();
        //Get the data from edittexts
        emailEdit = (EditText)findViewById(R.id.edit1);
        passEdit = (EditText)findViewById(R.id.edit2);
        confirmPassEdit = (EditText)findViewById(R.id.edit3);
        createAccount = (Button)findViewById(R.id.button);
        createAccount.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
              String email = emailEdit.getText().toString();
              String pass = passEdit.getText().toString();
              String confirmPass = confirmPassEdit.getText().toString();
                //Check whether any field is vacant
                if(email.equals("")||pass.equals("")||confirmPass.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"One or More Field Vacant",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!pass.equals(confirmPass))
                {
                    Toast.makeText(getApplicationContext(),"Password does not match",Toast.LENGTH_LONG).show();
                    return;
                }
                else
                {
                    //Save data in the database
                    ldata.insertEntry(email,pass);
                    Toast.makeText(getApplicationContext(),"Account Successfully Created!!",Toast.LENGTH_LONG).show();
                    userhomeMethod(v);
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
    public void userhomeMethod(View view)
    {
        Intent intent = new Intent(this,userhome.class);
        startActivity(intent);
    }
}

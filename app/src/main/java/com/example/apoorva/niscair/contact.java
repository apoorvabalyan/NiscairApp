package com.example.apoorva.niscair;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

public class contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_contact);
        getIntent();
        TextView text1 =(TextView)findViewById(R.id.contact1);
        text1.setText("Pusa Campus\n\n" +
                "                          CSIR-NISCAIR\n" +
                "                          Dr. K S Krishnan Marg\n" +
                "                          Pusa Campus\n" +
                "                          New Delhi 110 012\n" +
                "                          Ph.: +91-11-25846301,\n" +
                "                          25846304-7, 25842303,\n" +
                "                          25842990\n" +
                "                          Fax:+91-11-25847062");
        TextView text2 =(TextView)findViewById(R.id.contact2);
        text2.setText("S V Marg Campus\n\n" +
                "                          CSIR-NISCAIR\n" +
                "                          14 Satsang Vihar Marg\n" +
                "                          Spl. Institutional Area\n" +
                "                          New Delhi 110 067\n" +
                "                          Ph.: +91-11-26560141,\n"+
                "                          26560143, 26560165,\n" +
                "                          26560189\n" +
                "                          Fax:+91-11-26862228 ");

    }

}

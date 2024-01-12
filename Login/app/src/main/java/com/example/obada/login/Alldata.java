package com.example.obada.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Alldata extends AppCompatActivity {
ArrayList <clent>all;
TextView t2;
TextView t4;
TextView t6;
TextView t8;
TextView t10;
TextView t12;
String Username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alldata);
        t2=(TextView)findViewById(R.id.t2);
        t4=(TextView)findViewById(R.id.t4);
        t6=(TextView)findViewById(R.id.t6);
        t8=(TextView)findViewById(R.id.t8);
        t10=(TextView)findViewById(R.id.t10);
        t12=(TextView)findViewById(R.id.t12);
        Bundle b=getIntent().getExtras();
      Username=b.getString("username");
        Data db=new Data(this);
        all=db.getalldata();
        for(clent c:all)
        {

            if(c.username.equals(Username))
            {   Toast.makeText(Alldata.this, "obada",Toast.LENGTH_LONG).show();
                t2.setText(Username);
                t4.setText(c.email);
                t6.setText(c.password);
                t8.setText(c.country);
                t10.setText(c.type);
                t12.setText(c.age);

            }
        }
    }
}

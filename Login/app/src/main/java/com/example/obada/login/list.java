package com.example.obada.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class list extends AppCompatActivity {
ListView list;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_list,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
       String username= getIntent().getStringExtra("username");
       Toast.makeText(this,username,Toast.LENGTH_LONG).show();
        setTitle(username);
        Data db=new Data(this);
        list=(ListView)findViewById(R.id.li);
       ArrayList<String> arrayList=db.getdata();
       list.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayList));
       list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
           @Override
           public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
               Intent I=new Intent(list.this,Alldata.class);
               Bundle b=new Bundle();
               b.putString("username", (String) parent.getItemAtPosition(position));
               I.putExtras(b);
               startActivity(I);
               return false;
           }
       });
       list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Bundle b=new Bundle();
               b.putString("username_clent",(String) parent.getItemAtPosition(position));
               Intent I=new Intent(list.this,send_Rom.class);
               I.putExtras(b);
               startActivity(I);
           }
       });

    }
long back;
    @Override
    public void onBackPressed() {

        if(back+2000>System.currentTimeMillis()) {
            moveTaskToBack(true);
            android.os.Process.killProcess( android.os.Process.myPid());
            System.exit(1);
           // super.onBackPressed();
        }else
        {
            Toast.makeText(list.this,"Press Back Again to Exit..",Toast.LENGTH_LONG).show();
        }
        back=System.currentTimeMillis();
    }

    public void logout(MenuItem item) throws IOException {
        FileOutputStream fos=this.openFileOutput("Regester.txt",this.MODE_PRIVATE);
        String obada="";
        byte b[]=obada.getBytes();
        fos.write(b);
        fos.flush();
        fos.close();
        Intent I=new Intent(list.this,MainActivity.class);
        startActivity(I);
    }

}

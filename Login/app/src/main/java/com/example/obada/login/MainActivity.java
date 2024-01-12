package com.example.obada.login;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    CheckBox remamber;
    String username;
    ArrayList <String>search_username;
    ArrayList <Integer>search_password;
    LinearLayout linearLayout;
ProgressBar progressBar ;
    EditText e1;
    EditText e2;
    boolean yes1=false,yes2=false;
    int j=0;
    boolean b=false;
    Bundle bundle=new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        try {
            FileInputStream fis=this.openFileInput("Regester.txt");
            String obada="";
            while ((j=fis.read())!=-1)
            {
                obada=obada+String.valueOf((char)j);
            }
             fis.close();
            if (!obada.equals(""))
                b=true;
            Toast.makeText(this,obada+"",Toast.LENGTH_LONG).show();
              username=obada;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false); //optional
        getSupportActionBar().setTitle("Chat");
        getSupportActionBar().setSubtitle("obada and abd");
        getSupportActionBar().setIcon(R.drawable.u);
        Data db = new Data(this);
            search_username = db.getdata();
            search_password = db.getdatapassword();
            linearLayout = (LinearLayout) findViewById(R.id.linaer);
            progressBar = (ProgressBar) findViewById(R.id.progress);
            e1 = (EditText) findViewById(R.id.ett1);
            e2 = (EditText) findViewById(R.id.ett2);
            remamber=(CheckBox)findViewById(R.id.re);
            progressBar.setVisibility(View.INVISIBLE);
if(b==true)
{
    Intent I=new Intent(this,list.class);
    bundle.putString("username",username);
    I.putExtras(bundle);
    startActivity(I);
}

    }

    public void Log(View view) {
        linearLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }
    public void log_1(View view) throws InterruptedException, IOException {
        progressBar.setVisibility(View.VISIBLE);
        Thread.sleep(3000);
        if (e1.getText().toString().trim().length() == 0)
        {
            Toast.makeText(MainActivity.this,"Enter Your UserName Pleas ..",Toast.LENGTH_LONG).show();
        }
        else if (e2.getText().toString().trim().length() == 0)
        {
            Toast.makeText(MainActivity.this,"Enter Your Password Pleas ..",Toast.LENGTH_LONG).show();
        }
        else if(Valideuser()==false)
        {
            progressBar.setVisibility(View.INVISIBLE);
            Toast.makeText(MainActivity.this,"Check Your Username Pleas..it is Unacceptable",Toast.LENGTH_LONG).show();
        }
        else {
            progressBar.setVisibility(View.VISIBLE);

           for (String name :search_username)
           {
               if(name.equals(e1.getText().toString()))
               {
                   yes1=true;
               }
           }
               for (Integer pass : search_password) {

                   if (pass.equals(Integer.parseInt(e2.getText().toString()))) {
                       yes2 = true;
                   }
               }

           if(yes1==true) {
               if(yes2==true) {

                   Intent I = new Intent(MainActivity.this, list.class);
                   bundle.putString("username",e1.getText().toString());
                   I.putExtras(bundle);
                   startActivity(I);
                   yes2=false;
                   if(remamber.isChecked()) {
                   writfile();}

               }
               else
               {
                   progressBar.setVisibility(View.INVISIBLE);
                   Toast.makeText(MainActivity.this,"Check The Password",Toast.LENGTH_LONG).show();
               }
               yes1=false;
           }
           else
           {        progressBar.setVisibility(View.INVISIBLE);
               Toast.makeText(MainActivity.this,"Check The Username",Toast.LENGTH_LONG).show();
           }
           e1.setText("");
           e2.setText("");
        }


    }

    public void Creat(View view) {
        Intent I=new Intent(MainActivity.this,Creat.class);
        startActivity(I);
    }

    public void delete(MenuItem item) {
     Data db=new Data(this);
     db.deleteAll();
        search_username = db.getdata();
        search_password = db.getdatapassword();
    }
    public boolean Valideuser()
    {
        String pat="^(([A-Za-z_-]+[0-9]+)|([A-Za-z_-]+))$";
        Pattern pattern=Pattern.compile(pat);
        Matcher matcher=pattern.matcher(e1.getText().toString());
        if(matcher.matches())
        {
            return  true;
        }
        else return false;
    }
    public void writfile() throws IOException {
        FileOutputStream fos=this.openFileOutput("Regester.txt",this.MODE_PRIVATE);
        String obada=e1.getText().toString();
        byte b[]=obada.getBytes();
        fos.write(b);
        fos.flush();
        fos.close();
    }

}

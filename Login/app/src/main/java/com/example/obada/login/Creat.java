package com.example.obada.login;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Creat extends AppCompatActivity {
    clent cl;
    Data db;
    private static final int PICK_IMAGE=100;
    EditText e1;
    EditText e2;
    EditText e3;
    RadioButton r1;
    RadioButton r2;
    ImageView image;
    Uri im;
    ArrayList<Integer> arrayage=new ArrayList<Integer>();
    ArrayList<String> arraycountry=new ArrayList<String>();
    String []count;
    Spinner spinnerage;
    Spinner spinnercountry;
    Intent gallary;
    CheckBox remamber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat);
         db=new Data(this);
        cl=new clent();
        gallary = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        remamber=(CheckBox)findViewById(R.id.ch);
        e1=(EditText)findViewById(R.id.et1);
        e2=(EditText)findViewById(R.id.et2);
        e3=(EditText) findViewById(R.id.et3);
        r1=(RadioButton)findViewById(R.id.rb1);
        r2=(RadioButton)findViewById(R.id.rb2);
        spinnerage=(Spinner)findViewById(R.id.sp);
        spinnercountry=(Spinner)findViewById(R.id.sp1);
        image=(ImageView) findViewById(R.id.img);
        for(int i=5;i<=60;i++)
        {
            arrayage.add(i);
        }
        ArrayAdapter<Integer> arrad=new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item,arrayage);
        arrad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerage.setAdapter(arrad);
count= new String[]{"Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegowina", "Botswana", "Bouvet Island", "Brazil", "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo", "Costa Rica", "Cote d'Ivoire", "Croatia (Hrvatska)", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", "Finland", "France", "France Metropolitan", "French Guiana", "French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Heard and Mc Donald Islands", "Holy See (Vatican City State)", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran (Islamic Republic of)", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea, Democratic People's Republic of", "Korea, Republic of", "Kuwait", "Kyrgyzstan", "Lao, People's Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libyan Arab Jamahiriya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia, The Former Yugoslav Republic of", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia, Federated States of", "Moldova, Republic of", "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn", "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russian Federation", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Seychelles", "Sierra Leone", "Singapore", "Slovakia (Slovak Republic)", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Georgia and the South Sandwich Islands", "Spain", "Sri Lanka", "St. Helena", "St. Pierre and Miquelon", "Sudan", "Suriname", "Svalbard and Jan Mayen Islands", "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan, Province of China", "Tajikistan", "Tanzania, United Republic of", "Thailand", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "United States Minor Outlying Islands", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Virgin Islands (British)", "Virgin Islands (U.S.)", "Wallis and Futuna Islands", "Western Sahara", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe"};
        for(String i : count)
        {
            arraycountry.add(i);
        }
ArrayAdapter<String> arrad1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,arraycountry);
        arrad1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnercountry.setAdapter(arrad1);
image.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        OpenGallary();
    }
});
    }
    private void  OpenGallary() {
        startActivityForResult(gallary, PICK_IMAGE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK&&requestCode==PICK_IMAGE)
        {
            im=data.getData();
            image.setImageURI(im);
        }
    }
    public void Creat(View view) throws IOException {
        if (e1.getText().toString().trim().length() == 0)
        {
            Toast.makeText(Creat.this,"Enter Your Email Pleas ..",Toast.LENGTH_LONG).show();
        }
       else if (e2.getText().toString().trim().length() == 0)
        {
            Toast.makeText(Creat.this,"Enter Your UserName Pleas ..",Toast.LENGTH_LONG).show();
        }
      else   if (e3.getText().toString().trim().length() == 0)
        {
            Toast.makeText(Creat.this,"Enter Your Password Pleas ..",Toast.LENGTH_LONG).show();
        }
       else if(!r1.isChecked()&&!r2.isChecked())
        {
            Toast.makeText(Creat.this,"Checked You are male or female ..",Toast.LENGTH_LONG).show();
        }
      else   if(spinnerage.getSelectedItem() ==null)
        {
            Toast.makeText(Creat.this,"Selected Your Age ..",Toast.LENGTH_LONG).show();
        }
      else   if(spinnercountry.getSelectedItem() ==null)
        {
            Toast.makeText(Creat.this,"Selected Your Country ..",Toast.LENGTH_LONG).show();
        }
        else if(Validemail()==false)
        {
            Toast.makeText(Creat.this,"Check Your Email Pleas..it is Not Right",Toast.LENGTH_LONG).show();
        }
        else if(Valideuser()==false)
        {
            Toast.makeText(Creat.this,"Check Your Username Pleas..it is Unacceptable",Toast.LENGTH_LONG).show();
        }
        else
        {
            cl.username=e2.getText().toString();
            cl.password=Integer.parseInt(e3.getText().toString());
            cl.age= (int) spinnerage.getSelectedItem();
            cl.country= spinnercountry.getSelectedItem().toString();
            cl.email=e1.getText().toString();
            if(r1.isChecked())
                cl.type="Male";
            else if(r2.isChecked())
                cl.type="Female";
            db.insertrow(cl);
      if(remamber.isChecked()) {
          writfile();
          Intent I = new Intent(Creat.this, MainActivity.class);
          startActivity(I);
      }else
      {
          Intent I = new Intent(Creat.this, list.class);
          Bundle b=new Bundle();
          b.putString("username",e2.getText().toString());
          I.putExtras(b);
          startActivity(I);
      }
            finish();
        }
    }
    public boolean Validemail()
    {
        String pat="^(([A-Za-z_-]+[0-9][0-9][0-9])|([A-Za-z_-]+))@(hotmail|gmail|yahoo)\\.com$";
        Pattern pattern=Pattern.compile(pat);
        Matcher matcher=pattern.matcher(e1.getText().toString());
        if(matcher.matches())
        {
            return  true;
        }
        else return false;
    }
    public boolean Valideuser()
    {
        String pat="^(([A-Za-z_-]+[0-9]+)|([A-Za-z_-]+))$";
        Pattern pattern=Pattern.compile(pat);
        Matcher matcher=pattern.matcher(e2.getText().toString());
        if(matcher.matches())
        {
            return  true;
        }
        else return false;
    }
   public void writfile() throws IOException {
       FileOutputStream fos=this.openFileOutput("Regester.txt",this.MODE_PRIVATE);
       String obada=e2.getText().toString();
       byte b[]=obada.getBytes();
       fos.write(b);
       fos.flush();
       fos.close();
   }
}

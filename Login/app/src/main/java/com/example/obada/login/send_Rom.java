package com.example.obada.login;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.CalendarContract;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.MediaController;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import java.util.ArrayList;
public class send_Rom extends AppCompatActivity {
    String username;
    MultiAutoCompleteTextView text_send;
    LinearLayout Linear_chat;
    Intent gallary;
    Button image;
    Uri im;
    Uri ve;
    String path=null;
    String path_audio=null;
    private static final int PICK_IMAGE=1;
    private static final int  REQUEST_CAMERA=111;
    ArrayList<Button> buttonplay=new ArrayList<Button>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send__rom);
        text_send=(MultiAutoCompleteTextView)findViewById(R.id.ts1);
        Linear_chat=(LinearLayout)findViewById(R.id.Linear_chat);
        image=(Button)findViewById(R.id.photo);
         username=getIntent().getStringExtra("username_clent");
        setTitle(username);
    }

    public void send(View view) {
      edit_TextView();
    }
    public void edit_TextView()
    {
        TextView t=new TextView(this);
        t.setText(text_send.getText().toString());
        t.setTextSize(24);
        t.setBackgroundResource(R.drawable.rounded_orang);
        t.setPadding(15,15,20,15);
        t.setLayoutParams(
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(10,10,10,10);
        t.setLayoutParams(params);
        t.setTypeface(t.getTypeface(),Typeface.BOLD_ITALIC);
        Linear_chat.addView(t);
    }

    public void send_Photo(View view) {
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenGallary();
            }
        });

    }
    private void  OpenGallary() {
        /*AlertDialog.Builder builder = new AlertDialog.Builder(send_Rom.this);
        builder.setTitle("Add Photo!");

        builder.setCancelable(true);
        builder.se;
*/
        AlertDialog.Builder builder = new AlertDialog.Builder(send_Rom.this);
        builder.setItems(new CharSequence[]
                        {"Image", "Camera", "Video","Audio","Documents "},
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        switch (which) {
                            case 0:
                                gallary = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                                startActivityForResult(gallary, PICK_IMAGE);
                                break;
                            case 1:
                                gallary = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(gallary, REQUEST_CAMERA);

                                break;
                            case 2:
                                gallary = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.INTERNAL_CONTENT_URI);
                                startActivityForResult(gallary, PICK_IMAGE);
                                break;
                            case 3:
                                 gallary = new Intent(Intent.ACTION_GET_CONTENT);
                                gallary.setType("audio/*");
                                startActivityForResult(gallary, PICK_IMAGE);
                                break;
                            case 4:
                                 gallary = new Intent(Intent.ACTION_GET_CONTENT);
                                gallary.setType("application/pdf");
                                startActivityForResult(gallary, PICK_IMAGE);
                                break;


                        }
                    }
                });
        builder.create().show();


    }
    @SuppressLint("ResourceType")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK&&requestCode==PICK_IMAGE)
        {

            Uri Uri = data.getData();
            if (Uri.toString().contains("image")) {
                Toast.makeText(send_Rom.this,"image",Toast.LENGTH_LONG).show();
                im=data.getData();
                ImageView I=new ImageView(this);
                I.setImageURI(im);
                I.setPadding(15,15,20,15);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                params.setMargins(10,10,10,10);
                I.setLayoutParams(params);
                Linear_chat.addView(I);
            } else  if (Uri.toString().contains("video")) {///مـــشــكلة
                Toast.makeText(send_Rom.this,"vedio",Toast.LENGTH_LONG).show();
            final VideoView vid=new VideoView(this);
                 try
                {
                    String path = data.getData().toString();
                    vid.setVideoPath(path);
                    vid.setVisibility(1);
                    FrameLayout.LayoutParams f= new FrameLayout.LayoutParams(550, 700);
                    vid.setLayoutParams(f);

                }
            catch(Exception ex)
                {
                    ex.printStackTrace();
                }
                 final Button play=new Button(this);
                 final Button reload=new Button(this);
                 if(!buttonplay.isEmpty())
                for (Button b:buttonplay)
                {
                 b.setBackgroundResource(R.drawable.play2);
                }
                buttonplay.add(play);
                 reload.setBackgroundResource(R.drawable.restart);
                 LinearLayout track=new LinearLayout(this);
                LinearLayout video_Button=new LinearLayout(this);

                vid.setId(1);
                video_Button.addView(vid);
                FrameLayout.LayoutParams f= new FrameLayout.LayoutParams(80,80);
                f.leftMargin=190;
                f.rightMargin=20;
                FrameLayout.LayoutParams f1= new FrameLayout.LayoutParams(80,80);
                f1.rightMargin=200;
                f1.leftMargin=20;
                play.setLayoutParams(f);
                reload.setLayoutParams(f1);
                 track .addView(play);
                 track.addView(reload);
                 track.setBackgroundColor(R.color.colorAccent);
                 track.setOrientation(LinearLayout.HORIZONTAL);
                 track.setLayoutParams(new FrameLayout.LayoutParams(550, ViewGroup.LayoutParams.WRAP_CONTENT));
                 LinearLayout linearLayout=new LinearLayout(this);
                 video_Button.setId(1);
                 track.setId(2);
                 vid.start();
                 play.setBackgroundResource(R.drawable.pause);
                 linearLayout.addView(video_Button);
                 linearLayout.addView(track);
                 linearLayout.setOrientation(LinearLayout.VERTICAL);
                 reload.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         if(vid.isPlaying())
                         vid.resume();
                         else {
                             vid.start();
                             vid.resume();
                             play.setBackgroundResource(R.drawable.pause);

                         }
                     }
                 });
                 play.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         if(vid.isPlaying()) {
                             Toast.makeText(send_Rom.this, "pause", Toast.LENGTH_LONG).show();
                             vid.pause();
                             play.setBackgroundResource(R.drawable.play2);
                         }
                         else
                         {
                             Toast.makeText(send_Rom.this, "start", Toast.LENGTH_LONG).show();
                             vid.start();
                             play.setBackgroundResource(R.drawable.pause);
                         }

                     }
                 });
                vid.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        play.setBackgroundResource(R.drawable.play2);

                    }});
                FrameLayout.LayoutParams lll=new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                lll.leftMargin=15;
                lll.rightMargin=15;
            linearLayout.setLayoutParams(lll);
                linearLayout.setBackgroundResource(R.drawable.rouded_video);
                linearLayout.setPadding(10,10,10,10);
                Linear_chat.addView(linearLayout);

            }else  if (Uri.toString().contains("audio")) {
                Toast.makeText(send_Rom.this,"audio",Toast.LENGTH_LONG).show();
                TextView t=new TextView(this);
                path_audio=data.getDataString();
                t.setText(path_audio);
                t.setTextSize(16);
                LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 90);
                t.setLayoutParams(params2);
               LinearLayout l=new LinearLayout(this);
               l.setOrientation(LinearLayout.VERTICAL);
               ImageView audio=new ImageView(this);
                audio.setImageResource(R.drawable.audio);
                LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(70, 70);
                params1.setMargins(10,10,10,10);
                audio.setLayoutParams(params1);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                params.setMargins(10,10,10,10);
                l.setLayoutParams(params);
                t.setId(1);
                audio.setId(2);
                l.addView(audio);
                l.addView(t);
                Linear_chat.addView(l);

            }else if (requestCode == REQUEST_CAMERA) {
         String _FileName = "image file";
           Bitmap capturePic = null;
                Toast.makeText(send_Rom.this,"camera",Toast.LENGTH_LONG).show();

            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
          ImageView I=new ImageView(this);
          I.setImageBitmap(imageBitmap);
            capturePic = imageBitmap;
        }
            /*else  if (Uri.toString().contains("camera")) {
                Toast.makeText(send_Rom.this,"camera",Toast.LENGTH_LONG).show();
              /*  ImageView I=new ImageView(this);
                LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 90);
                I.setLayoutParams(params2);
                im=data.getData();

                I.setImageURI(im);
                Linear_chat.addView(I);
            }*/


        }
    }


  /*  public void saveToSD(Bitmap outputImage){


        File storagePath = new File(Environment.getExternalStorageDirectory() + "/MyPhotos/");
        storagePath.mkdirs();

        File myImage = new File(storagePath, Long.toString(System.currentTimeMillis()) + ".jpg");

        try {
            FileOutputStream out = new FileOutputStream(myImage);
            outputImage.compress(Bitmap.CompressFormat.JPEG, 80, out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}

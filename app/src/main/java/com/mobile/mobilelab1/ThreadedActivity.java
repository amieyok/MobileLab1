package com.mobile.mobilelab1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ThreadedActivity extends AppCompatActivity {
    ImageView imgVwProfile;
    Button btnTakePic;
    TextView txtVw;
    Bitmap bp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threaded);

        //get variable from previous activity
        imgVwProfile = (ImageView)findViewById(R.id.imgVwProfile);
        Intent intent = getIntent();
        String strMsg = intent.getStringExtra("varStr1");
        txtVw = (TextView)findViewById(R.id.txtVw);
        txtVw.setText("Welcome to new activity wahai "+strMsg);
        btnTakePic = (Button)findViewById(R.id.btnTakePic);
    }

    public void fnTakePic(View vw)
    {
        Runnable run = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);

                runOnUiThread(new Runnable(){
                    @Override
                    public void run()
                    {
                        txtVw.setText(txtVw.getText().toString()+".. This is your Picture heheh..");
                    }
                });
            }
        };

        Thread thr = new Thread(run);
        thr.start();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        Intent passPic = new Intent(this, FirstActivity.class);
        bp = (Bitmap)data.getExtras().get("data");
        imgVwProfile.setImageBitmap(bp);

        passPic.putExtra("dp" , bp);
        setResult(0,passPic);
    }


}

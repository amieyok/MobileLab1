package com.mobile.mobilelab1;

import android.content.Intent;
//import android.util.Calendar;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class FirstActivity extends AppCompatActivity {

    //Widgets
    TextView txtvwAge;
    EditText edtName, edtYear;
    Button btnClick , btnNewActivity;
    ImageView imgDP;

    //Variable
    int age;
    Bitmap dp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        txtvwAge = (TextView) findViewById(R.id.txtvwAge);
        edtName = (EditText) findViewById(R.id.edtName);
        edtYear = (EditText) findViewById(R.id.edtYear);
        btnClick = (Button) findViewById(R.id.btnClick);
        btnNewActivity = (Button) findViewById(R.id.btnNewActivity);
        imgDP = (ImageView) findViewById(R.id.imgDP);

        //dp = (Bitmap)this.getIntent().getParcelableExtra("Bitmap");

        //imgDP.setImageBitmap(dp);

    }


    public void fnGreet (View vw)
    {
        String strName = edtName.getText().toString();
        String strYear = edtYear.getText().toString();
        int year = Integer.parseInt(strYear);
        Calendar calendar = Calendar.getInstance();

        int currYear = calendar.get(Calendar.YEAR);
        age = currYear - year;
        txtvwAge.setText("hellooooooo and welcome " + strName + "\nYou are " + age + " years old.");

        //startActivityForResult(new Intent(getApplicationContext(), ThreadedActivity.class),111);
    }



    public void fnThreadActivity(View vw)
    {
        Intent intent = new Intent(this, ThreadedActivity.class);
        String strMsg = ((EditText) findViewById(R.id.edtName)).getText().toString();
        intent.putExtra("varStr1", strMsg);
        startActivityForResult(intent, 0);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        dp = (Bitmap)data.getExtras().get("dp");
        imgDP.setImageBitmap(dp);
    }






}

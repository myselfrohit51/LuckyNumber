package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    EditText editText;
    Button button;
    int rand;
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editText=findViewById(R.id.editText);
        button=findViewById(R.id.button);

        Intent i=getIntent();
        text=i.getStringExtra("Name");


        Random r=new Random();
        rand=r.nextInt(100);
        editText.setText(""+rand);

        String sub="Your random number";
        String body=text+", your random number is "+rand+". Thank you!";

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                shareText(text,rand);
            }
        });


    }
    public void shareText(String subject,int body) {
        Intent txtIntent = new Intent(Intent.ACTION_SEND);
        txtIntent .setType("text/plain");
        txtIntent .putExtra(Intent.EXTRA_SUBJECT, subject+" got a lucky number");
        txtIntent .putExtra(Intent.EXTRA_TEXT, "His lucky number is: " +body);
        startActivity(Intent.createChooser(txtIntent ,"Choose a platform"));
    }
}
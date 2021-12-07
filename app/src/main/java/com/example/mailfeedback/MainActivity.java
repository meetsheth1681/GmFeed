package com.example.mailfeedback;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                String[] recipients = {"parentishapp@gmail.com"};//Add multiple recipients here
                intent.putExtra(Intent.EXTRA_EMAIL, recipients);
                intent.putExtra(Intent.EXTRA_SUBJECT, "Mail Subject"); //Add Mail Subject
                intent.putExtra(Intent.EXTRA_TEXT, "Enter your mail body here...");//Add mail body
                intent.putExtra(Intent.EXTRA_CC, "mailcc@gmail.com");//Add CC emailid's if any
                intent.putExtra(Intent.EXTRA_BCC, "mailbcc@gmail.com");//Add BCC email id if any
                intent.setType("text/html");
                intent.setPackage("com.google.android.gm");//Added Gmail Package to forcefully open Gmail App
                startActivity(Intent.createChooser(intent, "Send mail"));
            }
        });
    }
}
package com.example.otimactivityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class OtimActivityIntent2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otim_intent2);

        if (getIntent().hasExtra("com.test.otimactivityintent.SOMETHING")) {
            TextView tv = (TextView) findViewById(R.id.secondTextView);
            String text = getIntent().getExtras().getString("com.test.otimactivityintent.SOMETHING");
            tv.setText(text);
        }
    }
}
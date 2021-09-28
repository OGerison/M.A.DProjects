package com.example.myregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button submitButton = (Button) findViewById(R.id.submitButton);
        Button youtubeButton = (Button) findViewById(R.id.youtubeButton);
        Button callButton = (Button) findViewById(R.id.callButton);
        Button logoutButton = (Button) findViewById(R.id.logoutButton);

        submitButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText1 = (EditText) findViewById(R.id.editText1);
                EditText editText2 = (EditText) findViewById(R.id.editText2);
                EditText editText3 = (EditText) findViewById(R.id.editText3);
                EditText editText4 = (EditText) findViewById(R.id.editText4);
                EditText editText5 = (EditText) findViewById(R.id.editText5);
                EditText editText6 = (EditText) findViewById(R.id.editText6);
                String first,last,program,year,course,place;

                TextView fnameTextView = findViewById(R.id.firstnameViewid);
                TextView lnameTextView = findViewById(R.id.lastnameViewid2);
                TextView sprogramTextView = findViewById(R.id.studyProgramViewid3);
                TextView ystudyTextView = findViewById(R.id.studyYearViewid4);
                TextView cunitTextView = findViewById(R.id.courseUnitViewid5);
                TextView presidenceTextView = findViewById(R.id.placeOfResidenceViewid6);

                first = editText1.getText().toString();
                last = editText2.getText().toString();
                program = editText3.getText().toString();
                year = editText4.getText().toString();
                course = editText5.getText().toString();
                place = editText6.getText().toString();

                fnameTextView.setText(first);
                lnameTextView.setText(last);
                sprogramTextView.setText(program);
                ystudyTextView.setText(year);
                cunitTextView.setText(course);
                presidenceTextView.setText(place);

            }
        });
        youtubeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String youtube = "https://www.youtube.com/watch?v=SAZxarU_SiY";
                Uri webaddress = Uri.parse(youtube);
                Intent openYoutube = new Intent(Intent.ACTION_VIEW, webaddress);
                if (openYoutube.resolveActivity(getPackageManager()) !=null) {
                    startActivity(openYoutube);
                }
            }
        });

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0775945681"));
                startActivity(intent);
            }
        });
        logoutButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}






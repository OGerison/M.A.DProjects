package com.example.multiplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText1 = (EditText) findViewById(R.id.editText1);
                EditText editText2 = (EditText) findViewById(R.id.editText2);
                TextView ResultTextView = (TextView) findViewById(R.id.ResultTextView);
                int num1, num2, result;
                num1=Integer.parseInt(editText1.getText() .toString());
                num2=Integer.parseInt(editText2.getText() .toString());
                result=num1*num2;
                ResultTextView.setText(result+"");
            }
        });
    }
}
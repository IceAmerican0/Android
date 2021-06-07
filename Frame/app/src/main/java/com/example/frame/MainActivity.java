package com.example.frame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button1,button2,button3,button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button3.getText().equals("Linear1Button1")) {
                    button3.setText("Linear2Button1");
                    button3.setBackgroundColor(Color.RED);
                }else{
                    button3.setText("Linear1Button1");
                    button3.setBackgroundColor(Color.GRAY);
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button4.getText().equals("Linear1Button2")) {
                    button4.setText("Linear2Button2");
                    button4.setBackgroundColor(Color.RED);
                }else{
                    button4.setText("Linear1Button2");
                    button4.setBackgroundColor(Color.GRAY);
                }
            }
        });
    }
}
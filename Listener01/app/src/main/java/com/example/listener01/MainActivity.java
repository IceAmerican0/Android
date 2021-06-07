package com.example.listener01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout cl=null;
    TextView textView;
    Button btn1,smaller,bigger;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.tv01);
        btn1=findViewById(R.id.apple);
        imageView=findViewById(R.id.dog);
        smaller=findViewById(R.id.smaller);
        bigger=findViewById(R.id.bigger);

        textView.setOnTouchListener(onTouchListener);
        btn1.setOnLongClickListener(onLongClickListener);
        imageView.setOnTouchListener(onTouchListener);

        bigger.setOnClickListener(onClickListener);
        smaller.setOnClickListener(onClickListener);
    }


    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            float size=1;
            switch(v.getId()){
                case R.id.bigger:
                    textView.setTextSize(textView.getTextSize()+size);
                    break;
                case R.id.smaller:
                    if(textView.getTextSize()<=2) break;
                    else {
                        textView.setTextSize(textView.getTextSize() - size);
                        break;
                    }
            }
        }
    };

    View.OnLongClickListener onLongClickListener=new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            Toast.makeText(MainActivity.this,"Button!",Toast.LENGTH_SHORT).show();
            return true;
        }
    };

    View.OnTouchListener onTouchListener=new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch(v.getId()){
                case R.id.tv01:
                    Toast.makeText(MainActivity.this,"Hello!",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.dog:
                    Toast.makeText(MainActivity.this,"멍!!",Toast.LENGTH_SHORT).show();
                    break;
            }
            return true;
        }
    };
}
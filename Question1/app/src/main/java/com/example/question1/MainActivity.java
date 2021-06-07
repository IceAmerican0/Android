package com.example.question1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int a=0;
    int b=0;
    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button=findViewById(R.id.call);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("질문1")
                        .setMessage("좌변을 선택하세요!")
                        .setCancelable(false)
                        .setPositiveButton("4",LClick)
                        .setNegativeButton("3",LClick)
                        .show();
            }
        });
    }

    DialogInterface.OnClickListener LClick=new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if(which==DialogInterface.BUTTON_POSITIVE){
                a=4;
                right();
            }else{
                a=3;
                right();
            }
        }
    };

    DialogInterface.OnClickListener RClick=new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if(which==DialogInterface.BUTTON_POSITIVE){
                b=6;
                calculate();
            }else{
                b=5;
                calculate();
            }
        }
    };

    DialogInterface.OnClickListener CClick=new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if(which==DialogInterface.BUTTON_POSITIVE){
                result=a*b;
            }else{
                result=a+b;
            }
            TextView textView=findViewById(R.id.result);
            textView.setText("연산결과 : "+result);
            Toast.makeText(MainActivity.this,"연산을 완료했습니다.",Toast.LENGTH_SHORT).show();
        }
    };

    protected  void right(){
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("질문2")
                .setMessage("우변을 선택하세요!")
                .setCancelable(false)
                .setPositiveButton("6",RClick)
                .setNegativeButton("5",RClick)
                .show();
    }

    protected void calculate(){
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("질문")
                .setMessage("어떤 연산을 하시겠습니까?")
                .setCancelable(false)
                .setPositiveButton("곱셈",CClick)
                .setNegativeButton("덧셈",CClick)
                .show();
    }

}
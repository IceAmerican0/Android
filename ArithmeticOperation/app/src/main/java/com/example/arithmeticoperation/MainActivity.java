package com.example.arithmeticoperation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit1,edit2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1=findViewById(R.id.num1);
        edit2=findViewById(R.id.num2);
        btn=findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edit1.getText().toString().equals("")||edit2.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "숫자를 입력해주세요!", Toast.LENGTH_SHORT).show();
                }else {
                    int num1 = Integer.parseInt(edit1.getText().toString());
                    int num2 = Integer.parseInt(edit2.getText().toString());

                    int add=num1+num2;
                    int min=num1-num2;
                    int mul=num1*num2;
                    Double div=(double)num1/num2;
                    if(num1==0||num2==0) div=0.0;

                    Toast.makeText(getApplicationContext(), "덧셈 : "+add+"\n뺄셈 : "+min+"\n곱셈 : "+mul+"\n나눗셈 : "+div, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
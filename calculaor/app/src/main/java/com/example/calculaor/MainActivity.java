package com.example.calculaor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAdd, btnMin, btnMul, btnDiv;

    Button[] numButtons = new Button[10];
    Integer[] numBtnIDs = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};
    EditText num1, num2;
    TextView result;

    int number1, number2;
    String result1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("계산기");

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        btnAdd = findViewById(R.id.btnAdd);
        btnMin = findViewById(R.id.btnMin);
        btnDiv = findViewById(R.id.btnDiv);
        btnMul = findViewById(R.id.btnMul);
        result = findViewById(R.id.result);


        btnAdd.setOnClickListener(mClickListener);
        btnMin.setOnClickListener(mClickListener);
        btnMul.setOnClickListener(mClickListener);
        btnDiv.setOnClickListener(mClickListener);

        for (int i = 0; i < numBtnIDs.length; i++) numButtons[i] = findViewById(numBtnIDs[i]);

        for (int i = 0; i < numBtnIDs.length; i++) {
            final int index = i;

            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (num1.isFocused())
                        num1.setText(num1.getText().toString() + numButtons[index].getText().toString());
                    else if (num2.isFocused())
                        num2.setText(num2.getText().toString() + numButtons[index].getText().toString());
                    else
                        Toast.makeText(MainActivity.this, "입력 항목부터 선택하세요!", Toast.LENGTH_SHORT).show();
                }
            });
        }



    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            number1 = Integer.parseInt(num1.getText().toString());
            number2 = Integer.parseInt(num2.getText().toString());

            switch (v.getId()) {
                case R.id.btnAdd:
                    result1 = Integer.toString(number1 + number2);
                    break;
                case R.id.btnMin:
                    result1 = Integer.toString(number1 - number2);
                    break;
                case R.id.btnMul:
                    result1 = Integer.toString(number1 * number2);
                    break;
                case R.id.btnDiv:
                    result1 = Double.toString(number1 / (double) number2);
                    break;
            }

            result.setText("계산 결과 : " + result1);
        }
    };



}
package com.example.bmi;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    EditText age,weight,height;
    TextView result,lecture,answer;
    Button button;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();

        radioGroup=findViewById(R.id.rg01);
        button=findViewById(R.id.btn);
        age=findViewById(R.id.age);
        weight=findViewById(R.id.weight);
        height=findViewById(R.id.height);
        result=findViewById(R.id.result);
        lecture=findViewById(R.id.lecture);
        answer=findViewById(R.id.answer);
        img=findViewById(R.id.img);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(radioGroup.getCheckedRadioButtonId()){
                    case R.id.rbMan:
                        check();
                        if(check()==1) calculateM();
                        break;
                    case R.id.rbWoman:
                        check();
                        if(check()==1) calculateW();
                        break;
                    default:
                        Toast.makeText(getApplicationContext(),"성별을 선택하세요!",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    public int check(){
        if(age.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(),"나이를 입력하세요!",Toast.LENGTH_SHORT).show();
            return 0;
        }
        else if(Integer.parseInt(age.getText().toString())<=0||Integer.parseInt(age.getText().toString())>130) {
            Toast.makeText(getApplicationContext(),"올바른 나이를 입력하세요!",Toast.LENGTH_SHORT).show();
            return 0;
        }
        else if(height.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"키를 입력하세요!",Toast.LENGTH_SHORT).show();
            return 0;
        }
        else if(Integer.parseInt(height.getText().toString())>250||Integer.parseInt(height.getText().toString())<100){
            Toast.makeText(getApplicationContext(),"올바른 키를 입력하세요!",Toast.LENGTH_SHORT).show();
            return 0;
        }
        else if(weight.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(),"몸무게를 입력하세요!",Toast.LENGTH_SHORT).show();
            return 0;
        }
        else if(Integer.parseInt(weight.getText().toString())>250||Integer.parseInt(weight.getText().toString())<30){
            Toast.makeText(getApplicationContext(),"올바른 몸무게를 입력하세요!",Toast.LENGTH_SHORT).show();
            return 0;
        }
        else{
            Double heightM=(Double.parseDouble(height.getText().toString())/100);
            Double weightKg=Double.parseDouble(weight.getText().toString());
            Double bmi=weightKg/(heightM*heightM);
            result.setText((bmi.toString().substring(0,5)));
        }
        return 1;
    }

    public void calculateM(){
        Double bmi=Double.parseDouble(result.getText().toString());
        int ageI=Integer.parseInt(age.getText().toString());
        if(ageI>=20&&ageI<=29) {
            if (bmi < 16) answer.setText("저체중입니다!");
            else if(bmi>=16&&bmi<=18.6) answer.setText("훌륭합니다!");
            else if(bmi>18.6&&bmi<=23.1) answer.setText("과체중입니다!");
            else answer.setText("비만입니다!");
        }else if(ageI>=30&&ageI<=39) {
            if (bmi < 16) answer.setText("저체중입니다!");
            else if (bmi >= 16 && bmi <= 21.4) answer.setText("훌륭합니다!");
            else if (bmi > 21.4 && bmi <= 24.9) answer.setText("과체중입니다!");
            else answer.setText("비만입니다!");
        }else if(ageI>=40&&ageI<=49) {
            if (bmi < 16) answer.setText("저체중입니다!");
            else if(bmi>=16&&bmi<=23.4) answer.setText("훌륭합니다!");
            else if(bmi>23.4&&bmi<=26.6) answer.setText("과체중입니다!");
            else answer.setText("비만입니다!");
        }else if(ageI>=50&&ageI<=59) {
            if (bmi < 16) answer.setText("저체중입니다!");
            else if(bmi>=16&&bmi<=24.6) answer.setText("훌륭합니다!");
            else if(bmi>24.6&&bmi<=27.8) answer.setText("과체중입니다!");
            else answer.setText("비만입니다!");
        }else{
            if (bmi < 16) answer.setText("저체중입니다!");
            else if(bmi>=16&&bmi<=25.2) answer.setText("훌륭합니다!");
            else if(bmi>25.2&&bmi<=28.4) answer.setText("과체중입니다!");
            else answer.setText("비만입니다!");
        }

        lecture.setVisibility(View.VISIBLE);
        result.setVisibility(View.VISIBLE);
        answer.setVisibility(View.VISIBLE);
        img.setVisibility(View.VISIBLE);
    }

    public void calculateW(){
        Double bmi=Double.parseDouble(result.getText().toString());
        int ageI=Integer.parseInt(age.getText().toString());
        if(ageI>=20&&ageI<=29) {
            if (bmi < 14) answer.setText("저체중입니다!");
            else if(bmi>=14&&bmi<=22.7) answer.setText("훌륭합니다!");
            else if(bmi>22.7&&bmi<=27.1) answer.setText("과체중입니다!");
            else answer.setText("비만입니다!");
        }else if(ageI>=30&&ageI<=39) {
            if (bmi < 14) answer.setText("저체중입니다!");
            else if (bmi >= 14 && bmi <= 24.6) answer.setText("훌륭합니다!");
            else if (bmi > 24.6 && bmi <= 29.2) answer.setText("과체중입니다!");
            else answer.setText("비만입니다!");
        }else if(ageI>=40&&ageI<=49) {
            if (bmi < 14) answer.setText("저체중입니다!");
            else if(bmi>=14&&bmi<=27.6) answer.setText("훌륭합니다!");
            else if(bmi>27.6&&bmi<=31.9) answer.setText("과체중입니다!");
            else answer.setText("비만입니다!");
        }else if(ageI>=50&&ageI<=59) {
            if (bmi < 14) answer.setText("저체중입니다!");
            else if(bmi>=14&&bmi<=30.4) answer.setText("훌륭합니다!");
            else if(bmi>30.4&&bmi<=34.5) answer.setText("과체중입니다!");
            else answer.setText("비만입니다!");
        }else{
            if (bmi < 14) answer.setText("저체중입니다!");
            else if(bmi>=14&&bmi<=31.3) answer.setText("훌륭합니다!");
            else if(bmi>31.3&&bmi<=35.4) answer.setText("과체중입니다!");
            else answer.setText("비만입니다!");
        }

        lecture.setVisibility(View.VISIBLE);
        result.setVisibility(View.VISIBLE);
        answer.setVisibility(View.VISIBLE);
        img.setVisibility(View.VISIBLE);
    }
}
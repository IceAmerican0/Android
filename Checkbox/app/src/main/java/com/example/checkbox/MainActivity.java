package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox cb1,cb2,cb3,cb4;
    int cnt=0;
    String str="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb1=findViewById(R.id.Cb_01);
        cb2=findViewById(R.id.Cb_02);
        cb3=findViewById(R.id.Cb_03);
        cb4=findViewById(R.id.Cb_04);

        cb1.setOnCheckedChangeListener(checkChangeListener);
        cb2.setOnCheckedChangeListener(checkChangeListener);
        cb3.setOnCheckedChangeListener(checkChangeListener);
        cb4.setOnCheckedChangeListener(checkChangeListener);


    }

    CompoundButton.OnCheckedChangeListener checkChangeListener=new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            switch(buttonView.getId()){
                case R.id.Cb_01:
                    if(isChecked==true){
                        str+=" 운동";
                        cnt++;
                    }
                    if(isChecked==false) {
                        cnt--;
                        str.replace("운동","");
                    }
                    break;
                case R.id.Cb_02:
                    if(isChecked==true){
                        str+=" 요리";
                        cnt++;
                    }
                    if(isChecked==false) {
                        cnt--;
                        str.replace("요리","");
                    }
                    break;
                case R.id.Cb_03:
                    if(isChecked==true){
                        str+=" 독서";
                        cnt++;
                    }
                    if(isChecked==false) {
                        cnt--;
                        str.replace("독서","");
                    }
                    break;
                case R.id.Cb_04:
                    if(isChecked==true){
                        str+=" 여행";
                        cnt++;
                    }
                    if(isChecked==false) {
                        cnt--;
                        str.replace("여행","");
                    }
                    break;
            }

            if(cnt!=0) {
                Toast.makeText(MainActivity.this, str + " is checked.", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(MainActivity.this, str + "취미가 없습니다!", Toast.LENGTH_SHORT).show();
            }
        }
    };

}
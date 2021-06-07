package com.example.quiz10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBox;
    LinearLayout choosePet;
    RadioGroup radioGroup;
    ImageView imgPet;
    FrameLayout frame;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox=findViewById(R.id.chk01);
        choosePet=findViewById(R.id.choosePet);
        frame=findViewById(R.id.frame);
        radioGroup=findViewById(R.id.rg01);
        imgPet=findViewById(R.id.imgPet);
        button=findViewById(R.id.btn01);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(checkBox.isChecked()==true) choosePet.setVisibility(View.VISIBLE);
                        else choosePet.setVisibility(View.INVISIBLE);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(radioGroup.getCheckedRadioButtonId()) {
                    case R.id.rb01:
                        imgPet.setImageResource(R.drawable.dog);
                        break;
                    case R.id.rb02:
                        imgPet.setImageResource(R.drawable.cat);
                        break;
                    case R.id.rb03:
                        imgPet.setImageResource(R.drawable.rabbit);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(),"동물을 선택하세요",Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

}
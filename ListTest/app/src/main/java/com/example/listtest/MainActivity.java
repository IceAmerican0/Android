package com.example.listtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> arGeneral=new ArrayList<>();
        arGeneral.add("김유신");
        arGeneral.add("이순신");
        arGeneral.add("강감찬");
        arGeneral.add("을지문덕");

        ArrayAdapter<String> Adapter;
        Adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arGeneral);

        ListView list=findViewById(R.id.list);
        list.setAdapter(Adapter);
    }
}
package com.example.studentjson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String urlAddr="http://192.168.145.42:8080/test/students.json";

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    ArrayList<JsonMember> students;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView=findViewById(R.id.item_image);
        recyclerView=findViewById(R.id.lv_members);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        try{
            NetworkTask networkTask=new NetworkTask(MainActivity.this,urlAddr);
            Object obj=networkTask.execute().get();
            students=(ArrayList<JsonMember>) obj;

            adapter=new RecyclerAdapter(MainActivity.this,R.layout.custom_layout,students);
            recyclerView.setAdapter(adapter);
        }catch(Exception e){
            e.printStackTrace();
        }



    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        if(webView.canGoBack()){
            webView.goBack();
        }else{
            finish();
        }
    }

}
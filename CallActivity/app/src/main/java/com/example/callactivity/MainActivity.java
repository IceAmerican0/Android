package com.example.callactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("Message","onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCall=findViewById(R.id.call);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SubActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart(){
        Log.v("Message","onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.v("Message","onStop");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.v("Message","onPause");
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.v("Message","onDestroy");
        super.onDestroy();
    }


}
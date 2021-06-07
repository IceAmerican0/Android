package com.example.callactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.v("Message","SubOnCreate");

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
        setContentView(R.layout.activity_sub);

        Button btnClose=findViewById(R.id.close);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onStart(){
        Log.v("Message","SubOnStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.v("Message","SubOnStop");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.v("Message","SubOnPause");
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.v("Message","SubOnDestroy");
        super.onDestroy();
    }
}
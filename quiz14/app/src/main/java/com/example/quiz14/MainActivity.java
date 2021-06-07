package com.example.quiz14;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edt1, edt2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = findViewById(R.id.userid);
        edt2 = findViewById(R.id.userpw);
        button = findViewById(R.id.btnok);

        button.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String userid = edt1.getText().toString();
            String userpw = edt2.getText().toString();

            if (userid.equals("aaa") && userpw.equals("1111")) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                startActivity(intent);
                edt1.setText("");
                edt2.setText("");

            } else Toast.makeText(MainActivity.this, "It's Wrong!", Toast.LENGTH_SHORT).show();
        }
    };

}
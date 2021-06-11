package com.example.dbcrud.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dbcrud.NetworkTask.NetworkTask;
import com.example.dbcrud.R;

public class DeleteActivity extends AppCompatActivity {

    String urlAddr=null;
    String scode,sname,sdept,sphone,macIP;
    EditText ecode,ename,edept,ephone;
    Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        Intent intent=getIntent();
        scode=intent.getStringExtra("code");
        sname=intent.getStringExtra("name");
        sdept=intent.getStringExtra("dept");
        sphone=intent.getStringExtra("phone");
        macIP=intent.getStringExtra("macIP");

        urlAddr="http://"+macIP+":8080/test/studentDeleteReturn.jsp?";

        ecode=findViewById(R.id.delete_code);
        ename=findViewById(R.id.delete_name);
        edept=findViewById(R.id.delete_dept);
        ephone=findViewById(R.id.delete_phone);

        //입력시 자릿수 제한
        ecode.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        ename.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10)});
        edept.setFilters(new InputFilter[]{new InputFilter.LengthFilter(12)});
        ephone.setFilters(new InputFilter[]{new InputFilter.LengthFilter(12)});

        ecode.setText(scode);
        ename.setText(sname);
        edept.setText(sdept);
        ephone.setText(sphone);

        btnUpdate=findViewById(R.id.delete_btn);
        btnUpdate.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            scode=ecode.getText().toString();

            urlAddr=urlAddr+"code="+scode;

            String result=connectInsertData();
            if(result.equals("1")){
                Toast.makeText(DeleteActivity.this,scode+"가 삭제되었습니다!",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(DeleteActivity.this,"삭제 실패했습니다!",Toast.LENGTH_SHORT).show();
            }
            finish();
        }
    };

    private String connectInsertData(){
        String result=null;
        try{
            NetworkTask networkTask=new NetworkTask(DeleteActivity.this,urlAddr,"select");
            Object obj=networkTask.execute().get();
            result=(String)obj;
        }catch(Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
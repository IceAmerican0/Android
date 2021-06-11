package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnInsert,btnUpdate,btnDelete,btnSelect;
    TextView tvResult;
    MemberInfo memberInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDelete=findViewById(R.id.btn_delete);
        btnSelect=findViewById(R.id.btn_select);
        btnUpdate=findViewById(R.id.btn_update);
        btnInsert=findViewById(R.id.btn_insert);
        tvResult=findViewById(R.id.tv_result);

        memberInfo=new MemberInfo(this);

        btnSelect.setOnClickListener(onClickListener);
        btnInsert.setOnClickListener(onClickListener);
        btnDelete.setOnClickListener(onClickListener);
        btnUpdate.setOnClickListener(onClickListener);
    }



    View.OnClickListener onClickListener=new View.OnClickListener() {
        SQLiteDatabase DB;

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.btn_insert:
                    try{
                        DB=memberInfo.getWritableDatabase();
                        String query="INSERT INTO member(username,userid,passwd) VALUES('홍길동','hkdong',1111);";
                        DB.execSQL(query);

                        memberInfo.close();

                        Toast.makeText(MainActivity.this,"Insert OK!",Toast.LENGTH_SHORT).show();
                    }catch(Exception e){
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this,"Insert Error!",Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.btn_update:
                    try{
                        DB=memberInfo.getWritableDatabase();
                        String query="UPDATE member SET username='강감찬',userid='kkchan';";
                        DB.execSQL(query);

                        memberInfo.close();

                        Toast.makeText(MainActivity.this,"Update OK!",Toast.LENGTH_SHORT).show();
                    }catch(Exception e){
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this,"Update Error!",Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.btn_delete:
                    try{
                        DB=memberInfo.getWritableDatabase();
                        String query="delete from member where username='강감찬';";
                        DB.execSQL(query);

                        memberInfo.close();

                        Toast.makeText(MainActivity.this,"Delete OK!",Toast.LENGTH_SHORT).show();
                    }catch(Exception e){
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this,"Delete Error!",Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.btn_select:
                    try{
                        DB=memberInfo.getWritableDatabase();
                        String query="select * from member;";
                        StringBuffer stringBuffer=new StringBuffer();
                        Cursor cursor=DB.rawQuery(query,null);
                        while(cursor.moveToNext()){
                            String username=cursor.getString(0);
                            String userid=cursor.getString(1);
                            int passwd=cursor.getInt(2);

                            stringBuffer.append("username : "+username+", userid : "+userid+", passwd : "+passwd+"\n");
                        }
                        tvResult.setText(stringBuffer.toString());

                        cursor.close();
                        memberInfo.close();

                        Toast.makeText(MainActivity.this,"Select OK!",Toast.LENGTH_SHORT).show();
                    }catch(Exception e){
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this,"Select Error!",Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    };


}
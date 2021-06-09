package com.example.studentjson;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class NetworkTask extends AsyncTask<Integer,String,Object> {

    Context context;
    String mAddr=null;
    ProgressDialog progressDialog=null;
    ArrayList<JsonMember> members;

    public NetworkTask(Context context, String mAddr){
        this.context=context;
        this.mAddr=mAddr;
        this.members=new ArrayList<JsonMember>();
    }

    @Override // 실행 전
    protected void onPreExecute() {
        progressDialog=new ProgressDialog(context);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setTitle("Dialog");
        progressDialog.setMessage("down . . . ");
        progressDialog.show();
    }

    @Override //진행 중
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }

    @Override // 실행 끝
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        progressDialog.dismiss();
    }

    @Override // 취소 시
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override
    protected Object doInBackground(Integer... integers) {
        StringBuffer stringBuffer=new StringBuffer();
        InputStream inputStream=null;
        InputStreamReader inputStreamReader=null;
        BufferedReader bufferedReader=null;

        try{
            URL url=new URL(mAddr);
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            httpURLConnection.setConnectTimeout(10000);

            if(httpURLConnection.getResponseCode()==HttpURLConnection.HTTP_OK){
                inputStream=httpURLConnection.getInputStream();
                inputStreamReader=new InputStreamReader(inputStream);
                bufferedReader=new BufferedReader(inputStreamReader);

                while(true){
                    String strline=bufferedReader.readLine();
                    if(strline==null) break;
                    stringBuffer.append(strline+"\n");
                }
                parser(stringBuffer.toString());
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(bufferedReader!=null) bufferedReader.close();
                if(inputStreamReader!=null) inputStreamReader.close();
                if(inputStream!=null) inputStream.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return members;
    }

    private void parser(String str){
        try{
            JSONObject jsonObject=new JSONObject(str);
            JSONArray jsonArray=new JSONArray(jsonObject.getString("students_info"));
            members.clear();

            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject1=(JSONObject)jsonArray.get(i);
                String name=jsonObject1.getString("name");
                String code=jsonObject1.getString("code");
                String dept=jsonObject1.getString("dept");
                String phone=jsonObject1.getString("phone");
                String image=jsonObject1.getString("image");


                JsonMember member=new JsonMember(code,name,dept,phone,image);
                members.add(member);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}

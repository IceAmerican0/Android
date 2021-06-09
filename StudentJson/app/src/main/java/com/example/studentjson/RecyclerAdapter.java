package com.example.studentjson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private ArrayList<JsonMember> data =null;
    private Context mcontext=null;
    private int layout=0;
    private LayoutInflater inflater=null;
    private String images="";

    public RecyclerAdapter(Context mcontext,int layout,ArrayList<JsonMember> data){
        this.mcontext=mcontext;
        this.layout=layout;
        this.data=data;
        this.inflater=(LayoutInflater)mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tv_code;
        public TextView tv_name;
        public TextView tv_phone;
        public TextView tv_dept;
        public WebView webView;
        public ViewHolder(View convertView){
            super(convertView);
            tv_code=convertView.findViewById(R.id.tv_code);
            tv_name=convertView.findViewById(R.id.tv_name);
            tv_dept=convertView.findViewById(R.id.tv_dept);
            tv_phone=convertView.findViewById(R.id.tv_phone);
            webView=convertView.findViewById(R.id.item_image);

        }
    }


    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout,parent,false);
        ViewHolder viewHolder=new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {
        holder.tv_name.setText("Name : "+data.get(position).getName());
        holder.tv_code.setText("Code : "+data.get(position).getCode());
        holder.tv_dept.setText("Dept : "+data.get(position).getDept());
        holder.tv_phone.setText("Phone : "+data.get(position).getPhone());
        holder.webView.loadDataWithBaseURL(null,htmlData(data.get(position).getImage()),"text/html","utf-8",null);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public String htmlData(String location){
        String htmlData="<html><head></head> <body><img style = 'width: 100%; height:auto;' src=\"http://192.168.145.42:8080/test/"+location+"\"></body></html>";

        return  htmlData;
    }
}

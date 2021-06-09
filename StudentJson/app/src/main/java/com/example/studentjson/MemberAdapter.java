package com.example.studentjson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MemberAdapter extends BaseAdapter {
    private Context mcontext=null;
    private int layout=0;
    private ArrayList<JsonMember> data =null;
    private LayoutInflater inflater=null;

    public MemberAdapter(Context mcontext, int layout, ArrayList<JsonMember> data) {
        this.mcontext = mcontext;
        this.layout = layout;
        this.data = data;
        this.inflater= (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position).getCode();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=inflater.inflate(this.layout,parent,false);
        TextView tv_code=convertView.findViewById(R.id.tv_code);
        TextView tv_name=convertView.findViewById(R.id.tv_name);
        TextView tv_dept=convertView.findViewById(R.id.tv_dept);
        TextView tv_phone=convertView.findViewById(R.id.tv_phone);

        tv_name.setText("Name : "+data.get(position).getName());
        tv_code.setText("Code : "+data.get(position).getCode());
        tv_dept.setText("Dept : "+data.get(position).getDept());
        tv_phone.setText("Phone : "+data.get(position).getPhone());


        if((position%2)==1){
            convertView.setBackgroundColor(0x5000ff00);
        }else{
            convertView.setBackgroundColor(0x500000ff);
        }

        return convertView;
    }
}

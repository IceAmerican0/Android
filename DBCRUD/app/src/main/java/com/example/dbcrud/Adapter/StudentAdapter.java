package com.example.dbcrud.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dbcrud.Bean.Student;
import com.example.dbcrud.R;

import java.util.ArrayList;

public class StudentAdapter extends BaseAdapter {
    private Context mcontext=null;
    private int layout=0;
    private ArrayList<Student> data=null;
    private LayoutInflater inflater=null;

    public StudentAdapter(Context mcontext, int layout, ArrayList<Student> data) {
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

        tv_code.setText("학번 : "+data.get(position).getCode());
        tv_name.setText("이름 : "+data.get(position).getName());
        tv_dept.setText("전공  : "+data.get(position).getDept());
        tv_phone.setText("번호 : "+data.get(position).getPhone());

        return convertView;
    }
}

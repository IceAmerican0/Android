package com.example.fragmenttest;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class TextFragment extends Fragment {

  TextView textView=null;

    @Nullable

    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
        Log.v("Message","TextFragmentOnCreateView");
        View view=inflater.inflate(R.layout.fragment_text,container,false);

        textView=view.findViewById(R.id.f2_text);

        return view;
    }

    public void changeTextProperties(int fontSize,String str){
        Log.v("Message","changeTextPropterties");
        textView.setTextSize(fontSize);
        textView.setText(str);
    }
}
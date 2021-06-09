package com.example.hybrid_02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    Button btn01,btn02,btn03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView=findViewById(R.id.webview);
        btn01=findViewById(R.id.btn_01);
        btn02=findViewById(R.id.btn_02);
        btn03=findViewById(R.id.btn_03);

        btn01.setOnClickListener(onClickListener);
        btn02.setOnClickListener(onClickListener);
        btn03.setOnClickListener(onClickListener);

        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true); // JavaScript 사용 가능
        webSettings.setBuiltInZoomControls(true); //확대 축소 가능
        webSettings.setDisplayZoomControls(false); //돋보기 없애기

    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        if(webView.canGoBack()){
            webView.goBack();
        }else{
            finish();
        }
    }

    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.btn_01:
                    String word="<h1>Hello World!</h1>";
                    webView.loadData(word,"text/html","UTF-8");
                    break;
                case R.id.btn_02:
                    webView.loadDataWithBaseURL(null,html(), "text/html", "utf-8", null);
                    break;
                case R.id.btn_03:
                    webView.loadDataWithBaseURL(null,html2(), "text/html", "utf-8", null);
                    break;
            }
        }
    };

    public String html(){
        String img="<html><head></head><body style='margin:0; padding:0; text-align:center;'><img style='width:100px; height:100px;' src=\"http://192.168.145.42:8080/test/dog.jpeg\"></body></html>";
        return img;
    }

    public String html2(){
        String img="<html><head></head><body  style='margin:0; padding:0; text-align:center;'><img style = 'width: 100%; height:auto;' src=\"http://192.168.145.42:8080/test/dog.jpeg\"></body></html>";
        return img;
    }
}
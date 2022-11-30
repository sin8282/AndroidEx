package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView = findViewById(R.id.webView);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("www.naver.com"); //https가 아니면 에러남 그럴경우 mainfest에 android:usesCleartextTraffic="true" 추가
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClientClass());
        //WebViewClient를 설정안해주면 그냥 링크처럼 창이 띄워진다. 설정해야 내앱에서 프레임안에 웹페이지가 실행된다.
        // 크롬 브라우저가 아닐때는 그냥 공통으로 사용할 매서드를 한개 만들어둔다.

    }


    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) { // 혹시모를 로딩상황시 뒤로가기정상적인 상태인지 확인 후 실행
        if(keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()){
            webView.goBack();
        }

        return super.onKeyDown(keyCode, event);
    }
}
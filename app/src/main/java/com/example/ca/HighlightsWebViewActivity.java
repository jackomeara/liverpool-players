package com.example.ca;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class HighlightsWebViewActivity extends AppCompatActivity {
    WebView webView = null;
    WebSettings webSettings = null;
    String url = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        webView = findViewById(R.id.webview);
        webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        url = (String) bundle.getSerializable("url");

        webView.loadUrl("https://www.youtube.com/watch?v=" + url);

    }
}

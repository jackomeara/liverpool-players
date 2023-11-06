package com.example.ca;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This activity holds a webview displaying a youtube video showing a player's highlights.
 * It can be viewed by clicking on the View Highlights button on the player bio.
 */
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
        webView.setWebViewClient(new WebViewClient());

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        url = (String) bundle.getSerializable("url");

        webView.loadUrl("https://www.youtube.com/watch?v=" + url);

    }
}

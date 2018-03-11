package com.example.sumansoft.ssp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

public class VideosActivity extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_video);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setTitle("Media Gallery");
        toolbar.setTitleTextColor(Color.WHITE);

        webView=(WebView) findViewById(R.id.webview);
        webView.loadUrl("https://www.youtube.com/watch?v=vt0uTWF2o4k");




        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VideosActivity.this,MainActivity.class));
            }
        });
    }
}

package org.javacream.training.android.people.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import org.javacream.training.android.R;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view);
        WebView myWebView = (WebView) findViewById(R.id.webView);
        myWebView.loadUrl("http://localhost:9090");
    }
}

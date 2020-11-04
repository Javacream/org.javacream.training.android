package org.javacream.training.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        WebView wv = findViewById(R.id.simpleWebView);
        String lastname = getIntent().getStringExtra("lastname");
        String firstname = getIntent().getStringExtra("firstname");
        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl("https://de.wikipedia.org/wiki/" + firstname + "_" + lastname);
    }
}
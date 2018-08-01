package com.example.hridoy.webbrowser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    WebView mWebView;
    EditText urlEditText;
    Button loadBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = findViewById(R.id.my_web_view);
        urlEditText = findViewById(R.id.url_edit_text);
        loadBtn = findViewById(R.id.load_btn);

        mWebView.loadUrl("https://www.google.com");

        mWebView.setWebViewClient(new WebViewClient());

        WebSettings mySettings = mWebView.getSettings();

        mySettings.setJavaScriptEnabled(true);


        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userInputUrl = urlEditText.getText().toString();

                if (userInputUrl.equals("")){
                    Toast.makeText(MainActivity.this, "Give url first", Toast.LENGTH_SHORT).show();
                }else {

                    mWebView.loadUrl("https://www."+userInputUrl);

                }
            }
        });



    }
}

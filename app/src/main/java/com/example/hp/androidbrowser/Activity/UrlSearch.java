package com.example.hp.androidbrowser.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hp.androidbrowser.R;

public class UrlSearch extends AppCompatActivity {
    private Button searchbtn,homeBtn;
    private EditText urlInput;
    private WebView searchWebAddress;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url_search);
        searchbtn = (Button)findViewById(R.id.search_btn);
        homeBtn = (Button)findViewById(R.id.home_btn);
        urlInput = (EditText)findViewById(R.id.search_url);
        searchWebAddress = (WebView)findViewById(R.id.web_view);

        url = getIntent().getExtras().get("url_address").toString();
        urlInput.setText(url);

        WebSettings webSettings = searchWebAddress.getSettings();
        webSettings.setJavaScriptEnabled(true);
        searchWebAddress.loadUrl(url);

       //setting progress dialog
        final ProgressDialog progressDialog = new ProgressDialog(UrlSearch.this,R.style.AppCompatAlertDialogStyle);
        progressDialog.setTitle("Loading...");
        progressDialog.setMessage("Please wait while we are opening your requested website ");
        progressDialog.show();
        progressDialog.setCancelable(false);
        searchWebAddress.setWebViewClient(new WebViewClient()
        {

            public void onPageFinished(WebView view, String url)
            {
                progressDialog.dismiss();
            }
        });


        //search button listener
        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             searchWebAddress();
            }
        });
        //home buttn listener
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
                Intent homepage = new Intent(UrlSearch.this,HomeActivity.class);
                startActivity(homepage);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (searchWebAddress.canGoBack()) {
            searchWebAddress.goBack();
        }
        else {
            super.onBackPressed();
        }
    }

    private void searchWebAddress() {
        String url_address = urlInput.getText().toString();
        if(TextUtils.isEmpty(url_address)){
            Toast empty = Toast.makeText(UrlSearch.this,"Please enter url or web address",Toast.LENGTH_LONG);
            empty.show();
        }
        else{

            String url_without_https = url_address.replaceAll("https://www.","");
            String https = "https://";
            String www = "www.";
            Intent search = new Intent(UrlSearch.this,UrlSearch.class);
            search.putExtra("url_address",https+www+url_without_https);
            startActivity(search);
            urlInput.setText("");
            urlInput.requestFocus();

        }
    }
}

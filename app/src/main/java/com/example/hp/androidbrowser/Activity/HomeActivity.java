package com.example.hp.androidbrowser.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hp.androidbrowser.R;

public class HomeActivity extends AppCompatActivity {
  private Button searchBtnHome;
  private EditText inputURLHome;
  private Button facebookBtn,instagramBtn,googleBtn,youtubeBtn,snapchatBtn,yahooBtn,gmailBtn,twitterBtn,linkedinBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        searchBtnHome = (Button)findViewById(R.id.search_btn_home);
        inputURLHome = (EditText)findViewById(R.id.search_url_home);
        facebookBtn  =  (Button)findViewById(R.id.facebook_btn);
        instagramBtn =  (Button)findViewById(R.id.instagram_btn);
        googleBtn    =  (Button)findViewById(R.id.google_btn);
        youtubeBtn   =  (Button)findViewById(R.id.youtube_btn);
        snapchatBtn  =  (Button)findViewById(R.id.snapchat_btn);
        yahooBtn     =   (Button)findViewById(R.id.yahoo_btn);
        gmailBtn    =    (Button)findViewById(R.id.gmail_btn);
        twitterBtn  =    (Button)findViewById(R.id.twitter_btn);
        linkedinBtn =    (Button)findViewById(R.id.linkedin_btn);
        //setting listener
        searchBtnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWebsite();
            }
        });

        //facebook listener
        facebookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Intent openFacebook = new Intent(HomeActivity.this,UrlSearch.class);
             openFacebook.putExtra("url_address","https://www.facebook.com");
             startActivity(openFacebook);
            }
        });

        //instagram listener
        instagramBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openInstagram= new Intent(HomeActivity.this,UrlSearch.class);
                openInstagram.putExtra("url_address","https://www.instagram.com");
                startActivity(openInstagram);
            }
        });

        //google listener
        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openGoogle= new Intent(HomeActivity.this,UrlSearch.class);
                openGoogle.putExtra("url_address","https://www.google.com");
                startActivity(openGoogle);
            }
        });
        //youtube listener
        youtubeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openYoutube= new Intent(HomeActivity.this,UrlSearch.class);
                openYoutube.putExtra("url_address","https://www.youtube.com");
                startActivity(openYoutube);
            }
        });

        //snapchat listener
        snapchatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openSnapchat= new Intent(HomeActivity.this,UrlSearch.class);
                openSnapchat.putExtra("url_address","https://snapchat.com");
                startActivity(openSnapchat);
            }
        });

        //yahoo listener
        yahooBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openYahoo= new Intent(HomeActivity.this,UrlSearch.class);
                openYahoo.putExtra("url_address","https://www.yahoo.com");
                startActivity(openYahoo);
            }
        });

        //gmail listener
        gmailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openGmail= new Intent(HomeActivity.this,UrlSearch.class);
                openGmail.putExtra("url_address","https://www.gmail.com");
                startActivity(openGmail);
            }
        });

        //twitter listener
        twitterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openTwitter= new Intent(HomeActivity.this,UrlSearch.class);
                openTwitter.putExtra("url_address","https://www.twitter.com");
                startActivity(openTwitter);
            }
        });
        //linkedin listener
        linkedinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openLinkedin = new Intent(HomeActivity.this,UrlSearch.class);
                openLinkedin.putExtra("url_address","https://www.linkedin.com");
                startActivity(openLinkedin);
            }
        });

    }

    private void openWebsite() {
        String url_address = inputURLHome.getText().toString();
        if(TextUtils.isEmpty(url_address)){
            Toast empty = Toast.makeText(HomeActivity.this,"Please enter url or web address",Toast.LENGTH_LONG);
            empty.show();
        }
        else{
            String url_without_https = url_address.replaceAll("https://www.","");
            String https = "https://";
            String www = "www.";
            Intent search = new Intent(HomeActivity.this,UrlSearch.class);
            search.putExtra("url_address",https+www+url_without_https);
            startActivity(search);
        }
    }
}

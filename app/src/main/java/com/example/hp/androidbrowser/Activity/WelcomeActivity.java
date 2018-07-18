package com.example.hp.androidbrowser.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hp.androidbrowser.R;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Thread thread = new Thread(){
            @Override
            public void run() {
                try{
                   sleep(2000);
                }
                catch(Exception e){
                  e.printStackTrace();
                }
                finally{
                    Intent home = new Intent(WelcomeActivity.this,HomeActivity.class);
                    startActivity(home);
                }
            }
        };
        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}

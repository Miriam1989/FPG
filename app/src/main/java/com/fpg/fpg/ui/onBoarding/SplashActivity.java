package com.fpg.fpg.ui.onBoarding;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.fpg.fpg.R;
import com.fpg.fpg.services.SyncUp;
import com.fpg.fpg.ui.home.MainActivity;


public class SplashActivity extends AppCompatActivity {

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        SyncUp syncUpServices = new SyncUp();
        syncUpServices.getOnBoardingData();
        waitChange();

    }



    private void waitChange() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                goActivity();
            }
        }, 10000);

    }

    private void goActivity() {

        //Intent intent = new Intent(this, PagerActivity.class);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }

}

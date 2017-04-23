package com.fpg.fpg.ui.onBoarding;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.Toast;

import com.fpg.fpg.R;
import com.fpg.fpg.models.OnBoarding;
import com.fpg.fpg.services.SplashServices;
import com.fpg.fpg.ws.fpgServices;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SplashActivity extends AppCompatActivity {
    private SplashServices splashServices;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        getOnBoardingData();

    }

    private void getOnBoardingData() {
        fpgServices.getServices().index().enqueue(new Callback<List<OnBoarding>>() {
            @Override
            public void onResponse(Call<List<OnBoarding>> call, Response<List<OnBoarding>> response) {
                splashServices = new SplashServices();
                splashServices.setItemOnBoarding(response.body());
                // waitChange();
            }

            @Override
            public void onFailure(Call<List<OnBoarding>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "false", Toast.LENGTH_SHORT).show();

            }
        });


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

        Intent intent = new Intent(this, PagerActivity.class);
        startActivity(intent);


    }

}

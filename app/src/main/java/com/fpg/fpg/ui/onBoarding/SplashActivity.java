package com.fpg.fpg.ui.onBoarding;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fpg.fpg.R;
import com.fpg.fpg.services.SyncUp;
import com.fpg.fpg.utils.Constants;
import com.fpg.fpg.utils.Fonts;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {

    //<editor-fold des=" * * * * *  U I    R E F E R E N C E S  * * * * * ">
    @BindView(R.id.tv_preescolar)
    TextView tvPreescolar;
    @BindView(R.id.tv_primaria)
    TextView tvPrimaria;
    @BindView(R.id.tv_secundaria)
    TextView tvSecundaria;
    @BindView(R.id.activity_splash)
    LinearLayout activitySplash;
    //</editor-fold>

    //<editor-fold des=" * * * * *  I N T E R N A L  V A R I A B L E  * * * * * ">
    private Handler handler = new Handler();
    //</editor-fold>

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        SyncUp syncUpServices = new SyncUp();
        syncUpServices.getOnBoardingData();

        setFont();
        waitChange();
    }

    private void setFont() {
        tvPreescolar.setTypeface(Fonts.getFontRoboto(this, Constants.ConstanTypeFont.DOSIS_BOLD));
        tvPrimaria.setTypeface(Fonts.getFontRoboto(this, Constants.ConstanTypeFont.DOSIS_BOLD));
        tvSecundaria.setTypeface(Fonts.getFontRoboto(this, Constants.ConstanTypeFont.DOSIS_BOLD));
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
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

}

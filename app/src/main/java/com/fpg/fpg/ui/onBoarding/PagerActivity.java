package com.fpg.fpg.ui.onBoarding;

import android.animation.ArgbEvaluator;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fpg.fpg.R;
import com.fpg.fpg.models.OnBoarding;
import com.fpg.fpg.services.OnBoardingServices;
import com.fpg.fpg.utils.Constants;
import com.fpg.fpg.utils.Fonts;
import com.fpg.fpg.utils.Utils;

import java.util.List;

/**
 * Created by jhovany on 31/03/17.
 */

public class PagerActivity extends AppCompatActivity {

    String var = "http://drive.google.com/uc?export=view&id=";
    //<editor-fold des=" * * * * *  I N T E R N A L  V A R I A B L E  * * * * * ">
    static List<OnBoarding> listView;
    public float fraction;

    public float getFraction() {
        return fraction;
    }

    public void setFraction(float fraction) {
        this.fraction = fraction;
    }

    //</editor-fold>
    // <editor-fold des=" * * * * *  U I V A R I A B L E  * * * * * ">
    private ImageView zero, one, two, three, four, five, six;
    private ImageView zeroRectangle, oneRectangle, twoRectangle, threeRectangle, fourRectangle, fiveRectangle, sixRectangle, glide;
    private ImageView[] indicators;
    private ImageView[] indicatorRectangles;
    private ImageButton mNextBtn;
    private Button mSkipBtn, mFinishBtn;
    private ViewPager mViewPager;
    private CoordinatorLayout mCoordinator;
    private ImageView circle;
    //</editor-fold>


    //<editor-fold des=" * * * * *  I N I T I A L I Z E   S E R V I C E S * * * * * ">
    OnBoardingServices onBoardingServices = new OnBoardingServices();
    //</editor-fold>


    //<editor-fold des=" * * * * *   A D A P T E R S   * * * * * ">
    SectionsPagerAdapter mSectionsPagerAdapter;
    //</editor-fold>


    int lastLeftValue = 0;


    int page = 0;   //  to track page position

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.black_trans80));
        }

        setContentView(R.layout.activity_pager);


//<editor-fold des=" * * * * *   U I  R E F E R E N C E S  * * * * * ">

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mNextBtn = (ImageButton) findViewById(R.id.intro_btn_next);
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP)
            mNextBtn.setImageDrawable(
                    Utils.tintMyDrawable(ContextCompat.getDrawable(this, R.drawable.ic_chevron_right_24dp), Color.WHITE)
            );

        mSkipBtn = (Button) findViewById(R.id.intro_btn_skip);
        mFinishBtn = (Button) findViewById(R.id.intro_btn_finish);

        zero = (ImageView) findViewById(R.id.intro_indicator_0);
        one = (ImageView) findViewById(R.id.intro_indicator_1);
        two = (ImageView) findViewById(R.id.intro_indicator_2);
        three = (ImageView) findViewById(R.id.intro_indicator_3);
        four = (ImageView) findViewById(R.id.intro_indicator_4);
        five = (ImageView) findViewById(R.id.intro_indicator_5);
        six = (ImageView) findViewById(R.id.intro_indicator_6);

        zeroRectangle = (ImageView) findViewById(R.id.progress_0);
        oneRectangle = (ImageView) findViewById(R.id.progress_1);
        twoRectangle = (ImageView) findViewById(R.id.progress_2);
        threeRectangle = (ImageView) findViewById(R.id.progress_3);
        fourRectangle = (ImageView) findViewById(R.id.progress_4);
        fiveRectangle = (ImageView) findViewById(R.id.progress_5);
        mCoordinator = (CoordinatorLayout) findViewById(R.id.main_content);
        circle = (ImageView) findViewById(R.id.imageView);
        //</editor-fold>

        //<editor-fold des=" * * * * *  I N I T I A L I Z E   E L E M E N T S * * * * * ">
        listView = onBoardingServices.getView();
        indicators = new ImageView[]{zero, one, two, three, four, five, six};
        indicatorRectangles = new ImageView[]{zeroRectangle, oneRectangle, twoRectangle, threeRectangle, fourRectangle, fiveRectangle, sixRectangle};

        //</editor-fold>


        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


        mViewPager.setCurrentItem(page);
        updateIndicators(page);

        final int color1 = Color.parseColor(listView.get(0).getBoardCircleColor());
        final int color2 = Color.parseColor(listView.get(1).getBoardCircleColor());
        final int color3 = Color.parseColor(listView.get(2).getBoardCircleColor());
        final int color4 = Color.parseColor(listView.get(3).getBoardCircleColor());
        final int color5 = Color.parseColor(listView.get(4).getBoardCircleColor());
        final int color6 = Color.parseColor(listView.get(5).getBoardCircleColor());
        final int color7 = Color.parseColor(listView.get(6).getBoardCircleColor());

        final int[] colorList = new int[]{color1, color2, color3, color4, color5, color6, color7};

        final ArgbEvaluator evaluator = new ArgbEvaluator();
        final Drawable circlee = ContextCompat.getDrawable(this, R.drawable.ic_circle);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                int colorUpdate = (Integer) evaluator.evaluate(positionOffset, colorList[position], colorList[position == 6 ? position : position + 1]);

                circlee.setColorFilter(colorUpdate, PorterDuff.Mode.SRC_ATOP);
                circle.setBackground(circlee);

            }

            @Override
            public void onPageSelected(int position) {

                page = position;

                updateIndicators(page);
/*
                switch (position) {
                    case 0:
                        mViewPager.setBackgroundColor(color1);
                        break;
                    case 1:
                        mViewPager.setBackgroundColor(color2);
                        break;
                    case 2:
                        mViewPager.setBackgroundColor(color3);
                        break;
                    case 3:
                        mViewPager.setBackgroundColor(color3);
                        break;
                    case 4:
                        mViewPager.setBackgroundColor(color3);
                        break;
                    case 5:
                        mViewPager.setBackgroundColor(color3);
                        break;
                    case 6:
                        mViewPager.setBackgroundColor(color3);
                        break;
                }

*/
                mNextBtn.setVisibility(position == 2 ? View.GONE : View.VISIBLE);
                mFinishBtn.setVisibility(position == 2 ? View.VISIBLE : View.GONE);


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page += 1;
                mViewPager.setCurrentItem(page, true);
            }
        });

        mSkipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        mFinishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                //  update 1st time pref
                //   Utils.saveSharedSetting(PagerActivity.this, MainActivity.PREF_USER_FIRST_TIME, "false");

            }
        });

    }

    void updateIndicators(int position) {
        for (int i = 0; i < indicators.length; i++) {
            indicators[i].setBackgroundResource(
                    i <= position ? R.drawable.indicator_selected : R.drawable.indicator_unselected);

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pager, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        private PlaceholderFragment placeholderFragment;

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            placeholderFragment = PlaceholderFragment.newInstance(position + 1);
            return placeholderFragment;

        }


        @Override
        public int getCount() {
            // Show 7 total pages.
            return 7;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }

    }


    public static class PlaceholderFragment extends Fragment {

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        private static final String ARG_SECTION_NUMBER = "section_number";
        final ArgbEvaluator evaluator = new ArgbEvaluator();
        ImageView img;

        public PlaceholderFragment() {

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_pager, container, false);
            TextView type = (TextView) rootView.findViewById(R.id.section_label);
            type.setTypeface(Fonts.getFontRoboto(getContext(), Constants.ConstanTypeFont.ROBOTO_MEDIUM));

            TextView mDescription = (TextView) rootView.findViewById(R.id.tv_description);
            mDescription.setTypeface(Fonts.getFontRoboto(getContext(), Constants.ConstanTypeFont.OPENSANS_REGULAR));

            int positionPager = (getArguments().getInt(ARG_SECTION_NUMBER) - 1);
            img = (ImageView) rootView.findViewById(R.id.section_img);


            Glide.with(this).load(Constants.GoogleDrive.DRIVE_IMAGE_ROUTE + listView.get(positionPager).getBoardImage()).into(img);
            type.setText(listView.get(positionPager).getBoardingName());
            mDescription.setText(listView.get(positionPager).getBoardDescription());

            return rootView;
        }

    }


}
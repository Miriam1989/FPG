package com.fpg.fpg.ui.home;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.fpg.fpg.R;
import com.fpg.fpg.adapters.ListHeaderNewsAdapter;
import com.fpg.fpg.interfaces.GroupCallbacks;
import com.fpg.fpg.models.GroupNews;
import com.fpg.fpg.models.News;
import com.fpg.fpg.models.OnBoarding;
import com.fpg.fpg.utils.Constants;
import com.fpg.fpg.ws.fpgServices;
import com.orm.query.Condition;
import com.orm.query.Select;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, GroupCallbacks {

    private RecyclerView mRecyclerView;
    private ListHeaderNewsAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private GroupCallbacks mGroupCallbacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Actividades");
        setSupportActionBar(toolbar);

        mGroupCallbacks = this;

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.getMenu().size();

        MenuItem mi = navigationView.getMenu().getItem(0);
        mi.setVisible(true);
        mi.setTitle("Actividades");

        final TextView tv_title = (TextView) navigationView.getHeaderView(0).findViewById(R.id.tv_title);
        final TextView tv_subtitle = (TextView) navigationView.getHeaderView(0).findViewById(R.id.tv_subtitle);
        final ImageView iv = (ImageView) navigationView.getHeaderView(0).findViewById(R.id.iv_profile);

        Glide.with(this).load(R.drawable.ic_logo).asBitmap().centerCrop().into(new BitmapImageViewTarget(iv) {

            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(getBaseContext().getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                iv.setImageDrawable(circularBitmapDrawable);
            }
        });

        tv_title.setText("Colegio Fray Pedro de Gante");
        tv_subtitle.setText("fpg_developer@gmail.com");

        fpgServices.getServices().index().enqueue(new Callback<List<OnBoarding>>() {
            @Override
            public void onResponse(Call<List<OnBoarding>> call, Response<List<OnBoarding>> response) {
                Toast.makeText(MainActivity.this, "true", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<OnBoarding>> call, Throwable t) {
                // Toast.makeText(MainActivity.this, "false", Toast.LENGTH_SHORT).show();

            }
        });
        initRecyclerView();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_section_1) {

        } else if (id == R.id.nav_section_2) {

        } else if (id == R.id.nav_section_3) {

        } else if (id == R.id.nav_section_4) {

        } else if (id == R.id.nav_section_5) {


        } else if (id == R.id.nav_divisor_section1) {


        } else if (id == R.id.nav_divisor_section2) {


        } else if (id == R.id.nav_divisor_section3) {


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void initRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_headerNews);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        List<GroupNews> groupNewsList = Select.from(GroupNews.class).list();

        for (GroupNews groupNews : groupNewsList) {

            groupNews.setNews(Select.from(News.class).where(Condition.prop("GROUP_NEWS").eq(groupNews.getRemoteId())).list());
        }

        mAdapter = new ListHeaderNewsAdapter(groupNewsList, getApplicationContext(), mGroupCallbacks);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void invokeActivity(Class activity, Long putExtras) {
        Intent intent = new Intent(this, activity);
        intent.putExtra(Constants.Group.GROUP_NEWS, putExtras);
        startActivity(intent);
    }
}

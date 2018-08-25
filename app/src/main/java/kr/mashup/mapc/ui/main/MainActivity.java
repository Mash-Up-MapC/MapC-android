package kr.mashup.mapc.ui.main;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import kr.mashup.mapc.R;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private static final int PAGER_SCREEN_OFFSET_LIMIT = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TabLayout tabLayout = findViewById(R.id.tab_layout);

        viewPager = findViewById(R.id.view_pager);
        viewPager.setOffscreenPageLimit(PAGER_SCREEN_OFFSET_LIMIT);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);

        getSupportActionBar().setElevation(0);
    }
}

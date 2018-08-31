package kr.mashup.mapc.ui.main;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import kr.mashup.mapc.R;
import kr.mashup.mapc.ui.base.BaseActivity;

public class MainActivity extends BaseActivity {

    private ViewPager viewPager;
    private static final int PAGER_SCREEN_OFFSET_LIMIT = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBarColor(Color.WHITE);
        setStatusBarLight();
        setContentView(R.layout.activity_main);

        final TabLayout tabLayout = findViewById(R.id.tab_layout);

        viewPager = findViewById(R.id.view_pager);
        viewPager.setOffscreenPageLimit(PAGER_SCREEN_OFFSET_LIMIT);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);
    }
}

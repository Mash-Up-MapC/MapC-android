package kr.mashup.mapc.ui.main;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import kr.mashup.mapc.R;
import kr.mashup.mapc.ui.base.BaseActivity;

tivity;

public class MainActivity extends BaseActivity {

    private ViewPager viewPager;
    private static final int PAGER_SCREEN_OFFSET_LIMIT = 3;

    private static final int[] TAB_IMAGES = {R.drawable.ic_course, R.drawable.ic_booking, R.drawable.ic_guide, R.drawable.ic_bus, R.drawable.ic_etc};
    private static final String[] TAB_TEXTS = {"코스", "예약", "가이드", "버스", "전체"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBarColor(Color.WHITE);
        setStatusBarLight();
        setContentView(R.layout.activity_main);


        viewPager = findViewById(R.id.view_pager);
        viewPager.setOffscreenPageLimit(PAGER_SCREEN_OFFSET_LIMIT);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);

        initTab();
    }

    private void initTab() {
        TabLayout tabLayout = findViewById(R.id.tab_layout);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorHeight(0);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            View tabView = LayoutInflater.from(this).inflate(R.layout.item_main_tab, null, false);

            ImageView tabIcon = tabView.findViewById(R.id.tab_icon);
            TextView tabText = tabView.findViewById(R.id.tab_text);

            tabIcon.setImageResource(TAB_IMAGES[i]);
            tabText.setText(TAB_TEXTS[i]);
            tabLayout.getTabAt(i).setCustomView(tabView);
        }
    }
}

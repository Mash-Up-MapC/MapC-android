package mashup.kr.mapc.ui.main;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import mashup.kr.mapc.ui.main.course.CourseFragment;
import mashup.kr.mapc.ui.main.booking.BookingFragment;
import mashup.kr.mapc.ui.main.guide.GuideFragment;
import mashup.kr.mapc.ui.main.etc.EtcFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter{

    private String[] tabTitles = new String[] {"홈", "큐앤픽", "오늘의 패션", "내 정보"};

    public ViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return CourseFragment.newInstance();
            case 1:
                return EtcFragment.newInstance();
            case 2:
                return BookingFragment.newInstance();
            case 3:
                return GuideFragment.newInstance();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}

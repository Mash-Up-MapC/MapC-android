package mashup.kr.mapc;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter{

    public ViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return HomeFragment.newInstance();
            case 1:
                return QnpFragment.newInstance();
            case 2:
                return MagazineFragment.newInstance();
            case 3:
                return MypageFragment.newInstance();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}

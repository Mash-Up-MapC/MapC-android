package kr.mashup.mapc.ui.main.guide;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import kr.mashup.mapc.R;
import kr.mashup.mapc.ui.main.MainActivity;
import me.relex.circleindicator.CircleIndicator;

public class GuideFragment extends Fragment {

    View view;
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static final String[] stationImageUrls= {"https://s3.ap-northeast-2.amazonaws.com/key-s3/mapc/%E1%84%80%E1%85%AA%E1%86%BC%E1%84%92%E1%85%AA%E1%84%86%E1%85%AE%E1%86%AB1.JPG",
            "https://s3.ap-northeast-2.amazonaws.com/key-s3/mapc/%E1%84%80%E1%85%AA%E1%86%BC%E1%84%92%E1%85%AA%E1%84%86%E1%85%AE%E1%86%AB2.jpg",
            "https://s3.ap-northeast-2.amazonaws.com/key-s3/mapc/%E1%84%80%E1%85%AA%E1%86%BC%E1%84%92%E1%85%AA%E1%84%86%E1%85%AE%E1%86%AB3.jpeg"};
    private ArrayList<String> ImageUrlsArray = new ArrayList<String>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_guide, container, false);
        init();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void init() {
        for(int i=0;i<stationImageUrls.length;i++)
            ImageUrlsArray.add(stationImageUrls[i]);

        mPager = (ViewPager)view.findViewById(R.id.pager);
        mPager.setAdapter(new SliderAdapter(getContext(),ImageUrlsArray));
        CircleIndicator indicator = (CircleIndicator) view.findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == stationImageUrls.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2500, 2500);
    }
    public class NaverCSSTask extends AsyncTask<String[],Void, String> {
        @Override
        protected String doInBackground(String[]... strings) {
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }
}

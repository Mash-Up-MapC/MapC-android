package kr.mashup.mapc;

import android.app.Application;
import android.appwidget.AppWidgetProvider;

/**
 * Created by jeongahri on 2018. 7. 1..
 */

public class BaseActivity extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        TypeFaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/IropkeBatangM.ttf");
    }
}

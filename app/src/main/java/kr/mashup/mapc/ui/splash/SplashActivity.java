package kr.mashup.mapc.ui.splash;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Completable;
import io.reactivex.functions.Action;
import kr.mashup.mapc.R;
import kr.mashup.mapc.ui.base.BaseActivity;
import kr.mashup.mapc.ui.main.MainActivity;

public class SplashActivity extends BaseActivity {

    private static final long SPLASH_DELAY = 1000 * 2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBarColor(Color.WHITE);
        setStatusBarLight();
        setContentView(R.layout.activity_splash);

        init();
    }

    private void init() {
        Completable.timer(SPLASH_DELAY, TimeUnit.MILLISECONDS)
                .subscribe(this::startMainActivity);
    }

    private void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        finish();
    }
}

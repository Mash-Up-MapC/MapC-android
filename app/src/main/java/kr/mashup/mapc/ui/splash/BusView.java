package kr.mashup.mapc.ui.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import kr.mashup.mapc.R;

public class BusView extends View {

    private Bitmap imageBackground;
    private Bitmap imageCloud;
    private Bitmap imageBusTop;
    private Bitmap imageBusBottom;

    public BusView(Context context) {
        super(context);

        init();
    }

    public BusView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    private void init() {
        loadResource();
    }

    private void loadResource() {
        imageBackground = decodeResource(R.drawable.background_splash_bus);
        imageCloud = decodeResource(R.drawable.img_splash_cloud);
        imageBusTop = decodeResource(R.drawable.img_splash_bus_top);
        imageBusBottom = decodeResource(R.drawable.img_splash_bus_bottom);
    }

    private Bitmap decodeResource(@DrawableRes int drawableId) {
        return BitmapFactory.decodeResource(getResources(), drawableId);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}

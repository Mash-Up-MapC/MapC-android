package kr.mashup.mapc.ui.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import kr.mashup.mapc.R;

public class BusView extends View {

    private int viewWidth;
    private int viewHeight;
    private float viewScale;

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
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        viewWidth = getMeasuredWidth();
        viewHeight = getMeasuredHeight();

        viewScale = (float) viewWidth / imageBackground.getWidth();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.scale(viewScale, viewScale);

        draw(canvas, imageBackground, 0, 0);
    }

    private void draw(Canvas canvas, Bitmap bitmap, int posX, int posY) {
        draw(canvas, bitmap, (float) posX, (float) posY);
    }

    private void draw(Canvas canvas, Bitmap bitmap, float posX, float posY) {
        canvas.drawBitmap(
                bitmap,
                new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()),
                new RectF(posX, posY, posX + bitmap.getWidth(), posY + bitmap.getHeight()),
                null
        );
    }

}

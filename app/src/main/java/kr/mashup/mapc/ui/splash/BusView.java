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

    private static final String TAG = BusView.class.getSimpleName();

    private int viewWidth;
    private int viewHeight;
    private float viewScale;

    private long lastMeasureTime = System.currentTimeMillis();
    private long frameCount = 0;

    private Bitmap imageBackground;
    private Bitmap imageCloud;
    private Bitmap imageBusTop;
    private Bitmap imageBusBottom;

    private static final int BACKGROUND_MOVE_SPEED = 5;
    private static final int CLOUD_MOVE_SPEED = 2;

    private int backgroundPosX = 0;
    private int cloudPosX = 0;

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

        drawViews(canvas);

        logFrame();
        invalidate();
    }

    private void drawViews(Canvas canvas) {
        drawBackground(canvas);
        drawCloud(canvas);
        drawBus(canvas);
    }

    private void drawBackground(Canvas canvas) {
        backgroundPosX += BACKGROUND_MOVE_SPEED;
        backgroundPosX %= imageBackground.getWidth();
        draw(canvas, imageBackground, backgroundPosX, 0);
        draw(canvas, imageBackground, backgroundPosX + imageBackground.getWidth(), 0);
        draw(canvas, imageBackground, backgroundPosX - imageBackground.getWidth(), 0);
    }

    private void drawCloud(Canvas canvas) {
        cloudPosX += CLOUD_MOVE_SPEED;
        cloudPosX %= (imageBackground.getWidth() + imageCloud.getWidth());

        draw(canvas, imageCloud, cloudPosX - imageCloud.getWidth(), 0);
    }

    private void drawBus(Canvas canvas) {
        draw(canvas, imageBusTop, 187, 247);
        draw(canvas, imageBusBottom, 100, 350);
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

    private void logFrame() {
        frameCount++;

        long currentTime = System.currentTimeMillis();

        if (currentTime > lastMeasureTime + 1000) {
            long timeDiff = currentTime - lastMeasureTime;
            float framePerSecond = (float) frameCount / (timeDiff / 1000);
            Log.d(TAG, "avg frame per second : " + framePerSecond);

            lastMeasureTime = currentTime;
            frameCount = 0;
        }
    }

}

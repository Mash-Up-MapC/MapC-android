package kr.mashup.mapc.ui.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

import net.jspiner.animation.AnimationBuilder;

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
    private Bitmap imageBusWheel;

    private static final int BACKGROUND_MOVE_SPEED = 5;
    private static final int CLOUD_MOVE_SPEED = 2;
    private static final int BUS_ANIMATION_CYCLE = 180;
    private static final int BUS_BOTTOM_ANIMATION_CYCLE = 45;
    private static final int BUS_ANIMATION_DURATION = 300;
    private static final int BUS_TOP_ANIMATION_DURATION = 400;
    private static final int[] BUS_ANIMATION_PATTERN = {0, 2, -7, 0};
    private static final int[] BUS_TOP_ANIMATION_PATTERN = {0, 2, -7, -20, 0};
    private static final int BUS_WHEEL_SPEED = 7;

    private int backgroundPosX = 0;
    private int cloudPosX = 0;
    private int busPosY = 0;
    private int busTopPosY = 0;
    private int wheelAngle = 0;

    private long busAnimationCount = 0;

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
        imageBusWheel = decodeResource(R.drawable.img_splash_bus_wheel);
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
        animateViews();

        logFrame();
        invalidate();
    }

    private void drawViews(Canvas canvas) {
        drawBackground(canvas);
        drawCloud(canvas);
        drawBus(canvas);
    }

    private void animateViews() {
        animateBackground();
        animateBus();
    }

    private void drawBackground(Canvas canvas) {
        draw(canvas, imageBackground, backgroundPosX, 0);
        draw(canvas, imageBackground, backgroundPosX + imageBackground.getWidth(), 0);
        draw(canvas, imageBackground, backgroundPosX - imageBackground.getWidth(), 0);
    }

    private void drawCloud(Canvas canvas) {
        draw(canvas, imageCloud, cloudPosX - imageCloud.getWidth(), 0);
    }

    private void drawBus(Canvas canvas) {
        draw(canvas, imageBusTop, 187, 247 + busPosY + busTopPosY);
        draw(canvas, imageBusBottom, 100, 350 + busPosY);
        draw(canvas, imageBusWheel, 217, 517 + busPosY, wheelAngle);
        draw(canvas, imageBusWheel, 459, 517 + busPosY, wheelAngle);
    }

    private void animateBackground() {
        backgroundPosX += BACKGROUND_MOVE_SPEED;
        backgroundPosX %= imageBackground.getWidth();

        cloudPosX += CLOUD_MOVE_SPEED;
        cloudPosX %= (imageBackground.getWidth() + imageCloud.getWidth());
    }

    private void animateBus() {
        busAnimationCount++;
        busAnimationCount %= BUS_ANIMATION_CYCLE;
        if (busAnimationCount % BUS_BOTTOM_ANIMATION_CYCLE == 0) {
            AnimationBuilder.builder()
                    .valueAnimator(BUS_ANIMATION_PATTERN)
                    .duration(BUS_ANIMATION_DURATION)
                    .interpolator(new LinearInterpolator())
                    .onUpdate(value -> busPosY = value)
                    .start();
        }

        if (busAnimationCount % BUS_ANIMATION_CYCLE == 0) {
            AnimationBuilder.builder()
                    .valueAnimator(BUS_TOP_ANIMATION_PATTERN)
                    .duration(BUS_TOP_ANIMATION_DURATION)
                    .interpolator(new LinearInterpolator())
                    .onUpdate(value -> busTopPosY = value)
                    .start();
        }
        wheelAngle += BUS_WHEEL_SPEED;
        wheelAngle %= 360;
    }

    private void draw(Canvas canvas, Bitmap bitmap, int posX, int posY) {
        draw(canvas, bitmap, (float) posX, (float) posY);
    }

    private void draw(Canvas canvas, Bitmap bitmap, float posX, float posY) {
        draw(canvas, bitmap, posX, posY, 0);
    }

    private void draw(Canvas canvas, Bitmap bitmap, float posX, float posY, float angle) {
        posX = scaleDpi(posX);
        posY = scaleDpi(posY);
        Matrix drawMatrix = new Matrix();
        drawMatrix.setRotate(
                -angle,
                bitmap.getWidth() / 2,
                bitmap.getHeight() / 2
        );
        drawMatrix.postTranslate(posX, posY);

        canvas.drawBitmap(bitmap, drawMatrix, null);
    }

    private float scaleDpi(float position) {
        float density = getResources().getDisplayMetrics().density;
        return position * (density / 2.0f);
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

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();

        imageBackground.recycle();
        imageCloud.recycle();
        imageBusTop.recycle();
        imageBusBottom.recycle();
        imageBusWheel.recycle();
    }
}

package ir.alirezabdn.wp7progress;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class WP10ProgressBar extends RelativeLayout {

    private static final int INTERVAL_DEF = 150;
    private static final int INDICATOR_COUNT_DEF = 5;
    private static final int ANIMATION_DURATION_DEF = 1800;
    private static final int INDICATOR_HEIGHT_DEF = 7;
    private static final int INDICATOR_RADIUS_DEF = 0;

    private int interval;
    private int animationDuration;
    private int indicatorHeight;
    private int indicatorColor;
    private int indicatorRadius;

    private boolean isShowing = false;
    private ArrayList<WP10Indicator> wp10Indicators;

    private Handler handler;
    private int progressBarCount = 0;

    public WP10ProgressBar(Context context) {
        super(context);
        initialize(null);
    }

    public WP10ProgressBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize(attrs);
    }

    public WP10ProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(attrs);
    }

    private void initialize(@Nullable AttributeSet attrs) {
        this.setGravity(Gravity.CENTER);
        this.handler = new Handler();
        this.setRotation(-25);
        setAttributes(attrs);
        initializeIndicators();
    }

    private void setAttributes(AttributeSet attributeSet) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.WP10ProgressBar);
        interval = typedArray.getInt(R.styleable.WP7ProgressBar_interval, INTERVAL_DEF);
        animationDuration = typedArray.getInt(R.styleable.WP7ProgressBar_animationDuration, ANIMATION_DURATION_DEF);
        indicatorHeight = typedArray.getInt(R.styleable.WP7ProgressBar_indicatorHeight, INDICATOR_HEIGHT_DEF);
        indicatorRadius = typedArray.getInt(R.styleable.WP7ProgressBar_indicatorRadius, INDICATOR_RADIUS_DEF);
        indicatorColor = typedArray.getColor(R.styleable.WP7ProgressBar_indicatorColor,
                ContextCompat.getColor(getContext(), R.color.colorAccent));
        typedArray.recycle();
    }

    private void showAnimation() {
        for (int i = 0; i < wp10Indicators.size(); i++) {
            wp10Indicators.get(i).startAnim(animationDuration, (5 - i) * interval);
        }
    }

    private void initializeIndicators() {
        if (wp10Indicators == null) {
            ArrayList<WP10Indicator> WP10Indicators = new ArrayList<>();
            for (int i = 0; i < INDICATOR_COUNT_DEF; i++) {
                WP10Indicator wp10Indicator = new WP10Indicator(getContext(), indicatorHeight, indicatorColor, indicatorRadius, i);
//                wp10Indicator.setRotation(i * 14);
                WP10Indicators.add(wp10Indicator);
                this.addView(wp10Indicator);
            }
            this.wp10Indicators = WP10Indicators;
        }
    }

    private void show() {
        if (isShowing)
            return;
        isShowing = true;
        showAnimation();
//        startWholeViewAnimation();
    }

    private void hide() {
        clearIndicatorsAnimations();
        isShowing = false;
//        hideWholeViewAnimation();
    }

    private void clearIndicatorsAnimations() {
        for (WP10Indicator wp10Indicator : wp10Indicators) {
            wp10Indicator.removeAnim();
        }
    }

    public void showProgressBar() {
        progressBarCount++;
        if (progressBarCount == 1) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    WP10ProgressBar.this.show();
                }
            });
        }
    }

    public void hideProgressBar() {
        progressBarCount--;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (progressBarCount == 0) {
                    WP10ProgressBar.this.hide();
                }
            }
        }, 50);
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public void setAnimationDuration(int animationDuration) {
        this.animationDuration = animationDuration;
    }

    public void setIndicatorHeight(int indicatorHeight) {
        this.indicatorHeight = indicatorHeight;
    }

    public void setIndicatorColor(int indicatorColor) {
        this.indicatorColor = indicatorColor;
    }

    public void setIndicatorRadius(int indicatorRadius) {
        this.indicatorRadius = indicatorRadius;
    }
}

package ir.alirezabdn.wp7progress;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class WP7ProgressBar extends LinearLayout {

    private static final int INTERVAL_DEF = 150;
    private static final int INDICATOR_COUNT_DEF = 5;
    private static final int ANIMATION_DURATION_DEF = 2200;
    private static final int INDICATOR_HEIGHT_DEF = 5;

    private int interval;
    private int animationDuration;
    private int indicatorHeight;
    private int indicatorColor;

    private boolean isShowing = false;
    private ArrayList<Indicator> indicators;

    private Handler handler;
    private int progressBarCount = 0;

    public WP7ProgressBar(Context context) {
        super(context);
        initialize(null);
    }

    public WP7ProgressBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize(attrs);
    }

    public WP7ProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(attrs);
    }

    private void initialize(@Nullable AttributeSet attrs) {
        this.setGravity(Gravity.CENTER);
        this.setOrientation(HORIZONTAL);
        this.handler = new Handler();
        setAttributes(attrs);
        initializeIndicators();
    }

    private void setAttributes(AttributeSet attributeSet) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.WP7ProgressBar);
        interval = typedArray.getInt(R.styleable.WP7ProgressBar_interval, INTERVAL_DEF);
        animationDuration = typedArray.getInt(R.styleable.WP7ProgressBar_animationDuration, ANIMATION_DURATION_DEF);
        indicatorHeight = typedArray.getInt(R.styleable.WP7ProgressBar_indicatorHeight, INDICATOR_HEIGHT_DEF);
        indicatorColor = typedArray.getColor(R.styleable.WP7ProgressBar_indicatorColor,
                ContextCompat.getColor(getContext(), R.color.colorAccent));
        typedArray.recycle();
    }

    private void showAnimation() {
        for (int i = 0; i < indicators.size(); i++) {
            indicators.get(i).startAnim(animationDuration, (5 - i) * interval);
        }
    }

    private void initializeIndicators() {
        if (indicators == null) {
            ArrayList<Indicator> indicators = new ArrayList<>();
            for (int i = 0; i < INDICATOR_COUNT_DEF; i++) {
                Indicator indicator = new Indicator(getContext(), indicatorHeight, indicatorColor);
                indicators.add(indicator);
                this.addView(indicator);
            }
            this.indicators = indicators;
        }
    }

    private void show() {
        if (isShowing)
            return;
        isShowing = true;
        showAnimation();
    }

    private void hide() {
        clearIndicatorsAnimations();
        isShowing = false;
    }

    private void clearIndicatorsAnimations() {
        for (Indicator indicator : indicators) {
            indicator.removeAnim();
        }
    }

    public void showProgressBar() {
        progressBarCount++;
        if (progressBarCount == 1) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    WP7ProgressBar.this.show();
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
                    WP7ProgressBar.this.hide();
                }
            }
        }, 50);
    }
}

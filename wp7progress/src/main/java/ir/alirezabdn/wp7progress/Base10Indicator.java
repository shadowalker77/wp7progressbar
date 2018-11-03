package ir.alirezabdn.wp7progress;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;

public class Base10Indicator extends View {
    private int color;

    public Base10Indicator(Context context, int indicatorHeight, int color, int radius) {
        super(context);
        this.color = color;
        initialize(indicatorHeight, radius);
    }

    private void initialize(int indicatorHeight, int radius) {
        this.setBackground(getCube(radius));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(Utils.px2dp(getContext(), indicatorHeight), Utils.px2dp(getContext(), indicatorHeight));
//        layoutParams.rightMargin = Utils.px2dp(getContext(), (int) (1.7f * indicatorHeight));
        this.setLayoutParams(layoutParams);
//        startAnim(0, 0);
//        removeAnim();
    }

    private GradientDrawable getCube(int radius) {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.RECTANGLE);
        drawable.setColor(color);
        drawable.setCornerRadius(Utils.px2dp(getContext(), radius));
        return drawable;
    }
}

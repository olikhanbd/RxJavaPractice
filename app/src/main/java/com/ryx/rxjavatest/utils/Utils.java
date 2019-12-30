package com.ryx.rxjavatest.utils;

import android.content.Context;
import android.util.TypedValue;

public class Utils {

    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier(
                "status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public static int getActionBarHeight(Context context) {
        int actionBarHeight = 0;
        // Calculate ActionBar height
        TypedValue tv = new TypedValue();
        if (context.getTheme()
                .resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
            actionBarHeight =
                    TypedValue.complexToDimensionPixelSize(
                            tv.data, context.getResources().getDisplayMetrics());
        }

        return actionBarHeight;
    }
}

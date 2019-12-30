package com.ryx.rxjavatest;

import android.app.Application;
import android.graphics.Rect;
import android.view.Window;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier(
                "status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}

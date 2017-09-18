package com.framgia.moviedb;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by workspace on 18/09/2017.
 */

public class MyApplication extends Application {
    public static void setColorStatusBar(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(activity, R.color.colorStatusBar));
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}

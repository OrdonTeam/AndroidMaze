package com.ordonteam.commons;
//import groovy.transform.CompileStatic

import android.app.Activity;

//@CompileStatic
//WARNING THIS IS NOT GROOVY CLASS
public class Util {
    public static <T> T getFromIntent(Activity activity, Class<T> p) {
        return (T) activity.getIntent().getExtras().getSerializable(p.getSimpleName());
    }

    public static Thread startThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.start();
        return thread;
    }
}

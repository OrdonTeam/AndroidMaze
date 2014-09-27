package com.ordonteam.custom

import android.app.Activity
import android.os.Bundle
import groovy.transform.CompileStatic

@CompileStatic
class CustomActivity extends Activity {
    private CustomLayout layout

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        layout = new CustomLayout(this)
        setContentView(layout);
    }
}

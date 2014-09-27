package com.ordonteam.levels

import android.app.Activity
import android.os.Bundle
import groovy.transform.CompileStatic

@CompileStatic
class LevelsActivity extends Activity {
    private LevelsLayout layout

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        layout = new LevelsLayout(this)
        setContentView(layout);
    }
}

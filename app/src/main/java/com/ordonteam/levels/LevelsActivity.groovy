package com.ordonteam.levels

import android.app.Activity
import android.os.Bundle
import android.widget.RelativeLayout
import com.ordonteam.background.BackgroundMazeDrawer
import groovy.transform.CompileStatic

@CompileStatic
class LevelsActivity extends Activity {
    BackgroundMazeDrawer drawer

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        RelativeLayout global = new RelativeLayout(this);

        drawer = new BackgroundMazeDrawer()
        global.addView(drawer.onCreate(this))

        LevelsLayout layout = new LevelsLayout(this)
        global.addView(layout)

        setContentView(global);
    }

    @Override
    void onResume(){
        super.onResume()
        drawer.onResume()
    }

    @Override
    void onPause(){
        super.onPause()
        drawer.onPause()
    }
}

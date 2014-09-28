package com.ordonteam

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RelativeLayout
import com.ordonteam.commons.CenteredLayout
import com.ordonteam.commons.DrawableView
import com.ordonteam.custom.CMGCanvas
import com.ordonteam.custom.CustomActivity
import com.ordonteam.levels.LevelsActivity
import groovy.transform.CompileStatic

@CompileStatic
class MainActivity extends Activity {
    CMGCanvas bgThread;
    DrawableView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        def layout = new RelativeLayout(this);
        CenteredLayout centeredLayout = new CenteredLayout(this)
        bgThread = new CMGCanvas()
        view = new DrawableView(this, bgThread.maze)
        layout.addView(view)
        centeredLayout.addView(levelsButton())
        centeredLayout.addView(customButton())
        layout.addView(centeredLayout)
        setContentView(layout);
        bgThread.start(view)
    }

    private Button levelsButton() {
        Button button = new Button(this)
        button.setText('levelsButton')
        button.setOnClickListener({
            startActivity(LevelsActivity.class)
        })
        return button
    }

    private Button customButton() {
        Button button = new Button(this)
        button.setText('customButton')
        button.setOnClickListener({
            startActivity(CustomActivity.class)
        })
        return button
    }

    private void startActivity(Class<?> activity) {
        Intent intent = new Intent(this, activity)
        startActivity(intent)
    }

    @Override
    protected void onPause() {
        bgThread.stop()
    }
}
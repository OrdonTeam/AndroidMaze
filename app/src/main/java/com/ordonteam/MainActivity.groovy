package com.ordonteam

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RelativeLayout
import com.ordonteam.background.CMGCanvas
import com.ordonteam.commons.CenteredLayout
import com.ordonteam.commons.DrawableView
import com.ordonteam.custom.CustomActivity
import com.ordonteam.levels.LevelsActivity
import groovy.transform.CompileStatic

@CompileStatic
class MainActivity extends Activity {
    DrawableView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        def layout = new RelativeLayout(this);
        view = new CMGCanvas().start(this)
        layout.addView(view)

        CenteredLayout centeredLayout = new CenteredLayout(this)
        centeredLayout.addView(levelsButton())
        centeredLayout.addView(customButton())
        layout.addView(centeredLayout)
        setContentView(layout);
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
        super.onPause();
    }
}
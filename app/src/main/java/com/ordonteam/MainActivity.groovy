package com.ordonteam

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RelativeLayout
import com.ordonteam.background.BackgroundMazeDrawer
import com.ordonteam.commons.CenteredLayout
import com.ordonteam.custom.CustomActivity
import com.ordonteam.levels.LevelsActivity
import groovy.transform.CompileStatic

@CompileStatic
class MainActivity extends Activity {
    private BackgroundMazeDrawer drawer

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        RelativeLayout layout = new RelativeLayout(this);

        drawer = new BackgroundMazeDrawer()
        layout.addView(drawer.onCreate(this))

        CenteredLayout centeredLayout = new CenteredLayout(this)
        centeredLayout.addView(startButton('levelsButton', LevelsActivity.class))
        centeredLayout.addView(startButton('customButton', CustomActivity.class))
        layout.addView(centeredLayout)

        setContentView(layout)
    }

    private Button startButton(String text, Class<?> activityToStart) {
        Button button = new Button(this)
        button.setText(text)
        button.setOnClickListener({
            startActivity(activityToStart)
        })
        return button
    }

    private void startActivity(Class<?> activity) {
        Intent intent = new Intent(this, activity)
        startActivity(intent)
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
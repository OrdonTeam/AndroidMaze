package com.ordonteam

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import com.ordonteam.custom.CustomActivity
import com.ordonteam.levels.LevelsActivity
import com.ordonteam.commons.CenteredLayout
import groovy.transform.CompileStatic

@CompileStatic
class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        CenteredLayout centeredLayout = new CenteredLayout(this)
        centeredLayout.addView(levelsButton())
        centeredLayout.addView(customButton())
        setContentView(centeredLayout);
    }

    private Button levelsButton() {
        Button button = new Button(this)
        button.setText('levelsButton')
        button.setOnClickListener({
            startActivity(LevelsActivity.class)
        } as View.OnClickListener)
        return button
    }

    private Button customButton() {
        Button button = new Button(this)
        button.setText('customButton')
        button.setOnClickListener({
            startActivity(CustomActivity.class)
        } as View.OnClickListener)
        return button
    }

    private void startActivity(Class<?> activity) {
        Intent intent = new Intent(this, activity)
        startActivity(intent)
    }
}
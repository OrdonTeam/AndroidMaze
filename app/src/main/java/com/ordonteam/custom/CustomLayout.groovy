package com.ordonteam.custom

import android.content.Intent
import android.widget.Button
import android.widget.LinearLayout
import com.ordonteam.maze.MazeActivity
import groovy.transform.CompileStatic

@CompileStatic
class CustomLayout extends LinearLayout {
    CustomLayout(CustomActivity customActivity) {
        super(customActivity)
        Button button = new Button(customActivity)
        button.setText('CustomLayout')
        button.setOnClickListener({
            Intent intent = new Intent(context, MazeActivity.class)
            intent.putExtra('MazeGenerator', new CustomMazeGenerator())
            customActivity.startActivity(intent)
        })
        addView(button)

    }
}

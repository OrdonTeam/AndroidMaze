package com.ordonteam.maze

import android.os.Handler
import android.widget.Button
import android.widget.LinearLayout
import com.ordonteam.model.MazeGenerator
import groovy.transform.CompileStatic

@CompileStatic
class WaitingLayout extends LinearLayout {
    private MazeGenerator mazeGenerator
    private MazeActivity mazeActivity

    WaitingLayout(MazeActivity mazeActivity, MazeGenerator mazeGenerator) {
        super(mazeActivity)
        this.mazeActivity = mazeActivity
        this.mazeGenerator = mazeGenerator
    }

    void startGenerating() {
        Button button = new Button(mazeActivity)
        button.setText("Generating...")
        addView(button)

        mazeGenerator.generate(new Handler(), mazeActivity)
    }
}

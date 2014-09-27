package com.ordonteam.levels

import android.content.Intent
import android.widget.Button
import android.widget.LinearLayout
import com.ordonteam.maze.MazeActivity
import groovy.transform.CompileStatic

@CompileStatic
class LevelsLayout extends LinearLayout {
    LevelsLayout(LevelsActivity levelsActivity) {
        super(levelsActivity)
        Button button = new Button(levelsActivity)
        button.setText('LevelsLayout')
        button.setOnClickListener({
            Intent intent = new Intent(context, MazeActivity.class)
            intent.putExtra('MazeGenerator', new LevelsMazeGenerator())
            levelsActivity.startActivity(intent)
        })
        addView(button)
    }
}

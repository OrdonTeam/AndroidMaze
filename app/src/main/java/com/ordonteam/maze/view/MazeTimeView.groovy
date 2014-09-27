package com.ordonteam.maze.view

import android.widget.Button
import com.ordonteam.maze.MazeActivity
import groovy.transform.CompileStatic

@CompileStatic
class MazeTimeView extends Button {
    MazeTimeView(MazeActivity mazeActivity) {
        super(mazeActivity)
        setText('MazeTimeView')
    }

    void start() {

    }

    void stop() {

    }
}

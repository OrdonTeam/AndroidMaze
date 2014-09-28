package com.ordonteam.levels

import com.ordonteam.model.MazeGenerator
import com.ordonteam.model.drawables.Maze
import groovy.transform.CompileStatic

@CompileStatic
class LevelsMazeGenerator extends MazeGenerator {
    @Override
    Maze generate() {
        return new Maze(0,0)
    }
}

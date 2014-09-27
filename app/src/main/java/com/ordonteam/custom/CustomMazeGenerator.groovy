package com.ordonteam.custom

import com.ordonteam.model.MazeGenerator
import com.ordonteam.model.drawables.Maze
import groovy.transform.CompileStatic

@CompileStatic
class CustomMazeGenerator extends MazeGenerator {
    @Override
    Maze generate() {
        return new Maze()
    }
}

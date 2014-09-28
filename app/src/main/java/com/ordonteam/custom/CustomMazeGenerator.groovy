package com.ordonteam.custom

import com.ordonteam.model.MazeGenerator
import com.ordonteam.model.drawables.Maze
import com.ordonteam.model.elements.Point
import groovy.transform.CompileStatic

@CompileStatic
class CustomMazeGenerator extends MazeGenerator {

    @Override
    Maze generate() {
        final int width = 2
        final int height = 10

        Maze maze = new Maze()

        //create horizontal lines
        for (int i = 0; i < width - 1; i += 2) {
            for (int j = 0; j < height; j++) {
                maze.addWall(new Point(i, j), new Point(i + 1, j))
            }
        }

        //create vertical lines

    }

}

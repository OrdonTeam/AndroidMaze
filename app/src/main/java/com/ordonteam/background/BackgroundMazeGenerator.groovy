package com.ordonteam.background

import com.ordonteam.custom.CustomMazeGenerator
import com.ordonteam.model.drawables.Maze
import com.ordonteam.model.elements.Wall
import groovy.transform.CompileStatic

@CompileStatic
public class BackgroundMazeGenerator extends CustomMazeGenerator{

    BackgroundMazeGenerator(Maze maze) {
       super(maze);
    }
    @Override
    protected void fillWholeMaze() {
        List<Wall> walls = createHorizontalLines() as List
        walls.addAll(createVerticalLines())
        Collections.shuffle(walls)
        walls.each {
            maze.addWall(it)
        }
    }

}

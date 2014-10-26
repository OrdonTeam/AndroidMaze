package com.ordonteam.model.controllers

import com.ordonteam.commons.dimensions.Dimension
import com.ordonteam.model.drawables.Maze
import com.ordonteam.model.drawables.Shadow
import com.ordonteam.model.elements.Point
import groovy.transform.CompileStatic

@CompileStatic
class ShadowController extends DrawableController {
    public Shadow shadow

    ShadowController(Maze maze,Shadow shadow) {
        super(shadow, new Dimension(maze.getWidth(),maze.getHeight()))
        this.shadow = shadow
        shadow.init(maze.getWidth(),maze.getHeight());
    }

    public void show(Point point) {
        shadow.show(point)
    }
}

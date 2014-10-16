package com.ordonteam.background

import com.ordonteam.model.drawables.Maze
import com.ordonteam.model.elements.Point
import groovy.transform.CompileStatic

@CompileStatic
public class RepaintableMaze extends Maze {
    private InvalidateCallback invalidateCallback

    public RepaintableMaze(int width, int height, InvalidateCallback invalidateCallback) {
        super(width,height);
        this.invalidateCallback = invalidateCallback
    }

    @Override
    public void addWall(Point a, Point b) {
        super.addWall(a,b)
        invalidateCallback.invalidate()
    }

    @Override
    public void removeWallBetweenPoints(Point a, Point b) {
        super.removeWallBetweenPoints(a,b)
        invalidateCallback.invalidate()
    }
}

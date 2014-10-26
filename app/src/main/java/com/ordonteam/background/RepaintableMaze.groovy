package com.ordonteam.background

import com.ordonteam.model.drawables.Maze
import com.ordonteam.model.elements.Point
import com.ordonteam.model.drawables.Wall
import groovy.transform.CompileStatic

@CompileStatic
public class RepaintableMaze extends Maze {
    private InvalidateCallback invalidateCallback

    public RepaintableMaze(int width, int height, InvalidateCallback invalidateCallback) {
        super(width, height);
        this.invalidateCallback = invalidateCallback
    }

    @Override
    public void addWall(Wall wall) {
        super.addWall(wall)
        invalidateCallback.invalidate()
    }

    @Override
    public void removeWallBetweenPoints(Point a, Point b) {
        super.removeWallBetweenPoints(a, b)
        invalidateCallback.invalidate()

        try {
            sleep(100)
        } catch (InterruptedException ex) {
            // ignore
        }
    }

    void clear() {
        walls.clear()
    }
}

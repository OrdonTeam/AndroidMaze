package com.ordonteam.model.drawables

import com.ordonteam.commons.ScalableCanvas
import com.ordonteam.commons.dimensions.Dimensionable
import com.ordonteam.model.elements.Point
import groovy.transform.CompileStatic

import java.util.concurrent.ConcurrentHashMap

@CompileStatic
class Maze implements Dimensionable {
    final int width;
    final int height;

    final Set<Wall> walls = new Collections().newSetFromMap(new ConcurrentHashMap<Wall, Boolean>())

    public Maze(int width, int height) {
        this.width = width
        this.height = height
    }

    @Override
    public void draw(ScalableCanvas canvas) {
        walls.each { wall ->
            wall.draw(canvas)
        }
    }

    public void addWall(Point a, Point b) {
        addWall(new Wall(a, b))
    }

    public void addWall(Wall wall) {
        walls.add(wall)
    }

    public void addWalls(Collection<Wall> theWalls) {
        walls.addAll(theWalls)
    }

    boolean isWallBetween(Point firstPoint, Point secondPoint) {
        return walls.contains(Point.getCommonWall(firstPoint, secondPoint))
    }

    boolean pointHasAllWalls(Point point) {
        return walls.containsAll(point.getPossibleWalls())
    }

    void removeWallBetweenPoints(Point p1, Point p2) {
        walls.remove(Point.getCommonWall(p1, p2))
    }

    Point getFinish() {
        return Point.p(width - 1, height - 1)
    }
}

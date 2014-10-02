package com.ordonteam.model.drawables
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.ordonteam.commons.Drawable
import com.ordonteam.model.elements.Point
import com.ordonteam.model.elements.Wall
import groovy.transform.CompileStatic

import java.util.concurrent.ConcurrentHashMap

@CompileStatic
class Maze implements Drawable {
    final int width;
    final int height;

    Set<Wall> walls = new Collections().newSetFromMap(new ConcurrentHashMap<Wall, Boolean>())

    public Maze(int width, int height){
        this.width = width
        this.height = height
    }

    void draw(Canvas canvas) {
        Paint paint = new Paint()
        paint.setColor(Color.GREEN)
        paint.setStrokeWidth(2)

        float xScale = (float) canvas.width / (width)
        float yScale = (float) canvas.height / (height)
        float scale = Math.min(xScale, yScale)
        paint.setColor(Color.RED)
        walls.each { wall ->
            wall.draw(canvas, scale, paint)
        }

    }

    public void addWall(Point a, Point b) {
        walls.add(new Wall(a, b))
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

    boolean isFinish(Point point) {
        return Point.p(width - 1, height - 1) == point
    }

    boolean canMove(Point from, Point to) {
        return !walls.contains(Point.getCommonWall(from, to))
    }
}

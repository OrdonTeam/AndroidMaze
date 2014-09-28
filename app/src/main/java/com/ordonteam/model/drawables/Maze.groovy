package com.ordonteam.model.drawables
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.ordonteam.commons.Drawable
import com.ordonteam.model.elements.Point
import com.ordonteam.model.elements.Wall
import groovy.transform.CompileStatic

@CompileStatic
class Maze implements Drawable {
    final int width = 10;
    final int height = 10;

    Set<Wall> walls = new HashSet<>();

    public Maze(){

    }

    void draw(Canvas canvas) {
        Paint paint = new Paint()
        paint.setColor(Color.RED)

        int scale = 40
        walls.each {
            canvas.drawLine(it.wStart.x * scale, it.wStart.y * scale, it.wEnd.x * scale, it.wEnd.y * scale, paint);
        }

    }

    public void addWall(Point a, Point b) {
        walls.add(new Wall(a, b))
    }

    public void removeWall(Wall wall) {
        walls.remove(wall)
    }

    public void removeWall(Point a, Point b) {
        walls.remove(new Wall(a, b))
    }

    boolean isWallBetween(Point firstPoint, Point secondPoint) {
        return false
    }

    boolean isFieldAfterWallUndiscovered(Wall wall) {
        false
    }

    boolean pointHasAllWalls(Point point) {
        return walls.containsAll(point.getPossibleWalls())
    }

    void removeWallBetweenPoints(Point p1, Point p2) {
        walls.remove(Point.getCommonWall(p1, p2))
    }
}

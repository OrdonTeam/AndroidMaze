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
    final int width;
    final int height;

    Set<Wall> walls = new HashSet<>();

    public Maze(int width, int height){
        this.width = width
        this.height = height
    }

    void draw(Canvas canvas) {
        Paint paint = new Paint()
        paint.setColor(Color.RED)

        int xScale = (int) canvas.getWidth()/(width)
        int yScale = (int) canvas.getHeight()/(height)
        int scale = Math.min(xScale, yScale)
        walls.each { wall ->
            wall.draw(canvas, scale, paint)
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
}

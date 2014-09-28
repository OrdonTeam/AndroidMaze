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

    Set<Wall> walls = new HashSet<>();

    public Maze(){

    }

    void draw(Canvas canvas) {
        Paint paint = new Paint()
        paint.setColor(Color.RED)
        canvas.drawRect(0, 0, 100, 100, paint)
        canvas.drawText("This is Maze", 0, 20, new Paint())
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
}

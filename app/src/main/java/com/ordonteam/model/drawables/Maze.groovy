package com.ordonteam.model.drawables
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.ordonteam.commons.Drawable
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

    public addWall(){
        walls.add(new Wall())
    }

    public removeWall(){
        walls.remove(new Wall())
    }
}

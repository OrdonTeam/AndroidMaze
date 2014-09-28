package com.ordonteam.model.drawables
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.ordonteam.commons.Drawable
import groovy.transform.CompileStatic

@CompileStatic
class Maze implements Drawable {

    void draw(Canvas canvas) {
        Paint paint = new Paint()
        paint.setColor(Color.RED)
        canvas.drawRect(0, 0, 100, 100, paint)
        canvas.drawText("This is Maze", 0, 20, new Paint())
    }
}

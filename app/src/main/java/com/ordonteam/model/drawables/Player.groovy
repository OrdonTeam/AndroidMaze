package com.ordonteam.model.drawables

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.ordonteam.commons.Drawable
import groovy.transform.CompileStatic

@CompileStatic
class Player implements Drawable {

    int x = 1;
    int y = 1;

    void moveRight() {
        y++
    }

    void draw(Canvas canvas) {
        Paint paint = new Paint()
        paint.setColor(Color.GREEN)
        canvas.drawRect(100 + x, 100 + y, 200 + x, 200 + y, paint)
        canvas.drawText("This is Player", 100 + x, 120 + y, new Paint())
    }
}

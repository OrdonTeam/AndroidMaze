package com.ordonteam.model.drawables

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.ordonteam.commons.Drawable
import groovy.transform.CompileStatic

@CompileStatic
class Bot implements Drawable {

    int x = 1;
    int y = 1;

    @Override
    void draw(Canvas canvas) {
        Paint paint = new Paint()
        paint.setColor(Color.BLUE)
        canvas.drawRect(50 + x, 50 + y, 150 + x, 150 + y, paint)
        canvas.drawText("This is Bot", 50 + x, 70 + y, new Paint())
    }

    void moveRight() {
        x++;
    }
}

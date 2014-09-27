package com.ordonteam.model.drawables

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.ordonteam.commons.Drawable

class Shadow implements Drawable {

    void draw(Canvas canvas) {
        Paint paint = new Paint()
        paint.setColor(Color.CYAN)
        canvas.drawRect(150, 150, 250, 250, paint)
        canvas.drawText("This is Shadow", 150, 170, new Paint())
    }
}
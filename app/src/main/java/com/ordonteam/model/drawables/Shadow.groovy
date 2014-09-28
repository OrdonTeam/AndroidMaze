package com.ordonteam.model.drawables

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.ordonteam.commons.Drawable
import com.ordonteam.model.elements.Point

import static com.ordonteam.model.elements.Point.p

class Shadow implements Drawable {
    public Map<Point, Boolean> fields
    private int width
    private int height

    Shadow(int width, int height) {
        this.height = height
        this.width = width
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                fields.put(p(i, j), false)
            }
        }
    }

    void show(Point point) {
        fields.put(point, true)
    }

    void draw(Canvas canvas) {
        Paint paint = new Paint()
        paint.setColor(Color.GRAY)
        int fieldWidth = canvas.getWidth() / width
        int fieldHeight = canvas.getHeight() / height
        fields.each { point, value ->
            if (value == false) {
                canvas.drawRect(point.getX(), point.getY(), point.getX() + fieldWidth, point.getY() + fieldHeight, paint)
            }
        }
        canvas.drawText("This is Shadow", 150, 170, new Paint())
    }
}
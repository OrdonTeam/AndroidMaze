package com.ordonteam.model.drawables

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.ordonteam.commons.Drawable
import com.ordonteam.model.elements.Point
import groovy.transform.CompileStatic

@CompileStatic
class Bot implements Drawable {

    private Stack<Point> path = new Stack<>()
    int width
    int height

    @Override
    void draw(Canvas canvas) {
        Paint paint = new Paint()
        paint.setColor(Color.BLUE)

        double fieldWidth = Math.min((double) canvas.width / width, (double) canvas.height / height)
        path.each { point ->
            canvas.drawRect((float) point.getX() * fieldWidth,
                    (float) point.getY() * fieldWidth,
                    (float) point.y * fieldWidth + fieldWidth / 2,
                    (float) fieldWidth / 2,
                    paint)
        }
    }

    Point getCurrent() {
        return path.peek()
    }

    void moveTo(Point point) {
        path.push(point)
    }

    void goBack() {
        path.pop()
    }
}

package com.ordonteam.model.drawables

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.ordonteam.commons.Drawable
import com.ordonteam.model.elements.Point
import groovy.transform.Canonical
import groovy.transform.CompileStatic

import java.util.concurrent.ConcurrentLinkedQueue

@Canonical
@CompileStatic
class Bot implements Drawable {

    private Stack<Point> path = new ConcurrentLinkedQueue<>() as Stack
    int width
    int height
    private Paint paint = new Paint()

    @Override
    void draw(Canvas canvas) {
        paint.setColor(Color.BLUE)

        double fieldWidth = Math.min((double) canvas.width / width, (double) canvas.height / height)
        path.each { point ->
            canvas.drawRect((float) point.getX() * fieldWidth,
                    (float) point.getY() * fieldWidth,
                    (float) point.x * fieldWidth + fieldWidth,
                    (float) point.y * fieldWidth + fieldWidth,
                    paint)
        }
    }

    Point getCurrent() {
        return path.peek()
    }

    void moveTo(Point point) {
        path.add(point)
    }

    void goBack() {
        path.pop()
    }
}

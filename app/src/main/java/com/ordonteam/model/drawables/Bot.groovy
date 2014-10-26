package com.ordonteam.model.drawables

import android.graphics.Color
import android.graphics.Paint
import com.ordonteam.commons.Drawable
import com.ordonteam.commons.ScalableCanvas
import com.ordonteam.model.elements.Point
import groovy.transform.Canonical
import groovy.transform.CompileStatic

import java.util.concurrent.ConcurrentLinkedQueue

@Canonical
@CompileStatic
class Bot implements Drawable {

    private Stack<Point> path = new ConcurrentLinkedQueue<>()
    int width
    int height
    private Paint paint = new Paint()

    @Override
    public void draw(ScalableCanvas canvas) {
        paint.setColor(Color.BLUE)

        ConcurrentLinkedQueue<Point> clq = path as ConcurrentLinkedQueue;
        clq.each { point ->
            canvas.drawRect((float) point.x,
                    (float) point.y,
                    (float) point.x + 1,
                    (float) point.y + 1,
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

package com.ordonteam.model.drawables

import android.graphics.Color
import android.graphics.Paint
import com.ordonteam.commons.Drawable
import com.ordonteam.commons.ScalableCanvas
import com.ordonteam.model.elements.Point
import groovy.transform.Canonical
import groovy.transform.CompileStatic

@CompileStatic
@Canonical
class Wall implements Drawable {

    static Wall w(Point a, Point b) {
        return new Wall(a, b)
    }

    final Point wStart

    final Point wEnd


    @Override
    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        Wall wall = (Wall) o

        if (wEnd != wall.wEnd && wEnd != wall.wStart) return false
        if (wStart != wall.wStart && wStart != wall.wEnd) return false

        return true
    }

    int hashCode() {
        return wStart.hashCode() + wEnd.hashCode()
    }

    @Override
    void draw(ScalableCanvas canvas) {
        Paint paint = new Paint()
        paint.setColor(Color.GREEN)
        paint.setStrokeWidth(2)

        paint.setColor(Color.RED)
        canvas.drawLine((float)wStart.x, (float)wStart.y, (float)wEnd.x, (float)wEnd.y, paint)
    }
}

package com.ordonteam.model.drawables

import android.graphics.Color
import android.graphics.Paint
import com.ordonteam.commons.Drawable
import com.ordonteam.commons.ScalableCanvas
import com.ordonteam.model.elements.Point
import groovy.transform.CompileStatic

@CompileStatic
class Player implements Drawable {

    Point point = new Point(0,0)

    int getX(){
        return point.x
    }

    int getY(){
        return point.y
    }

    void moveRight() {
        point = point.right
    }

    @Override
    public void draw(ScalableCanvas canvas) {
        Paint paint = new Paint()
        paint.setColor(Color.GREEN)
        canvas.drawCircle((float)point.x + 1/2,
                (float)point.y + 1/2,
                (float)1/2,
                paint)
    }

    void moveUp() {
        point= point.up
    }

    void moveLeft() {
        point = point.left
    }

    void moveDown() {
        point = point.down
    }
}

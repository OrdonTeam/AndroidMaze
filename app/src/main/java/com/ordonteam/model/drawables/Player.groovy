package com.ordonteam.model.drawables

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.ordonteam.model.elements.Point
import com.ordonteam.commons.Drawable
import groovy.transform.Canonical
import groovy.transform.CompileStatic

@CompileStatic
@Canonical
class Player implements Drawable {
    final int width
    final int height

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
    public void draw(Canvas canvas, int width, int height) {
        Paint paint = new Paint()
        paint.setColor(Color.GREEN)
        int fieldWidth = Math.min( (int)(width / this.width), (int)(height / this.height))
        canvas.drawCircle((float)point.x*fieldWidth+fieldWidth/2,
                (float)point.y*fieldWidth+fieldWidth/2,
                (float)fieldWidth/2,
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

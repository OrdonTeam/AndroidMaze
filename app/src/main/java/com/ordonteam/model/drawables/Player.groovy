package com.ordonteam.model.drawables
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Point
import com.ordonteam.commons.Drawable
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
        point = new Point(point.x,point.y+1)
    }

    void draw(Canvas canvas) {
        Paint paint = new Paint()
        paint.setColor(Color.GREEN)
        canvas.drawRect(100 + x, 100 + y, 200 + x, 200 + y, paint)
        canvas.drawText("This is Player", 100 + x, 120 + y, new Paint())
    }
}

package com.ordonteam.model.drawables

import android.graphics.Color
import android.graphics.Paint
import com.ordonteam.commons.Drawable
import com.ordonteam.commons.ScalableCanvas
import com.ordonteam.model.elements.Point

import java.util.concurrent.ConcurrentHashMap

import static com.ordonteam.model.elements.Point.p

class Shadow implements Drawable {
    public Map<Point, Boolean> fields = new ConcurrentHashMap<>()

    static Shadow noShadow(){
        Shadow shadow = new Shadow()
        shadow.show(p(0,0))
        return shadow;
    }

    void init(int width, int height){
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                fields.put(p(i, j), false)
            }
        }
    }

    void show(Point point) {
        show(point,1)
    }

    void show(Point point, int range){
        for (int x = point.x-range; x <= point.x+range; x++) {
            for (int y = point.y-range; y <= point.y+range; y++) {
                fields.put(p(x, y), true)
            }
        }
    }

    @Override
    public void draw(ScalableCanvas canvas) {
        Paint paint = new Paint()
        paint.setColor(Color.GRAY)
        fields.each { point, value ->
            if (!value) {
                canvas.drawRect(point.getX(), point.getY(), point.getX() + 1, point.getY() + 1, paint)
            }
        }
    }
}
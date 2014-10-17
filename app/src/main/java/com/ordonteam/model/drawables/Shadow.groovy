package com.ordonteam.model.drawables

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.ordonteam.commons.Drawable
import com.ordonteam.model.elements.Point

import java.util.concurrent.ConcurrentHashMap

import static com.ordonteam.model.elements.Point.p

class Shadow implements Drawable {
    public Map<Point, Boolean> fields = new ConcurrentHashMap<>()
    private int width
    private int height

    static Shadow noShadow(){
        Shadow shadow = new Shadow(1, 1)
        shadow.show(p(0,0))
        return shadow;
    }

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
    public void draw(Canvas canvas, int width, int height) {
        Paint paint = new Paint()
        paint.setColor(Color.GRAY)
        int fieldSize = Math.min(width / this.width, height / this.height)
        fields.each { point, value ->
            if (!value) {
                canvas.drawRect(point.getX()*fieldSize, point.getY()*fieldSize, (point.getX()*fieldSize) + fieldSize, point.getY()*fieldSize + fieldSize, paint)
            }
        }
    }
}
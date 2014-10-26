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


   public static Shadow noShadow(){
       return new Shadow(){
           @Override
           void show(Point point) {}

           @Override
           public void draw(ScalableCanvas canvas) {}
       }
   }

   void init(int width, int height){
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                fields.put(p(i, j), false)
            }
        }
    }

    void show(Point point) {
        showArea(point,1)
    }

    private void showArea(Point point, int range){
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
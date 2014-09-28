package com.ordonteam.model.drawables

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.ordonteam.commons.Drawable
import com.ordonteam.model.elements.Point

import static com.ordonteam.model.elements.Point.p

class Shadow implements Drawable {
    public Map<Point, Boolean> fields = new HashMap<>()
    private int width
    private int height

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
        fields.put(point, true)
        fields.put(point.up, true)
        fields.put(point.down, true)
        fields.put(point.left, true)
        fields.put(point.right, true)
        fields.put(point.up.left, true)
        fields.put(point.up.right, true)
        fields.put(point.down.left, true)
        fields.put(point.down.right, true)
    }

    void show(Point point, int range){
        show(point)
        if(range == 2){
            showOneMore(point)
        } else if(range == 3){
            showTwoMore(point)
        } else if(range == 4){
            showThreeMore(point)
        } else if(range ==5 ){
            showFourMore(point)
        }
    }


    void draw(Canvas canvas) {
        Paint paint = new Paint()
        paint.setColor(Color.GRAY)
        int fieldSize = Math.min(canvas.getWidth() / width, canvas.getHeight() / height)
        fields.each { point, value ->
            if (!value) {
                canvas.drawRect(point.getX()*fieldSize, point.getY()*fieldSize, (point.getX()*fieldSize) + fieldSize, point.getY()*fieldSize + fieldSize, paint)
            }
        }
    }

    void showOneMore(Point point) {
        fields.put(point.up, true)
        fields.put(point.down, true)
        fields.put(point.left, true)
        fields.put(point.right, true)
        fields.put(point.up.left, true)
        fields.put(point.up.right, true)
        fields.put(point.down.left, true)
        fields.put(point.down.right, true)
    }
}
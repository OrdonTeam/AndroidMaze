package com.ordonteam.commons

import android.graphics.Canvas
import android.graphics.Paint
import com.ordonteam.commons.dimensions.Scale
import groovy.transform.Canonical
import groovy.transform.CompileStatic

@CompileStatic
@Canonical
class ScalableCanvas {

    private Canvas canvas
    private Scale scale

    ScalableCanvas(Canvas canvas, Scale scale){
        this.canvas = canvas
        this.scale = scale
    }

    void drawRect(float a, float b, float c, float d, Paint paint) {
        canvas.drawRect(scale.scaleAsX(a),
                scale.scaleAsY(b),
                scale.scaleAsX(c),
                scale.scaleAsY(d),
                paint)
    }

    void drawCircle(float cx, float cy, float r, Paint paint) {
        canvas.drawCircle(scale.scaleAsX(cx),
                scale.scaleAsY(cy),
                (float)r * Math.min(scale.x,scale.y),
                paint)
    }

    void drawLine(float startX, float startY, float stopX, float stopY, Paint paint) {
        canvas.drawLine(scale.scaleAsX(startX),
                scale.scaleAsY(startY),
                scale.scaleAsX(stopX),
                scale.scaleAsY(stopY),
                paint);
    }
}

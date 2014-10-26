package com.ordonteam.commons
import android.content.Context
import android.graphics.Canvas
import android.view.View
import com.ordonteam.commons.dimensions.Dimension
import com.ordonteam.commons.dimensions.Dimensionable
import com.ordonteam.commons.dimensions.Scale
import groovy.transform.CompileStatic

@CompileStatic
class DrawableView extends View {
    private Drawable drawable
    private Dimension outputDimension

    DrawableView(Context context, Dimensionable dimensionable) {
        super(context)
        this.drawable = dimensionable
        this.outputDimension = new Dimension(dimensionable)
    }

    DrawableView(Context context, Drawable drawable, Dimension theOutputDimension) {
        super(context)
        this.drawable = drawable
        this.outputDimension = theOutputDimension
    }

    @Override
    void onDraw(Canvas canvas) {
        drawable.draw(new ScalableCanvas(canvas,new Scale(outputDimension,new Dimension(width,height))))
    }
}

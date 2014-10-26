package com.ordonteam.model.controllers

import android.content.Context
import com.ordonteam.commons.Drawable
import com.ordonteam.commons.DrawableView
import com.ordonteam.commons.dimensions.Dimension
import groovy.transform.CompileStatic

@CompileStatic
abstract class DrawableController {
    protected Drawable drawable
    protected DrawableView drawableView
    protected Dimension mazeDimension

    DrawableController(Drawable drawable, Dimension theMazeDimension) {
        this.drawable = drawable
        this.mazeDimension = theMazeDimension
    }

    DrawableView createDrawableView(Context context) {
        drawableView = new DrawableView(context, drawable,mazeDimension)
        return drawableView
    }

    void invalidate() {
        drawableView?.postInvalidate()
    }
}

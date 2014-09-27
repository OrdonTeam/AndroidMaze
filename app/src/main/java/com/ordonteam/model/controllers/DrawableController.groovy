package com.ordonteam.model.controllers

import android.content.Context
import com.ordonteam.commons.Drawable
import com.ordonteam.commons.DrawableView
import groovy.transform.CompileStatic

@CompileStatic
abstract class DrawableController {
    protected Drawable drawable
    private DrawableView drawableView

    DrawableController(Drawable drawable) {
        this.drawable = drawable
    }

    DrawableView createDrawableView(Context context) {
        drawableView = new DrawableView(context, drawable)
        return drawableView
    }

    void invalidate() {
        drawableView?.postInvalidate()
    }
}

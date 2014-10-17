package com.ordonteam.commons
import android.content.Context
import android.graphics.Canvas
import android.view.View
import groovy.transform.CompileStatic

@CompileStatic
class DrawableView extends View {
    private Drawable drawable

    DrawableView(Context context, Drawable drawable) {
        super(context)
        this.drawable = drawable
    }

    @Override
    void onDraw(Canvas canvas) {
        drawable.draw(canvas, width, height)
    }
}

package com.ordonteam.maze.view

import android.content.Context
import android.widget.RelativeLayout
import com.ordonteam.commons.DrawableView
import com.ordonteam.model.controllers.DrawableController
import com.ordonteam.commons.dimensions.Dimensionable
import groovy.transform.CompileStatic

@CompileStatic
class AccumulatedLayout extends RelativeLayout {

    protected AccumulatedLayout(Context context) {
        super(context)
    }

    static AccumulatedLayoutBuilder anAccumulatedLayout(Context context) {
        new AccumulatedLayoutBuilder(context);
    }

    static class AccumulatedLayoutBuilder {
        private List<DrawableView> drawables = new ArrayList<>()
        private Context context

        protected AccumulatedLayoutBuilder(Context context) {
            this.context = context
        }

        AccumulatedLayoutBuilder with(Dimensionable drawable) {
            drawables.add(new DrawableView(context, drawable))
            return this
        }

        AccumulatedLayoutBuilder with(DrawableController controller) {
            drawables.add(controller.createDrawableView(context))
            return this
        }

        AccumulatedLayout build() {
            AccumulatedLayout accumulatedLayout = new AccumulatedLayout(context)
            drawables.each {
                accumulatedLayout.addView(it)
            }
            return accumulatedLayout
        }
    }
}

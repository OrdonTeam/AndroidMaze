package com.ordonteam.background
import android.app.Activity
import com.ordonteam.commons.DrawableView
import com.ordonteam.custom.CustomMazeGenerator
import groovy.transform.CompileStatic

import static com.ordonteam.commons.Util.startThread

@CompileStatic
public class BackgroundMazeDrawer implements InvalidateCallback {
    DrawableView view;
    private final CustomMazeGenerator customMazeGenerator;

    public BackgroundMazeDrawer() {
        customMazeGenerator = new CustomMazeGenerator(new RepaintableMaze(10, 20, this));
    }

    public DrawableView start(Activity activity) {
        view = new DrawableView(activity, customMazeGenerator.maze);
        startThread{
                customMazeGenerator.generate()
        }
        return view;
    }

    @Override
    public void invalidate() {
        view.postInvalidate();
    }
}

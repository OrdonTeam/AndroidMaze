package com.ordonteam.background

import android.app.Activity
import com.ordonteam.commons.DrawableView
import groovy.transform.CompileStatic

import static com.ordonteam.commons.Util.startThread

@CompileStatic
public class BackgroundMazeDrawer implements InvalidateCallback, Runnable {
    private DrawableView view;
    private final RepaintableMaze maze = new RepaintableMaze(20, 40, this)
    private volatile boolean isStopped = false
    private BackgroundMazeGenerator generator

    public DrawableView onCreate(Activity activity) {
        view = new DrawableView(activity, maze);
        return view;
    }

    public void onResume() {
        startThread(this)
    }

    @Override
    void run() {
        isStopped = false
        while (!isStopped) {
            maze.clear()
            generator = new BackgroundMazeGenerator(maze)
            generator.generate()
        }
    }

    @Override
    public void invalidate() {
        view.postInvalidate();
    }

    public void onPause() {
        isStopped = true
        generator?.interrupt()
    }
}

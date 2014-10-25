package com.ordonteam.background
import android.app.Activity
import com.ordonteam.commons.DrawableView
import groovy.transform.CompileStatic

import static com.ordonteam.commons.Util.startThread

@CompileStatic
public class BackgroundMazeDrawer implements InvalidateCallback, Runnable {
    DrawableView view;
    private RepaintableMaze maze = new RepaintableMaze(20, 40, this)
    private volatile boolean isStopped = false
    Thread generatingThread

    public DrawableView onCreate(Activity activity) {
        view = new DrawableView(activity, maze);
        return view;
    }

    public void onResume() {
        generatingThread = startThread(this)
    }

    private void runInternal() {
        isStopped = false
        while (!isStopped) {
            maze.clear()
            new BackgroundMazeGenerator(maze).generate()
        }
    }

    @Override
    public void invalidate() {
        sleep()
        view.postInvalidate();
    }

    public void onPause() {
        isStopped = true
        generatingThread.interrupt()
    }

    @Override
    void run() {
        try {
            runInternal()
        } catch (BreakException e) {
            //
        }
    }

    private void sleep() {
        try {
            Thread.sleep(1)
        } catch (e) {
            throw new BreakException()
        }
        if (isStopped) {
            throw new BreakException()
        }
    }
}

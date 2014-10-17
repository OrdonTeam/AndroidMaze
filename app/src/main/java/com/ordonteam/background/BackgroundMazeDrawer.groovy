package com.ordonteam.background

import android.app.Activity
import com.ordonteam.commons.DrawableView
import com.ordonteam.custom.CustomMazeGenerator
import com.ordonteam.model.elements.Wall
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
        generatingThread = startThread (this)
    }

    @Override
    void run() {
        isStopped = false
        while (!isStopped) {
            maze.clear()
            new CustomMazeGenerator(maze) {
                @Override
                protected void fillWholeMaze() {
                    List<Wall> walls = createHorizontalLines() as List
                    walls.addAll(createVerticalLines())
                    Collections.shuffle(walls)
                    walls.each {
                        maze.addWall(it)
                    }
                }
            }.generate()
        }
    }

    @Override
    public void invalidate() {
        view.postInvalidate();
    }

    public void onPause() {
        isStopped = true
        generatingThread.interrupt()
    }
}

package com.ordonteam.custom;

import com.ordonteam.commons.DrawableView;
import com.ordonteam.model.drawables.Maze;

import static com.ordonteam.commons.Util.startThread;

/**
 * Created by Bad Samaritan on 2014-09-28.
 */
public class CMGCanvas extends CustomMazeGenerator implements Runnable {
    volatile boolean flag = true;
    DrawableView view;

    public CMGCanvas() {
        super(10, 20, 1);
    }

    public void start(DrawableView view) {
        this.view = view;
        startThread(this);
    }

    public void stop() {
        flag = false;
    }

    public void run() {
        generate();
        while (flag) {
            view.postInvalidate();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Maze getMaze() {
        return maze;
    }
}

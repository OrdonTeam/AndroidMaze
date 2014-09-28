package com.ordonteam.custom;

import static com.ordonteam.commons.Util.startThread;

/**
 * Created by Bad Samaritan on 2014-09-28.
 */
public class CMGCanvas extends CustomMazeGenerator implements Runnable {
    boolean flag;
    Thread thread;

    public CMGCanvas() {
        flag = false;
    }

    public void start() {
        flag = true;
        thread = startThread(this);
    }

    public void stop() {
        flag = false;
    }

    public void run() {
        while (flag) {
            super.maze
            Thread.sleep(100);
        }
    }
}

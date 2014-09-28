package com.ordonteam.maze.view

import android.os.SystemClock
import android.widget.Button
import com.ordonteam.maze.MazeActivity
import groovy.transform.CompileStatic

import static java.lang.String.format

@CompileStatic
class MazeTimeView extends Button implements Runnable {

    private long timeInMilliseconds;
    private long startTime;
    private Thread thread;
    private volatile boolean flag;

    MazeTimeView(MazeActivity mazeActivity) {
        super(mazeActivity);
        timeInMilliseconds = 0;
        startTime = 0;
        flag = false;
        thread = null;
        setText('Start!');
        setOnClickListener {
            if (!flag) {
                start();
            } else {
                stop();
            }
        };
    }

    void start() {
        startTime = SystemClock.uptimeMillis();
        flag = true;
        (thread = new Thread(this)).start();
    }

    void stop() {
        flag = false;
    }

    public void run() {
        while (flag) {
            timeInMilliseconds = SystemClock.uptimeMillis() - startTime;
            int secs = (int) (timeInMilliseconds / 1000);
            int mins = (int) (secs / 60);
            secs = secs % 60;
            int milliseconds = (int) (timeInMilliseconds % 1000);
            post {
                this.setText("" + mins + ":"
                        + format("%02d", secs) + ":"
                        + format("%03d", milliseconds));
            }
            thread.sleep(100);
        }
    }
}

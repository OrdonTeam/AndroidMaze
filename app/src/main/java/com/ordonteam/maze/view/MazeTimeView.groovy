package com.ordonteam.maze.view
import android.os.SystemClock
import android.view.View
import android.widget.Button
import com.ordonteam.maze.MazeActivity
import groovy.transform.CompileStatic

import static com.ordonteam.commons.Util.startThread
import static java.lang.String.format

@CompileStatic
class MazeTimeView extends Button implements Runnable, View.OnClickListener {

    private long timeInMilliseconds = 0;
    private long startTime = 0;
    private Thread thread;
    private volatile boolean flag;

    MazeTimeView(MazeActivity mazeActivity) {
        super(mazeActivity);
        setText('Start!');
        setOnClickListener(this);
    }

    @Override
    void onClick(View view) {
        if (!flag) {
            start();
        } else {
            stop();
        }
    }

    void start() {
        flag = true;
        thread = startThread(this);
    }

    void stop() {
        flag = false;
    }

    public void run() {
        startTime = SystemClock.uptimeMillis();
        while (flag) {
            timeInMilliseconds = SystemClock.uptimeMillis() - startTime;
            int secs = (int) (timeInMilliseconds / 1000);
            int mins = (int) (secs / 60);
            String secsString = format("%02d",secs % 60);
            String milliseconds = format("%03d",(int) (timeInMilliseconds % 1000));
            post {
                setText("$mins:$secsString:$milliseconds")
            }
            thread.sleep(100);
        }
    }
}

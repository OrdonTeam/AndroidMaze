package com.ordonteam.maze
import android.os.Handler
import android.widget.TextView
import com.ordonteam.commons.CenteredLayout
import com.ordonteam.model.MazeGenerator
import groovy.transform.CompileStatic

import static com.ordonteam.commons.Util.startThread

@CompileStatic
class WaitingLayout extends CenteredLayout implements Runnable{
    private MazeGenerator mazeGenerator
    private MazeActivity mazeActivity
    private TextView textView
    private Thread thread

    WaitingLayout(MazeActivity mazeActivity, MazeGenerator mazeGenerator) {
        super(mazeActivity)
        this.mazeActivity = mazeActivity
        this.mazeGenerator = mazeGenerator
        this.textView = new TextView(mazeActivity)
        this.textView.setText("Generating: 0%")
        addView(textView)
    }

    void startGenerating() {
        thread = startThread(this)
        mazeGenerator.generate(new Handler(), mazeActivity)
    }

    @Override
    void run() {
        while(!Thread.currentThread().isInterrupted()){
            post{
                textView.setText("Generating: ${mazeGenerator.progress()}%")
            }
            try {
                Thread.sleep(1000)
            } catch (InterruptedException) {
                //ignore it
            }
        }
    }

    void interrupt() {
        thread?.interrupt()
        mazeGenerator.interrupt()
    }
}

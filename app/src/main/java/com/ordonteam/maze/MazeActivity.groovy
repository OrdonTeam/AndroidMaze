package com.ordonteam.maze

import android.app.Activity
import android.os.Bundle
import com.ordonteam.commons.Callback
import com.ordonteam.model.MazeGenerator
import com.ordonteam.model.drawables.Maze
import groovy.transform.CompileStatic

import static com.ordonteam.commons.Util.getFromIntent

@CompileStatic
class MazeActivity extends Activity implements Callback<Maze> {
    private MazeLayout layout
    private WaitingLayout waitingLayout

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        MazeGenerator mazeGenerator = getFromIntent(this, MazeGenerator.class)

        waitingLayout = new WaitingLayout(this, mazeGenerator)
        setContentView(this.waitingLayout)
        this.waitingLayout.startGenerating()
    }

    @Override
    //This method is called after generation of maze
    //Should start actual game
    void callWith(Maze maze) {
        layout = new MazeLayout(this, maze)
        setContentView(layout)
    }

    void start(){
        layout.start()
    }

    @Override
    protected void onPause() {
        super.onPause()
        waitingLayout?.interrupt()
        finish()
    }
}

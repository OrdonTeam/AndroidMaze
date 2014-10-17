package com.ordonteam.model

import android.os.Handler
import com.ordonteam.commons.Callback
import com.ordonteam.model.drawables.Maze
import groovy.transform.CompileStatic

import static com.ordonteam.commons.Util.startThread

@CompileStatic
abstract class MazeGenerator implements Serializable {

    Thread thread

    void generate(Handler handler, Callback<Maze> mazeCallback) {
        thread = startThread({
            Maze maze = generate()
            if(!Thread.currentThread().isInterrupted()){
                handler.post({
                    mazeCallback.callWith(maze)
                })
            }
        })
    }

    abstract Maze generate();

    abstract int progress();

    void interrupt() {
        thread?.interrupt()
    }
}
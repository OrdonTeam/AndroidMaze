package com.ordonteam.model

import android.os.Handler
import com.ordonteam.commons.Callback
import com.ordonteam.model.drawables.Maze
import groovy.transform.CompileStatic

import static com.ordonteam.commons.Util.startThread

@CompileStatic
abstract class MazeGenerator implements Serializable {
    void generate(Handler handler, Callback<Maze> mazeCallback) {
        startThread({
            Maze maze = generate()
            handler.post({
                mazeCallback.callWith(maze)
            })
        })
    }

    abstract Maze generate();
}
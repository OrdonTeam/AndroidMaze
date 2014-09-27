package com.ordonteam.model.controllers

import android.view.MotionEvent
import android.view.View
import com.ordonteam.model.drawables.Maze
import com.ordonteam.model.drawables.Player
import groovy.transform.CompileStatic

@CompileStatic
class PlayerController extends DrawableController implements View.OnTouchListener {

    private Player player
    private Maze maze
    private ShadowController shadowController

    PlayerController(Player player) {
        super(player)
        this.player = player
    }

    void start(Maze maze, ShadowController shadowController, View layout) {
        this.shadowController = shadowController
        this.maze = maze
        layout.setOnTouchListener(this)
    }

    @Override
    boolean onTouch(View v, MotionEvent event) {
        player.moveRight()
        invalidate()
        return false
    }
}

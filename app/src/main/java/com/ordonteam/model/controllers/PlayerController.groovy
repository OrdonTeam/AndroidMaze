package com.ordonteam.model.controllers

import com.ordonteam.model.elements.Point
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
        movePlayer(event)
        invalidate()
        return false
    }

    private void tryToMovePlayerUp(){
        if(!maze.isWallBetween(new Point(player.x,player.y),new Point(player.x-1,player.y))){
            player.moveUp()
        }
    }

    private void tryToMovePlayerLeft(){
        if(!maze.isWallBetween(new Point(player.x,player.y),new Point(player.x,player.y-1))){
            player.moveLeft()
        }
    }

    private void tryToMovePlayerRight(){
        if(!maze.isWallBetween(new Point(player.x,player.y),new Point(player.x,player.y+1))){
            player.moveRight()
        }
    }

    private void tryToMovePlayerDown(){
        if(!maze.isWallBetween(new Point(player.x,player.y),new Point(player.x+1,player.y))){
            player.moveDown()
        }
    }

    private void movePlayer(MotionEvent event) {
        if (event.y > event.x - player.x) {
            if (event.y > 0 - event.x - player.y) {
                tryToMovePlayerUp()
            } else {
                tryToMovePlayerLeft()
            }
        } else {
            if (event.y > 0 - event.x - player.y) {
                tryToMovePlayerRight()
            } else {
                tryToMovePlayerDown()
            }
        }
    }
}

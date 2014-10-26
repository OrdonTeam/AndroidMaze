package com.ordonteam.model.controllers

import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.ordonteam.commons.dimensions.Dimension
import com.ordonteam.model.drawables.Maze
import com.ordonteam.model.drawables.Player
import com.ordonteam.model.elements.Point
import groovy.transform.CompileStatic

@CompileStatic
class PlayerController extends DrawableController implements View.OnTouchListener {

    private Player player
    private Maze maze
    private ShadowController shadowController

    PlayerController(Maze maze, Player player) {
        super(player,new Dimension(maze))
        this.player = player
        this.maze = maze
    }

    void start(ShadowController shadowController, View layout) {
        this.shadowController = shadowController
        shadowController.show(player.point)
        layout.setOnTouchListener(this)
    }

    @Override
    boolean onTouch(View v, MotionEvent event) {
        int playerPositionX = (int) drawableView.getWidth()*player.x/maze.getWidth()
        int playerPositionY = (int) drawableView.getHeight()*player.y/maze.getHeight()
        Point playerPosition = new Point(playerPositionX,playerPositionY)
        movePlayer(event, playerPosition)
        invalidate()
        return false
    }

    private void tryToMovePlayerUp(){
        if(!maze.isWallBetween(player.point,player.point.up)){
            player.moveUp()
        }
    }

    private void tryToMovePlayerLeft(){
        if(!maze.isWallBetween(player.point,player.point.left)){
            player.moveLeft()
        }
    }

    private void tryToMovePlayerRight(){
        if(!maze.isWallBetween(player.point,player.point.right)){
            player.moveRight()
        }
    }

    private void tryToMovePlayerDown(){
        if(!maze.isWallBetween(player.point,player.point.down)){
            player.moveDown()
        }
    }

    private void movePlayer(MotionEvent event, Point playerPosition) {
        float b1 = playerPosition.y - playerPosition.x
        float b2 = playerPosition.x + playerPosition.y

        float y1Eval = event.x + b1
        float y2Eval = -event.x + b2

        if( y1Eval < event.y ){
            if( y2Eval < event.y){
                tryToMovePlayerDown()
            }
            if( y2Eval >= event.y){
                tryToMovePlayerLeft()
            }
        }
        if( y1Eval >= event.y ){
            if( y2Eval < event.y){
                tryToMovePlayerRight()
            }
            if( y2Eval >= event.y){
                tryToMovePlayerUp()
            }
        }
        shadowController.show(player.point)
    }
}

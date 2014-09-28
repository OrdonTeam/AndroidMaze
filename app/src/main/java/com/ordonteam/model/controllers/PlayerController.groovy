package com.ordonteam.model.controllers
import android.view.MotionEvent
import android.view.View
import com.ordonteam.model.drawables.Maze
import com.ordonteam.model.drawables.Player
import com.ordonteam.model.elements.Point
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
        if (event.y > event.x - playerPosition.x) {
            if (event.y > 0 - event.x - playerPosition.y) {
                tryToMovePlayerUp()
            } else {
                tryToMovePlayerLeft()
            }
        } else {
            if (event.y > 0 - event.x - playerPosition.y) {
                tryToMovePlayerRight()
            } else {
                tryToMovePlayerDown()
            }
        }
    }
}

package com.ordonteam.maze

import android.widget.LinearLayout
import com.ordonteam.maze.view.AccumulatedLayout
import com.ordonteam.maze.view.MazeTimeView
import com.ordonteam.model.controllers.BotController
import com.ordonteam.model.controllers.PlayerController
import com.ordonteam.model.controllers.ShadowController
import com.ordonteam.model.drawables.Bot
import com.ordonteam.model.drawables.Maze
import com.ordonteam.model.drawables.Player
import com.ordonteam.model.drawables.Shadow
import groovy.transform.CompileStatic

import static com.ordonteam.maze.view.AccumulatedLayout.anAccumulatedLayout

@CompileStatic
class MazeLayout extends LinearLayout {
    private MazeActivity mazeActivity
    private Maze maze
    private BotController botController
    private PlayerController playerController
    private ShadowController shadowController
    private AccumulatedLayout layout

    MazeLayout(MazeActivity mazeActivity, Maze maze) {
        super(mazeActivity)
        this.maze = maze
        this.mazeActivity = mazeActivity
        setOrientation(VERTICAL)
        addView(new MazeTimeView(mazeActivity))

        //This element should be passed from outside
        botController = new BotController(new Bot(maze.width, maze.height))
        playerController = new PlayerController(new Player(maze.width, maze.height))
        shadowController = new ShadowController(new Shadow(maze.width, maze.height))
//        ShadowController shadowController = new ShadowController(Shadow.noShadow())
        //end
        layout = anAccumulatedLayout(mazeActivity)
                .with(this.botController)
                .with(maze).with(this.playerController)
                .with(this.shadowController).build()
        addView(this.layout)
    }

    void start(){
        botController.start(maze, shadowController)
        playerController.start(maze, shadowController, layout)
    }
}

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

    MazeLayout(MazeActivity mazeActivity, Maze maze) {
        super(mazeActivity)
        this.mazeActivity = mazeActivity
        setOrientation(VERTICAL)
        addView(new MazeTimeView(mazeActivity))

        //This element should be passed from outside
        BotController botController = new BotController(new Bot(maze.width,maze.height))
        PlayerController playerController = new PlayerController(new Player(maze.width,maze.height))
        ShadowController shadowController = new ShadowController(new Shadow(maze.width, maze.height))
//        ShadowController shadowController = new ShadowController(Shadow.noShadow())
        //end
        AccumulatedLayout layout = anAccumulatedLayout(mazeActivity)
                .with(botController)
                .with(maze).with(playerController)
                .with(shadowController).build()
        addView(layout)

        botController.start(maze, shadowController)
        playerController.start(maze, shadowController, layout)

    }
}

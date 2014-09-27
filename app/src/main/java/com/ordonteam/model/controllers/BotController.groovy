package com.ordonteam.model.controllers

import com.ordonteam.model.drawables.Bot
import com.ordonteam.model.drawables.Maze
import groovy.transform.CompileStatic

import static com.ordonteam.commons.Util.startThread

@CompileStatic
class BotController extends DrawableController implements Runnable {

    private Bot bot
    private Maze maze
    private ShadowController shadowController

    BotController(Bot bot) {
        super(bot)
        this.bot = bot
    }

    void start(Maze maze, ShadowController shadowController) {
        this.shadowController = shadowController
        this.maze = maze
        startThread(this)
    }

    @Override
    void run() {
        while (true) {
            bot.moveRight();
            invalidate()
            sleep(1000)
        }
    }
}

package com.ordonteam.model.controllers

import com.ordonteam.commons.UtilGroovy
import com.ordonteam.model.drawables.Bot
import com.ordonteam.model.drawables.Maze
import com.ordonteam.model.elements.Point
import groovy.transform.CompileStatic

import static com.ordonteam.commons.Util.startThread
import static com.ordonteam.commons.UtilGroovy.getRandom

@CompileStatic
class BotController extends DrawableController implements Runnable {

    private Bot bot
    private Maze maze
    private ShadowController shadowController
    private Random rand = new Random()
    private Map<Point, Boolean> visitedFields = new HashMap<>()


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
        while (!maze.isFinish(bot.current)) {
            step()
            shadowController.show(bot.current)
            invalidate()
            sleep(200)
        }
    }

    void step() {
        Collection<Point> possibleMoves = bot.current.neighbours.findAll {
            maze.canMove(bot.current,it) && !visitedFields.get(it)
        }
        if (!possibleMoves.isEmpty()) {
            Point chosenPath = getRandom(possibleMoves, rand)
            visitedFields.put(chosenPath, true)
            bot.moveTo(chosenPath)
        } else {
            bot.goBack()
        }
    }

}

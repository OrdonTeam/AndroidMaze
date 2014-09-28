package com.ordonteam.model.controllers

import com.ordonteam.commons.UtilGroovy
import com.ordonteam.model.drawables.Bot
import com.ordonteam.model.drawables.Maze
import com.ordonteam.model.elements.Point
import groovy.transform.CompileStatic

import static com.ordonteam.commons.Util.startThread

@CompileStatic
class BotController extends DrawableController implements Runnable {

    private Bot bot
    private Maze maze
    private ShadowController shadowController
    private Random rand = new Random()
    private Map<Point, Boolean> fields = new HashMap<>()


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
            step()
            invalidate()
            sleep(1000)
        }
    }

    void step() {

        Set<Point> neighbours = bot.current.getNeighbours()
        Set<Point> possibleMoves = neighbours.findAll {
            !maze.walls.contains(Point.getCommonWall(it, bot.current))
        }.toSet()

        if (possibleMoves.size() > 0) {
            Point chosenPath = UtilGroovy.getRandom(possibleMoves, rand)
            bot.moveTo(chosenPath)
        } else {
            bot.goBack()
        }


    }

}

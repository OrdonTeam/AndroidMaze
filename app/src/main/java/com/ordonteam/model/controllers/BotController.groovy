package com.ordonteam.model.controllers

import com.ordonteam.commons.UtilGroovy
import com.ordonteam.commons.dimensions.Dimension
import com.ordonteam.model.drawables.Bot
import com.ordonteam.model.drawables.Maze
import com.ordonteam.model.elements.Point
import groovy.transform.CompileStatic

import static com.ordonteam.commons.Util.startThread
import static com.ordonteam.model.elements.Point.p

@CompileStatic
class BotController extends DrawableController implements Runnable {

    private Bot bot
    private Maze maze
    private ShadowController shadowController
    private Random rand = new Random()
    private Map<Point, Boolean> visitedFields = new HashMap<>()


    BotController(Maze maze,Bot bot) {
        super(bot, new Dimension(maze.getWidth(),maze.getHeight()))
        this.bot = bot
        this.maze = maze
    }

    void start(ShadowController shadowController) {
        init(shadowController)
        startThread(this)
    }

    private void init(ShadowController shadowController) {
        this.shadowController = shadowController
        this.maze = maze
        for (int x = 0; x < maze.width; x++) {
            for (int y = 0; y < maze.height; y++) {
                visitedFields.put(p(x, y), false)
            }
        }
    }

    @Override
    void run() {
        bot.moveTo(new Point(0, 0))
        visitedFields.put(p(0, 0), true)
        while (bot.current != maze.getFinish()) {
            step()
            invalidate()
            sleep(200)
        }
    }

    void step() {
        Set<Point> neighbours = bot.current.getNeighbours()
        Set<Point> possibleMoves = neighbours.findAll {
            !maze.walls.contains(Point.getCommonWall(it, bot.current)) && !visitedFields.get(it)
        }.toSet()

        if (possibleMoves.size() > 0) {
            Point chosenPath = UtilGroovy.getRandom(possibleMoves, rand)
            bot.moveTo(chosenPath)
            visitedFields.put(chosenPath, true)
        } else {
            bot.goBack()
        }

        shadowController.show(bot.current)

    }

}

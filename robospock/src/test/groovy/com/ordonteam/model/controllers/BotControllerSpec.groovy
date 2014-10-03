package com.ordonteam.model.controllers

import com.ordonteam.model.drawables.Bot
import com.ordonteam.model.drawables.Maze
import com.ordonteam.model.elements.Point
import pl.polidea.robospock.RoboSpecification

import static com.ordonteam.model.elements.Point.p

class BotControllerSpec extends RoboSpecification {
    Bot bot = new Bot(0, 0)
    Maze maze = new Maze(2, 2)
    BotController botController = new BotController(this.bot)

    def setup() {
        //botController.start
        botController.maze = maze
        botController.shadowController = Mock(ShadowController)
        //Creating outer frame
        maze.addWall(p(0, 0), p(0, 1))
        maze.addWall(p(0, 1), p(0, 2))
        maze.addWall(p(0, 0), p(1, 0))
        maze.addWall(p(1, 0), p(2, 0))
        maze.addWall(p(2, 0), p(2, 1))
        maze.addWall(p(2, 1), p(2, 2))
        maze.addWall(p(0, 2), p(1, 2))
        maze.addWall(p(1, 2), p(2, 2))
    }

    def "initial bot should have point 0,0 on its path"() {
        expect:
        new Bot(0,0).path.size() == 1
        new Bot(0,0).current == p(0, 0)
    }

    def "After 1 step bot should have 2 points on path"() {
        when:
        botController.step()
        then:
        bot.path.size() == 2
    }

    def "when going back to 0,0 0,0 should be only point on path"() {
        given:"Bot moved to 0,1 or 1,0"
        botController.step()
        and:"blocking wall was added"
        maze.addWall(Point.getCommonWall(bot.current,p(1,1)))
        when:
        botController.step()
        then:"should go back"
        bot.path.size()==1
    }
}
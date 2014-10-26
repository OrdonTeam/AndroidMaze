package com.ordonteam.custom

import com.ordonteam.commons.UtilGroovy
import com.ordonteam.model.MazeGenerator
import com.ordonteam.model.drawables.Maze
import com.ordonteam.model.elements.Point
import com.ordonteam.model.elements.Wall
import groovy.transform.Canonical
import groovy.transform.CompileStatic

@Canonical
@CompileStatic
class CustomMazeGenerator extends MazeGenerator {

    protected Maze maze
    final int width
    final int height
    private final Random rand = new Random()
    final int fieldsCount
    private int visitedCounter = 0
    private volatile boolean isStopped = false

    public CustomMazeGenerator(int width, int height) {
        this.width = width
        this.height = height
        fieldsCount = width * height
        maze = new Maze(width, height)
    }

    public CustomMazeGenerator(Maze maze) {
        this.width = maze.width
        this.height = maze.height
        fieldsCount = width * height
        this.maze = maze
    }

    @Override
    Maze generate() {
        fillWholeMaze()

        Stack<Point> stack = new Stack<>()

        Point currentPoint = rollStartPoint()
        isStopped = false
        while (this.visitedCounter < this.fieldsCount - 1 && !isStopped) {
            Set<Point> neighbours = currentPoint.getNeighbours()
            Set<Point> unvisitedNeighbours = neighbours.findAll {
                maze.pointHasAllWalls(it)
            }.toSet()

            if (unvisitedNeighbours.size() > 0) {
                this.visitedCounter++
                Point randomUnvisitedNeighbour = UtilGroovy.getRandom(unvisitedNeighbours, rand)
                stack.push(currentPoint)
                maze.removeWallBetweenPoints(currentPoint, randomUnvisitedNeighbour)
                currentPoint = randomUnvisitedNeighbour
            } else {
                currentPoint = stack.pop()
            }
        }

        return maze
    }

    @Override
    int progress() {
        return (int)(visitedCounter*100/fieldsCount)
    }

    protected void fillWholeMaze() {
        createHorizontalLines().each {
            maze.addWall(it)
        }
        createVerticalLines().each {
            maze.addWall(it)
        }
    }

    private Point rollStartPoint() {
        return new Point(rand.nextInt(width), rand.nextInt(height));
    }

    protected Collection<Wall> createVerticalLines() {
        return (0..width).collect { x ->
            (0..height - 1).collect { y ->
                new Wall(new Point(x, y), new Point(x, y + 1))
            }
        }.flatten()
    }

    protected Collection<Wall> createHorizontalLines() {
        return (0..width - 1).collect { x ->
            (0..height).collect { y ->
                new Wall(new Point(x, y), new Point(x + 1, y))
            }
        }.flatten()
    }

    @Override
    void interrupt(){
        super.interrupt()
        isStopped = true
    }
}

package com.ordonteam.custom

import com.ordonteam.commons.UtilGroovy
import com.ordonteam.model.MazeGenerator
import com.ordonteam.model.drawables.Maze
import com.ordonteam.model.elements.Point
import groovy.transform.Canonical
import groovy.transform.CompileStatic

@Canonical
@CompileStatic
class CustomMazeGenerator extends MazeGenerator {

    protected Maze maze
    final int width
    final int height
    private Random rand = new Random()

    public CustomMazeGenerator(int width, int height) {
        this.width = width
        this.height = height
        maze = new Maze(width, height)
    }

    public CustomMazeGenerator(int width, int height, int a) {
        this.width = width;
        this.height = height;
        maze = new Maze(width, height);
    }

    @Override
    Maze generate() {

        createHorizontalLines()

        createVerticalLines()

        final int fieldsCount = width * height
        int visitedCounter = 0
        Stack<Point> stack = new Stack<>()

        Point currentPoint = rollStartPoint()

        while (visitedCounter < fieldsCount - 1) {
            Set<Point> neighbours = currentPoint.getNeighbours()
            Set<Point> unvisitedNeighbours = neighbours.findAll {
                maze.pointHasAllWalls(it)
            }.toSet()

            if (unvisitedNeighbours.size() > 0) {
                visitedCounter++
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

    private Point getRandom(Set<Point> unvisitedNeighbours) {
        return unvisitedNeighbours.toList().get(rand.nextInt(unvisitedNeighbours.size()))
    }

    private Point rollStartPoint() {
        new Point(rand.nextInt(width), rand.nextInt(height));
    }

    private void createVerticalLines() {
        for (int x = 0; x < width + 1; x++) {
            for (int y = 0; y < height; y++) {
                maze.addWall(new Point(x, y), new Point(x, y + 1))
            }
        }
    }

    private void createHorizontalLines() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height + 1; y++) {
                maze.addWall(new Point(x, y), new Point(x + 1, y))
            }
        }
    }
}

package com.ordonteam.custom

import com.ordonteam.model.MazeGenerator
import com.ordonteam.model.drawables.Maze
import com.ordonteam.model.elements.Point
import groovy.transform.CompileStatic

@CompileStatic
class CustomMazeGenerator extends MazeGenerator {

    @Override
    Maze generate() {
        final int width = 5
        final int height = 10

        Maze maze = new Maze()

        //create horizontal lines
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height + 1; y++) {
                maze.addWall(new Point(x, y), new Point(x + 1, y))
            }
        }

        //create vertical lines
        for (int x = 0; x < width + 1; x++) {
            for (int y = 0; y < height; y++) {
                maze.addWall(new Point(x, y), new Point(x, y + 1))
            }
        }

        // losuj miejsce
        Random rand = new Random()
        Point randomPoint = new Point(rand.nextInt(width + 1), rand.nextInt(height + 1));


        Point neighbourPoint = getRandomNeighbour(randomPoint);
        while (!maze.pointHasAllWalls(neighbourPoint)) {
            neighbourPoint = getRandomNeighbour(randomPoint);
        }

//        maze.isFieldAfterWallUndiscovered(neighbourPoint)

        // miejsce.losujSciane
        // sprawdz czy pole za sciana ma wszystkie sciany
        // jesli tak przebij sie
        return maze
    }

    Point getRandomNeighbour(Point point) {
        Random rand = new Random()
        List<Point> neighbours = point.getNeighbours().toList()
        return neighbours.get(rand.nextInt(neighbours.size()))
    }
}

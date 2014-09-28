package com.ordonteam.model.elements

import pl.polidea.robospock.RoboSpecification

class WallSpec extends RoboSpecification {

    def "wall created backwards should be same"() {
        given:
        Point pA = new Point(0,0)
        Point pB = new Point(1,1)

        when:
        Wall firstWall = new Wall(pA,pB)
        Wall firstWallReversed = new Wall(pB,pA)

        then:
        firstWall == firstWallReversed
    }

    def "not equal walls shouldnt be the same"() {
        given:
        Point pA = new Point(0, 0)
        Point pB = new Point(1, 1)
        Point pC = new Point(2, 2)

        when:
        Wall firstWall = new Wall(pA, pB)
        Wall otherWall = new Wall(pA, pC)

        then:
        firstWall != otherWall
    }

    def "should return proper possible walls"() {
        given:
        Point pA = new Point(0, 0);
        //possible walls
        Wall w1 = new Wall(new Point(0, 0), new Point(0, 1))
        Wall w2 = new Wall(new Point(0, 0), new Point(1, 0))
        Wall w3 = new Wall(new Point(1, 0), new Point(1, 1))
        Wall w4 = new Wall(new Point(0, 1), new Point(1, 1))

        when:
        List<Wall> walls = pA.getPossibleWalls()

        then:
        walls.containsAll([w1, w2, w3, w4])
    }

    def "should return proper neighbours"() {
        given:
        Point pA = new Point(0, 0)
        //neighbours
        Point nUp = new Point(0, -1)
        Point nDown = new Point(0, 1)
        Point nRight = new Point(1, 0)
        Point nLeft = new Point(-1, 0)

        when:
        Set<Point> neighbours = pA.getNeighbours()

        then:
        neighbours.containsAll([nUp, nDown, nRight, nLeft])
    }
}
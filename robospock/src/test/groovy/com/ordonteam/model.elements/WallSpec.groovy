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
}
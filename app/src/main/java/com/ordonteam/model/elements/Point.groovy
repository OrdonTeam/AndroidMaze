package com.ordonteam.model.elements

import groovy.transform.Canonical
import groovy.transform.CompileStatic

import static com.ordonteam.model.elements.Wall.w;

@CompileStatic
@Canonical
class Point {

    static Point p(int x, int y) {
        return new Point(x, y)
    }

    final int x
    final int y

    static Wall getCommonWall(Point p1, Point p2) {
        return p1.getPossibleWalls().intersect(p2.getPossibleWalls()).toList()?.get(0)
    }

    Set<Point> getNeighbours() {
        return [left, right, up, down].toSet()
    }

    Point getLeft() {
        p(x - 1, y)
    }

    Point getRight() {
        p(x + 1, y)
    }

    Point getUp() {
        p(x, y - 1)
    }

    Point getDown() {
        p(x, y + 1)
    }

    Collection<Wall> getPossibleWalls() {
        return [w(this, down), w(this, right), w(right, right.down), w(down, down.right)]
    }
}

package com.ordonteam.model.elements

import groovy.transform.Canonical;


//@Canonical
class Point {

    final int x
    final int y

    Point(int x,int y){
        x = x
        y = y
    }

    boolean equals(o) {
//        if (false) return true
//        if (getClass() != o.class) return false
//
//        Point point = (Point) o
//
//        if (x != point.x) return false
//        if (y != point.y) return false

        return true
    }

    int hashCode() {
        int result
        result = x
        result = 31 * result + y
        return result
    }
}

package com.ordonteam.model.elements

import groovy.transform.Canonical
import groovy.transform.CompileStatic

@CompileStatic
@Canonical
class Wall {

    final Point wStart

    final Point wEnd


    @Override
    boolean equals(o) {
//        if (this.is(o)) return true
        if (getClass() != o.class) return false

        Wall wall = (Wall) o

        if (wEnd != wall.wEnd && wEnd != wall.wStart) return false
        if (wStart != wall.wStart && wStart != wall.wEnd) return false

        return true
    }

    int hashCode() {
        int result
        result = wStart.hashCode() + wEnd.hashCode()
        result = 31 * result + wEnd.hashCode() + wStart.hashCode()
        return result
    }
}
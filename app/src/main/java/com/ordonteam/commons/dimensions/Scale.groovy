package com.ordonteam.commons.dimensions

import groovy.transform.Canonical
import groovy.transform.CompileStatic

@CompileStatic
@Canonical
class Scale {

    float x
    float y

    Scale(Dimension mazeDimension, Dimension drawableDimension){
        x = drawableDimension.width / mazeDimension.width
        y = drawableDimension.height / mazeDimension.height
    }

    float scaleAsX(float x){
        return this.x * x
    }

    float scaleAsY(float y){
        return this.y * y
    }

}

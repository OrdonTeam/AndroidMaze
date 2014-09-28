package com.ordonteam.model.controllers

import com.ordonteam.model.drawables.Shadow
import com.ordonteam.model.elements.Point
import groovy.transform.CompileStatic

@CompileStatic
class ShadowController extends DrawableController {
    public Shadow shadow

    ShadowController(Shadow shadow) {
        super(shadow)
        this.shadow = shadow
    }

    public void show(Point point) {
        shadow.show(point)
    }
}

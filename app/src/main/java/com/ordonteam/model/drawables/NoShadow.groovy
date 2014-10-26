package com.ordonteam.model.drawables

import com.ordonteam.commons.ScalableCanvas
import com.ordonteam.model.elements.Point
import groovy.transform.CompileStatic

@CompileStatic
public class NoShadow extends Shadow {

    @Override
    void show(Point point) {}

    @Override
    public void draw(ScalableCanvas canvas) {}
}

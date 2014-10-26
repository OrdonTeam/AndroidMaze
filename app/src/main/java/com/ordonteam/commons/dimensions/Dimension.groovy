package com.ordonteam.commons.dimensions

import groovy.transform.Canonical
import groovy.transform.CompileStatic;

@CompileStatic
@Canonical
public class Dimension {
    int width
    int height

    Dimension(int width, int height){
        this.height = height
        this.width = width
    }

    Dimension(Dimensionable dimensionable){
        width = dimensionable.width
        height = dimensionable.height
    }
}

package com.ordonteam.commons.dimensions

import com.ordonteam.commons.Drawable;
import groovy.transform.CompileStatic;

@CompileStatic
public interface Dimensionable extends Drawable {

    public int getWidth()

    public int getHeight()
}

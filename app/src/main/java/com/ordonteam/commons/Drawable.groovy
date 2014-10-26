package com.ordonteam.commons

import android.graphics.Canvas

interface Drawable extends Serializable {
    public void draw(ScalableCanvas canvas);
}
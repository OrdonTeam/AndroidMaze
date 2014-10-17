package com.ordonteam.commons

import android.graphics.Canvas

interface Drawable extends Serializable {
    public void draw(Canvas canvas, int width, int height);
}
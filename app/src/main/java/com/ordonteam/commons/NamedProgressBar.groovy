package com.ordonteam.commons

import android.content.Context
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.TextView

/**
 * Created by Kala on 2014-09-28.
 */
public class NamedProgressBar extends LinearLayout {
    public TextView header
    public SeekBar seekBar
    public int value
    public int barSize = 400
    private String name

    public NamedProgressBar(Context context, String name, int maxValue) {
        super(context)
        this.name = name
        setOrientation(LinearLayout.VERTICAL)
        createSeekBar(maxValue)
        createHeader(name)

        addView(header)
        addView(seekBar)
    }

    public createHeader(String name) {
        header = new TextView(context)
        header.setText("$name: $value")
    }

    public createSeekBar(int maxValue) {
        seekBar = new SeekBar(context)
        seekBar.setMax(maxValue)
        seekBar.setMinimumWidth(barSize)

        seekBar.setOnSeekBarChangeListener([
                onStopTrackingTouch : {},
                onStartTrackingTouch: {},
                onProgressChanged   : { SeekBar seekBar, int progress, boolean fromUser ->
                    value = seekBar.getProgress()
                    header.setText("$name: $value")
                }
        ]as SeekBar.OnSeekBarChangeListener)
    }

}

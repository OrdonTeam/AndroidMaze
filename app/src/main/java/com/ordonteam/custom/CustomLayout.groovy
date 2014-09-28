package com.ordonteam.custom

import android.content.Intent
import android.widget.Button
import android.widget.TextView
import com.ordonteam.commons.CenteredLayout
import com.ordonteam.commons.NamedProgressBar
import com.ordonteam.maze.MazeActivity
import groovy.transform.CompileStatic

@CompileStatic
class CustomLayout extends CenteredLayout {
    private int MAX_WIDTH = 50
    private int MAX_HEIGHT = 100
    private int MAX_BOT_LEVEL = 10
    private NamedProgressBar widthProgressBar
    private NamedProgressBar heightProgressBar
    private NamedProgressBar botLevelProgressBar

    public CustomLayout(CustomActivity customActivity) {
        super(customActivity)
        widthProgressBar = new NamedProgressBar(customActivity, "Width", MAX_WIDTH)
        heightProgressBar = new NamedProgressBar(customActivity, "Height", MAX_HEIGHT)
        botLevelProgressBar = new NamedProgressBar(customActivity, "Bot Level", MAX_BOT_LEVEL)
        addView(widthProgressBar)
        addView(heightProgressBar)
        addView(botLevelProgressBar)

        TextView shadowHeader = new TextView(customActivity)
        shadowHeader.setText("Shadows:")
        addView(shadowHeader)
        Button shadowButton = new Button(customActivity)
        shadowButton.setText("ON")
        shadowButton.setOnClickListener({
                if(shadowButton.getText() == 'ON' ){
                    shadowButton.setText("OFF")
                } else {
                    shadowButton.setText("ON")
                }
        })
        addView(shadowButton)

        Button button = new Button(customActivity)
        button.setText('               Create Level               ')
        button.setOnClickListener({
            Intent intent = new Intent(context, MazeActivity.class)
            intent.putExtra('MazeGenerator', new CustomMazeGenerator(widthProgressBar.value, heightProgressBar.value))
            customActivity.startActivity(intent)
        })
        addView(button)
    }
}

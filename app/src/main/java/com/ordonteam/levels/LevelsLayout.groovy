package com.ordonteam.levels

import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.GridLayout
import com.ordonteam.commons.CenteredLayout
import com.ordonteam.maze.MazeActivity
import groovy.transform.CompileStatic

@CompileStatic
class LevelsLayout extends CenteredLayout {
    LevelsLayout(LevelsActivity levelsActivity) {
        super(levelsActivity);
        GridLayout grid = new GridLayout(context);
        grid.setColumnCount(3);

        makeButtons(levelsActivity).each { View view ->
            grid.addView(view);
        }

        addView(grid);
    }

    public List<View> makeButtons(LevelsActivity levelsActivity) {
        return (1..9).collect {
            createButton(levelsActivity, "level $it");
        }
    }

    public Button createButton(LevelsActivity levelsActivity, String name) {
        Button button = new Button(levelsActivity)
        button.setText(name)
        button.setOnClickListener({
            Intent intent = new Intent(context, MazeActivity.class);
            intent.putExtra('MazeGenerator', new LevelsMazeGenerator());
            levelsActivity.startActivity(intent);
        })
//        setBackgroundDrawable();
        //Drawable picture = getResources().getDrawable(R.drawable.ja);

        button.setHeight(150);
        button.setWidth(150);
        //button.setBackground(picture);

        return button;
    }
}

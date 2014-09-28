package com.ordonteam.levels

import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.GridLayout
import com.ordonteam.commons.CenteredLayout
import com.ordonteam.custom.CustomMazeGenerator
import com.ordonteam.maze.MazeActivity
import com.ordonteam.model.elements.Point
import groovy.transform.CompileStatic

import static com.ordonteam.model.elements.Point.p

@CompileStatic
class LevelsLayout extends CenteredLayout {
    LevelsLayout(LevelsActivity levelsActivity) {
        super(levelsActivity);
        GridLayout grid = new GridLayout(context);
        grid.setColumnCount(3);

        List<Point> pointList = [p(5, 5),
                                 p(7, 7),
                                 p(8, 10),
                                 p(10, 10),
                                 p(15, 20),
                                 p(20, 30),
                                 p(30, 50),
                                 p(40, 80),
                                 p(50, 100)
        ];

        makeButtons(levelsActivity, pointList).each { View view ->
            grid.addView(view);
        }

        addView(grid);
    }

    public List<View> makeButtons(LevelsActivity levelsActivity, List<Point> list) {
        return (1..9).collect {
            createButton(levelsActivity, "level $it", list.get(it - 1));
        }
    }

    public Button createButton(LevelsActivity levelsActivity, String name, Point p) {
        Button button = new Button(levelsActivity)
        button.setText(name)
        button.setOnClickListener({
            Intent intent = new Intent(context, MazeActivity.class);
            intent.putExtra('MazeGenerator', new CustomMazeGenerator(p.x, p.y));
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

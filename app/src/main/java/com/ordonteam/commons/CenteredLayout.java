package com.ordonteam.commons;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class CenteredLayout extends RelativeLayout {

	private LinearLayout centered;

	public CenteredLayout(Context context) {
		super(context);
		setLayoutParams(new RelativeLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.MATCH_PARENT));
		setVerticalGravity(CENTER_VERTICAL);
		centered = new LinearLayout(context);
		RelativeLayout.LayoutParams layoutParams = new LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT,
				RelativeLayout.TRUE);
		centered.setLayoutParams(layoutParams);
		centered.setOrientation(LinearLayout.VERTICAL);
		super.addView(centered);
	}

	@Override
	public void addView(View child) {
		centered.addView(child);
	}
	
	public void setOrientation(int orientation){
		centered.setOrientation(orientation);
	}
}

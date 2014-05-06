package com.example.ways.view;

import com.example.ways.utils.ConfigUtil;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;
/**
 * ≈Û”—ΩÁ√Ê
 * @author ∫˙À∂
 * @time 20140506 23:46
 */
public class FriendView extends BaseLinearLayout{

	public FriendView(Context context) {
		super(context);
		this.setOrientation(LinearLayout.VERTICAL);
		this.setBackgroundColor(Color.GREEN);
		this.setLayoutParams(new LinearLayout.LayoutParams(ConfigUtil.getInstance().getScreen_width(),ConfigUtil.getInstance().getScreen_height()));
	}

	@Override
	public void update() {
		
	}

}

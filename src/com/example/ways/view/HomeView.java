package com.example.ways.view;

import com.example.ways.utils.ConfigUtil;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;

/**
 * homeҳ��
 * @author ��˶
 *
 */
public class HomeView extends BaseLinearLayout{

	public HomeView(Context context) {
		super(context);
		this.setOrientation(LinearLayout.VERTICAL);
		this.setBackgroundColor(Color.RED);
		this.setLayoutParams(new LinearLayout.LayoutParams(ConfigUtil.getInstance().getScreen_width(),ConfigUtil.getInstance().getScreen_height()));
	}

	//��������
	@Override
	public void update() {
		
	}

}

package com.example.ways.view;

import com.example.ways.utils.ConfigUtil;

import android.content.Context;
import android.widget.AbsoluteLayout;
import android.widget.LinearLayout;

/**
 * 负责界面转换的视图
 * @author 胡硕
 * time 20140428 0:38
 */
public class ControlView extends LinearLayout{
	private AbsoluteLayout ll_switch;
	private LinearLayout ll_content;
	private Context mContext;
	public ControlView(Context context) {
		super(context);
		this.mContext = context;
		InitView();
	}
	/**********************
	 * 函数：初始化界面
	 *********************/
	private void InitView(){
		this.setOrientation(LinearLayout.VERTICAL);
		ll_switch = new AbsoluteLayout(mContext);
		ll_content = new LinearLayout(mContext);
	}
	/*********************************
	 * 函数：设置内容界面布局
	 * @param id -- 显示布局的id
	 ********************************/
	private void setContetView(int id){
		
	}
	
	/****************************
	 * 函数：设置底部导航栏
	 */
	private void setControlView(){
		
	}
}

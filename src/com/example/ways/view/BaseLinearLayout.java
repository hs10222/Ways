package com.example.ways.view;

import com.example.ways.tool.UpdateData;

import android.content.Context;
import android.widget.LinearLayout;
/**
 * 基础布局--抽象连接错误页面
 * @author 胡硕
 * time 20140428 1:18
 */
public abstract class BaseLinearLayout extends LinearLayout{
	private Context mContext;
	private NetErrorView mErrorView;
	public BaseLinearLayout(Context context) {
		super(context);
		mContext = context;
	}
	/**************************
	 * 函数：显示错误页面
	 **************************/
	public void ShowErrorView(){
		UpdateData mUpdateData = new UpdateData() {
			@Override
			public void onClick() {
				update();
			}
		};
		mErrorView = new NetErrorView(mContext, mUpdateData);
		this.addView(mErrorView);
	}
	//请求服务器数据
	public abstract void update();
}

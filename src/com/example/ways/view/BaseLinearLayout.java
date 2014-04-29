package com.example.ways.view;

import com.example.ways.tool.UpdateData;

import android.content.Context;
import android.widget.LinearLayout;
/**
 * ��������--�������Ӵ���ҳ��
 * @author ��˶
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
	 * ��������ʾ����ҳ��
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
	//�������������
	public abstract void update();
}

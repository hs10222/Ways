package com.example.ways.view;

import com.example.ways.utils.ConfigUtil;

import android.content.Context;
import android.widget.AbsoluteLayout;
import android.widget.LinearLayout;

/**
 * �������ת������ͼ
 * @author ��˶
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
	 * ��������ʼ������
	 *********************/
	private void InitView(){
		this.setOrientation(LinearLayout.VERTICAL);
		ll_switch = new AbsoluteLayout(mContext);
		ll_content = new LinearLayout(mContext);
	}
	/*********************************
	 * �������������ݽ��沼��
	 * @param id -- ��ʾ���ֵ�id
	 ********************************/
	private void setContetView(int id){
		
	}
	
	/****************************
	 * ���������õײ�������
	 */
	private void setControlView(){
		
	}
}

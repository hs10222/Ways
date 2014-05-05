package com.example.ways;

import com.example.ways.debug.LogApi;
import com.example.ways.utils.ConfigUtil;
import com.example.ways.view.ControlView;

import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.widget.LinearLayout;
/**
 * ��������
 * @author  ��˶
 * time 20140428 0:40
 */
public class MainActivity extends BaseActivity {
	private final String TAG = "MainActivity";
	private LinearLayout ll_loading;
	private int niFame = 0;
	private MyThread mThread;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ll_loading = new LinearLayout(this);
		LinearLayout.LayoutParams llp_loading = new LinearLayout.LayoutParams(screenHeight, screenHeight);
		ll_loading.setLayoutParams(llp_loading);
//		ll_loading.setBackgroundResource(R.drawable.ways_loading);
		ConfigUtil.getInstance().setScreen_height(screenHeight);
		ConfigUtil.getInstance().setScreen_width(screenWidth);
		setContentView(ll_loading);
		//����ȫ��
		setFullScreen(true);
		//��ʼ��ת
		startNextView();
	}
	
	/***************************
	 * ������ִ��������������תҳ��
	 ***************************/
	private void startNextView(){
		mThread = new MyThread();
		mThread.start();
	}
	
	/**
	 * ���������������߳�
	 * @author ��˶
	 * time 20140428 0:50
	 */
	private class MyThread extends Thread{
		@Override
		public void run() {
				while(niFame <= 11){
					mHandler.sendEmptyMessage(niFame);
					niFame ++;
					LogApi.Msg(TAG, "niFame------->>>"+niFame);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	
	Handler mHandler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			if(msg.what < 11){
				ll_loading.setBackgroundResource(R.drawable.ways_loading);
			}else{
//				ll_loading.setBackgroundColor(Color.WHITE);
//				ll_loading.removeAllViews();
				ControlView mControlView = new ControlView(getApplicationContext());
				LinearLayout.LayoutParams llp_control = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
				mControlView.setLayoutParams(llp_control);
				setContentView(mControlView);
//				ll_loading.addView(mControlView, llp_control);
			}
		}
	};
}

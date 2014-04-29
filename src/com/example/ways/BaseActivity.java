package com.example.ways;


import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
/**
 * 基础Activity
 * @author 胡硕
 * time 20140428 1:04
 */
public class BaseActivity extends Activity{
	public  int 				screenHeight;
	public  int 				screenWidth;
	public  float 				scale_pixel;
	protected BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			finish();
		} 
	 };
	 
	 @Override
	protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 	//出去任务栏和菜单栏
	        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	        this.requestWindowFeature(Window.ID_ANDROID_CONTENT);
			IntentFilter filter = new IntentFilter();     
			filter.addAction("ExitApp");     
			this.registerReceiver(broadcastReceiver, filter); 
			DisplayMetrics metric = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(metric);
			screenHeight = metric.heightPixels; // 屏幕宽度（像素）
			screenWidth = metric.widthPixels; // 屏幕高度（像素）

			scale_pixel = metric.density; // 屏幕密度
			
	 }
	@Override
	public void onResume() {
		super.onResume();
	}
	@Override
	public void onDestroy() {
		 this.unregisterReceiver(broadcastReceiver);
		super.onResume();
	}
	
	/*******************
	 * 函数：退出app
	 *******************/
	public void close() {    
		 Intent intent = new Intent();    
		 intent.setAction("ExitApp");    
		 this.sendBroadcast(intent);  
		 super.finish(); 
	}
	
	/***************************************
	 * 函数：设置是否全屏
	 * @param isFull
	 ****************************************/
	public void setFullScreen(boolean isFull){
		if(isFull){
			 //全屏显示
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		}
	}
}

package com.example.ways.utils;
/**
 * 全局变量实体类
 * @author 胡硕
 * @time 20140429 23:40
 */
public class ConfigUtil {
	private static ConfigUtil mConfig;
	//屏幕宽
	private int screen_width;
	//屏幕高
	private int screen_height;
	private ConfigUtil() {
	}
	/*************************************
	 * 函数：单利模式，获取ConfigUtil对象
	 * @return mConfig
	 */
	public static ConfigUtil getInstance(){
			if(mConfig == null){
				mConfig = new ConfigUtil();
				}
			return mConfig;
	}
	
	
	public int getScreen_width() {
		return screen_width;
	}
	public void setScreen_width(int screen_width) {
		this.screen_width = screen_width;
	}
	public int getScreen_height() {
		return screen_height;
	}
	public void setScreen_height(int screen_height) {
		this.screen_height = screen_height;
	}
	
}

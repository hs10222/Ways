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
		synchronized (mConfig) {
			if(mConfig == null){
				mConfig = new ConfigUtil();
				}
			}
		return mConfig;
	}
	
	public int getScreenWidth(){
		return screen_width;
	}
}

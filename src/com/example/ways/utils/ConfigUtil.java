package com.example.ways.utils;
/**
 * ȫ�ֱ���ʵ����
 * @author ��˶
 * @time 20140429 23:40
 */
public class ConfigUtil {
	private static ConfigUtil mConfig;
	//��Ļ��
	private int screen_width;
	//��Ļ��
	private int screen_height;
	private ConfigUtil() {
	}
	/*************************************
	 * ����������ģʽ����ȡConfigUtil����
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

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

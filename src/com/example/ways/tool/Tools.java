package com.example.ways.tool;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.utooo.cmccmarket.R;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

/**
 * ������--�ṩ���õķ�������
 * @author ��˶
 * time 20140428 1:05
 */
public class Tools {

	/***************************************
	 * ����:�ж��Ƿ����sd��(������ĳЩ�ֻ���û�취ʵ��)
	 * @return
	 *************************************/
	public static boolean isExitsdCard() {
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED))
			return true;

		return false;
	}
	
	 /**********************************
     * ��������ȡ�洢��·��
     * @return
     */
	 public static String getSdcardPath(){
	    	if(isExitsdCard()){
				   File path = Environment.getExternalStorageDirectory();
					 return path.getAbsolutePath();
	    	}
	    	return "";
	    }
	 
		/************************************************
		 * ��������ȡ�ֻ���Ψһ�豸ID
		 * @param context --������
		 * @return IMEI�豸ID
		 *************************************************/
		public static String getImei(Context context) {
			// ����IMEI
			String IMEI;
			// ��ȡ�绰���ܹ�����
			TelephonyManager tm = (TelephonyManager) context
					.getSystemService(context.TELEPHONY_SERVICE);
			IMEI = tm.getDeviceId();
			return IMEI;
		}
		
		/*********************************
		 * ��������ȡsdʣ��洢�ռ�
		 * @return
		 ***********************************/
		public static long getAvailaleSize() {
			// ȡ��SD���ļ�·��
			File path = Environment.getExternalStorageDirectory();
			StatFs sf = new StatFs(path.getPath());
			// ��ȡ�������ݿ�Ĵ�С(Byte)
			long blockSize = sf.getBlockSize();
			// ���е����ݿ������
			long freeBlocks = sf.getAvailableBlocks();
			// ����SD�����д�С
			// return freeBlocks * blockSize; //��λByte
			// return (freeBlocks * blockSize)/1024; //��λKB
			Log.i("sys", "sdcard size ------------>>>"+(freeBlocks*blockSize));
			return (freeBlocks * blockSize); // ��λMB
		}
		
		/**************************************************
		 *��������ȡ�汾��
		 * @return
		 ****************************************************/
		public static int getVersionName(Context context){
			PackageManager pm = context.getPackageManager();
			
			int versionCode = -1;
			try {
				versionCode = pm.getPackageInfo("com.utooo.cmccmarket", 0).versionCode;
			} catch (NameNotFoundException e) {
				e.printStackTrace();
			}
			return versionCode;
		}
		
		/***********************************************
		 * ������ƥ������
		 * @return
		 ***********************************************/
		public static boolean emailFormat(String mail){
			boolean flag = true;
			String check =  "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
			Pattern regex = Pattern.compile(check);
			Matcher matcher = regex.matcher(mail);
			if(!matcher.find()){
				flag = false;
			}
			return flag;
		}
		
		/***********************************************************
		 * ��������������Ƿ����
		 * @param context -- ������
		 * @return
		 ***********************************************************/
		public static boolean checkNetworkStatus(Context context){
			ConnectivityManager manager = (ConnectivityManager) context.getSystemService("connectivity");
			NetworkInfo info = manager.getActiveNetworkInfo();
			if(info == null || !info.isAvailable())
				return false;
			if(info.isRoaming())
				return true;
			return true;
		}
		/******************************************************************
		 * ������ʾ��ϢToast
		 * @param context -- ������
		 * @param msg		-- ��ʾ����ʾ��Ϣ
		 * @param gravity		-- ��ʾ��λ��
		 *****************************************************************/
		public static void showToast(Context context,int msg){
			Toast	toast = Toast.makeText(context,msg,	Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER,0, 0);
			toast.show();
		}
}

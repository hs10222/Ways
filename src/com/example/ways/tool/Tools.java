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
 * 工具类--提供常用的方法调用
 * @author 胡硕
 * time 20140428 1:05
 */
public class Tools {

	/***************************************
	 * 函数:判断是否存在sd卡(可能在某些手机上没办法实现)
	 * @return
	 *************************************/
	public static boolean isExitsdCard() {
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED))
			return true;

		return false;
	}
	
	 /**********************************
     * 函数：获取存储卡路径
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
		 * 函数：获取手机的唯一设备ID
		 * @param context --上下文
		 * @return IMEI设备ID
		 *************************************************/
		public static String getImei(Context context) {
			// 定义IMEI
			String IMEI;
			// 获取电话功能管理器
			TelephonyManager tm = (TelephonyManager) context
					.getSystemService(context.TELEPHONY_SERVICE);
			IMEI = tm.getDeviceId();
			return IMEI;
		}
		
		/*********************************
		 * 函数：获取sd剩余存储空间
		 * @return
		 ***********************************/
		public static long getAvailaleSize() {
			// 取得SD卡文件路径
			File path = Environment.getExternalStorageDirectory();
			StatFs sf = new StatFs(path.getPath());
			// 获取单个数据块的大小(Byte)
			long blockSize = sf.getBlockSize();
			// 空闲的数据块的数量
			long freeBlocks = sf.getAvailableBlocks();
			// 返回SD卡空闲大小
			// return freeBlocks * blockSize; //单位Byte
			// return (freeBlocks * blockSize)/1024; //单位KB
			Log.i("sys", "sdcard size ------------>>>"+(freeBlocks*blockSize));
			return (freeBlocks * blockSize); // 单位MB
		}
		
		/**************************************************
		 *函数：获取版本号
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
		 * 函数：匹配邮箱
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
		 * 函数：检测网络是否可用
		 * @param context -- 上下文
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
		 * 弹出提示信息Toast
		 * @param context -- 上下文
		 * @param msg		-- 显示的提示信息
		 * @param gravity		-- 显示的位置
		 *****************************************************************/
		public static void showToast(Context context,int msg){
			Toast	toast = Toast.makeText(context,msg,	Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER,0, 0);
			toast.show();
		}
}

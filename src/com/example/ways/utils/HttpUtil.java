package com.example.ways.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/**
 * ����������ݽ�����http���ͺ��������ݹ�����
 * @author ��˶
 * time 20140428 1:06
 */
public class HttpUtil {
	// get�������ļ����ȴ�С����
	/************************************************
	 * ����:get����ʽ
	 * @param path-- url·��
	 * @return true����ɹ� false����ʧ��
	 ************************************************/
	public static boolean getRequest(String path) {
		try {
			URL url = new URL(path);
			// ��url������
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// ��������ʽΪget
			conn.setRequestMethod("GET");
			// ��������ʱʱ��Ϊ5��
			conn.setReadTimeout(5000);
			// ����ɹ�����true
			if (conn.getResponseCode() == 200) {
				return true;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	/************************************************************************
	 * 
	 * ������post����ʽ
	 * 
	 * @param path-- ����·��
	 * @param map -- �������
	 * @return true����ɹ� �� false����ʧ��
	 ************************************************************************/
	public static boolean postRequest(String path, Map<String, String> map) {
		// ƴ��URL
		StringBuilder builder = new StringBuilder();
		if (map != null && !map.isEmpty()) {
			for (Map.Entry<String, String> param : map.entrySet()) {
				try {
					builder.append(param.getKey())
							.append('=')
							.append(URLEncoder.encode(param.getValue(), "utf-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			builder.deleteCharAt(builder.length() - 1);
		}
		// �����Content-Length: �����URL�Ķ��������ݳ���
		byte b[] = builder.toString().getBytes();
		try {
			URL url = new URL(path);
			//������
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			//����post����ʽ
			con.setRequestMethod("POST");
			con.setReadTimeout(2 * 1000);
			con.setDoOutput(true);// ���������
			con.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");// ��������
			con.setRequestProperty("Content-Length", String.valueOf(b.length));// ����
			//��ȡ�����
			OutputStream outStream = con.getOutputStream();
			outStream.write(b);// д������
			outStream.flush();// ˢ���ڴ�
			outStream.close();
			// �����Ƿ�ɹ�
			if (con.getResponseCode() == 200) {
				return true;
			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}

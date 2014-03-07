package com.yuli.netspider;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 作者：于立
 * 负责实现对种子连接的读取，以及存储服务器中断后的url。
 */
public class torrentLink {
	//写入种子链接
	public static boolean setTorrent(String str) {
		try{
			File file = new File("torrent.txt");
		    BufferedWriter out = new BufferedWriter(new FileWriter(file, false));  
		    out.write(str);
		    out.close();
		    return true;
	    }catch (Exception e) {
	    	e.printStackTrace();
	    	return false;
	    }
	}
	//读取链接
    public static String getTorrent() {
    	try{
    		File file = new File("torrent.txt");
    		BufferedReader in = new BufferedReader(new FileReader(file));
    		String temp = in.readLine();
    		temp = replaceRN(temp);
    		return temp;
    	}catch (Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }
    //去除字符串中的回车换行
    public static String replaceRN(String s) {
    	String dest = "";
    	if(s!=null) {
    		Pattern p = Pattern.compile("\r|\t");
    		Matcher m = p.matcher(s);
    		dest = m.replaceAll("");
    	}
    	return dest;
    }
}

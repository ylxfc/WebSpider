package com.yuli.webcrawler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class showData {
	public static ArrayList<resultBean> run(String key) {
	//	List<String> list = new ArrayList<String>();
		ArrayList<resultBean> arr2 = new ArrayList<resultBean>();
		List<String> ls = new ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
		}
		try {
			Connection conn;
			Statement stmt;
			ResultSet rs;
			String sql;
			ArrayList<resultBean> arr = new ArrayList<resultBean>();
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crawler", "root", "123456");
			sql = "SELECT URL2, webTitle FROM webcontent";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			try {
//				while (rs.next()) {
//					if(rs.getString(4).indexOf(key)!=-1||rs.getString(2).indexOf(key)!=-1)//标题或关键字里面包含
//					{
//					list.add(rs.getString(2)+"⊙"+a);
//					}
//					a++;
//				}
				arr = (ArrayList<resultBean>) resultToList.rtl(rs);
				for(int i=0;i<arr.size();i++) {
					String temp = arr.get(i).getTitle();
					boolean flag = temp.contains(key);
					if(flag) {
						//ls.add(arr.get(i).getUrl());
						arr2.add(arr.get(i));
					}
				}
				
				
				rs.close();
			} catch (Exception e) {
			}
			conn.close();
			rs.close();
			stmt.close();
		} catch (Exception e) {
		}
//		return ls;
		return arr2;
	}
}

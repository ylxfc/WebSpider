package com.yuli.webcrawler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.ResultSetMetaData;

public class resultToList {
	
	public static List<resultBean> rtl(ResultSet rs) throws SQLException{
//			ResultSetMetaData md = (ResultSetMetaData) rs.getMetaData();
//			for(int i=0;i<md.getColumnCount();i++) {
//				System.out.println(md.getColumnName(i)); 
//				System.out.println( "----------------- "); 
//			}
			List<resultBean> list = new ArrayList<resultBean>();
			while(rs.next()) {
				resultBean bean = new resultBean();
				String url = rs.getString("URL2");
				String title = rs.getString("webTitle");
				bean.setUrl(url);
				bean.setTitle(title);
				list.add(bean);
			}
			return list;
	}
}

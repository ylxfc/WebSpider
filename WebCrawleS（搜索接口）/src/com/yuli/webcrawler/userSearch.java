package com.yuli.webcrawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class userSearch {
	
	public static List<resultBean> run(String str) {
		
		List<resultBean> list = new ArrayList<resultBean>();
		List<String> list2 = new ArrayList<String>();
		List<resultBean> list3 = new ArrayList<resultBean>();
		try {
			list2 = Analyz.fenci(str);
			for(int i=0;i<list2.size();i++) {
				String temp = list2.get(i);
				list = showData.run(temp);
				for(int j=0;j<list.size();j++) {
					list3.add(list.get(j));
//					System.out.println("hehe"+list.get(j));
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list3;
	}
//	public static void main(String[] args) {
//		run("百度");
//	}
}

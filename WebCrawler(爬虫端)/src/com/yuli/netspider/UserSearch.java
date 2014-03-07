package com.yuli.netspider;

import java.io.IOException;

public class UserSearch {

	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
//		UserSearch us = new UserSearch();
		mainPro mp1 = new mainPro(utils.URL1);
		mainPro mp2 = new mainPro(utils.URL2);
		mainPro mp3 = new mainPro(utils.URL3);
		mainPro mp4 = new mainPro(utils.URL4);
		mainPro mp5 = new mainPro(utils.URL5);
		mainPro mp6 = new mainPro(utils.URL6);
		mainPro mp7 = new mainPro(utils.URL7);
		mainPro mp8 = new mainPro(utils.URL8);
		mainPro mp9 = new mainPro(utils.URL9);
		mainPro mp10 = new mainPro(utils.URL10);
		mp1.start();
		mp2.start();
		mp3.start();
		mp4.start();
		mp5.start();
		mp6.start();
		mp7.start();
		mp8.start();
		mp9.start();
		mp10.start();
	}
}

package com.yuli.netspider;

import java.io.IOException;
import java.sql.Connection;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class httpGet {
	public final static void getByString(String url, Connection conn) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		
		try{
			HttpGet httpget = new HttpGet(url);
			System.out.println("已得到反馈！"+ httpget.getURI());
			
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

				@Override
				public String handleResponse(final HttpResponse response)
						throws ClientProtocolException, IOException {
					// TODO Auto-generated method stub
					int status = response.getStatusLine().getStatusCode();
					if(status>=200 && status <300) {
						HttpEntity entity = response.getEntity();
						return entity != null? EntityUtils.toString(entity):null;
					}
					else {
						throw new ClientProtocolException("未知错误: " + status);
					}
				}
				
			};
			
			String responseBody = httpclient.execute(httpget, responseHandler);
			/*
			 * 
			 * System.out.println("----------------------------------------");
             * System.out.println(responseBody);
             * System.out.println("----------------------------------------");
			 * 
			 */
			parsePage.parseFromString(responseBody, conn, url);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			httpclient.close();
		}
	}
}

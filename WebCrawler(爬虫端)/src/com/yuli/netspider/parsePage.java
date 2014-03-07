package com.yuli.netspider;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;


public class parsePage {
	public static void parseFromString(String content, Connection conn, String url) throws Exception {
		Parser parser = new Parser(content);
		parser.setEncoding("UTF-8");
		HasAttributeFilter filter = new HasAttributeFilter("href");
		getPageContent getpagecontent = new getPageContent();
		
		try{
			String sql = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			Statement stmt = null;
			
			
			NodeList list = parser.parse(filter);
			int count = list.size();
			
			for(int i=0;i<count;i++) {
				Node node = list.elementAt(i);
				
				if(node instanceof LinkTag) {
					LinkTag link = (LinkTag)node;
					String nextlink = link.extractLink();
//					String mainurl = utils.URLS;
				//	String wpurl = mainurl + "wp-content/";
					
					//仅仅保存页面从mainurl
					//nextlink.startsWith(mainurl)
					if(true) {
						
						String tag = null;
						
						//不保存任何来自“wp-content”的页面
//						if(nextlink.startsWith(wpurl)) {
//							continue;
//						}
						
						try{
							//检查连接是否已经存在数据库中
							sql = "SELECT * FROM record WHERE URL = '" + nextlink + "'";
							stmt = conn.createStatement();
//							stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
							rs = stmt.executeQuery(sql);
							
							if(rs.next()) {
								
							}else {
								//如果连接不在数据库中，插入他
								sql = "INSERT INTO record (URL, crawled) VALUES ('" + nextlink + "',0)";
								pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
								pstmt.execute();
								System.out.println(nextlink);
								
								//将页面的内容存入数据库
								try {
									
									String temp = getpagecontent.getText(nextlink);
									String temp2 = getpagecontent.getTitle(nextlink);
								//	temp = URLDecoder.decode(temp, "UTF-8");
									//判断字符串中是否含有单引号
									if(nextlink.indexOf("'")>-1){
										nextlink = nextlink.replace("\\'", "\\\\'");
									}
									if(temp.indexOf("'")>-1){
										temp = nextlink.replace("\\'", "\\\\'");
									}
									if(temp2.indexOf("'")>-1){
										temp2 = nextlink.replace("\\'", "\\\\'");
									}
									sql = "INSERT INTO webcontent (URL2, webTitle, webContent) VALUES ('"+nextlink+"', '"+temp2+"', '"+temp+"')";
//									pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//									pstmt.execute();
									stmt.executeUpdate(sql);
									
								}catch(Exception e) {
									e.printStackTrace();
								}
								
								//使用子字符创来更好的解析
//								nextlink = nextlink.substring(mainurl.length());
//								//System.out.println(nextlink);
//								
//								if(nextlink.startsWith("tag/")) {
//									tag = nextlink.substring(4, nextlink.length()-1);
//									
//									//中文转为UTF-8编码
//									tag = URLDecoder.decode(tag, "UTF-8");
//									sql = "INSERT INTO tags (tagname) VALUES ('" + tag + "')";
//									pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//									//如果link互不相同，则tag一定不同
//									pstmt.execute();
//								}
								
							}
						}catch(Exception e) {
							e.printStackTrace();
						}finally {
							if(pstmt != null) {
								try{
									pstmt.close();
								}catch(Exception e2) {}
							}
							pstmt = null;
							if(rs != null) {
								try{
									rs.close();
								}catch(Exception e3) {}
							}
							rs = null;
							if(stmt != null) {
                                try {
                                    stmt.close();
                                } catch (Exception e4) {}
                            }
                            stmt = null;
						}
					}
				}
			}
		}catch(ParserException e) {
			e.printStackTrace();
		}
	}
}

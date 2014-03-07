<%@page import="com.yuli.webcrawler.resultBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.yuli.webcrawler.tools" %>
<%@ page import="com.yuli.webcrawler.userSearch" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String str = tools.toChinnese(request.getParameter("search"));

%>
<jsp:useBean id="myWord" class="com.yuli.webcrawler.wordsingle" scope="request"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>搜索结果</title>
    <%@ include file="top.jsp" %>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body background="inc_pic/middle.gif">
   
    <% 
    	List<resultBean> list2 = userSearch.run(str);
    	out.print("<table align=center>");
    	out.print("<tr>");
    	out.print("<td valign=\"middle\">");
    	out.print("</td>");
		out.print("<td>");
		out.print("<FONT face=隶书>");
    	out.print("\""+str+"\"的搜索结果有："+list2.size()+"个！");
    	out.print("</FONT>");
    	out.print("</td>");
    	out.print("</tr>");
	//	List<String> list2 =showData.run(tools.toChinnese(myWord.getSearch()));
	//	out.print("<table align=center>");
		for(int i=0;i<list2.size();i++){
	//	String[] subs = (list2.get(i)).split("⊙");
		out.print("<tr>");
		out.print("<td height=22 width=10 valign=\"middle\">");
		out.print("<img src=\"inc_pic/icon.jpg\" width=9 height=9 />");
		out.print("</td>");
		out.print("<td>");
		out.print("<a href='"+list2.get(i).getUrl()+"'>"+list2.get(i).getTitle()+"</a>");
	//	out.print("<br>");
		out.print("</td>");
		out.print("</tr>");
		}
		out.print("</table>");
	//	out.print("<br>");
	//	out.print("<br>");
		if(list2.size()==0)
		out.print("<p align=center>抱歉，没有您想要的结果!</p>");
	%>
    <%@ include file="bottom.html" %>
  </body>
</html>

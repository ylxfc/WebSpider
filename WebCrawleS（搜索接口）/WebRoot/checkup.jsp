<%@ page language="java" import="java.util.*" import="com.yuli.webcrawler.userSearch" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String str = request.getParameter("search");

//userSearch.run(str);
%>

<jsp:useBean id="myWord" class="com.yuli.webcrawler.wordsingle" scope="request">

<!-- 使用javaBean作为数据的载体传递过去 对象名:myWord 类:WorldSingle -->
	<jsp:setProperty name="myWord" property="*"/>
</jsp:useBean>

<jsp:forward page="show.jsp"></jsp:forward>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>搜索结果</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    This is my JSP page. <br>
    <%
    	System.out.println("jjk");
     %>
  </body>
</html>

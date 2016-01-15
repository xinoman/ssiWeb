<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<s:head/>
  </head>
  
  <body>
    <center>
    	<h1>用户登录</h1>
    	<s:a action="user_addUI" namespace="/user">添加新用户</s:a>
    	<s:form action="login" namespace="/" method="post">
    		<s:textfield key="user.username" name="user.username"></s:textfield>
    		<s:password key="user.password" name="user.password"></s:password>
    		<s:submit value="登录"></s:submit>
    	</s:form>
    </center>
  </body>
</html>

<%@page import="com.sale.dao.UserDAO"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'check.jsp' starting page</title>
    
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
    <% 
    	//设置请求对象中参数的字符编码(只能针对post方式提交)
    	//request.setCharacterEncoding("UTF-8");
    	//获取表单元素的内容
    	String usercode = request.getParameter("usercode");
    	String password = request.getParameter("password");
    	
    	//get方式提交转换字符编码
    	usercode = new String(usercode.getBytes("ISO-8859-1"),"UTF-8");
    	password = new String(password.getBytes("ISO-8859-1"),"UTF-8");
    	
    	
    	System.out.println(usercode+" "+password);
    	UserDAO dao = new UserDAO();
    	if(dao.checkUser(usercode,password)){
    		out.println("欢迎您："+usercode+"登录系统");
    	}else{
    		out.println("账户或者密码错误!<a href='login.jsp'>返回</a>");
    	}
    %>
  </body>
</html>

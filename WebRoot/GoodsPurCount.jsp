<%@page import="com.lck.dao.GoodsPurCountDAO"%>
<%@page import="com.lck.bean.GoodsPurCount"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'GoodsPurCount.jsp' starting page</title>
    
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
  <table class="GoodsPurCountTable" border="1" width="80%" align="center">
    	<td colspan="10" align="center"><h2>商品采购明细统计表</h2></td>   	
    	<tr>  		
    		<th>采购单号</th>
    		<th>采购日期</th>
    		<th>供货商</th>
    		<th>商品编号</th>
    		<th>商品名称</th>
    		<th>单位</th>
    		<th>进货价格</th>
    		<th>进货数量</th>
    		<th>进货总价</th>   		
    		<th>采购员</th>

    	</tr>
    	 <% 
    		GoodsPurCountDAO gpcDao = new GoodsPurCountDAO();
    		List<GoodsPurCount> list = gpcDao.getList();
    		for(GoodsPurCount gpclCount : list){
	    %>
		   		<tr align="center">
		   				   			   			
		   			<td><%=gpclCount.getPurId() %></td>
		   			<td><%=gpclCount.getPurTime() %></td>
		   			<td><%=gpclCount.getsName() %></td>
		   			<td><%=gpclCount.getpId() %></td>
		   			<td><%=gpclCount.getpName() %></td>
		   			<td><%=gpclCount.getpUnit() %></td>
		   			<td><%=gpclCount.getPurPrice() %></td>
		   			<td><%=gpclCount.getPurNum() %></td>
		   			
		   			<td><%=gpclCount.getPurPrice()*gpclCount.getPurNum() %></td>
		   				   			
		   			<td><%=gpclCount.geteName() %></td>		   		   			
		   		</tr>
	    <%		
	    	}
    	%>	    	
    </table>   
  </body>
</html>

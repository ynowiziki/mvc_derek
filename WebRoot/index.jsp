<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
  </head>
  
  <body>
  
    <form action="<%=request.getContextPath()%>/sss.do" method="post">
    
    	name:<input type="text" name="name"/>
    	pass:<input type="text" name="pass"/>
    	<input type="submit" value="提交">
    
    </form>
  </body>
</html>

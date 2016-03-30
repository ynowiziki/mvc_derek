<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="service.voMessage.ViewObject" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>Success</title>
    
	
  </head>
  
  <body>
    <%
       ViewObject vo = (ViewObject)request.getAttribute("output");
     %>
      <table border="2" width="85%">
        <tr>
          <td><%= vo.getAddress() %> </td> <td><%=vo.getMessage1() %> </td>
        </tr>
  
      </table>
  </body>
</html>

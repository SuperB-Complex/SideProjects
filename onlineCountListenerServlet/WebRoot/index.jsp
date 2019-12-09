<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
    The nubmer of on-line person is ${numberOfUsers} <br>
    
    <% 
    Map<String, jjm.learn.entity.User> userMap = (Map<String, jjm.learn.entity.User>)request.getServletContext().getAttribute("usersMap");
    %>
    <%   if (userMap != null) {
			for (jjm.learn.entity.User user : userMap.values()) {
	%>
	IP : <%=user.getIp() %>, First Time : <%=user.getFirstTime() %>, Session Id : <%=user.getSessionId() %> <br>
				
	<%		}
			
		} else {
	%>
	<br>user map is null
	<%
		}
     %>
    
  </body>
</html>

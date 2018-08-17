<%@ page language="java"  contentType ="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Greeting</title>
</head>
<body>
		<% request.setCharacterEncoding("UTF-8");%>
		<p>こんにちは、<%= request.getParameter("user")%>さん!</p>

</body>
</html>
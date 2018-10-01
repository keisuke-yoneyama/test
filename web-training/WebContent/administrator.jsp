<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title>ホーム画面</title>
	<link rel="stylesheet" href="./css/style.css">
</head>
<body>
	<div id="container">
	<jsp:include page="header.jsp" />
	<div id="main" class="clear">
		<div id="top">
			<h1>ホーム画面</h1>
		</div>
		<div class="center">
			<h2>
				<s:property value="#session.administratorFamily_name"/>さん、管理者画面へようこそ！
			</h2>
			<a href='<s:url action="ItemInfoAction" />'><input type="button" value="商品変更" class="button"></a><br>
			<a href='<s:url action="UserInfoAction" />'><input type="button" value="ユーザー変更" class="button marginTop"></a>

		</div>
	</div>
	<jsp:include page="footer.jsp" />
</div>
</body>
</html>
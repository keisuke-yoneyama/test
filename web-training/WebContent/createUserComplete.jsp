<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title>ユーザー登録完了</title>
	<link rel="stylesheet" href="./css/style.css">
</head>
<body>
	<div id="container">
	<jsp:include page="header.jsp" />
	<div id="main" class="clear">
		<div id="top">
			<h2>ユーザー登録が完了いたしました。</h2>
			<s:if test='#session.containsKey("administrator")'>
				<a href='<s:url action="GoAdministratorAction" />' class="marginTop">管理画面へ</a>
			</s:if>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title>パスワード再設定確認</title>
	<link rel="stylesheet" href="./css/style.css">
</head>
<body>
<div id="container">
	<jsp:include page="header.jsp" />
	<div id="main" class="clear">
		<div id="top">
			<h1>パスワード再設定確認画面</h1>
		</div>
		<div>
			<table class="verticalTable marginTop">
				<tr>
					<th>ログインID</th>
					<td><s:property value="#session.user_id_reset"/></td>
				</tr>
				<tr>
					<th>パスワード</th>
					<td><s:property value="#session.concealPassword"/></td>
				</tr>
				<tr>
					<td colspan="2" class="center"><a href='<s:url action="ResetPasswordCompleteAction" />'><input type="button" value="登録" class="button"></a></td>
				</tr>
			</table>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</div>
</body>
</html>
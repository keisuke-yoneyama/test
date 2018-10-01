<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title>パスワード再設定</title>
	<link rel="stylesheet" href="./css/style.css">
</head>
<body>
<div id="container">
	<jsp:include page="header.jsp" />
	<div id="main" class="clear">
		<div id="top">
			<h1>パスワード再設定</h1>
		</div>
		<s:if test="errorMassage != ''">
			<s:property value="errorMassage" escape="false" />
		</s:if>
		<div>
			<table class="verticalTable">
			<s:form action="ResetPasswordConfirmAction">
				<tr>
					<th>ログインID</th>
					<td><s:textfield name="user_id" class="txt" placeholder="ログインID" autocomplete="off" /></td>
				</tr>
				<tr>
					<th>現在のパスワード</th>
					<td><s:password name="password" class="txt" placeholder="パスワード" autocomplete="off" /></td>
				</tr>
				<tr>
					<th>新しいパスワード</th>
					<td><s:password name="newPassword" class="txt" placeholder="パスワード" autocomplete="off" /></td>
				</tr>
				<tr>
					<th>（再確認用）</th>
					<td><s:password name="confirmPassword" class="txt" placeholder="パスワード" autocomplete="off" /></td>
				</tr>
				<tr>
					<td colspan="2" class="center"><s:submit value="パスワード再設定" class="button marginTop"/></td>
				</tr>
			</s:form>
			</table>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</div>
</body>
</html>
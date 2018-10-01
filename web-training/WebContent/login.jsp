<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title>ログイン画面</title>
	<link rel="stylesheet" href="./css/style.css">
</head>
<body>
<div id="container">
	<jsp:include page="header.jsp" />
	<div id="main" class="clear">
		<div id="top">
			<h1>ログイン画面</h1>
		</div>
		<s:if test="errorMassage != ''">
			<s:property value="errorMassage" escape="false" />
		</s:if>
		<div>
			<table class="verticalTable">
			<s:form action="LoginAction">
				<s:if test="#session.idSaved == true">
				<tr>
					<th>ログインID:</th>
					<td><s:textfield name="user_id" class="txt" placeholder="ログインID" autocomplete="off" value='%{#session.id}' /></td>
				</tr>
				</s:if>
				<s:else>
				<tr>
					<th>ログインID:</th>
					<td><s:textfield name="user_id" class="txt" placeholder="ログインID" autocomplete="off" /></td>
				</tr>
				</s:else>
				<tr>
					<th>パスワード：</th>
					<td><s:password name="password" class="txt" placeholder="パスワード" autocomplete="off" /></td>
				</tr>
				<s:if test="#session.idSaved == true">
				<tr>
					<td><s:checkbox name="idSaved" checked="checked"/> ログインID保存</td>
				</tr>
				</s:if>
				<s:else>
				<tr>
					<td><s:checkbox name="idSaved"/> ログインID保存</td>
				</tr>
				</s:else>
				<tr>
					<td colspan="2" class="center"><s:submit value="ログイン" class="button marginTop"/></td>
				</tr>
			</s:form>
			<s:form action="CreateUserAction">
				<tr>
					<td colspan="2" class="center"><s:submit value="新規ユーザー登録" class="button marginTop"/></td>
				</tr>
			</s:form>
			<s:form action="ResetPasswordAction">
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
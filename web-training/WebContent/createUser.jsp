<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ユーザー情報入力</title>
	<link rel="stylesheet" href="./css/style.css">
</head>
<body>
<div id="container">
	<jsp:include page="header.jsp"/>
	<div id="main" class="clear">
		<div id="top">
			<h1>ユーザー情報入力画面</h1>
		</div>
		<s:if test="errorMassage != ''">
			<s:property value="errorMassage" escape="false"/>
		</s:if>
		<div>
			<table class="verticalTable">
			<s:form action="CreateUserConfirmAction">
				<tr>
					<th>姓</th>
					<td><s:textfield name="family_name" class="txt" placeholder="姓" autocomplete="off" value="%{family_name}"/></td>
				</tr>
				<tr>
					<th>名</th>
					<td><s:textfield name="first_name" class="txt" placeholder="名" autocomplete="off" value="%{first_name}"/></td>
				</tr>
				<tr>
					<th>姓ふりがな</th>
					<td><s:textfield name="family_name_kana" class="txt" placeholder="姓ふりがな" autocomplete="off" value="%{family_name_kana}"/></td>
				</tr>
				<tr>
					<th>名ふりがな</th>
					<td><s:textfield name="first_name_kana" class="txt" placeholder="名ふりがな" autocomplete="off" value="%{first_name_kana}"/></td>
				</tr>
				<tr>
					<th>性別</th>
					<td><s:radio list="#{0:'男性', 1:'女性'}" name="gender" value="%{gender}"/></td>
				</tr>
				<tr>
					<th>メールアドレス</th>
					<td><s:textfield name="email" class="txt" placeholder="メールアドレス" autocomplete="off" value="%{email}"/></td>
				</tr>
				<tr>
					<th>ログインID</th>
					<td><s:textfield name="user_id" class="txt" placeholder="ログインID" autocomplete="off" value="%{user_id}"/></td>
				</tr>
				<tr>
					<th>パスワード</th>
					<td><s:password name="password" class="txt" placeholder="パスワード" autocomplete="off" value="%{password}"/></td>
				</tr>
				<tr>
					<td colspan="2" class="center"><s:submit value="登録" class="button marginTop}"/></td>
				</tr>
			</s:form>
			</table>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</div>
</body>
</html>
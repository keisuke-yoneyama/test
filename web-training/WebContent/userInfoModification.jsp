<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title>ユーザー情報の変更を入力</title>
	<link rel="stylesheet" href="./css/style.css">
</head>
<body>
<div id="container">
	<jsp:include page="header.jsp" />
	<div id="main" class="clear">
		<div id="top">
			<h1>ユーザー情報の変更を入力</h1>
		</div>
		<s:if test="errorMassage != ''">
			<s:property value="errorMassage" escape="false" />
		</s:if>
		<div>
			<table class="verticalTable">
			<s:form action="UserInfoModificationConfirmAction">
			<s:iterator value="userInfoList">
				<tr>
					<th>姓</th>
					<td><input type="text" name="family_name" class="txt" value='<s:property value="family_name"/>' placeholder="姓" autocomplete="off" /></td>
				</tr>
				<tr>
					<th>名</th>
					<td><input type="text" name="first_name" class="txt" value='<s:property value="first_name"/>' placeholder="名" autocomplete="off" /></td>
				</tr>
				<tr>
					<th>姓ふりがな</th>
					<td><input type="text" name="family_name_kana" class="txt" value='<s:property value="family_name_kana"/>' placeholder="姓ふりがな" autocomplete="off" /></td>
				</tr>
				<tr>
					<th>名ふりがな</th>
					<td><input type="text" name="first_name_kana" class="txt" value='<s:property value="first_name_kana"/>' placeholder="名ふりがな" autocomplete="off" /></td>
				</tr>
				<tr>
					<th>性別</th>
					<td><s:radio list="#{0:'男性', 1:'女性'}" name="gender" value="gender" /></td>
				</tr>
				<tr>
					<th>メールアドレス</th>
					<td><input type="text" name="email" class="txt" value='<s:property value="email"/>' placeholder="メールアドレス" autocomplete="off" /></td>
				</tr>
				<tr>
					<th>ログインID</th>
					<td><input type="text" name="user_id" class="txt" value='<s:property value="user_id"/>' placeholder="ログインID" autocomplete="off" /></td>
				</tr>
				<tr>
					<th>パスワード</th>
					<td><input type="text" name="password" class="txt" value='<s:property value="password"/>' placeholder="パスワード" autocomplete="off" /></td>
				</tr>
				<tr>
					<td colspan="2" class="center"><s:submit value="変更" class="button marginTop"/></td>
				</tr>
			</s:iterator>
			</s:form>
			</table>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</div>
</body>
</html>
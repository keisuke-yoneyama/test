<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title>ユーザー情報確認</title>
	<link rel="stylesheet" href="./css/style.css">
</head>
<body>
<div id="container">
	<jsp:include page="header.jsp" />
	<div id="main" class="clear">
		<div id="top">
			<h1>ユーザー情報確認画面</h1>
			<h2>以下の内容でよろしいですか。</h2>
		</div>
		<div>
			<table class="verticalTable marginTop">
				<tr>
					<th>姓</th>
					<td><s:property value="#session.family_name_provisional"/></td>
				</tr>
				<tr>
					<th>名</th>
					<td><s:property value="#session.first_name_provisional"/></td>
				</tr>
				<tr>
					<th>姓ふりがな</th>
					<td><s:property value="#session.family_name_kana_provisional"/></td>
				</tr>
				<tr>
					<th>名ふりがな</th>
					<td><s:property value="#session.first_name_kana_provisional"/></td>
				</tr>
				<tr>
					<th>性別</th>
					<td>
					<s:if test="#session.gender_provisional.hashCode() == 0">男</s:if>
					<s:else>女</s:else>
					</td>
				</tr>
				<tr>
					<th>メールアドレス</th>
					<td><s:property value="#session.email_provisional"/></td>
				</tr>
				<tr>
					<th>ログインID</th>
					<td><s:property value="#session.user_id_provisional"/></td>
				</tr>
				<tr>
					<th>パスワード</th>
					<td><s:property value="#session.password_provisional"/></td>
				</tr>
				<tr>
					<td colspan="2" class="center"><a href='<s:url action="UserInfoModificationCompleteAction" />'><input type="button" value="変更" class="button"></a></td>
				</tr>
			</table>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</div>
</body>
</html>
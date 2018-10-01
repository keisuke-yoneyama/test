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
			<s:form id="form" action="CreateUserCompleteAction">
				<table class="verticalTable marginTop">
					<tr>
						<th>姓</th>
						<td><s:property value="family_name"/></td>
					</tr>
					<tr>
						<th>名</th>
						<td><s:property value="first_name"/></td>
					</tr>
					<tr>
						<th>姓ふりがな</th>
						<td><s:property value="family_name_kana"/></td>
					</tr>
					<tr>
						<th>名ふりがな</th>
						<td><s:property value="first_name_kana"/></td>
					</tr>
					<tr>
						<th>性別</th>
						<td>
						<s:if test="gender == 0">男</s:if>
						<s:else>女</s:else>
						</td>
					</tr>
					<tr>
						<th>メールアドレス</th>
						<td><s:property value="email"/></td>
					</tr>
					<tr>
						<th>ログインID</th>
						<td><s:property value="user_id"/></td>
					</tr>
					<tr>
						<th>パスワード</th>
						<td><s:property value="password"/></td>
					</tr>
					<tr>
						<td class="center"><input type="submit" value="登録" class="button"></td>
						<td class="center"><input type="submit" value="戻って修正" class="button" onclick="this.form.action='CreateUserAction';"></td>
					</tr>
				</table>
				<s:hidden name="family_name" value="%{family_name}" />
				<s:hidden name="first_name" value="%{first_name}" />
				<s:hidden name="family_name_kana" value="%{family_name_kana}" />
				<s:hidden name="first_name_kana" value="%{first_name_kana}" />
				<s:hidden name="gender" value="%{gender}" />
				<s:hidden name="email" value="%{email}" />
				<s:hidden name="user_id" value="%{user_id}" />
				<s:hidden name="password" value="%{password}" />
			</s:form>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</div>
</body>
</html>
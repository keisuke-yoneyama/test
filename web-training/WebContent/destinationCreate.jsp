<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title>宛先情報入力</title>
	<link rel="stylesheet" href="./css/style.css">
</head>
<body>
<div id="container">
	<jsp:include page="header.jsp" />
	<div id="main" class="clear">
		<div id="top">
			<h1>宛先情報入力画面</h1>
		</div>
		<s:if test="errorMassage != ''">
			<s:property value="errorMassage" escape="false" />
		</s:if>
		<div>
			<table class="verticalTable">
			<s:form action="DestinationConfirmAction">
				<tr>
					<th>姓</th>
					<td><s:textfield name="family_name" class="txt" placeholder="姓" autocomplete="off" /></td>
				</tr>
				<tr>
					<th>名</th>
					<td><s:textfield name="first_name" class="txt" placeholder="名" autocomplete="off" /></td>
				</tr>
				<tr>
					<th>姓ふりがな</th>
					<td><s:textfield name="family_name_kana" class="txt" placeholder="姓ふりがな" autocomplete="off" /></td>
				</tr>
				<tr>
					<th>名ふりがな</th>
					<td><s:textfield name="first_name_kana" class="txt" placeholder="名ふりがな" autocomplete="off" /></td>
				</tr>
				<tr>
					<th>住所</th>
					<td><s:textfield name="user_address" class="txt" placeholder="住所" autocomplete="off" /></td>
				</tr>
				<tr>
					<th>電話番号</th>
					<td><s:textfield name="tel_number" class="txt" placeholder="パスワード" autocomplete="off" /></td>
				</tr>
				<tr>
					<th>メールアドレス</th>
					<td><s:textfield name="email" class="txt" placeholder="メールアドレス" autocomplete="off" /></td>
				</tr>
				<tr>
					<td colspan="2" class="center"><s:submit value="宛先情報登録" class="button marginTop"/></td>
				</tr>
			</s:form>
			</table>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</div>
</body>
</html>
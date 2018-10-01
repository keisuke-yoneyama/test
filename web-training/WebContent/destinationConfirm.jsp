<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title>宛先情報確認</title>
	<link rel="stylesheet" href="./css/style.css">
</head>
<body>
<div id="container">
	<jsp:include page="header.jsp" />
	<div id="main" class="clear">
		<div id="top">
			<h1>宛先情報確認画面</h1>
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
					<th>住所</th>
					<td><s:property value="#session.user_address_provisional"/></td>
				</tr>
				<tr>
					<th>電話番号</th>
					<td><s:property value="#session.tel_number_provisional"/></td>
				</tr>
				<tr>
					<th>メールアドレス</th>
					<td><s:property value="#session.email_provisional"/></td>
				</tr>
				<tr>
					<td colspan="2" class="center"><a href='<s:url action="DestinationCompleteAction" />'><input type="button" value="登録" class="button"></a></td>
				</tr>
			</table>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</div>
</body>
</html>
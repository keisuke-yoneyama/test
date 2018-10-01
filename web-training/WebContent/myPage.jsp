<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title>マイページ</title>
	<link rel="stylesheet" href="./css/style.css">
</head>
<body>
<div id="container">
	<jsp:include page="header.jsp" />
	<div id="main" class="clear">
		<div id="top">
			<h1>マイページ</h1>
		</div>
		<div>
			<s:iterator value="userInfoList">
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
						<s:if test="gender == 0">
							<span>男性</span>
						</s:if>
						<s:elseif test="gender == 1">
							<span>女性</span>
						</s:elseif>
					</td>
				</tr>
				<tr>
					<th>メールアドレス</th>
					<td><s:property value="email"/></td>
				</tr>
				<tr>
					<td colspan="2" class="center"><a href='<s:url action="GoPurchaseHistoryInfoAction" />'><input type="button" value="購入履歴" class="button marginTop"></a></td>
				</tr>
			</table>
		</s:iterator>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</div>
</body>
</html>
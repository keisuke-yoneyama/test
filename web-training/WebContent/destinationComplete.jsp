<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title>宛先登録完了</title>
	<link rel="stylesheet" href="./css/style.css">
</head>
<body>
	<div id="container">
	<jsp:include page="header.jsp" />
	<div id="main" class="clear">
		<div id="top">
			<h2>宛先の登録が完了いたしました。</h2>
			<span>決済画面に戻る場合は<a href='<s:url action="SettlementConfirmAction" />'>こちら</a></span>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title>商品登録完了</title>
	<link rel="stylesheet" href="./css/style.css">
	<meta http-equiv="refresh" content="3;URL=GoHomeAction">
</head>
<body>
	<div id="container">
	<jsp:include page="header.jsp" />
	<div id="main" class="clear">
		<div id="top">
			<h1>エラーが発生しました。</h1>
			<s:if test="!message.isEmpty()">
				<span><s:property value="message"/>の在庫がありません。</span>
			</s:if>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</div>
</body>
</html>
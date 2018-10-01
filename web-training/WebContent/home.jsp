<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>ホーム</title>
<link rel="stylesheet" href="./css/style.css">
</head>
<body>
	<div id="container">
		<jsp:include page="header.jsp" />
		<div id="main" class="clear">
			<div id="top">
				<h1>ホーム画面</h1>
			</div>
			<div>
				<s:if test='#session.containsKey("user_id")'>
					<h2>
						<s:property value="#session.family_name" />
						<s:property value="#session.first_name" />
						さん、こんにちは！
					</h2>
				</s:if>
				<s:if test='#session.containsKey("administrator")'>
					<a href='<s:url action="GoAdministratorAction" />'
						class="marginTop">管理画面へ</a>
				</s:if>
			</div>
		</div>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>
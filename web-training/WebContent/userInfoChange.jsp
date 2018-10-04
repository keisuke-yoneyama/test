<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title>商品情報画面</title>
	<link rel="stylesheet" href="./css/style.css">
</head>
<body>
	<div id="container">
	<jsp:include page="header.jsp" />
	<div id="main" class="clear">
		<div id="top">
			<h1>ユーザー情報画面</h1>
		</div>
		<div class="marginLeft">
			<s:if test="userInfoList == null">
				<h3>ユーザ情報はありません。</h3>
			</s:if>
			<s:elseif test="message == null">
				<h3>ユーザ情報は以下になります。</h3>
			<table border="1" class="ShowData">
				<tr>
					<th>姓</th>
					<th>名</th>
					<th>姓ふりがな</th>
					<th>名ふりがな</th>
					<th>性別</th>
					<th>メールアドレス</th>
					<th>ログインID</th>
					<th>パスワード</th>
				</tr>
				<s:iterator value="userInfoList">
				<tr>
					<th><s:property value="family_name" /></th>
					<th><s:property value="first_name" /></th>
					<th><s:property value="family_name_kana" /></th>
					<th><s:property value="first_name_kana" /></th>
					<th>
						<s:if test="gender == 0">
							<span>男性</span>
						</s:if>
						<s:elseif test="gender == 1">
							<span>女性</span>
						</s:elseif>
					</th>
					<th><s:property value="email" /></th>
					<th><s:property value="user_id" /></th>
					<th><s:property value="password" /></th>
				</tr>
				</s:iterator>
			</table>
			</s:elseif>
			<s:form action="UserInfoModificationAction" class="marginTop">
				<s:submit value="ユーザーの変更" class="button"/>
			</s:form>
			<s:form action="UserInfoAction" class="marginTop">
				<input type="hidden" name="deleteFlg" value="1">
				<s:submit value="削除" method="delete" class="button" />
			</s:form>
			<s:if test="message != null">
				<h3><s:property value="message"/></h3>
			</s:if>
			<s:form action="GoAdministratorAction" class="marginTop">
				<s:submit value="管理者画面へ戻る" class="button"/>
			</s:form>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</div>
</body>
</html>
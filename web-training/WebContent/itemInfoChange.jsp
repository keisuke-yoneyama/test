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
			<h1>商品情報画面</h1>
		</div>
		<div class="marginLeft">
			<s:if test="itemInfoList == null">
				<h3>商品情報はありません。</h3>
			</s:if>
			<s:elseif test="message == null">
				<h3>商品情報は以下になります。</h3>
			<table border="1" class="ShowData">
				<tr>
					<th>製品ID</th>
					<th>商品名</th>
					<th>製品詳細</th>
					<th>カテゴリー名</th>
					<th>価格</th>
					<th>イメージファイル名</th>
					<th>発売日</th>
					<th>発売会社</th>
				</tr>
				<s:iterator value="itemInfoList">
				<tr>
					<th><s:property value="product_id" /></th>
					<th><s:property value="product_name" /></th>
					<th><s:property value="product_description" /></th>
					<th>
						<s:if test="category_id == 2">
							<span>本</span>
						</s:if>
						<s:elseif test="category_id == 3">
							<span>家電・パソコン</span>
						</s:elseif>
						<s:elseif test="category_id == 4">
							<span>おもちゃ・ゲーム</span>
						</s:elseif>
					</th>
					<th><s:property value="price" /><span>円</span></th>
					<th><s:property value="image_file_name" /></th>
					<th><s:property value="release_date" /></th>
					<th><s:property value="release_company" /></th>
				</tr>
				</s:iterator>
			</table>
			</s:elseif>
			<s:form action="ItemInfoModificationAction" class="marginTop">
				<s:submit value="商品の変更" class="button"/>
			</s:form>
			<s:form action="ItemInfoChangeAction" class="marginTop">
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
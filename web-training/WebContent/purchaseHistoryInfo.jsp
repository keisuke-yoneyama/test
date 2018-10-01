<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title>カート</title>
	<link rel="stylesheet" href="./css/style.css">
</head>
<body>
	<div id="container">
	<jsp:include page="header.jsp" />
	<div id="main" class="clear">
		<div id="top">
			<h1>購入履歴画面</h1>
		</div>
		<div class="marginLeft">
			<s:if test="purchaseHistoryInfoInfoList == null">
				<h3>商品の購入履歴の情報はありません。</h3>
			</s:if>
			<s:else>
				<s:if test="true">
					<h2><s:property value="message" /></h2>
					<s:property value="%{message}" />
				</s:if>
			<s:form action="GoPurchaseHistoryInfoAction.action">
			<table border="1" class="ShowData marginBottom">
				<tr>
					<th>商品名</th>
					<th>ふりがな</th>
					<th>商品画像</th>
					<th>値段</th>
					<th>発売会社</th>
					<th>発売年月日</th>
					<th>購入個数</th>
				</tr>
				<s:iterator value="#session.purchaseHistoryInfoInfoList">
				<tr>
					<th><s:property value="product_name" /></th>
					<th><s:property value="product_name_kana" /></th>
					<th>
						<img class="itemImageSmall" src='<s:property value="image_file_path"/>/<s:property value="image_file_name"/>'>
					</th>
					<th><s:property value="price" /><span>円</span></th>
					<th><s:property value="release_company" /></th>
					<th><s:property value="release_date" /></th>
					<th><s:property value="product_count" /></th>
				</tr>
				</s:iterator>
			</table>
				<input type="hidden" name="deleteFlg" value="1">
				<s:submit value="削除" class="button"/>
			</s:form>
			</s:else>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</div>
</body>
</html>
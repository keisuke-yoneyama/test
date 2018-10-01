<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title>商品詳細</title>
	<link rel="stylesheet" href="./css/style.css">
</head>
<body>
	<div id="container">
	<jsp:include page="header.jsp" />
	<div id="main" class="clear">
		<div id="top">
			<h1>商品詳細画面</h1>
		</div>
		<div id="itemList">
			<div class="itemDetailBox">
			<s:if test="message">
				<h2>ログインしてください。</h2>
			</s:if>
			<s:if test="errorMessage == null">
			<s:form action="AddCartAction">
				<img class="itemDetailImage" src='<s:property value="#session.image_file_path"/>/<s:property value="#session.image_file_name"/>'>
				<table border="1">
					<tr>
						<th>商品名</th>
						<th><s:property value="#session.product_name" /></th>
					</tr>
					<tr>
						<th>商品名かな</th>
						<th><s:property value="#session.product_name_kana" /></th>
					</tr>
					<tr>
						<th>価格</th>
						<th><s:property value="#session.price" /><span>円</span></th>
					</tr>
					<tr>
						<th>購入個数</th>
						<th>
							<select name="product_count">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</select>個
						</th>
					</tr>
					<tr>
						<th>発売日</th>
						<th><s:property value="#session.release_date" /></th>
					</tr>
					<tr>
						<th>発売会社</th>
						<th><s:property value="#session.release_company" /></th>
					</tr>
					<tr>
						<th>製品詳細</th>
						<th><s:property value="#session.product_description" /></th>
					</tr>
				</table>
				<s:submit value="カートに追加" class="button"/>
			</s:form>
			</s:if>
			<s:else>
				<s:property value="%{errorMessage}"/>
			</s:else>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</div>
</body>
</html>
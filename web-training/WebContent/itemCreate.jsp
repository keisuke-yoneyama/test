<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title>商品情報入力</title>
	<link rel="stylesheet" href="./css/style.css">
</head>
<body>
<div id="container">
	<jsp:include page="header.jsp" />
	<div id="main" class="clear">
		<div id="top">
			<h1>商品情報入力画面</h1>
		</div>
		<div class="error">
			<s:if test="errorMassage != ''">
				<p><s:property value="errorMassage" escape="false" /></p>
			</s:if>
			<s:if test="imageFilePathError != null">
				<p><s:property value="imageFilePathError"/></p>
			</s:if>
		</div>
		<div>
			<table class="verticalTable">
			<s:form action="ItemCreateConfirmAction" enctype="multipart/form-data" method="post">
				<tr>
					<th>商品名</th>
					<td><s:textfield name="product_name" class="txt" placeholder="商品名" autocomplete="off" /></td>
				</tr>
				<tr>
					<th>商品名かな</th>
					<td><s:textfield name="product_name_kana" class="txt" placeholder="商品名かな" autocomplete="off" /></td>
				</tr>
				<tr>
					<th>製品詳細</th>
					<td><s:textfield name="product_description" class="txt" placeholder="製品詳細" autocomplete="off" /></td>
				</tr>
				<tr>
					<th>カテゴリー名</th>
					<td class="list"><s:radio list="#{2:'本', 3:'家電・パソコン', 4:'おもちゃ・ゲーム'}" name="category_id" value="2" /></td>
				</tr>
				<tr>
					<th>価格</th>
					<td><input type="number" name="price" value="" class="txt" placeholder="価格" autocomplete="off" /></td>
				</tr>
				<tr>
					<th>商品画像:</th>
					<td class="list"><s:file name="userImage"/></td>
				</tr>
				<tr>
					<th>発売日</th>
					<td><input type="date" name="release_date" value="2018-06-21" class="txt" placeholder="発売日" autocomplete="off" /></td>
				</tr>
				<tr>
					<th>販売元</th>
					<td><s:textfield name="release_company" class="txt" placeholder="販売元" autocomplete="off" /></td>
				</tr>
				<tr>
					<td colspan="2" class="center"><s:submit value="登録" class="button marginTop"/></td>
				</tr>
			</s:form>
			</table>
			<div  class="marginTop">
				<p>管理者画面へ戻る場合は<a href='<s:url action="GoAdministratorAction" />'>こちら</a></p>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title>商品情報変更入力</title>
	<link rel="stylesheet" href="./css/style.css">
</head>
<body>
<div id="container">
	<jsp:include page="header.jsp" />
	<div id="main" class="clear">
		<div id="top">
			<h1>商品情報変更入力画面</h1>
		</div>
		<s:if test="errorMassage != ''">
			<s:property value="errorMassage" escape="false" />
		</s:if>
		<div>
			<table class="verticalTable">
			<s:form action="ItemInfoModificationConfirmAction">
			<s:iterator value="itemInfoList">
				<tr>
					<th>商品名</th>
					<td><input type="text" name="product_name" class="txt" value='<s:property value="product_name"/>' placeholder='<s:property value="product_name"/>' autocomplete="off" /></td>
				</tr>
				<tr>
					<th>商品名かな</th>
					<td><input type="text" name="product_name_kana" class="txt" value='<s:property value="product_name_kana"/>' placeholder='<s:property value="product_name_kana"/>' autocomplete="off" /></td>
				</tr>
				<tr>
					<th>製品詳細</th>
					<td><input type="text" name="product_description" class="txt" value='<s:property value="product_description"/>' placeholder='<s:property value="product_description"/>' autocomplete="off" /></td>
				</tr>
				<tr>
					<th>カテゴリー名</th>
					<td><s:radio list="#{2:'本', 3:'家電・パソコン', 4:'おもちゃ・ゲーム'}" name="category_id" value="category_id" /></td>
				</tr>
				<tr>
					<th>価格</th>
					<td><input type="number" name="price" value='<s:property value="price"/>' class="txt" placeholder='<s:property value="price"/>' autocomplete="off" min="1" max="100000000" /></td>
				</tr>
				<tr>
					<th>在庫</th>
					<td><input type="number" name="stock" value='<s:property value="stock"/>' class="txt" placeholder='<s:property value="stock"/>' autocomplete="off" min="1" max="1000" /></td>
				</tr>
				<tr>
					<th>イメージファイルパス</th>
					<td><input type="text" name="image_file_path" class="txt" value='<s:property value="image_file_path"/>' placeholder='<s:property value="image_file_path"/>' autocomplete="off" /></td>
				</tr>
				<tr>
					<th>イメージファイル名</th>
					<td><input type="text" name="image_file_name" class="txt" value='<s:property value="image_file_name"/>' placeholder='<s:property value="image_file_name"/>' autocomplete="off" /></td>
				</tr>
				<tr>
					<th>発売日</th>
					<td><input type="date" name="release_date" class="txt" value='<s:property value="release_date"/>' placeholder='<s:property value="release_date"/>' autocomplete="off" /></td>
				</tr>
				<tr>
					<th>販売元</th>
					<td><input type="text" name="release_company" class="txt" value='<s:property value="release_company"/>' placeholder='<s:property value="release_company"/>' autocomplete="off" /></td>
				</tr>
				<tr>
					<td colspan="2" class="center"><s:submit value="変更する" class="button marginTop"/></td>
				</tr>
			</s:iterator>
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
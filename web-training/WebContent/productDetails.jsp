<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title>商品一覧</title>
	<link rel="stylesheet" href="./css/style.css">
</head>
<body>
	<div id="container">
	<jsp:include page="header.jsp" />
	<div id="main" class="clear">
		<div id="top">
			<h1>商品一覧画面</h1>
		</div>
		<div id="itemList">
		<s:iterator value="#session.itemInfoList">
			<div class="itemListBox">
				<ul>
					<li>
						<a href='<s:url action="ProductDetailsAction">
						<s:param name="itemId" value="%{product_id}"/></s:url>'>
						<img class="itemImage" src='<s:property value="image_file_path"/>/<s:property value="image_file_name"/>'>
						</a>
					</li>
					<li><s:property value="product_name"/></li>
					<li><s:property value="product_name_kana"/></li>
					<li><s:property value="price"/>円</li>
				</ul>
			</div>
		</s:iterator>

		</div>
		<div class="center">
			<ul id="pageNo">
				<s:iterator begin="1" end="#session.totalPageNum" status="pageNo">
					<s:if test="#session.currentPageNo == #pageNo.count">
						<li><s:property value="%{#pageNo.count}"/></li>
					</s:if>
					<s:else>
						<li>
							<a href='<s:url action="ItemListAction"><s:param name="PageNo" value="%{#pageNo.count}" /><s:param name="retrievalFlg" value="%{retrievalFlg}" /></s:url>'><s:property value="%{#pageNo.count}"/></a>
						</li>
					</s:else>
				</s:iterator>
			</ul>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</div>
</body>
</html>
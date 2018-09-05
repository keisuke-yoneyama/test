<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>お問い合わせ　受付完了</title>
<link rel="stylesheet"type="text/css"href="./css/style.css">
</head>
<body>
	<table>
		<tbody>
			<tr>
				<th>名前</th>
				<th>お問い合わせの種類</th>
				<th>お問い合わせの内容</th>
			</tr>

			<s:iterator value="inquiryDTOList">
				<tr>
					<td><s:property value="name"/></td>
				</tr>
				</s:iterator>
		</tbody>
	</table>
</body>
</html>
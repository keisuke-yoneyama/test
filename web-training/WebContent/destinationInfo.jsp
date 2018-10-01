<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title>決済確認</title>
	<link rel="stylesheet" href="./css/style.css">
<script type="text/javascript">
	function SettlementConfirmAction() {
		document.getElementById("form").action='SettlementConfirmAction';
	}
</script>
</head>
<body>
	<div id="container">
	<jsp:include page="header.jsp" />
	<div id="main" class="clear">
		<div id="top">
			<h1>決済確認画面</h1>
		</div>
		<div class="marginLeft">
			<s:if test="destinationInfoList == null">
				<h3>送り先情報はありません。</h3>
			</s:if>
			<s:else>
				<s:if test="true">
					<h2><s:property value="message" /></h2>
					<s:property value="%{message}" />
				</s:if>
				<h3>送り先情報を選択してください</h3>
			<s:form id="form" action="SettlementCompleteAction">
			<table border="1" class="ShowData">
				<tr>
					<th>#</th>
					<th>名前</th>
					<th>ふりがな</th>
					<th>住所</th>
					<th>電話番号</th>
					<th>メールアドレス</th>
				</tr>
				<s:iterator value="destinationInfoList">
				<tr>
					<th><input type="radio" checked="checked" name="selectAddress" value='<s:property value="id"/>'></th>
					<th><s:property value="family_name" /> <s:property value="first_name" /></th>
					<th><s:property value="family_name_kana" /> <s:property value="first_name_kana" /></th>
					<th><s:property value="user_address" /></th>
					<th><s:property value="tel_number" /></th>
					<th><s:property value="email" /></th>
				</tr>
				</s:iterator>
			</table>
				<s:submit value="決済" action="SettlementCompleteAction" class="button marginTop"/>
				<input type="hidden" name="deleteFlg" value="1">
				<s:submit value="削除" onclick="this.form.action='SettlementConfirmAction';" class="button marginTop"/>
			</s:form>
			</s:else>
				<a href='<s:url action="DestinationCreateAction" />'><input type="button" value="新規登録" class="button marginTop"></a>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title>ヘッダー</title>
<!-- 	<link rel="stylesheet" href="./css/style.css"> -->
</head>
<body>
<div id="header">
	<div id="nameIntroduction">
		<p><a href='<s:url action="GoAdministratorAction" />'>internous社ECsite</a></p>
	</div>

	<ul>
		<s:form action="ItemListAction" class="float">
		<li>
			<select name="category_id">
				<option value="1">全てのカテゴリー</option>
				<option value="2">本</option>
				<option value="3">家電・パソコン</option>
				<option value="4">おもちゃ・ゲーム</option>
			</select>
		</li>
		<li>
			<input type="hidden" name="retrievalFlg" value="1">
			<input type="text" name="keywords" placeholder="検索ワード" id="text">
		</li>
		<li><s:submit value="商品検索"  class="button"/></li>
		</s:form>
		<li>
			<s:if test='#session.containsKey("user_id")'>
				<a href='<s:url action="LogoutAction" />'><input type="button" value="ログアウト" class="button"></a>
			</s:if>
			<s:else>
				<a href='<s:url action="GoLoginAction" />'><input type="button" value="ログイン" class="button"></a>
			</s:else>
		</li>
		<li><a href='<s:url action="GoCartAction" />'><input type="button" value="カート" class="button"></a></li>
		<li><a href='<s:url action="ItemListAction" />'><input type="button" value="商品一覧" class="button"></a></li>
		<s:if test='#session.containsKey("user_id") && !#session.containsKey("administrator")'>
			<li><a href='<s:url action="GoMyPageAction" />'><input type="button" value="マイページ" class="button"></a></li>
		</s:if>
		<s:elseif test='#session.containsKey("administrator")'>
			<li><a href='<s:url action="GoAdministratorAction" />'><input type="button" value="管理者画面へ" class="button"></a></li>
		</s:elseif>
	</ul>
</div>
</body>
</html>
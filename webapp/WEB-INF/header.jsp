<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- パッケージ・モデルインポート -->
<%@ page import ="model.UserModel"%>    
<!-- セッションスコープからインスタンス取得 -->
<% UserModel name = (UserModel) session.getAttribute("login_name");%>
  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ヘッダー</title>
	<link rel="stylesheet" href="css/header.css">
</head>
<body>

<header>
	<div class="container">
		<div class="header-title">
			<h2><a href="/WebP2/Login">スケジュール管理</a></h2>
		</div>
		<div class="header-menu">
			<ul>
				<li><form action="/WebP2/Schedule" method="post"><input type="submit" value="確認" name="schedule"><input type ="hidden" name="ID" value="<%= name.getId()%>"></input></form></li>
				<li><form action="/WebP2/Regist" method="get"><input type="submit" value="登録" name="regist"></input></form></li>
				<li><form action="/WebP2/Search" method="get"><input type="submit" value="検索" name="seach"></input></form></li>
				<li><form action="/WebP2/Logout" method="get"><input type="submit" value="ログアウト" name="logout"></input></form></li>
			</ul>
		</div>
	</div>
</header>


</body>
</html>

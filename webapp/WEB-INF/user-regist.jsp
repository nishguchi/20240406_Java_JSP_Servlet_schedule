<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- パッケージ・モデルインポート -->
<%@ page import ="model.UserModel"%>    
<!-- セッションスコープからインスタンス取得 -->
<% UserModel name = (UserModel) session.getAttribute("login_name");%>
<!-- バリデーションリクエストスコープ取得 -->
<% String error = (String) request.getAttribute("error"); %>


<% if(error==null){ %>
	<% error = "";%>
<%}%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ユーザー登録</title>
	<link rel="stylesheet" href="css/main.css">
</head>
<body>
		<header>
			<div class="container">
				<div class="header-title">
					<h2><a href="/WebP2/Login">スケジュール管理</a></h2>
				</div>
			</div>
		</header>
	
	<form action="/WebP2/UserRegist" method="post">
		<p>ユーザー名</p>
		<input type="text" name="userName">
		<p>希望ID入力</p>
		<input type="text" name="id">
		<p>希望パスワード入力</p>
		<input type="text" name="pass">
		<p>用途</p>
		<select name="department_key">
			<option value="1">管理</option>
		</select>
		
		<p>管理権限</p>
		<select name="edit">
			<option value="0">一般ユーザー</option>
			<% if(!(name == null)){ %>
				<option value="1">管理者権限</option>
				<option value="2">一部管理許可</option>
			<% } %>
		</select>
		<input type="submit" value="登録する">
	</form>
	<%= error %>
	
	<!-- インクルード  フッター  -->
	<jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
	

</body>
</html>
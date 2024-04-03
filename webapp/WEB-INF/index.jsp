<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String id = (String) request.getAttribute("id"); %>
<% String pass = (String) request.getAttribute("pass");  %>
<% String error = (String) request.getAttribute("error"); %>

<% if(id == null){ %>
	<% id ="";%>	
<%}%>
<% if(pass==null){ %>
	<% pass = "";%>
<%}%>
<% if(error==null){ %>
	<% error = "";%>
<%}%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ログイン</title>
		<link rel="stylesheet" href="css/main.css">
	</head>

<!-- エントリーポイントはLogin.java -->

	<body>
	
		<header>
			<div class="container">
				<div class="header-title">
					<h2><a href="#">スケジュール管理</a></h2>
				</div>
			</div>
		</header>
	
	
		<div class="login-form">
			<form action="/WebP2/Login" method="post" onsubmit="return Form()">
				<p>ログインID</p>
				<input type="text" name="ID" value="<%= id %>">
				<p>パスワード</p>
				<input type="password" id = "PASS" name="PASS" value ="<%= pass %>">
				<input type="submit">
			</form>
			<%= error %>
		
		</div>		
		<a href="/WebP2/UserRegist">ユーザー登録</a>


	<!-- 
	<div id="message"></div>
	    <script src="test.js"></script>
	 -->
	 
	<!-- インクルード  フッター  -->
	<jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
	 
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!-- パッケージ・インポート  -->
<%@ page import ="model.UserModel"%> 
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>

<% UserModel name = (UserModel) session.getAttribute("login_name");%>
<% Date start = new Date(); %>
<% Date end = new Date(); %>
<% SimpleDateFormat fmt = new SimpleDateFormat("yyyy年MM月dd日HH:mm"); %>
<% String error = (String) request.getAttribute("error"); %>

<!-- メッセージ表示 -->
<% if(error==null){ %>
	<% error = "";%>
<%}%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予定登録</title>
</head>
<body>

	<!-- インクルード  ヘッダー  -->
	<jsp:include page="/WEB-INF/header.jsp"></jsp:include>

	<p>ようこそ<%= name.getName() %>さん</p>
	<form action="/WebP2/Regist" method="post">
		
		<p>作業名</p>
		<input type="text" value="" name="work_name">
		<p>作業メモ</p>
		<textarea name="work_memo" rows="10" cols="80"></textarea>
		<p>予定開始時刻</p>
		<input type="text" value="<%= fmt.format(start)%>" name="start">
		<p>予定終了時刻</p>
		<input type="text" value="<%= fmt.format(end)%>" name="end">
		<input type ="hidden" name="ID" value="<%= name.getId()%>"></input>
		<input type="submit" value="登録">		
	</form>
	<%= error %>

	<!-- インクルード  フッター  -->
	<jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
	
</body>
</html>
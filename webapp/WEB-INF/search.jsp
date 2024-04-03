<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- パッケージ・モデルインポート -->
<%@ page import ="model.UserModel"%> 
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>

<!-- セッションスコープからインスタンス取得 -->
<% UserModel name = (UserModel) session.getAttribute("login_name");%>  
<% Date start = new Date(); %>
<% Date end = new Date(); %>
<% SimpleDateFormat fmt = new SimpleDateFormat("yyyy年MM月dd日HH:mm"); %>
  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予定検索ページ</title>
</head>
<body>

	<!-- インクルード  ヘッダー  -->
	<jsp:include page="/WEB-INF/header.jsp"></jsp:include>
	
	<p><%= name.getName() %>さんの予定検索</p>
	
	<form action="/WebP2/Search" method="post">
		<p>IDで検索</p>
		<input type="text" name="id">
		<p>作業名で検索</p>
		<input type="text" name ="work_name">
		<p>メモ内容で検索</p>
		<input type="text" name ="work_memo">
		<p>日付で検索</p>
		<input type="text" value="<%= fmt.format(start) %>" name ="start"> ～ <input type="text" value="<%= fmt.format(end) %>" name="end">
		<p>ユーザーIDで検索</p>
		<input type="text" name ="user_id">
		<input type="submit" value="検索">
		
	
	</form>
	
	<!-- インクルード  フッター  -->
	<jsp:include page="/WEB-INF/footer.jsp"></jsp:include>

</body>
</html>
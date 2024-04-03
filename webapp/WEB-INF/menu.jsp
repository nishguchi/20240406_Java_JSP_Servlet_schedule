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
<title>予定管理ページ</title>
</head>
<body>

<!-- インクルード  ヘッダー  -->
<jsp:include page="/WEB-INF/header.jsp"></jsp:include>

<p>ようこそ<%= name.getName() %>さん</p>
<%-- 
<form action="/WebP2/Schedule" method="post"><input type="submit" value="確認" name="schedule"><input type ="hidden" name="ID" value="<%= name.getId()%>"></input></form>
<form action="/WebP2/Regist" method="get"><input type="submit" value="登録" name="regist"></input></form>
<form action="/WebP2/Search" method="get"><input type="submit" value="検索" name="seach"></input></form>
<form action="/WebP2/Logout" method="get"><input type="submit" value="ログアウト" name="logout"></input></form>
 --%>

<% if (name.getEdit()==1){%>
<form action="/WebP2/User" method="get"><input type="submit" value="ユーザー編集" name="users"></input></form>
<a href="/WebP2/UserRegist">ユーザー登録</a>
<% }%>

<!-- インクルード  フッター  -->
<jsp:include page="/WEB-INF/footer.jsp"></jsp:include>

</body>
</html>
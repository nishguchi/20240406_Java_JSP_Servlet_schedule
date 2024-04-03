<%@page import="model.ScheduleModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- パッケージ・インポート  -->
<%@ page import ="model.UserModel"%> 

<% ScheduleModel change = (ScheduleModel) request.getAttribute("changeData");%>
<% String error = (String) request.getAttribute("error"); %>

<!-- メッセージ取得  -->
<% if(error==null){ %>
	<% error = "";%>
<%}%>

    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予定変更</title>
</head>
<body>
	<!-- インクルード  ヘッダー  -->
	<jsp:include page="/WEB-INF/header.jsp"></jsp:include>
	
	<form action="/WebP2/ScheduleChange" method="post">
		<p>作業名</p>
		<input type="text" value="<%= change.getWork_name() %>" name="work_name">
		<p>作業内容</p>
		<input type="text" value="<%= change.getWork_memo() %>" name="work_memo">
		<p>予定開始日時</p>
		<input type="text" value="<%= change.getStart() %>" name="start">
		<p>予定終了日時</p>
		<input type="text" value="<%= change.getEnd() %>" name="end">
		<input type="hidden" value="<%= change.getId() %>" name="id">
		<input type="submit">
	</form>
	<%= error %>
	
	<!-- インクルード  フッター  -->
	<jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
</body>
</html>
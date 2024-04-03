<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- パッケージ・モデルインポート -->
<%@ page import ="model.UserModel"%> 
<%@ page import ="model.ScheduleModel"%>    
<%@ page import ="java.util.List" %>


<!-- セッションスコープからインスタンス取得 -->
<% UserModel name = (UserModel) session.getAttribute("login_name");%>
<% List<ScheduleModel> mySchedule = (List<ScheduleModel>) request.getAttribute("mySc");%>

<!-- 
自分のスケジュール/確認/変更/（削除追記）
 -->



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スケジュール確認ページ</title>
</head>
<body>
	<!-- インクルード  ヘッダー  -->
	<jsp:include page="/WEB-INF/header.jsp"></jsp:include>
	<p><%= name.getName() %>さんの予定確認</p>
	
	
	<table>
		<thead>
			<tr>
				<th class="work-id">作業ID</th>
				<th class="work-name">作業名</th>
				<th class="work-memo">作業内容</th>
				<th class="start-time">開始予定時刻</th>
				<th class="end-time">終了予定時刻</th>
				<th class="change">変更</th>
				<th class ="delete">削除</th>
			</tr>
		</thead>
	
		<tbody>
			<% for(ScheduleModel sc : mySchedule) {%>	
				<% if(sc.getDelete_key()==0){ %>				
					<tr>
						<td><%= sc.getId() %></td>
						<td><%= sc.getWork_name() %></td>
						<% String memo = (String)sc.getWork_memo(); %>
						<% if (memo.length() >= 20){
							memo = memo.substring(0,20);
						} %>
						<td><%= memo %></td>
						<td><%= sc.getStart() %></td>
						<td><%= sc.getEnd() %></td>
						<td><form action="/WebP2/ScheduleChange" method="post"><input type="submit" value="変更"><input type="hidden" name="SchID" value="<%= sc.getId() %>"></form></td>
						<td><form action="/WebP2/ScheduleDelete" method="post"><input type="submit" value="削除"><input type="hidden" name="SchID" value="<%= sc.getId() %>"></form></td>
					</tr>
				<%}%>		
			<%}%>		
		</tbody>
	</table>
	
	<% if(mySchedule.isEmpty()){ %>
		<p>まだスケジュールは登録されていません</p>
	<% } %>


	<!-- インクルード  フッター  -->
	<jsp:include page="/WEB-INF/footer.jsp"></jsp:include>

</body>
</html>
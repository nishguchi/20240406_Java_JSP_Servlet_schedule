<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- パッケージ・モデルインポート -->
<%@ page import ="model.UserModel"%> 
<%@ page import ="model.ScheduleModel"%>    
<%@ page import ="java.util.List" %>
    
<!-- セッションスコープからインスタンス取得 -->
<% UserModel name = (UserModel) session.getAttribute("login_name");%>
<% List<ScheduleModel> searchSchedule = (List<ScheduleModel>) request.getAttribute("sMLData");%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果画面</title>
</head>
<body>
	<!-- インクルード  ヘッダー  -->
	<jsp:include page="/WEB-INF/header.jsp"></jsp:include>
	
	<table>
		<thead>
			<tr>
				<th>作業ID</th>
				<th>作業名</th>
				<th>作業内容</th>
				<th>開始予定時刻</th>
				<th>終了予定時刻</th>
				<th>ユーザーID</th>
			</tr>
		</thead>
		<tbody>
				<% for(ScheduleModel sSc : searchSchedule){%>
					<% if(sSc.getDelete_key()==0){ %>
						<tr>
							<td><%= sSc.getId() %></td>		
							<td><%= sSc.getWork_name() %></td>		
							<% String memo = (String)sSc.getWork_memo(); %>
							<% if (memo.length() >= 20){
								memo = memo.substring(0,20);
							} %>
							<td><%= memo %></td>		
							<td><%= sSc.getStart() %></td>		
							<td><%= sSc.getEnd() %></td>		
							<td><%= sSc.getUser_id() %></td>
						</tr>
					<% } %>
				<% } %>
		</tbody>
	</table>


	<!-- インクルード  フッター  -->
	<jsp:include page="/WEB-INF/footer.jsp"></jsp:include>

</body>
</html>
package servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ScheduleLogic;
import model.ScheduleModel;

/**
 *DAOから 
 *自分の予定を取得
 *スケジュール画面に遷移
 **/
@WebServlet("/Schedule")
public class Schedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//取得値 をエンコード
		request.setCharacterEncoding("UTF-8");
		
		ScheduleModel sM = new ScheduleModel();
		ScheduleLogic sL = new ScheduleLogic();
		List<ScheduleModel> myScList = new ArrayList<ScheduleModel>();
		
		sM.setUser_id(Integer.parseInt(request.getParameter("ID")));		
		myScList = sL.execute(sM);
		
		System.out.println(myScList);

		//スケジュール画面遷移 /WEB-INF/schedule.jsp
		request.setAttribute("mySc", myScList);
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/schedule.jsp");
		disp.forward(request, response);
		
	}
}

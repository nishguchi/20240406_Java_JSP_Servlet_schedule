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
import javax.servlet.http.HttpSession;

import model.ScheduleLogic;
import model.ScheduleModel;
import model.UserModel;

/**
 * スケジュール削除
 */
@WebServlet("/ScheduleDelete")
public class ScheduleDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * 自分のスケジュールを削除
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession sess = request.getSession();
		UserModel name = (UserModel) sess.getAttribute("login_name");
		
		int id = Integer.parseInt(request.getParameter("SchID"));
		
		ScheduleModel sM = new ScheduleModel();
		ScheduleLogic sL = new ScheduleLogic();
		List<ScheduleModel> myScList = new ArrayList<ScheduleModel>();
		
		sM.setId(id);
		sM.setUser_id(name.getId());
		myScList = sL.delete(sM);
		

		//スケジュール画面遷移
		request.setAttribute("mySc", myScList);
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/schedule.jsp");
		disp.forward(request, response);
		
	}

}

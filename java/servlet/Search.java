package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ScheduleModel;
import model.SearchLogic;

@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/search.jsp");
		disp.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//取得値 をエンコード
		request.setCharacterEncoding("UTF-8");
		
		SearchLogic sL = new SearchLogic();
		ScheduleModel sM = new ScheduleModel();
		List<ScheduleModel> sML = new ArrayList<ScheduleModel>();
		
		
		
		
		//バリデーション
		model.Validation val = new model.Validation();
		
		boolean val_start = false;
		boolean val_end = false;

		//boolean search = false;
		
		String start;
		String end;
		
		start = request.getParameter("start");
		end = request.getParameter("end");
		
		//空か
		if(val.isEmpty(start)) {
			val_start = val.CalToDate(start);
			if(val_start) {
				sM.setStart(request.getParameter("start"));
				
				System.out.println("startは空じゃないです");
				System.out.println(start);
			}else {
				RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/menu.jsp");
				disp.forward(request, response);
			}
		}else {
			//空
			sM.setStart(request.getParameter("start"));
		}
		
		//空か
		if(val.isEmpty(end)) {
			val_end = val.CalToDate(end);	
			if(val_end) {			
				sM.setEnd(request.getParameter("end"));				
			}else {
				RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/menu.jsp");
				disp.forward(request, response);
			}
		}else {
			//空
			sM.setEnd(request.getParameter("end"));
		}
		

		
		//空の場合変換
		if(!(request.getParameter("id").equals(""))) {
			if(val.isNumeric(request.getParameter("id"))) {
				sM.setId(Integer.parseInt(request.getParameter("id")));
			}else {
				RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/menu.jsp");
				disp.forward(request, response);
			}
		}
		

		
		//空の場合変換
		if(!(request.getParameter("user_id").equals(""))) {
			if(val.isNumeric(request.getParameter("user_id"))) {				
				sM.setUser_id(Integer.parseInt(request.getParameter("user_id")));
				//search = true;
			}else {
				RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/menu.jsp");
				disp.forward(request, response);
			}
		}
		
		
		if(val.length25Max(request.getParameter("work_name"))) {
			sM.setWork_name(request.getParameter("work_name"));
			//search = true;
		}else {
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/menu.jsp");
			disp.forward(request, response);
		}
		
		if(val.length600Max(request.getParameter("work_memo"))) {
			sM.setWork_memo(request.getParameter("work_memo"));

		}else {
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/menu.jsp");
			disp.forward(request, response);
		}
		


		try {

			
			sML = sL.serch(sM);
			request.setAttribute("sMLData", sML);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/search-result.jsp");
		disp.forward(request, response);
			

	}
}

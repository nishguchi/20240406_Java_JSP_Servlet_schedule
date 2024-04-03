package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.RegistLogic;
import model.RegistModel;

/**
 * Servlet implementation class Regist
 */
@WebServlet("/Regist")
public class Regist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/regist.jsp");
		disp.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//取得値 をエンコード
		request.setCharacterEncoding("UTF-8");


		String work_name = request.getParameter("work_name");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		String work_memo =  request.getParameter("work_memo");
		int user_id = Integer.parseInt(request.getParameter("ID")); 
		
		boolean regist = false;
		RegistLogic rL = new RegistLogic();

		
		//バリデーション
		model.Validation val = new model.Validation();
		
		boolean val_start = false;
		boolean val_end = false;
		
		
		val_start = val.CalToDate(start);
		val_end = val.CalToDate(end);
		

		if(val_start && val_end) {
			
			//登録処理
			RegistModel  rM = new RegistModel(
					work_name, 
					work_memo, 
					start, 
					end, 
					user_id
					);

			regist = rL.execute(
						rM.getWork_name(), 
						rM.getWork_memo(),
						rM.getStart(), 
						rM.getEnd(), 
						rM.getUser_id()
					);

			if(regist) {
				RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/menu.jsp");
				disp.forward(request, response);
			}else {
				System.out.println("post");
			}
			
		}else {
			
			request.setAttribute("error", "登録できませんでした（入力例：2024年01月01日01:01）");
			
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/regist.jsp");
			disp.forward(request, response);
		}

	}

}

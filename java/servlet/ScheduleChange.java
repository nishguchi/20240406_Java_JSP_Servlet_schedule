
package servlet;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ScheduleDao;
import model.ScheduleModel;

@WebServlet("/ScheduleChange")
public class ScheduleChange extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("post");
		
		
		//取得値 をエンコード
		request.setCharacterEncoding("UTF-8");
		

		ScheduleDao sD = new ScheduleDao();
		String check = request.getParameter("id");
		boolean update = false;
	
		ScheduleModel sM = new ScheduleModel();
		
		
		//バリデーション
		model.Validation val = new model.Validation();
		
		boolean val_start = false;
		boolean val_end = false;
		
		String start;
		String end;
		
		
		if(!(check == null)) {

			start = request.getParameter("start");
			end = request.getParameter("end");
			
			val_start = val.CalToDate(start);
			val_end = val.CalToDate(end);
			
			
			
			int id = Integer.parseInt(request.getParameter("id")); 
			
			sM.setWork_name(request.getParameter("work_name"));
			sM.setStart(request.getParameter("start"));
			sM.setEnd(request.getParameter("end"));
			sM.setWork_memo(request.getParameter("work_memo"));
			sM.setId(id);
			

			
			if(val_start && val_end) {
				
				
				
				try {
					update = sD.update(sM);
					
				} catch (ParseException e) {
					//update Daoの中でthrows ParseException 付与
					e.printStackTrace();
				}
				
				System.out.println(update);
				
					if(update) {
						
						//System.out.println("aaa" + "変更実行");
						RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/menu.jsp");
						disp.forward(request, response);
						
					}else {
						
						//System.out.println("bbb" + "変更を実行できませんでした");
						request.setAttribute("changeData", sM);
						request.setAttribute("error", "変更を実行できませんでした");
						RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/sc-change.jsp");
						disp.forward(request, response);
					}
					
			//val_start && val_end
			}else {
				
				//System.out.println("bbb" + "変更を実行できませんでした");
				
				request.setAttribute("changeData", sM);
				request.setAttribute("error", "変更を実行できませんでした\n（入力例：2024年01月01日01:01）");
				
				RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/sc-change.jsp");
				disp.forward(request, response);
			}
			
			

			
		//check is null				
		}else {
			
			//System.out.println("ccc" +"変更入力");
			int schId = Integer.parseInt(request.getParameter("SchID"));
			
			sM = sD.change(schId);
			request.setAttribute("changeData", sM);
			
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/sc-change.jsp");
			disp.forward(request, response);
			
		}

		
	}

}

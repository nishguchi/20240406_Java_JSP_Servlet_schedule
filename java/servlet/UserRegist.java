
package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserModel;
import model.UserResgistLogic;


@WebServlet("/UserRegist")
public class UserRegist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/user-regist.jsp");
		disp.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		//取得値 をエンコード
		request.setCharacterEncoding("UTF-8");
		
		UserResgistLogic uRL = new UserResgistLogic();
		UserModel uM = new UserModel();
		
		
		boolean userCheck = false;			
		boolean regist = false;
		
		model.Validation val = new model.Validation();
		
		//バリデーション
		boolean val_id = false;
		boolean val_name = false;
		boolean val_pass = false;

		String name = request.getParameter("userName");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		
		//数値か //9桁か
		if(val.isNumeric(id) && val.length9(id)) {
			val_id = true;
		}else {
			request.setAttribute("error", "idを入力してください（半角数字1文字以上）");
			
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/user-regist.jsp");
			disp.forward(request, response);
		}
		
		

		//空でないか 15文字以下か
		if(val.isEmpty(name) && val.length15(name)) {
			val_name = true;
		}else{
			
			request.setAttribute("error", "お名前入力値が正しくありません(15文字以下)");
			
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/user-regist.jsp");
			disp.forward(request, response);
		}

		
		//空でないか 25文字以下か
		if(val.isEmpty(pass) && val.length25(pass)&& val.isNumAS(pass)) {
			val_pass = true;
		}else{
			
			request.setAttribute("error", "パスワードが正しくありません(半角/英数字/記号 3文字以上、15文字以下)");
			
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/user-regist.jsp");
			disp.forward(request, response);
		}
		
		

		
		if(val_id && val_name && val_pass) {
			uM.setName(request.getParameter("userName"));
			uM.setId(Integer.parseInt(request.getParameter("id")));
			uM.setPass(request.getParameter("pass"));
			uM.setEdit(Integer.parseInt(request.getParameter("edit")));
			uM.setDepartment_key(Integer.parseInt(request.getParameter("department_key")));
			
			userCheck = uRL.find(uM);
			

			if(userCheck) {
				regist = uRL.execute(uM);
				
				if(regist) {
					System.out.println("登録しました");
					
					
					RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/index.jsp");
					disp.forward(request, response);
				}//else
				
			}else {
				System.out.println("IDが重複しています");
				
				request.setAttribute("error", "IDが重複しています");			
				RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/user-regist.jsp");
				disp.forward(request, response);
				
			}
			

			
		}else {
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/user-regist.jsp");
			disp.forward(request, response);
		}
		

	}

}

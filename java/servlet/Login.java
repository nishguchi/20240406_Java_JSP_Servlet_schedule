package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.LoginModel;
import model.UserLogic;
import model.UserModel;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/* エントリーポイント */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession sess = request.getSession();
		UserModel name = (UserModel) sess.getAttribute("login_name");

		if(name == null) {
			
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/index.jsp");
			disp.forward(request, response);
			
		}else {
			
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/menu.jsp");
			disp.forward(request, response);

			//
		}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//取得値 をエンコード
		request.setCharacterEncoding("UTF-8");

		//取得引数
		String id = request.getParameter("ID");
		String pass = request.getParameter("PASS");
		boolean login = false;
		
		
		LoginModel lM = new LoginModel();
		LoginLogic lL = new LoginLogic();

		UserModel uM = new UserModel();
		UserLogic uL = new UserLogic();
		
		HttpSession sess = request.getSession(); 
		
		//LoginModel引数セット
		lM.setId(id);
		lM.setPass(pass);
		login = lL.execute(lM.getId(),lM.getPass());
				

		//ログイン・ログイン失敗
		if (login) {
			
			//ユーザー情報を引き出す
			uL.execute(lM,uM);
			sess.setAttribute("login_name", uM);  //ログイン情報一式
			//遷移
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/menu.jsp");
			disp.forward(request, response);
			
		}else {	
			request.setAttribute("id", id);
			request.setAttribute("pass", pass);
			request.setAttribute("error", "IDまたはパスワードが正しくありません");
			
			//遷移
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/index.jsp");
			disp.forward(request, response);
			
		}

	}
}
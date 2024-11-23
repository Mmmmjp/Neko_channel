package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.LoginLogic;
import model.User;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//ログイン情報（リクエストパラメータ）を取得
		//setCharacterEncodingはフィルターを作成
		
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		//Userインスタンスの生成
		User user = new User(name,pass);
		
		//ログイン処理(戻り値はboolean)
		//戻り値の値をBoolean の変数として格納
		LoginLogic loginLogic = new LoginLogic();
		boolean isLogin = loginLogic.execute(user);
		
		//ログインの成功もしくは失敗時の処理
		
		if(isLogin ==true) {
			//Userインスタンスをセッションスコープに保存
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);	
			
			//loginResult.jsp にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/loginResult.jsp");
			dispatcher.forward(request,response);
			
		} else if (isLogin== false || user==null) {
			
			String errorMsg = "ログインに失敗しました";
			//requestScopeにエラーメッセー時を保存
			request.setAttribute("errorMsg",errorMsg);
			
			//トップ画面へ戻る（リクエストスコープを失わないようフォワード）
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}

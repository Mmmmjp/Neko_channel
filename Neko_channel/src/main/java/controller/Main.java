package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Mutter;
import model.PostMutterLogic;
import model.User;

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//つぶやきリストをアプリケーションスコープから取得
		ServletContext application = this.getServletContext();
		List<Mutter> mutterList = (List<Mutter>)application.getAttribute("mutterList");
		
		//取得出来なかった時（まだつぶやきがない時
		//つぶやきリストを新規作成しアプリケーションスコープに保存
		
		if(mutterList==null) {
			mutterList = new ArrayList<>();
			
			application.setAttribute("mutterList", mutterList);
		}
		
		//main.jspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/main.jsp");
		dispatcher.forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//つぶやき情報を取得
		String text = request.getParameter("text");
		
		//入力値チェック
		if(text !=null && text.length() != 0) {
			//アプリケーションスコープに保存されたつぶやきリストを取得
			ServletContext application = this.getServletContext();
			List<Mutter> mutterList = (List<Mutter>)application.getAttribute("mutterList");
			
			//セッションスコープに保存されたユーザ情報を取得
			HttpSession session = request.getSession();
			User loginUser = (User)session.getAttribute("loginUser");
			
			//つぶやきを作成し、リストに追加
			Mutter mutter = new Mutter(loginUser.getName(),text);
			PostMutterLogic postMutterLogic = new PostMutterLogic();
			postMutterLogic.execute(mutter, mutterList);
			
			//メイン画面にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/main.jsp");
			dispatcher.forward(request, response);
			
		} else {
			//errorMsg をリクエストスコープに保存
			request.setAttribute("errorMsg", "つぶやきを入力してにゃ");
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/main.jsp");
		    dispatcher.forward(request, response);
		    return; // 処理終了
		}
		
		
		
	}

}

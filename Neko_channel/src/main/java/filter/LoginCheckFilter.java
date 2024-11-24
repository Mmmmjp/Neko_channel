package filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;


@WebFilter("/Main") // フィルターを適用するパス
public class LoginCheckFilter extends HttpFilter {
 
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		//セッションスコープからユーザ情報を取得
		HttpSession session = request.getSession(false); // セッションが存在しない場合、nullを返す
        User loginUser = (session != null) ? (User) session.getAttribute("loginUser") : null;
		
		if (loginUser== null) {//ログインしていない場合
			 // リダイレクト処理（アプリケーションのコンテキストパスを考慮）
			response.sendRedirect(request.getContextPath() + "/index.jsp");	
			 return; // 処理終了
		}
		
		chain.doFilter(request, response);
	}
	


}

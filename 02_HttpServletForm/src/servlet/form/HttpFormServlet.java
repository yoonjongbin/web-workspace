package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HttpFormServlet
 */
public class HttpFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		// 한글처리는 양방향으로 처리해주어야 한다.
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		String resultId = request.getParameter("userId");
		String resultPw = request.getParameter("userPwd");
		
		String menuList[] = request.getParameterValues("menu");
		
		String gender = request.getParameter("gender");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<p> 아이디 : " + resultId + "</p>");
		out.println("<p> 패스워드 : " + resultPw + "</p>");
//		out.println("<p> 선택한 메뉴 : " + Arrays.toString(menu) + "</p>");
		
		
//		당신의 성별은 --> form.html 라디오사용!
		out.println("<ul>");
		
		for(String menu : menuList) {
			out.println("<li>" + menu + "</li>");
		}
		
		out.println("</ul>");
		
		out.println("<p> 성별 : " + (gender.charAt(0) =='M'? "남" : "여") + "</p>");
		out.println("</html></body>");
		out.close();
	}

}

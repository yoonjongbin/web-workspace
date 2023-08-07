package servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberVO;

//쿠키는 String으로 밖에 정보를 저장할 수 없다.
// 객체로 정보를 저장하고, 쿠키보다 보안성을 좋게 쓰고 싶으면 session을 사용하자
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 세션을 하나 받아온다.... request.getSession()
		
		
		HttpSession session = request.getSession();	// session은 클라이언트가 서버에 무언가를 요청하면 바로 만들어진다.
		
		// 2. 폼에 입력된 값을 가지고 객체 생성... MemberVO
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberVO vo =  new MemberVO(id, pw, "윤종빈", "경기도 광주");
		
		// 3. 세션에 바인딩
		
		session.setAttribute("vo", vo);
		
		// 4. 네비게이션
		
		PrintWriter out = response.getWriter();
		out.println("<a href=ProductServlet>ProductServlet...</a>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

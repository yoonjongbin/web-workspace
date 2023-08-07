package servlet.cookie;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookieTest
 */
public class SetCookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 요청이 들어왔을 때
		 * 
		 * 1. 쿠기 생성 : Cookie c = new Cookie("name", "value");
		 * 
		 * 2. 생성한 쿠키를 웹 브라우저로 보냄 : response.addCookie(c);
		 */
		
		Date now = new Date();
		String id = "kh";
		
		// 1. 쿠키 생성
		
		Cookie c1 = new Cookie("now", Long.toString(now.getTime()));
		Cookie c2 = new Cookie("id", id);
		
		// 2. 쿠키의 유효시간을 지정
		
		c1.setMaxAge(0); //쿠키 사용 X
		c1.setMaxAge(20); // 20초
		c2.setMaxAge(60*60*24); // 하루
		
		
		// 3. 쿠키를 전송
		
		response.addCookie(c1);
		response.addCookie(c2);
		
		// 4. 페이지 이동
		
		response.sendRedirect("gc");	// 내가 설정한 url 패턴으로 보내줄 것 
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

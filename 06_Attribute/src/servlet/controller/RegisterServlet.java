package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberVO;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 로직은 여기서 작성

		
		/*
		 * 1. 양방향 한글처리
		 * 2. 폼 값을 받아
		 * 3. vo객체 생성
		 * 4. 객체 바인딩... ServletContext에
		 * 5. ViewServlet(view)한테 결과(이름, 나이, 주소) 출력
		 * */
		
		
//		1. 양방향 한글처리
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
		
		
//		2. 폼 값을 받아
		
		String name, addr;
		int age;
		name = request.getParameter("name");
		age = Integer.parseInt(request.getParameter("age"));
		addr = request.getParameter("addr");

//		3. vo객체 생성
		MemberVO vo = new MemberVO(name, age, addr);
		
//		4. 객체 바인딩... ServletContext에
		context = getServletContext();
		
//		5. ViewServlet(view)한테 결과(이름, 나이, 주소) 출력
		// a링크로 ViewServlet 결과 확인하러 가기
		PrintWriter out = response.getWriter();
		context.setAttribute("vo", vo);
	
		
//		out.println("<a href='viewservlet?name=" + name + "&age=" + age + "&addr=" + addr + "'>ViewServlet</a>");
//		out.println("<a href='viewservlet'>ViewServlet</a>");
		out.println("<a href='result.jsp'>결과 확인하러 가기</a>");
		
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

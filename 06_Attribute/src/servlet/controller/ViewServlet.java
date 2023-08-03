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
 * Servlet implementation class ViewServlet
 */
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
//		String name, age, addr;
//		
//		name = request.getParameter("name");
//		age = request.getParameter("age");
//		addr = request.getParameter("addr");
		
		/*
		 * 1. Attribute에 바인딩 된 데이터를 받아와서
		 * 2. 웹 브라우저로 출력하는 로직을 생성...
		 * */
		
//		1. Attribute에 바인딩 된 데이터를 받아와서
		context = getServletContext();
		MemberVO vo = (MemberVO) context.getAttribute("vo");
		
//		2. 웹 브라우저로 출력하는 로직을 생성...
		
		
		
		out.println("<p>이름 : " + vo.getName() + "</p>");
		out.println("<p>나이 : " + vo.getAge() + "</p>");
		out.println("<p>주소 : " + vo.getAddr() + "</p>");
		
		out.close();
		
	}

}

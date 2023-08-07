package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.vo.MemberDTO;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		
		session = request.getSession();
		
		MemberDTO dto_register = new MemberDTO();
		dto_register.setId(id);
		dto_register.setPw(pw);
		dto_register.setName(name);
		dto_register.setAddr(addr);
//		System.out.println(dto_register.toString());
		session.setAttribute("dto_register", dto_register);
		
		if(session.getAttribute("dto_register") != null) {
			response.sendRedirect("/AllMemberServlet");
		}else {
			response.sendRedirect("../index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

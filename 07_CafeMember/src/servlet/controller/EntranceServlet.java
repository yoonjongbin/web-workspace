package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberVO;

/*
 * 회원 가입하면.. 정보를 바탕으로 MemberVO를 생성..ArrayList에 추가
 * ArrayList를 통째로 ServletContext에 바인딩
 * 출력 결과는 viewMember.jsp 페이지에서
 */
public class EntranceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;
	List<MemberVO> list = Collections.synchronizedList(new ArrayList<MemberVO>());

	public void init(ServletConfig config) throws ServletException {
//		context = config.getServletContext();
//		context.setAttribute("list", list);	//로그인 했을때만 등록하고 싶다면 이 방식 X
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("list", list);
		
		String name, addr;
		int age;
		
		name = request.getParameter("name");
		age = request.getParameter("age")!=null ? Integer.parseInt(request.getParameter("age")) : 0;
		addr = request.getParameter("addr");
		
		MemberVO vo = new MemberVO(name, age, addr);
		list.add(vo);
		// 내비게이션
		RequestDispatcher rdp = request.getRequestDispatcher("viewMember.jsp");
		// PrintWriter out = response.getWriter(); 대신 설정
		rdp.forward(request, response); // 이때 위에 설정한 페이지로 이동됨 result.jsp
		
		PrintWriter out = response.getWriter();
		
		out.println("<a href='viewMember.jsp'>결과보기</a>");
		out.close();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

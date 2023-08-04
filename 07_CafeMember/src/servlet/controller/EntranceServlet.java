package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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

import servlet.model.MemberDAO;
import servlet.model.MemberVO;

/*
 * 회원 가입하면.. 정보를 바탕으로 MemberVO를 생성..ArrayList에 추가
 * ArrayList를 통째로 ServletContext에 바인딩
 * 출력 결과는 viewMember.jsp 페이지에서
 */
public class EntranceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private ServletContext context;
//	List<MemberVO> list = Collections.synchronizedList(new ArrayList<MemberVO>());
//
//	public void init(ServletConfig config) throws ServletException {
//		context = config.getServletContext();
//		context.setAttribute("list", list);	//로그인 했을때만 등록하고 싶다면 이 방식 X
		
		
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setAttribute("list", list);
		
		String name, addr;
		int age;
		
		name = request.getParameter("name");
		age = request.getParameter("age")!=null ? Integer.parseInt(request.getParameter("age")) : 0;	// 나이(age)가 null 일때 기본값 0(로그인 하고 jsp 접근시 오류 제거)
		addr = request.getParameter("addr");
		
		MemberVO vo = new MemberVO(name, age, addr);
		System.out.println("2. vo 생성");
//		list.add(vo);
		
		// 3. DAO로 데이터 전송
		
		MemberDAO dao = new MemberDAO();
		try {
			dao.insertMem(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("가입 실패!! : " + e.getMessage());
		}
		
		// 4. 내비게이션 -> ViewMemberSerlvet
//		RequestDispatcher rdp = request.getRequestDispatcher("viewMember.jsp");
//		PrintWriter out = response.getWriter(); //대신 설정
//		rdp.forward(request, response); // 이때 위에 설정한 페이지로 이동됨 result.jsp
		
//		request.getRequestDispatcher("view").forward(request, response);
		response.sendRedirect("view");	// 굳이 위처럼 안가고 redirect로 응답
		
		
		PrintWriter out = response.getWriter();
		
//		out.println("<a href='viewMember.jsp'>결과보기</a>");
		out.close();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

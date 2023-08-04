package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAO;
import servlet.model.MemberVO;

public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 폼 데이터 받아오기
		String name = request.getParameter("name");
		
		// 2. DAO 리턴 받아서
		MemberDAO dao = new MemberDAO();
		MemberVO vo = null;
		
		try {
			vo = dao.findByNameMember(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// 3. 멤버 정보 1개 바인딩
		request.setAttribute("vo", vo);
		
		// 4. 네비게이션 -> view.jsp

		if(vo!=null) { // 시험에서 나오는거 참고
			request.getRequestDispatcher("view.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("fail.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

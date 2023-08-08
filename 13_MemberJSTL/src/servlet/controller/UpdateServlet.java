package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberDTO;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDTO dto1 = (MemberDTO) session.getAttribute("dto");
		
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		
		
		System.out.println(pw);
		MemberDTO dto = new MemberDTO();
		dto.setId(dto1.getId());
		dto.setPassword(pw);
		dto.setName(name);
		dto.setAddress(addr);
		
		
		session.setAttribute("dto", dto);
		
		
		try {
			 if(MemberDAO.getInstance().update(dto) == 1) {
				 System.out.println("수정성공");
				 request.getRequestDispatcher("views/update_result.jsp").forward(request, response);
			 }else {
				 System.out.println("수정실패!!");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

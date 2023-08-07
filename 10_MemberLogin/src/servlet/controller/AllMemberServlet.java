package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberDTO;

/**
 * Servlet implementation class RegisterServlet
 */
public class AllMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDAO dao = new MemberDAO();
		HttpSession session = request.getSession();
		
		MemberDTO newMem = (MemberDTO) session.getAttribute("dto_register");
		
//		System.out.println(newMem.getName());
		
//		PrintWriter out = response.getWriter();
		
//		out.println("<p>등록하시는 유저의 이름은 " + newMem.getName() + " 입니다.</p>");
		
		try {
			dao.registerMember(newMem);
			
			ArrayList<MemberDTO> memList = dao.showAllMember();
			
			session.setAttribute("memList", memList);
			
			ArrayList<MemberDTO> list = (ArrayList) session.getAttribute("memList");
			
			for(MemberDTO mem : list) {
				System.out.println(mem.getId() + "/" + mem.getPw() + "/" + mem.getName() + "/" + mem.getAddr() + "/");
			}
			
			
			request.getRequestDispatcher("/views/allShow.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

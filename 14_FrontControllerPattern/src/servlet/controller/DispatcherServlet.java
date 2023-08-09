package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberDTO;
import servlet.model.vo.MemberVO;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet(urlPatterns = "/front.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DispatcherServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 요청이 어디에서 들어오는 요청인지.. command 값 받는다.

		String command = request.getParameter("command");
		String path = "index.jsp";

		try {
			if (command.equals("register")) {
				path = register(request, response);
			} else if(command.equals("login")) {
				path = login(request, response);
			}else if(command.equals("search")) {
				path = search(request, response);
			}else if(command.equals("allMember")) {
				path = allMember(request, response);
			}else if(command.equals("logout")) {
				path = logout(request, response);
			}else if(command.equals("update")) {
				path = update(request, response);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		

		// 네비게이션

		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected String register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		// 1. 폼값 가져온다.
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");

		// 2. 객체 생성 - 폼 값 담기
		MemberVO vo = new MemberVO(id, password, name, address);

		// 3. DAO와 연결
//					MemberDAO dao = new MemberDAO();
		MemberDAO.getInstance().registerMember(vo);

		// 4. 데이터 바인딩 - session 생략
//			HttpSession session = request.getSession();
//			session.setAttribute("vo", vo);


		return "index.jsp";
	}
	
	protected String login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		// 1. 폼값 가져온다.
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		// 2. 객체 생성 - 폼 값 담기
		MemberVO vo = MemberDAO.getInstance().login(id, password);


		// 4. 데이터 바인딩 - session 생략
			HttpSession session = request.getSession();
			session.setAttribute("vo", vo);


		return "views/login_result.jsp";
	}
	
	protected String search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		// 1. 폼값 가져온다.
		String id = request.getParameter("id");

		// 2. 객체 생성 - 폼 값 담기
		MemberVO vo = MemberDAO.getInstance().findByIdMember(id);
		
		
		request.setAttribute("vo", vo);

		if(vo!=null) {
			return "views/find_ok.jsp";
		}


		return "views/find_fail.jsp";
	}
	
	protected String allMember(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		ArrayList<MemberVO> list = MemberDAO.getInstance().showAllMember();
		request.setAttribute("list", list);
		
		return "views/allShow.jsp";
	}
	
	protected String logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("vo")!=null) {
			session.invalidate();
			return "index.jsp";
		}
		
		return "index.jsp";
	}
	
	protected String update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		int result;
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		
		MemberVO vo = new MemberVO(id, pw, name ,addr);
		result = MemberDAO.getInstance().update(vo);
		
		System.out.println(result);
		
		if(result==1) {
			
			session.setAttribute("vo", vo);
			MemberVO vo2 = (MemberVO) session.getAttribute("vo");
			System.out.println(vo2.getName());
			return "views/update_result.jsp";
		}
		
		return "views/update_result.jsp";
	}
}

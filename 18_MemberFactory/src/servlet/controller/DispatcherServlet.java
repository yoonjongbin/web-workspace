package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DispatcherServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// hidden 값으로 들어온 요청을 받지 않고, 들어온 요청의 주소를 직접 인식한다.
		String requestURI = request.getRequestURI();
		System.out.println("RequestURI :: " + requestURI);	// RequestURI :: /find.do

		
		String [] requestURIList = requestURI.split("/");	
		System.out.println("requestURIList :: " + Arrays.toString(requestURIList)); // requestURIList ::[, find.do]
		String command = requestURIList[requestURIList.length-1];
		System.out.println("Command :: " + command);	// Command :: find.do
		
		Controller controller = HandlerMapping.getInstance().createController(command);
		
		try {
			ModelAndView mv = controller.handle(request, response);
			
			System.out.println(mv.getPath());
			
			if(mv!=null) {
				if(mv.isInRedirect()) {
					response.sendRedirect(mv.getPath());
				}else {
					request.getRequestDispatcher(mv.getPath()).forward(request, response);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	
	// 14_FrontControllerPattern
	
//	protected String register(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException, SQLException {
//		// 1. 폼값 가져온다.
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");
//		String name = request.getParameter("name");
//		String address = request.getParameter("address");
//
//		// 2. 객체 생성 - 폼 값 담기
//		MemberVO vo = new MemberVO(id, password, name, address);
//
//		// 3. DAO와 연결
////					MemberDAO dao = new MemberDAO();
//		MemberDAO.getInstance().registerMember(vo);
//
//		// 4. 데이터 바인딩 - session 생략
////			HttpSession session = request.getSession();
////			session.setAttribute("vo", vo);
//
//
//		return "index.jsp";
//	}
//	
//	protected String login(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException, SQLException {
//		// 1. 폼값 가져온다.
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");
//
//		// 2. 객체 생성 - 폼 값 담기
//		MemberVO vo = MemberDAO.getInstance().login(id, password);
//
//
//		// 4. 데이터 바인딩 - session 생략
//			HttpSession session = request.getSession();
//			session.setAttribute("vo", vo);
//
//
//		return "views/login_result.jsp";
//	}
//	
//	protected String search(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException, SQLException {
//		// 1. 폼값 가져온다.
//		String id = request.getParameter("id");
//
//		// 2. 객체 생성 - 폼 값 담기
//		MemberVO vo = MemberDAO.getInstance().findByIdMember(id);
//		
//		
//		request.setAttribute("vo", vo);
//
//		if(vo!=null) {
//			return "views/find_ok.jsp";
//		}
//
//
//		return "views/find_fail.jsp";
//	}
//	
//	protected String allMember(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException, SQLException {
//		ArrayList<MemberVO> list = MemberDAO.getInstance().showAllMember();
//		request.setAttribute("list", list);
//		
//		return "views/allShow.jsp";
//	}
//	
//	protected String logout(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException, SQLException {
//		HttpSession session = request.getSession();
//		
//		if(session.getAttribute("vo")!=null) {
//			session.invalidate();
//			return "index.jsp";
//		}
//		
//		return "index.jsp";
//	}
//	
//	protected String update(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException, SQLException {
//		int result;
//		HttpSession session = request.getSession();
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		String name = request.getParameter("name");
//		String addr = request.getParameter("addr");
//		
//		MemberVO vo = new MemberVO(id, pw, name ,addr);
//		result = MemberDAO.getInstance().update(vo);
//		
//		System.out.println(result);
//		
//		if(result==1) {
//			
//			session.setAttribute("vo", vo);
//			MemberVO vo2 = (MemberVO) session.getAttribute("vo");
//			System.out.println(vo2.getName());
//			return "views/update_result.jsp";
//		}
//		
//		return "views/update_result.jsp";
//	}
}

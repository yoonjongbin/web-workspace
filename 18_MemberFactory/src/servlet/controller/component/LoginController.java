package servlet.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.controller.Controller;
import servlet.controller.ModelAndView;
import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;

public class LoginController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		
		String path = "views/login_result.jsp";
		
		MemberVO vo = MemberDAO.getInstance().login(id, pw);
		System.out.println(vo.getId());
		
//		request.setAttribute("vo", vo);
		
		
		
		HttpSession session = request.getSession();
		
		
		if(vo!=null) {
		session.setAttribute("vo", vo);
		}
//		return new ModelAndView(path);	// 내가한거
		return new ModelAndView(path);
	}

}

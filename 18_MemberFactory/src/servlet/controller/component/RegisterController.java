package servlet.controller.component;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.controller.Controller;
import servlet.controller.ModelAndView;
import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;

public class RegisterController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String path = "views/allShow.jsp";
//		String path = "/";
		
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		String name = request.getParameter("name");
		String addr = request.getParameter("address");
		
		MemberVO vo = new MemberVO(id, pw, name, addr);
		
		MemberDAO.getInstance().registerMember(vo);
		
//		ArrayList<MemberVO> list = MemberDAO.getInstance().showAllMember();
		
//		request.setAttribute("list", list);
		
		
//		return new ModelAndView(path);	// 내가한거
		return new ModelAndView("index.jsp", true);
	}

}

package member.controller.component;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.Controller;
import member.controller.ModelAndView;
import member.model.service.MemberService;
import member.model.vo.MemberVO;

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
		
		new MemberService().registerMember(vo);
		
//		ArrayList<MemberVO> list = MemberDAO.getInstance().showAllMember();
		
//		request.setAttribute("list", list);
		
		
//		return new ModelAndView(path);	// 내가한거
		return new ModelAndView("index.jsp", true);
	}

}

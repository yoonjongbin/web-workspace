package member.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.controller.Controller;
import member.controller.ModelAndView;
import member.model.service.MemberService;
import member.model.vo.MemberVO;

public class UpdateController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String id = request.getParameter("id");
		String password = request.getParameter("pw");
		String name = request.getParameter("name");
		String address = request.getParameter("addr");

		MemberVO vo = new MemberVO(id, password, name, address);
				
		new MemberService().updateMember(vo);
		
		HttpSession session = request.getSession();
//		session.setAttribute("vo", vo);	// 내가 한거
		if(session.getAttribute("vo")!=null) {
			session.setAttribute("vo", vo);
		}
		
		
		String path = "views/update_result.jsp";
		
		return new ModelAndView(path);
	}

}

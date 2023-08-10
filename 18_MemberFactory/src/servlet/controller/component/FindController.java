package servlet.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.controller.Controller;
import servlet.controller.ModelAndView;
import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;

public class FindController implements Controller {

	public FindController() {}

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String path = "views/find_fail.jsp";
		
		MemberVO vo = MemberDAO.getInstance().findByIdMember(id);
		
//		System.out.println(vo.getId());
		
		if(vo!=null) {
			request.setAttribute("vo", vo);
			path = "views/find_ok.jsp";
		}
//		System.out.println(path);
		
		return new ModelAndView(path);
	}
	
	
	
}

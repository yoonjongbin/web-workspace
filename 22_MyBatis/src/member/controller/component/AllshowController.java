package member.controller.component;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.Controller;
import member.controller.ModelAndView;
import member.model.service.MemberService;
import member.model.vo.MemberVO;

public class AllshowController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		List<MemberVO> list = new MemberService().showAllMember();
		

		String path = "views/allShow.jsp";
		request.setAttribute("list", list);
//		String path = "index.jsp";
//		if(list!=null) {
//			request.setAttribute("list", list);
//			path = "views/allShow.jsp";
//		}	// 내가 한거
		
		return new ModelAndView(path);
	}

	
	
}

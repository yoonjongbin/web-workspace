package member.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.controller.Controller;
import member.controller.ModelAndView;

public class LogoutController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		String path = "views/login_result.jsp";
		
		if(session.getAttribute("vo")!=null) {
			session.invalidate();
//			path= "/";
			return new ModelAndView("views/logout.jsp");
		}			
		
		return new ModelAndView(path);
	}

}

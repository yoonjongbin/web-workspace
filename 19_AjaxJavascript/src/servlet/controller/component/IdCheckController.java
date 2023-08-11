package servlet.controller.component;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.controller.Controller;
import servlet.controller.ModelAndView;
import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;

public class IdCheckController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PrintWriter out = response.getWriter();
		
		
		String id = request.getParameter("id");
		
		System.out.println(id);
		
		MemberVO vo = MemberDAO.getInstance().findByIdMember(id);
		
		if(vo!=null) {
			out.print(vo.getId() + "는 중복된 아이디입니다.");
		} else {
			out.print("사용가능!!");
		}
		
		System.out.println(vo.getId());
		
		return null;
	}

}

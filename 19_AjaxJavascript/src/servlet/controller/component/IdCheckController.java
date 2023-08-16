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
		
		
		
//		System.out.println(vo.getId());
		
		// 비동기식	(주석인 내가 한 방법)
		
		boolean flag = false;
		
		if(vo!=null) {
//			out.print(vo.getId() + "는 중복된 아이디입니다.");
			flag = true;
		} //else {
//			out.print("사용가능!!");
//		}
		
		out.print(flag);
		
		return null;
	}

}

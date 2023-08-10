package servlet.controller.component;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.controller.Controller;
import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;

public class FindUser implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		
		String path = "find_fail.jsp";
		
		String id = request.getParameter("id");
		MemberVO vo= MemberDAO.getInstance().findByIdMember(id);
		
		request.setAttribute("vo", vo);
		
		
		if(vo != null) {
			if(id.equals(vo.getId())) {
				path = "find_ok.jsp";
			}
		}
		
		return path;
	}

}

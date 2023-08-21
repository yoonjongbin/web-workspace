package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.service.StudentService;
import model.vo.DepartmentVO;
import model.vo.StudentVO;

public class allPrintController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String value = request.getParameter("value");
		
		System.out.println(value);
		
		List<DepartmentVO> list = new StudentService().allPrint();
//		list.get(0).getStudentName();
		return new ModelAndView("index.jsp");
	}

}

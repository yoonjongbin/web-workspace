package controller.component;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import model.service.StudentService;
import model.vo.StudentVO;

public class FindController implements Controller {


	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "index.jsp";
		
		String word = request.getParameter("word");
		System.out.println("controller : "+word);
		List<StudentVO> list = new StudentService().showAllStudent(word);
		
		//list.get(1).getStudentName();
		
		request.setAttribute("list", list);
		
		
		
		return new ModelAndView(path);
	}

}

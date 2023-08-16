package controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println(uri);
		String[] arr = uri.split("/");
	
		String command = arr[arr.length-1];
		System.out.println(command);
		Controller controller = HandlerMapping.getInstance().createController(command);
		try {
			ModelAndView mv = controller.handle(request, response);
			
			if(mv!=null) {
				if(mv.isInRedirect()) {
					response.sendRedirect(mv.getPath());
				}else {
					request.getRequestDispatcher(mv.getPath()).forward(request, response);
				}
			} 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package cal.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletCalculator
 */
public class ServletCalculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletCalculator() {
        
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html; charset=utf-8");
		
//		int num1 = Integer.parseInt(request.getParameter("num1"));
//		int num2 = Integer.parseInt(request.getParameter("num2"));
//		
//		int result = num1+num2;
		
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		
		String result = num1+num2;
		
		
		
		PrintWriter out = response.getWriter();
		
		out.println("<p>덧셈결과 : " + result  + "</p>");
	}

}

package servlet.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConfigServlet2
 */
public class ConfigServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String path;
	public int count = 0;
       

    public ConfigServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// 1. ServletConfig의 기능을 사용해서 path에 연결된 값을 받아온다.
		// 2. BufferedReader, FileReader를 사용해서 파일을 읽어들인다.
		// 3. count값으로 필드 초기화
//		name = config.getInitParameterNames("userName");
		try {
			path = config.getInitParameter("path");
			BufferedReader br = new BufferedReader(new FileReader(path));
			String str = br.readLine();
			count = Integer.parseInt(str);
		} catch (IOException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		}
	}


	public void destroy() {
		// 4. PrintWriter, FileWriter를 사용해서 count값 저장
		
		File file = new File(path);
		
		file.getParentFile().mkdirs();
		
		
		try {
			PrintWriter save = new PrintWriter(file);
			
			save.println(count);
			save.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("저장실패");
		}
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 5. 폼에 입력된 값을 받아서 "~~~ 아무개 님은 ~ 몇번쨰 입장하신 고객입니다.." 를 브라우저로 출력
		// (이때 출력은 config2.jsp에서)
		
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String name = request.getParameter("userName");
		PrintWriter out = response.getWriter();
		
		System.out.println(name);
		
		out.println("<h3>입력받는 곳</h3>");
		out.println("<a href=config2.jsp?name=" + name + "&count=" + ++count + ">번호표 뽑기</a>");
		
		out.println();
	}

}

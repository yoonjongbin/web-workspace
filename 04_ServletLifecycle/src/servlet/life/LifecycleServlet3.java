package servlet.life;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * - 서버가 stop 되는 순간 destroy() callback 함수가 자동으로 호출되어, count 값이 
 * 	 영구적으로 보관되지 않는다.
 * 
 * - 보관하려면 DB or 파일로 서버가 내려가도 서비스를 수행한 후 필드에 저장시킨 값을 저장해야 한다.
 * 
 * 이때, Servlet LifeCycle Method가 중요하게 사용된다.
 * 
 * 	1) 해당 필드 값을 파일로 출력 (destroy() 함수)
 * 	2) 파일에 저장된 값을 불러(읽어들임)와야 한다. (init() 함수)
 * */

public class LifecycleServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	public int count = 0;
	private String path = "d:\\test\\count.txt";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifecycleServlet3() {
       
        System.out.println("1. LifecycleServlet3 생성자...");
        
    }


	public void init(ServletConfig config) throws ServletException {
		System.out.println("2. init... 호출...");
		
		
		// 서버가 다시 시작될 때, init에서 파일에 저장된 내용을 읽어서 count에 다시 할당
		
		try {
			BufferedReader br =new BufferedReader(new FileReader(path));
			String str = br.readLine();
			
			count = Integer.parseInt(str);
			br.close();
			
			System.out.println("count.txt 파일의 내용을 읽어들임.... count :: " + count);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("파일을 읽어들이는데 실패..");
		}
		
	}

	public void destroy() {
		System.out.println("4. destroy... 호출..");
		
		
		// 필드에 저장된 값을 파일로 저장하고 서버가 내려질 것
		
		File file = new File(path);
		
		
		// 출력용 파일을 출력스트림에서 자동적으로 생성되려면
		// 그전에 반드시 디렉토리가 만들어져 있어야 한다.
		
		file.getParentFile().mkdirs(); // 하나든 여러개든 디렉토리를 만들어줌
		
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(file));
			pw.println(count);
			pw.close();
			
			System.out.println(path + "count 값 :: " + count + "파일에 영구적으로 저장");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("스트림 생성 실패");
		}
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("3. service... 호출....");
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		
		PrintWriter out = response.getWriter();
		
		out.println("<h2>LifeCycle3 CallBack Method...</h2>");
		out.println("<p>Count :: " + ++count + "</p>");
		
		out.close();
	}

}

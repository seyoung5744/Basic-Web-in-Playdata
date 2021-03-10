package uploadTest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class Upload
 */
@WebServlet("/Upload")
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Upload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("euc-kr");
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=EUC-KR");
		
		int maxSize = 10*1024*1024; // 전송파일의 최대 크기
		
		// 하지만 서버 컴퓨터의 C는 웹으로는 접근을 못함.
		// web_workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\webapps 에 img 폴더 생성
		/*
		    create table img_board(
			num int auto_increment primary key,
			writer varchar(20) not null,
			title varchar(50) not null,
			content varchar(100),
			path varchar(50)
			);
		 */
		String savePath = "C:\\img\\"; 
		
		
		String format = "euc-kr";
		String uploadFile="";
		String type = "";
		
		try {
			// 파일 업로드 객체
			MultipartRequest multi = new MultipartRequest(request, savePath, maxSize, format, new DefaultFileRenamePolicy()); // DefaultFileRenamePolicy: 똑같은 파일이 업로드되면 뒤에 숫자 붙인다든지 하는 정책 클래스
			String title = multi.getParameter("title");
			
			System.out.println("title :" + title);
			
			multi.getFile("file"); // 파일 업로드. 업로드된 파일을 자동으로 서버의 C:\\img\\에 올려줌.
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		response.getWriter().print("<html><body><h3>upload success</h3></body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

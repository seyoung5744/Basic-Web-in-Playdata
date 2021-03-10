package imgController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import imgBoard.ImgBoard;
import imgBoard.Service;
import imgBoard.ServiceImpl;

/**
 * Servlet implementation class Write
 */
@WebServlet("/img/Write")
public class Write extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Write() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher ds = request.getRequestDispatcher("/imgboard/writeForm.jsp");
		ds.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("euc-kr");
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=EUC-KR");
		
		int maxSize = 10*1024*1024; // 전송파일의 최대 크기
		String savePath = "C:\\Users\\wonseyoung\\Desktop\\web_workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\img\\"; 	
		String format = "euc-kr";
		String path = "/img/";
		String writer = "";
		String title = "";
		String content = "";
		
		try {
			// 파일 업로드 객체
			MultipartRequest multi = new MultipartRequest(request, savePath, maxSize, format, new DefaultFileRenamePolicy()); // DefaultFileRenamePolicy: 똑같은 파일이 업로드되면 뒤에 숫자 붙인다든지 하는 정책 클래스
			writer = multi.getParameter("writer");
			title = multi.getParameter("title");
			content = multi.getParameter("content");
			
			File f = multi.getFile("file");// file에 대한 정보 갖는 객체
			String name = f.getName();
			path += name;
			System.out.println(writer + "," + title + "," + content + "," + path);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		ImgBoard ib = new ImgBoard(0, writer, title, content, path);
		Service service = new ServiceImpl();
		service.writeImgboard(ib);
		
		response.sendRedirect(request.getContextPath()+"/img/List");
	}

}

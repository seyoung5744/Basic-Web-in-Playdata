package memController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mem.Member;
import mem.Service;
import mem.ServiceImpl;

/**
 * Servlet implementation class IdCheck
 */
@WebServlet("/member/IdCheck")
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IdCheck() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean flag = false;
		Service service = new ServiceImpl();
		String id = request.getParameter("id");
		Member m = service.getMember(id);
		if (m == null) {
			flag = true;
			request.setAttribute("id", id);
		}
		
		request.setAttribute("flag", flag);//request 객체에 정보 저장. 
		
		RequestDispatcher ds = request.getRequestDispatcher("/member/idcheck.jsp");
		ds.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

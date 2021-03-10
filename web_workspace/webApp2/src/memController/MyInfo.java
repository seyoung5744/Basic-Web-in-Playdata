package memController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mem.Member;
import mem.Service;
import mem.ServiceImpl;

/**
 * Servlet implementation class MyInfo
 */
@WebServlet("/member/MyInfo")
public class MyInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Service service = new ServiceImpl();
		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("id");
		Member m = service.getMember(id);
		request.setAttribute("m", m);
		RequestDispatcher ds = request.getRequestDispatcher("/member/myinfo.jsp");
		ds.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		Service service = new ServiceImpl();
		service.editMember(new Member(id, pwd, "", ""));
		RequestDispatcher ds = request.getRequestDispatcher("/member/success.jsp");
		ds.forward(request, response);
	}

}

package com.example.demo.mem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("/member/login") // @RequestMapping 중에서 get방식 맵핑과 동일
	public void login_get() {
		// 아무 동작 안하도록 구현 완료됨.
		// 링크로 이동 or 웹 브라우저에 url 직접 치는 것이 get 방식
	}
	
	@PostMapping("/member/login")
	public String login_post(String id, String pwd, HttpServletRequest request) { // Servlet 클래스는 HttpServletRequest, session...과 같은 기능들을 갖고 있지만 지금 해당 controller클래스는 일반 클래스이므로 선언이 필요
		String result = "member/"; // 로그인 성공 여부에 따라 이동할 페이지가 달라진다.
		boolean flag = service.login(id, pwd);
		if(flag) {
			HttpSession session = request.getSession(); // 세션 획득
			session.setAttribute("id", id);
			result += "success";
		}else {
			result += "login";
		}
		return result;
	}
	
	@GetMapping("/member/join")
	public void join_get() {
		
	}
	
	@PostMapping("/member/join")
	public String join_post(Member m) {	
		service.addMember(m);
		
		return "redirect:member/login"; // 기존의 forward 방식으로 view 페이지 이동을 하면 새로고침 할때마다 회원가입이 반복.
		// 즉, 쓰기 작업과 같은 것을 새로고침하더라고 이전 작업을 반복하지 않으려고 함.
		// 클라이언트한테 새로 요청을 시킴.
	}
	
	@GetMapping("/member/edit") // 폼을 전달해주는 코드. 폼을 보여주는
	public void edit(Model model, HttpServletRequest req) {
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("id");
		Member m = service.getMember(id);
		model.addAttribute("m",m);
	}
	
	@PostMapping("/member/edit") // 폼에 작성한 작업을 완료. DB에서 수정 완료
	public String edit(Member m) {
		service.editMember(m);
		return "redirect:/member/success";
	}
	
	// 요청이 오면 요청 url 과 실행할 함수를 매핑
	// 굳이 get, post 방식이 아니면 이런식으로 
	@RequestMapping("/member/success")
	public void success() {
		
	}
	
	@RequestMapping("/member/logout")
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		session.invalidate();
		return "redirect:/member/login";
	}
	
	@RequestMapping("/member/out")
	public String out(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		String id = (String) session.getAttribute("id");
		service.delMember(id);
		session.invalidate();
		return "redirect:/member/login";
	}
	

	// 일반 requestMapping 함수의 반환값은 뷰 페이지 경로
	@RequestMapping("/member/idcheck")
	@ResponseBody // 응답을 직접 만들어서 반환
	public String idcheck_post(String id) {
		String res = "사용불가능";
		Member m = service.getMember(id);
		if(m==null) {
			res = "사용가능";
		}
		return res;
	}
}

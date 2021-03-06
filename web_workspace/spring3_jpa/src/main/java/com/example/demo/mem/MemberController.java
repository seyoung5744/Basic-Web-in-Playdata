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

	@GetMapping("/member/login")
	public void login_get() {

	}

	@PostMapping("/member/login")
	public String login_post(String id, String pwd, HttpServletRequest req) {
		String result = "member/";
		boolean flag = service.login(id, pwd);
		if (flag) {
			HttpSession session = req.getSession();
			session.setAttribute("id", id);
			result += "success";
		} else {
			result += "login";
		}
		return result;
	}

	@GetMapping("/member/join")
	public void join_get() {

	}

	@PostMapping("/member/join")
	public String join(Member2 m) {
		service.addMember(m);
		return "redirect:/member/login";
	}

	@GetMapping("/member/edit")
	public void edit(Model model, HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		String id = (String) session.getAttribute("id");
		Member2 m = service.getMember(id);
		model.addAttribute("m", m);
	}

	@PostMapping("/member/edit")
	public String edit_post(Member2 m) {
		service.editMember(m);
		return "redirect:/member/success";
	}

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

	// ?????? requestMapping ????????? ???????????? ??? ????????? ??????
	@RequestMapping("/member/idCheck")
	@ResponseBody // ????????? ?????? ???????????? ??????
	public String idCheck(String id) {
		String res = "???????????????";
		Member2 m = service.getMember(id);
		
		if (m == null) {
			res = "????????????";
		}
		return res;
	}
	
	@RequestMapping("/board/getByWriter")
	public String getByWriter(String writer, Model mm) {
		Member2 m = service.getMember(writer);
		
		if(m != null) {
			mm.addAttribute("list", m.getList());
		}		
		return "board/list";
	}
}

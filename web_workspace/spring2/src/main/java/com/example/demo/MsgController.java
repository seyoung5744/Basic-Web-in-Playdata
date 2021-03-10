package com.example.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MsgController {
	
	@Autowired
	private MsgService service;
	
	@RequestMapping("/msg/list")
	public void list(Model m) { // Model 객체는 뷰 페이지에 자동으로 전달됨
		ArrayList<MsgVo> list = service.getAll();
		m.addAttribute("list",list);
		
	}
	
	@GetMapping("/msg/write")//글작성 폼
	public void writeForm() {
		//return "board/write";
	}
	
	@PostMapping("/msg/write")//글작성 완료
	public String write(@ModelAttribute("mv") MsgVo mv) {//커맨드 객체는 자동으로 뷰 페이지에 전달됨
		//db에 담고 redirect로 /list
		service.addMsg(mv);
		return "redirect:/msg/list";	//redirect로 페이지 이동. 클라이언트가 이 url을 요청
	}
	
	@RequestMapping("/msg/edit")
	public String edit(MsgVo mv) {
		service.editMsg(mv);
		return "redirect:/msg/list";
	}
	
	@RequestMapping("/msg/del")
	public String del(int num) {
		service.delMsg(num);;
		return "redirect:/msg/list";
	}
}

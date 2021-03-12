package com.example.demo.board;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	@Autowired
	private BoardService service;
	
	@RequestMapping("/board/list")
	public void list(Model m) {		
		ArrayList<Board2> list = service.getAll();
		m.addAttribute("list", list);		
	}
	
	@GetMapping("/board/write")
	public void writeForm() {}
	
	@PostMapping("/board/write")
	public String write(Board2 b) {
		service.writeBoard(b);
		return "redirect:/board/list";
	}
	
	@PostMapping("/board/edit")
	public String edit(Board2 b) {
		b.setW_date(new Date());
		service.editBoard(b);
		return "redirect:/board/list";
	}
	
	@RequestMapping("/board/del")
	public String del(int num) {		
		service.delBoard(num);
		return "redirect:/board/list";	
	}
	
	@RequestMapping("/board/getByTitle")
	public ModelAndView getByTitle(String title) {		
		ModelAndView mav = new ModelAndView("board/list");
		ArrayList<Board2> list = service.getByTitle("%"+title+"%");
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping("/board/read")
	public void read(Model m, int num) {
		Board2 b = service.getBoard(num);
		m.addAttribute("b", b);
	}
}







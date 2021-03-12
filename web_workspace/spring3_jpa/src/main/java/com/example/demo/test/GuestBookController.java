package com.example.demo.test;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GuestBookController {
	@Autowired
	private GuestBookService service;
	
	@RequestMapping("/guestbook/list")
	public void list(Model m) {
		ArrayList<GuestBook> list = service.getAll();
		m.addAttribute("list", list);
	}
	
	@GetMapping("/guestbook/write")
	public void writeForm() {}
	
	@PostMapping("/guestbook/write")
	public String write(GuestBook gb) {
		service.write(gb);
		return "redirect:/guestbook/list";
	}
}

package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

// URL 요청 종류별 실행할 코드 등록
@Controller
public class MyController {
	
	// home이라는 함수는 url 요청이 /로 요쳥이 오면 실행됨.
	@RequestMapping(value="/") // url만 지정. method 상관없음
	public String home() {
		return "index"; // view 페이지 경로
	}
	
	@RequestMapping(value="/hello", method=RequestMethod.GET) // url과 method 지정
	public void hello_get() { // @RequestMapping 메서드의 반환값이 void일 경우, url과 동일한 경로의 뷰 페이지 실행

	}
	
//	@RequestMapping(value="/hello", method=RequestMethod.POST) 
//	public ModelAndView hello_post(@RequestParam("id") String id, @RequestParam("name") String name) { // 요즘은 @RequestParam 없어도 이름이 같으면 알아서 값을 받아옴
//		ModelAndView mav = new ModelAndView("hello_result"); // 뷰페이지 경로와 뷰페이지에 전달할 데이터 담는 객체
//		mav.addObject("id",id); // 뷰 페이지에 전달할 데이터 저장
//		mav.addObject("name",name);
//		return mav;
//	}
	
	@RequestMapping(value="/hello", method=RequestMethod.POST)
	// 커멘드 객체. 
	// 일단 default 생성자로 객체 생성. 그리고 jsp의 form 양식에 있는 똑같은 set을 호출하여 맴버 변수에 값을 넣어줌.
	// 그러고 ModelAndView에 담을 필요가 없이 자동으로 뷰 페이지에 전달됨
	// (소문자 클래스명 : vo) return한 view 페이지에서 정보를 담은 객체의 소문자 클래스명을 사용해서 값을 사용
	public String hello_post(@ModelAttribute("v") Vo v) {  
		
		return "command";
	}
	
	@RequestMapping("/test1")
	public void test1(Model m) {
		m.addAttribute("val1", "aaa");
		m.addAttribute("val2", "BBB");
	}
}

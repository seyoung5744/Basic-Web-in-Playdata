package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController { // 컨트롤러의 주 역할 : 외부에 노출할 url을 정의하고 이 url로 요청이 왔을때 실행할 코드 정의
	
	// @RequestMapping : url과 함수 등록. 전송 방식 따지지 않음(get, post로 변경 가능).
	// index url로 요청이 오면 밑의 함수로 처리해라~
	@RequestMapping("/index"/*or value="/index"*/)
	public void index() {
		// return "/WEB-INF/views/index.jsp"; // 뷰 페이지 경로 반환
		// "/WEB-INF/views/" 파일명 ".jsp" 가 공통
		// return "index"만 사용할 수 있도록...즉, 더 편하도록 application.properties에 prefix, suffix 등록
		// return "index";
		// void : 뷰 페이지 경로 반환 안하면. url과 동일한 경로의 뷰 페이지 생성 
	}
	
//	@RequestMapping("/board/writeForm")
//	public String writeForm() {
//		return "board/write";
//	}
	
//	@RequestMapping("/board/write")
	// form에 작성됨 값이 동일한 이름의 클래스 set함수에 자동 저장됨. ex) write.jsp의 email에 값을 넣으면 자동으로 MsgVo의 setEmail이 호출되어 저장됨.
	// 이때 form 쪽에서 누락된 데이터가 있을 수도 있으니 오류 발생을 방지하기 위해 default 생성자를 정의해둠.
	// 그래서 아래와 같이 파라미터에 객체를 만들면 default 생성자가 우선 생성.
//	public String write(@ModelAttribute("mv") MsgVo msgVo) { // 커멘드 객체는 자동으로 뷰 페이지에 전달됨
//		return "index";
//	}
	
	/*
	 	컨트롤러에서 get/post를 구분하는 이유는 join 작업 중에서 폼을 원하는지, 입력 내용 저장을 원하는지 구분하는 용도
	 	
	 	작업이 2단계로 나뉨. 폼을 보여줌. 입력내용을 서버로 보내서 저장
	 	회원가입 1. /join - 폼을 보여주는 것은(get), 입력 내용 저장(post) - 같은 url을 쓸 경우에
	 	       2. 다른 url을 쓸 경우 구분할 필요 없이 작성 가능 
	 	로그인
	 	글쓰기
	 	
	 	글목록 - 불러오기만 하면 되기 때문에 get,post없이 하나로 작성
	 */
	@GetMapping("/board/write")//글작성 폼
	public void writeForm() {
		//return "board/write";
	}
	
	@PostMapping("/board/write")//글작성 완료
	public String write(@ModelAttribute("mv") MsgVo mv) {//커맨드 객체는 자동으로 뷰 페이지에 전달됨
		//db에 담고 redirect로 /list
		return "index";	//redirect로 페이지 이동. 클라이언트가 이 url을 요청
	}

}

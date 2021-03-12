package com.example.demo.upload;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
	private String path = "C:\\img\\";
	
	@GetMapping("/upload/upload")
	public void uploadForm() { // get 방식으로 요청이 오면 uploadForm을 보여준다.
		
	}
	
	@PostMapping("/upload/upload")
	public String upload(ImgVo iv) { // 업로드 파일의 파일명 반환
		MultipartFile f = iv.getFile();
		String fname = f.getOriginalFilename();
		System.out.println(f);
		File ff = new File(path + fname); // 지정한 경로에 파일 객체 생성
		try {
			f.transferTo(ff); // 업로드 파일 복사
			System.out.println("title:" + iv.getTitle());
			System.out.println("file:" + fname);
			System.out.println("업로드 됨");
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/upload/list";
	}
	
	@RequestMapping("/upload/list")
	public void list(Model m) {
		File imgDir = new File(path);
		String[] files = imgDir.list();
		m.addAttribute("imgs", files);
	}
	
	@RequestMapping("/upload/read_img")
	public ResponseEntity<byte[]> read_img(String fname) {
		File f = new File(path + fname);//타겟 파일
		System.out.println("Executable: " + f.canExecute());
        System.out.println("Readable: " + f.canRead());
        System.out.println("Writable: " + f.canWrite());
		HttpHeaders header = new HttpHeaders();
		ResponseEntity<byte[]> result = null;
		try {
			header.add("Content-Type", Files.probeContentType(f.toPath()));//마임타입
			result = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(f), header, HttpStatus.OK);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}

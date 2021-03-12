package com.example.demo.down;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.upload.ImgVo;

@Controller
public class DownFileController {
	private String path = "C:\\img\\";
	private String basePath = "C:\\down\\";

	@Autowired
	private DownFileService service;

	@GetMapping("/down/upload")
	public void uploadForm() {
	}

	@PostMapping("/down/upload")
	public String upload(DownFile df) {
		MultipartFile ff = df.getFile();
		if (ff == null) {
			System.out.println("file not found");

		} else {
			String fname = ff.getOriginalFilename();
			File f = new File(basePath + fname);
			try {
				ff.transferTo(f);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			df.setPath(fname);
			service.upload(df);
		}
		return "redirect:/down/list";
	}

	@RequestMapping("/down/list")
	public void list() {
		
	}
}

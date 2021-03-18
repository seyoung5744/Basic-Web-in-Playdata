package com.example.demo.down;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
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
public class DownFileController {

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
	public void list(Model m) {
		ArrayList<DownFile> list = service.getAll();
		m.addAttribute("list", list);
	}

	@RequestMapping("/down/read")
	public void read(Model m, int num) {
		DownFile df = service.getFile(num);
		m.addAttribute("df", df);
	}

	@RequestMapping("/down/down")
	public ResponseEntity<byte[]> down(int num) {
		DownFile df = service.getFile(num);
		File f = new File(basePath + df.getPath());// 타겟 파일
		HttpHeaders header = new HttpHeaders();
		ResponseEntity<byte[]> result = null;

		try {
			header.add("Content-Type", Files.probeContentType(f.toPath()));// 마임타입
			header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + df.getPath() + "\"");
			result = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(f), header, HttpStatus.OK);
			service.cntUpdate(num);// 다운로드 수 1증가
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@RequestMapping("/down/del")
	public String del(int num) {
		DownFile df = service.getFile(num);
		service.delFile(num);
		File f = new File(basePath + df.getPath());
		f.delete();
		return "redirect:/down/list";
	}
}

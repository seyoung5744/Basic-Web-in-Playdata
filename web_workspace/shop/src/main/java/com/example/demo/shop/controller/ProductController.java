package com.example.demo.shop.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.shop.model.Category;
import com.example.demo.shop.model.Product;
import com.example.demo.shop.model.ShopMember;
import com.example.demo.shop.service.ProductService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/products") // 이 컨트롤러의 기본 uri
public class ProductController {
	private String basePath = "C:\\shop_img\\";
	@Autowired
	private ProductService service;

	// 상품등록, 상품번호로검색, 상품수정, 상품삭제, 상품카테고리로 검색, 상품판매자로 검색, 상품전체목록
	@PostMapping("")
	public Map addProduct(Product p) {
		boolean flag = false;
		try {
			Product p2 = service.addProduct(p);
			int num = p2.getNum();
			String fpath = basePath + num + "\\";
			File dir = new File(fpath);
			dir.mkdir();// 이미지 저장할 폴더 생성: C:\\shop_img\\33

			MultipartFile[] files = { p.getFile1(), p.getFile2(), p.getFile3(), p.getFile4() };
			int cnt = 1;

			String end = "";
			for (MultipartFile f : files) {
				if (f != null) {
					int idx = f.getOriginalFilename().lastIndexOf(".");
					end = f.getOriginalFilename().substring(idx);// .확장자 추출 1.jpg 2.png
					File ff = new File(fpath + cnt + end);
					f.transferTo(ff);
					cnt++;
				}
			}
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		Map map = new HashMap();
		map.put("result", flag);
		return map;
	}

	@GetMapping("")
	public Map getAll() {
		boolean flag = false;
		Map map = new HashMap();
		try {
			ArrayList<Product> list = service.getAll();
			map.put("list", list);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("result", flag);
		return map;
	}

	@GetMapping("/{num}")
	public Map getByNum(@PathVariable("num") int num) {
		boolean flag = false;
		Map map = new HashMap();
		try {
			Product p = service.getProduct(num);
			File dir = new File(basePath + num);
			String[] files = dir.list();
			int cnt = 1;
			if (files.length > 0) {
				for (String f : files) {
					map.put("file" + cnt, "/img/" + num + "/" + f);
				}
			}
			map.put("p", p);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("result", flag);
		return map;
	}

	@GetMapping("/img/{num}/{file}")
	public ResponseEntity<byte[]> read_img(@PathVariable("num") int num, @PathVariable("file") String file) {
		String path = basePath + num + "\\" + file;
		File f = new File(path);// 타겟 파일
		HttpHeaders header = new HttpHeaders();
		ResponseEntity<byte[]> result = null;
		try {
			header.add("Content-Type", Files.probeContentType(f.toPath()));// 마임타입
			result = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(f), header, HttpStatus.OK);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@GetMapping("/{cate}/cates")
	public Map getByCate(@PathVariable("cate") int cate) {
		boolean flag = false;
		Map map = new HashMap();
		Category c = new Category(cate, "");
		try {
			System.out.println(cate);
			ArrayList<Product> list = service.getByCate(c);
			map.put("list", list);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("result", flag);
		return map;
	}

	@GetMapping("/{seller}/members")
	public Map getByCate(@PathVariable("seller") String seller) {
		boolean flag = false;
		Map map = new HashMap();
		ShopMember ss = new ShopMember();
		ss.setId(seller);
		try {
			ArrayList<Product> list = service.getBySeller(ss);
			map.put("list", list);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("result", flag);
		return map;
	}

	@PutMapping("")
	public Map editProduct(Product p) {
		boolean flag = false;
		Map map = new HashMap();
		try {
			service.editProduct(p);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("result", flag);
		return map;
	}

	@DeleteMapping("/{num}")
	public Map delProduct(@PathVariable("num") int num) {
		boolean flag = false;
		Map map = new HashMap();
		try {
			service.delProduct(num);
			File dir = new File(basePath + num);
			File[] files = dir.listFiles();
			if (files.length > 0) {
				for (File f : files) {
					f.delete();
				}
			}
			dir.delete();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("result", flag);
		return map;
	}
}

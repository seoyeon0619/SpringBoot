package com.kosa.myapp;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @Controller는 이전과 동일
// return값을 이용해 필요한 mustache파일을 찾음
// src/main/resource/templates 폴더 아래에 html 파일을 두어야함
@RestController
public class HelloController {
	
	@GetMapping("/")
	public String hello() {
		return "/test";
	}
	
	//http://localhost:9000/add?x=5&y=7
	@RequestMapping(value="/add")
	public HashMap<String, Integer> data(Integer x, Integer y){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("x", x);
		map.put("y", y);
		map.put("result", x+y);
		return map;
	}
}

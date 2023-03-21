package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping(value="/")
	public String home() {
		return "Hello";
	}
	
	@RequestMapping(value="/data")
	public HashMap<String, String> data(){
		HashMap map = new HashMap<String, String>();
		map.put("name", "이서연");
		map.put("age", "23");
		map.put("phone", "010-0000-0000");
		map.put("email", "tjdus5077@naver.com");
		return map;
	}
	
	@RequestMapping(value="/dataList")
	public List<HashMap<String,String>> data_list(){
		List<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();
		HashMap map = new HashMap<String, String>();
		
		map.put("name", "이서연");
		map.put("age", "23");
		map.put("phone", "010-0000-0000");
		map.put("email", "tjdus5077@naver.com");
		dataList.add(map);
		
		map = new HashMap<String, String>();
		map.put("name", "홍길동");
		map.put("age", "32");
		map.put("phone", "010-0000-0002");
		map.put("email", "hong@naver.com");
		dataList.add(map);
		
		map = new HashMap<String, String>();
		map.put("name", "김냠냠");
		map.put("age", "45");
		map.put("phone", "010-0000-0003");
		map.put("email", "yamyam@naver.com");
		dataList.add(map);
		
		return dataList;
	}
	
	//http://lacalhost:9000/info?userid=test&password=1234
	@GetMapping("/info")
	public HashMap<String, String> info(String userid, String password){
	HashMap<String, String> map = new HashMap<String, String>();
	map.put("userid", userid);
	map.put("password", password);
	return map;
	}
}

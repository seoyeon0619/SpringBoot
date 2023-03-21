package com.kosa.myapp.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kosa.myapp.domain.MemberDto;
import com.kosa.myapp.service.MemberService;

@Controller 
public class MemberController {
	@Autowired
	MemberService service;
	
	//등록페이지로 이동하기 
	@GetMapping("/member/write")
	String member_write()
	{
		return "/member/write";
	}
	
	@PostMapping("/member/save")
	String member_save(MemberDto dto)
	{
		service.insert(dto);
		return "redirect:/";
	}
	
	@ResponseBody
	@GetMapping("/member/isuse")
	HashMap<String, String> isuse(MemberDto dto)
	{
		HashMap<String, String> resultMap = new 
				HashMap<String, String>();
		if( service.isUse(dto))
			resultMap.put("result", "Y");
		else
			resultMap.put("result", "N");
		return resultMap;
	}
	
	
}





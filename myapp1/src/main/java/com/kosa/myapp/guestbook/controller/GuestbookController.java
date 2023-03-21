package com.kosa.myapp.guestbook.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kosa.myapp.guestbook.domain.GuestbookDto;
import com.kosa.myapp.guestbook.service.GuestbookService;

import jakarta.annotation.Resource;

@RestController
public class GuestbookController {
	@Resource(name="guestbookService")
	GuestbookService service;
	
	// guestbook/list/1
	// {pg}값을 가져오려면 @PathVariable 써줘야함
	@GetMapping("/guestbook/list/{pg}")
	public HashMap<String, Object> getList(@PathVariable("pg")int pg,GuestbookDto dto)
	{
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		dto.setPg(pg);
		
		resultMap.put("totalCnt", service.getTotalCnt(dto));
		resultMap.put("data", service.getList(dto));
		
		return resultMap;
	}
	
	// post 방식 전송은 브라우저로 확인 불가능
	// RequestBody json형태로 데이터 수신
	@PostMapping("/guestbook/insert")
	public HashMap<String, String>insert(@RequestBody GuestbookDto dto)
	{	
		HashMap<String, String>resultMap = new HashMap<String, String>();
		
		try {
			service.insert(dto);
			resultMap.put("result", "success");
		} catch (Exception e) {
			e.printStackTrace(); 
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	
	// guestbook/view/2 
	// guestbook/view?seq=2 : 옛날방식
	@GetMapping("/guestbook/view/{seq}")
	public HashMap<String, Object> getView(@PathVariable("seq")int seq,GuestbookDto dto)
	{
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		dto.setPg(seq);
		try {
			resultMap.put("result", "success");
			resultMap.put("msg", "성공");
			resultMap.put("data", service.getView(dto));
		}
		catch(Exception ex)
		{
			resultMap.put("result", "fail");
			resultMap.put("msg", "실패");
		}
		return resultMap;
	}
	
	

}

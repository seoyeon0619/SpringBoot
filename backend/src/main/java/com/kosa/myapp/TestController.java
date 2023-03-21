package com.kosa.myapp;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	//add?x=5&y=7 -> add/5/8
	@GetMapping("/cal/{x}/{y}/{no}")
	public HashMap<String, String>cal(@PathVariable("x")int x, @PathVariable("y")int y, @PathVariable("no")int no)
	{	
		HashMap<String, String> map = new HashMap<String, String>();
		int result=0;
		if (no==1)
			result = x+y;
		else if (no==2)
			result = x-y;
		else if (no==3)
			result = x*y;
		else if (no==4)
			result = x/y;
		map.put("x", String.valueOf(x));
		map.put("y", String.valueOf(y));
		map.put("result", String.valueOf(result));
		return map;
	}
	
	@GetMapping("/score_json")
	public HashMap<String, Object>socre_json(@RequestBody HashMap<String, Object> paramMap, @RequestBody ScoreDto dto)
	{	
		HashMap<String, Object>resultMap = new HashMap<String, Object>();
		int total = dto.getKor() + dto.getEng() + dto.getMat();
		dto.setTotal(total);
		dto.setAvg(total/3);
		
		resultMap.put("name", dto.getName());
		resultMap.put("kor", dto.getKor());
		resultMap.put("eng", dto.getEng());
		resultMap.put("mat", dto.getMat());
		resultMap.put("total", dto.getTotal());
		resultMap.put("avg", dto.getAvg());
		
		return resultMap;
	}
}

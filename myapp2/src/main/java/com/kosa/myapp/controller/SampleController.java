package com.kosa.myapp.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosa.myapp.domain.SampleDto;
import com.kosa.myapp.service.SampleService;

@RestController 
public class SampleController {
	@Autowired 
	SampleService service;
	
	@GetMapping("/sample/list")
	List<SampleDto> getList(SampleDto dto)
	{
		return service.getList(dto);
	}
	///sample/insert?test=dfjeslfj
	@GetMapping("/sample/insert")
	HashMap<String, Object> insert(SampleDto dto)
	{
		HashMap<String, Object> map = new HashMap<String, Object>();
		try
		{
			service.insert(dto);
			map.put("result", "success");
		}
		catch(Exception e)
		{
			map.put("result", "fail");
		}
		return map;
	}
	
	// sample/update?seq=1&test=update
	@GetMapping("/sample/update")
	HashMap<String, Object> update(SampleDto dto)
	{
		HashMap<String, Object> map = new HashMap<String, Object>();
		try
		{
			service.update(dto);
			map.put("result", "success");
		}
		catch(Exception e)
		{
			map.put("result", "fail");
		}
		return map;
	}
	
	// sample/delete?seq=1
	@GetMapping("/sample/delete")
	HashMap<String, Object> delete(SampleDto dto)
	{
		HashMap<String, Object> map = new HashMap<String, Object>();
		try
		{
			service.delete(dto);
			map.put("result", "success");
		}
		catch(Exception e)
		{
			map.put("result", "fail");
		}
		return map;
	}
	
	// sample/find?test=seoyeon
	@GetMapping("/sample/find")
	List<SampleDto> findByTest(SampleDto dto)
	{
		return service.findTest(dto);
	}
	
}

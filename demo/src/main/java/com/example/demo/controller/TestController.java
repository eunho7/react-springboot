package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")	// 리소스
public class TestController {
	
	@GetMapping("/testGetMapping")
	public String testController() {
		return "Hello World testGetMapping";
	}
	
	// 매개변수를 넘겨받는 방법
	@GetMapping({"/{id}", "/"})
	public String testControllerWithPathVariables(@PathVariable(required=false)Integer id) {
		return "Hello World! ID " + id;
	}

}

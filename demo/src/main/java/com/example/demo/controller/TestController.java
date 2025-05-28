package com.example.demo.controller;

import com.example.demo.dto.TestRequestBodyDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("test")	// 리소스
public class TestController {
	
	@GetMapping("/testGetMapping")
	public String testController() {
		return "Hello World testGetMapping";
	}
	
	// 매개변수를 넘겨받는 방법
	@GetMapping({"/{id}", "/"})
	public String testControllerWithPathVariables(@PathVariable(required=false)int id) {
		return "Hello World! ID " + id;
	}

	@GetMapping("/testRequestParam")
	public String testControllerRequestParam(@RequestParam(required=false) int id) {
		return "Hello World! ID " + id;
	}

	@GetMapping("/testRequestBody")
	public String testControllerRequestBody(@RequestBody TestRequestBodyDTO testRequestBodyDTO){
		return "Hello World! ID " + testRequestBodyDTO.getId() + " Message : " +testRequestBodyDTO.getMessage();
	}
}

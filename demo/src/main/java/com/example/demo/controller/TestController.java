package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TestRequestDTO;

@RestController
@RequestMapping("test")
public class TestController {
	
	@GetMapping
	public String testController() {
		return "Hello, World!";
	}
	
	@GetMapping("/{id}")
	public String testControllerWithPathVariables(@PathVariable(required = true) int id) {
		return "Hello World!" + id;
	}
	
	@GetMapping("/testRequestParam")
	public String testControllerRequestParam(@RequestParam(required = false) int id) {
		return "Hello World!" + id;
	}

	@GetMapping("/testRequestBody")
	public String testControllerWithRequestBody(@RequestBody TestRequestDTO testRequestDTO) {
		return "Hello World! ID " + testRequestDTO.getId()
		+ "Message : " + testRequestDTO.getMessgae();
	}
	
	@GetMapping("/testResponseBody")
	public ResponseDTO<?> testControllerResponseBody() {
		List<String> list = new ArrayList<>();
		list.add("Hello World! I'm ResponseBody");
		ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
		return response;
	}
	
	@GetMapping("/testResponseEntity")
	public ResponseEntity<?> testControllerResponseEntity() {
	    List<String> list = new ArrayList<>();
	    list.add("Hello World! I'm ResponseBody. And you got 400!");
	    ResponseDTO<String> response = ResponseDTO.<String>builder()
	                                              .data(list)
	                                              .build();
	    return ResponseEntity.badRequest().body(response);
	}
}

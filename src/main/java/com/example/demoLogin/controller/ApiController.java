package com.example.demoLogin.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoLogin.service.ApiService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/")
public class ApiController {
	
	private final ApiService apiService;
	
	@GetMapping(path = "login", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> loginDemo(@RequestParam(name = "usr", required = true) String usr ,
											@RequestParam(name = "pwd", required = true) String pwd ) throws Exception {
		
		return ResponseEntity.ok(apiService.login(usr, pwd));
	}
}

package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SessionController {
	
	@GetMapping("/sign")
	public String signup() {
		return "SignUp";
		}
	
}

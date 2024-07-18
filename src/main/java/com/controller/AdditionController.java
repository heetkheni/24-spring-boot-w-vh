package com.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.AdditionBean;

@Controller
public class AdditionController {
	
	
	@GetMapping("/addinput")
	public String addInput() {
		return "AddInput";
	}
	
	@PostMapping("/addition")
	public String addNum(AdditionBean additionBean , Model model) {
		model.addAttribute("nums",additionBean);
		return "AddOutput";
	}
	
}

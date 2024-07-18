package com.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.bean.BoxCricket;

@Controller
public class StudentController {
	
	@GetMapping("/boxcricketreg")
	public String boxRegistration() {
		return "BoxCricketReg";
	}
	
	@PostMapping("/savereg")
	public String saveReg(BoxCricket boxCricket , Model model) {
		System.out.println(boxCricket.getStudentName());
		System.out.println(boxCricket.getDrink());
		System.out.println(boxCricket.getFoodPreference());
		System.out.println(boxCricket.getPlayerType());
		
		boolean isError = false;
		String alphaRegEx = "[A-Za-z]+";
		
		if(boxCricket.getStudentName() == null || boxCricket.getStudentName().trim().length() == 0 ) {
			isError = true;
			model.addAttribute("studentNameError" , "Please Enter Name");
		}
		else if(boxCricket.getStudentName().matches(alphaRegEx) == false) {
				isError = true;
				model.addAttribute("studentNameError" , "Please Enter Valid Name");
			}
		else {
			model.addAttribute("studentNameValue",boxCricket.getStudentName());
		}
		
		
		if(boxCricket.getFoodPreference().equals("-1")) {
			isError = true;
			model.addAttribute("foodPreferenceError" , "Please Select Food Pref.");
		}
		else {
			model.addAttribute("foodPreferenceValue",boxCricket.getFoodPreference());
		}
		
		if(boxCricket.getPlayerType() == null ) {
			isError = true;
			model.addAttribute("playerTypeError" , "Please Select Player Type");
		}
		else {
			model.addAttribute("playerTypeValue",boxCricket.getPlayerType());
		}
		
		if(boxCricket.getDrink() == null ) {
			isError = true;
			model.addAttribute("drinkError" , "Please Select any Drink");
		}
		else {
			model.addAttribute("drinkValue",boxCricket.getDrink());
		}
		
		if(isError) {
			return "BoxCricketReg";
		}
		else {
			model.addAttribute("student",boxCricket);
			return "Welcome";			
		}

	}
}

package com.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.EUserBean;
import com.dao.EUserDao;
import com.services.FileUploadService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EcomSessionController {
	
	@Autowired
	EUserDao userDao;
	
	@Autowired
	FileUploadService fileUploadService;
	
	@GetMapping("/esignup")
	public String signup() {
		return "EcomSignUp";
	}
	
	@GetMapping("/elogin")
	public String login() {
		return "EcomLogin";
	}
	
	@PostMapping("/esignup")
	public String signupPost(EUserBean userBean) {
		
		fileUploadService.uploadProfilePic(userBean.getProfilePic(), userBean.getEmail());
		
		userBean.setProfilePicPath(
				"images//userProfilePic//" + userBean.getEmail() + "//" + userBean.getProfilePic().getOriginalFilename());
		
		userDao.insertUser(userBean);
		
		return "EcomSignUp";
		
	}
	
	@PostMapping("/elogin")
	public String eLogin(EUserBean userBean , Model model , HttpSession httpSession) {
		
		EUserBean dbUser =  userDao.authenticate(userBean.getEmail(), userBean.getPassword());
		
		
		if(dbUser == null) {
			model.addAttribute("error","Invalid Credentials");
			return "EcomLogin";
		}
		else {
			httpSession.setAttribute("user", dbUser);
			model.addAttribute("firstName", dbUser.getFirstName());
			model.addAttribute("profilePicPath", dbUser.getProfilePicPath());	
			return "EcomHome";
		}
		
		
		
		
	}
	
		
		
	
	
	

}

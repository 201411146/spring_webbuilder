package com.company.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
	
	//사이트 홈
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		return "home";
	}
	
}

package com.cognizant.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
	
	@RequestMapping(value="/" , method=RequestMethod.GET)
	public String loginMessage() {
		return "hello";
	}

	@RequestMapping(value="index" , method=RequestMethod.GET)
	public String indexPage() {
		return "index";
	}
}

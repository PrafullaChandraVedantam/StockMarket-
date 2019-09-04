package com.example.SpringBoot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	// TODO Auto-generated method stub
	@RequestMapping(path = "/hello")
	public String sayHello() {
		System.out.println("hello");
		return "helloWorld";
	}

}

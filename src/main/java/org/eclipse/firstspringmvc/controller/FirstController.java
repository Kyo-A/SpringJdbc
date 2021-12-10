package org.eclipse.firstspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public void sayHello() {
		System.out.println("Hello World!");
	}

//	@GetMapping(value = "/hello")
//	public void sayHello(@RequestParam(value = "nom", required =false) String s) {
//		System.out.println("Hello " + s);
//	}

//	@GetMapping(value = "/hello/{nom}")
//	public void sayHello(@PathVariable String nom) {
//		System.out.println("Hello " + nom);
//	}

//	@GetMapping(value = "/hello")
//	public String sayHello() {
//		return "hello";
//	}

//	@GetMapping(value = "/hello")
//	public String sayHello(Model model) {
//		model.addAttribute("nom", "Wick");
//		return "hello";
//	}

}

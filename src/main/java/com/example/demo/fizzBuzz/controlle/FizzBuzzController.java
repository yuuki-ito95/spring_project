package com.example.demo.fizzBuzz.controlle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.fizzBuzz.service.FizzBuzzService;

@Controller
public class FizzBuzzController {

	private final FizzBuzzService fizzBuzzService;

	public FizzBuzzController(FizzBuzzService fizzBuzzService) {
		this.fizzBuzzService = fizzBuzzService;
	}

	@GetMapping("/fizzBuzz")
	public String number(Model model) {
		model.addAttribute("numbers", fizzBuzzService.fizzBuzz());
		return "fizzBuzz";
	}

}

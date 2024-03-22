package com.example.demo.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.calculator.service.CalculatorService;

@Controller
public class CalculatorController {

	private final CalculatorService calculatorService;

	public CalculatorController(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}

	@GetMapping("calculator")
	public String showCalculator() {
		return "calculator.html";
	}

	@PostMapping("calculator")
	public String showResult(@RequestParam("num1") int num1, @RequestParam("num2") int num2,
			@RequestParam("operators") String operator, Model model) {

		String result = null;
		try {
			result = calculatorService.culculate(num1, num2, operator);
		} catch (ArithmeticException e) {
			model.addAttribute("error", "ゼロ除算はできません");
		}
		model.addAttribute("result", result);
		return "calculator.html";

	}

}

package com.example.demo.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

	public String culculate(int num1, int num2, String operator) {

		int result = 0;

		switch (operator) {
		case "+":
			result = num1 + num2;
			break;
		case "-":
			result = num1 - num2;
			break;
		case "*":
			result = num1 * num2;
			break;
		case "/":
			if (num1 == 0 || num2 == 0) {
				throw new ArithmeticException("ゼロ除算はできません");
			} else {
				result = num1 / num2;
			}
			break;
		}

		return String.valueOf(result);
	}

}

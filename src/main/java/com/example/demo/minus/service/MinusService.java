package com.example.demo.minus.service;

import org.springframework.stereotype.Service;

@Service
public class MinusService {

	public String result(int num1, int num2) {

		int result = num1 - num2;

		return String.valueOf(result);

	}

}

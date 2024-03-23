package com.example.demo.animalsAPI.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.animalsAPI.data.AnimalData;
import com.example.demo.animalsAPI.service.AnimalService;

@Controller
public class AnimalController {

	private final AnimalService animalService;

	public AnimalController(AnimalService animalService) {
		this.animalService = animalService;
	}

	@GetMapping("/animal-search")
	public String getAnimal(Model model) throws IOException {

		List<AnimalData> animalsList = animalService.getAnimals();

		model.addAttribute("animalsList", animalsList);

		return "animal-search.html";

	}

	@PostMapping("animal-detail")
	public String animalDetail(@RequestParam("animal") int id, Model model) throws URISyntaxException, IOException {

		List<AnimalData> animalDetail = animalService.getAnimalDetail(id);

		model.addAttribute("animalDetail", animalDetail);

		return "animal-detail.html";
	}

	@PostMapping("animal-search")
	public String animalSearch() {
		return "animal-search.html";
	}

}

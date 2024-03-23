package com.example.demo.animalsAPI.repository;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.demo.animalsAPI.data.AnimalData;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class AnimalRepository {

	public AnimalData[] getAnimals() throws IOException {

		String url = "https://jsn9xu2vsk.execute-api.ap-northeast-1.amazonaws.com/sample/sampleapi";

		RestTemplate rest = new RestTemplate();

		ResponseEntity<String> response = rest.getForEntity(url, String.class);

		String json = response.getBody();

		ObjectMapper mapper = new ObjectMapper();

		AnimalData[] animalsList = mapper.readValue(json, AnimalData[].class);

		return animalsList;

	}

	public AnimalData[] getAnimalDetail(int id) throws IOException {

		String url = "https://jsn9xu2vsk.execute-api.ap-northeast-1.amazonaws.com/sample/sampleapi?id=" + id;

		RestTemplate rest = new RestTemplate();

		ResponseEntity<String> response = rest.getForEntity(url, String.class);

		String json = response.getBody();

		ObjectMapper mapper = new ObjectMapper();

		AnimalData[] animalDetail = mapper.readValue(json, AnimalData[].class);

		return animalDetail;

	}

}

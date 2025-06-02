package com.cmp.synopticproject;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
	private ToiletRepository toiletRepository;

	public ApiController(ToiletRepository toiletRepository) {
		this.toiletRepository = toiletRepository;
	}

	@GetMapping("/toilets")
	public List<Toilet> getAllToilets () {
		return this.toiletRepository.findAll();
	}
}


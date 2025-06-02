package com.cmp.synopticproject;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class to handle REST API requests.
 */
@RestController
public class ApiController {
	private ToiletRepository toiletRepository;

	public ApiController(ToiletRepository toiletRepository) {
		this.toiletRepository = toiletRepository;
	}

	/**
	 * Query database for all toilet entities.
	 * @return a List of all toilet entities in the database.
	 */
	@GetMapping("/toilets")
	public List<Toilet> getAllToilets () {
		return this.toiletRepository.findAll();
	}
}


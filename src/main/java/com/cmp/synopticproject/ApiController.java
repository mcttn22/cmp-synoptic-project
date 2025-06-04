package com.cmp.synopticproject;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class to handle REST API requests.
 */
@RestController
public class ApiController {
	private ToiletBlockRepository toiletBlockRepository;
	private ToiletRepository toiletRepository;
	private ResidentRepository residentRepository;
	private FarmerRepository farmerRepository;

	public ApiController(ToiletBlockRepository toiletBlockRepository,
					     ToiletRepository toiletRepository,
						 ResidentRepository residentRepository,
						 FarmerRepository farmerRepository) {
		this.toiletBlockRepository = toiletBlockRepository;
		this.toiletRepository = toiletRepository;
		this.residentRepository = residentRepository;
		this.farmerRepository = farmerRepository;
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


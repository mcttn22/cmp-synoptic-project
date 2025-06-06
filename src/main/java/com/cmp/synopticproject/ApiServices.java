package com.cmp.synopticproject;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

/**
 * Class to perform services related to the API.
 */
@Service
public class ApiServices {
	private ToiletBlockRepository toiletBlockRepository;
	private ToiletRepository toiletRepository;
	private ResidentRepository residentRepository;
	private FarmerRepository farmerRepository;

	public ApiServices(ToiletBlockRepository toiletBlockRepository,
					     ToiletRepository toiletRepository,
						 ResidentRepository residentRepository,
						 FarmerRepository farmerRepository) {
		this.toiletBlockRepository = toiletBlockRepository;
		this.toiletRepository = toiletRepository;
		this.residentRepository = residentRepository;
		this.farmerRepository = farmerRepository;
	}

	/**
	 * Check if resident already exists in database.
	 * @return true if resident already exists, otherwise false.
	 */
	public boolean doesResidentExist (String username) {
		return residentRepository.existsByUsername(username);
	}

	/**
	 * Save resident to database.
	 */
	public void signUpResident (Resident resident) {
		residentRepository.save(resident);
	}

	/**
	 * Check if resident login details match resident in database.
	 * @return true if success otherwise false.
	 */
	public boolean authenticateResident (ResidentLogin residentLogin) {
		Resident resident = residentRepository.findByUsername(residentLogin.getUsername());
		if (resident != null) {
			System.out.println(resident.getPassword());
			System.out.println(residentLogin.getPassword());
			if (resident.getPassword().equals(residentLogin.getPassword())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Create list of toilet block response objects.
	 * @return ArrayList of toilet block response objects.
	 */
	public ArrayList<ToiletBlockResponse> getToiletBlockResponses () {
		ArrayList<ToiletBlockResponse> toiletBlockResponses = new ArrayList<ToiletBlockResponse>();
		for (ToiletBlock toiletBlock: toiletBlockRepository.findAll()) {
			ToiletBlockResponse toiletBlockResponse = new ToiletBlockResponse();
			toiletBlockResponse.setBlockId(toiletBlock.getBlockId());
			toiletBlockResponse.setBlockAddress(toiletBlock.getBlockAddress());
			toiletBlockResponse.setBlockStatus(toiletBlock.getBlockStatus());
			toiletBlockResponse.setToiletCount(toiletBlock.getToiletCount());

			// Add list of toilet block's toilets
			ArrayList<Toilet> toilets = new ArrayList<Toilet>();
			for (Toilet toilet: toiletRepository.findAllByBlockId(toiletBlock.getBlockId())) {
				toilets.add(toilet);
			}
			toiletBlockResponse.setToilets(toilets);

			toiletBlockResponses.add(toiletBlockResponse);
		}
		return toiletBlockResponses;
	}
}


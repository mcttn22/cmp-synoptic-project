package com.cmp.synopticproject;

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
}


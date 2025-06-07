package com.cmp.synopticproject.service;

import com.cmp.synopticproject.dto.*;
import com.cmp.synopticproject.exception.*;
import com.cmp.synopticproject.model.*;
import com.cmp.synopticproject.repository.*;

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
	 * Save resident to database.
	 */
	public void signUpResident (Resident resident) {
		if (residentRepository.existsByUsername(resident.getUsername())) {
			throw new ResidentAlreadyExistsException("Resident already exists");
		} else {
			residentRepository.save(resident);
		}
	}

	/**
	 * Check if resident login details match resident in database.
	 * @return true if success otherwise false.
	 */
	public void authenticateResident (ResidentLogin residentLogin) {
		Resident resident = residentRepository.findByUsername(residentLogin.getUsername()).orElseThrow(() -> new ResidentDoesNotExistException("Resident does not exist"));
		if (!(resident.getPassword().equals(residentLogin.getPassword()))) {
			throw new ResidentAuthenticationFailureException("Unsuccessfull login");
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

	/**
	 * Update status of toilet with given id.
	 */
	public void updateToiletStatus (Integer id, String status) {
		Toilet toilet = toiletRepository.findById(id).orElseThrow(() -> new ToiletDoesNotExistException(String.format("Toilet %d does not exist", id)));
		toilet.setToiletStatus(status);
		toiletRepository.save(toilet);
	}
}


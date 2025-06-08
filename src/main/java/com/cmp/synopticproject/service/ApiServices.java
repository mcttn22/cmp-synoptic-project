package com.cmp.synopticproject.service;

import com.cmp.synopticproject.dto.*;
import com.cmp.synopticproject.exception.*;
import com.cmp.synopticproject.model.*;
import com.cmp.synopticproject.repository.*;

import java.util.ArrayList;

import org.springframework.security.crypto.password.PasswordEncoder;
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
	private ReportRepository reportRepository;

	private PasswordEncoder passwordEncoder;

	public ApiServices(ToiletBlockRepository toiletBlockRepository,
					     ToiletRepository toiletRepository,
						 ResidentRepository residentRepository,
						 FarmerRepository farmerRepository,
						 ReportRepository reportRepository,
						 PasswordEncoder passwordEncoder) {
		this.toiletBlockRepository = toiletBlockRepository;
		this.toiletRepository = toiletRepository;
		this.residentRepository = residentRepository;
		this.farmerRepository = farmerRepository;
		this.reportRepository = reportRepository;

		this.passwordEncoder = passwordEncoder;
	}

	/**
	 * Save resident to database.
	 */
	public void signUpResident (SignupRequest signupRequest) {

		// Generate Resident object from signup request
		Resident resident = new Resident();
		resident.setUsername(signupRequest.getUsername());
		resident.setEmail(signupRequest.getEmail());

		// Encode password
		resident.setPassword(passwordEncoder.encode(signupRequest.getPassword()));

		if (residentRepository.existsByUsername(resident.getUsername())) {
			throw new ResidentAlreadyExistsException("Resident already exists");
		} else {
			residentRepository.save(resident);
		}
	}

	/**
	 * Save farmer to database.
	 */
	public void signUpFarmer (SignupRequest signupRequest) {
		signUpResident(signupRequest);

		// Get saved resident entity
		Resident resident = residentRepository.findByUsername(signupRequest.getUsername()).orElseThrow(() -> new ResidentDoesNotExistException("Resident does not exist"));
		
		// Generate Farmer object from signup request
		Farmer farmer = new Farmer();
		farmer.setResId(resident.getResId());

		farmerRepository.save(farmer);
	}

	/**
	 * Save report to database.
	 */
	public void reportIssue (Report report) {
		reportRepository.save(report);
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


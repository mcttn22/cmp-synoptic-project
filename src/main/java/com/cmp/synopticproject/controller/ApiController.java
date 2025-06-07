package com.cmp.synopticproject.controller;

import com.cmp.synopticproject.dto.*;
import com.cmp.synopticproject.exception.*;
import com.cmp.synopticproject.model.*;
import com.cmp.synopticproject.service.*;

import java.util.HashMap;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Class to handle REST API requests.
 */
@RestController
@RequestMapping("/api")
public class ApiController {
	@Autowired ApiServices apiServices;

	/**
	 * Sign up a new resident to the database.
	 * @return a ResponseEntity object.
	 */
	@PostMapping("/signup")
	public ResponseEntity<HashMap<String, String>> signupResident (@RequestBody SignupRequest signupRequest) {
		HashMap<String, String> responseData = new HashMap<String, String>();
		if (signupRequest.getUserType().equals("resident")) {
			apiServices.signUpResident(signupRequest);
		} else if (signupRequest.getUserType().equals("farmer")) {
			apiServices.signUpFarmer(signupRequest);
		} else {
			throw new InvalidUserTypeException(String.format("%s is not a valid user type"));
		}
		responseData.put("message", "User signed up successfully");
		return new ResponseEntity<HashMap<String, String>>(responseData, HttpStatus.OK);
	}

	/**
	 * Log in a resident.
	 * @return a ResponseEntity object.
	 */
	@PostMapping("/login")
	public ResponseEntity<HashMap<String, String>> loginResident (@RequestBody LoginRequest loginRequest) {
		HashMap<String, String> responseData = new HashMap<String, String>();
		if (loginRequest.getUserType().equals("resident")) {
			apiServices.authenticateResident(loginRequest);
		} else if (loginRequest.getUserType().equals("farmer")) {
			apiServices.authenticateFarmer(loginRequest);
		} else {
			throw new InvalidUserTypeException(String.format("%s is not a valid user type"));
		}
		responseData.put("message", "Successfull login");
		return new ResponseEntity<HashMap<String, String>>(responseData, HttpStatus.OK);
	}

	/**
	 * Report issue
	 * @return a ResponseEntity object.
	 */
	@PostMapping("/reportissue")
	public ResponseEntity<HashMap<String, String>> reportIssue (@RequestBody Report report) {
		HashMap<String, String> responseData = new HashMap<String, String>();
		apiServices.reportIssue(report);
		responseData.put("message", "Issue successfully reported");
		return new ResponseEntity<HashMap<String, String>>(responseData, HttpStatus.OK);
	}

	/**
	 * Get list of all toilet blocks and their toilets.
	 * @return ArrayList of ToiletBlockResponse objects.
	 */
	@GetMapping("/toiletblocks")
	public ArrayList<ToiletBlockResponse> getToiletBlocks () {
		return apiServices.getToiletBlockResponses();
	}

	/**
	 * Update status of toilet by its id.
	 * @return a ResponseEntity object.
	 */
	@PutMapping("/toilet/{id}")
	public ResponseEntity<HashMap<String, String>> updateToiletStatus (@RequestBody ToiletStatusUpdate toiletStatusUpdate, @PathVariable Integer id) {
		HashMap<String, String> responseData = new HashMap<String, String>();
		apiServices.updateToiletStatus(id, toiletStatusUpdate.getToiletStatus());
		responseData.put("message", "Toilet status successfully updated");
		return new ResponseEntity<HashMap<String, String>>(responseData, HttpStatus.OK);
	}
}


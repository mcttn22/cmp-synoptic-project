package com.cmp.synopticproject;

import java.util.HashMap;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Class to handle REST API requests.
 */
@RestController
public class ApiController {
	@Autowired ApiServices apiServices;

	/**
	 * Sign up a new resident to the database.
	 * @return a ResponseEntity object.
	 */
	@PostMapping("/signup/resident")
	public ResponseEntity<HashMap<String, String>> signupResident (@RequestBody Resident resident) {
		HashMap<String, String> responseData = new HashMap<String, String>();
		if (apiServices.doesResidentExist(resident.getUsername())) {
			responseData.put("message", "Resident already exists");
			return new ResponseEntity<HashMap<String, String>>(responseData, HttpStatus.BAD_REQUEST);
		} else {
			apiServices.signUpResident(resident);
			responseData.put("message", "Resident signed up successfully");
			return new ResponseEntity<HashMap<String, String>>(responseData, HttpStatus.OK);
		}
	}

	/**
	 * Log in a resident.
	 * @return a ResponseEntity object.
	 */
	@PostMapping("/login/resident")
	public ResponseEntity<HashMap<String, String>> loginResident (@RequestBody ResidentLogin residentLogin) {
		HashMap<String, String> responseData = new HashMap<String, String>();
		if (apiServices.authenticateResident(residentLogin)) {
			responseData.put("message", "Successfull login");
			return new ResponseEntity<HashMap<String, String>>(responseData, HttpStatus.OK);
		} else {
			responseData.put("message", "Unsuccessfull login");
			return new ResponseEntity<HashMap<String, String>>(responseData, HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Get list of all toilet blocks and their toilets.
	 * @return ArrayList of ToiletBlockResponse objects.
	 */
	@GetMapping("/toiletblocks")
	public ArrayList<ToiletBlockResponse> getToiletBlocks () {
		return apiServices.getToiletBlockResponses();
	}
}


package com.cmp.synopticproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Class to handle HTTP requests.
 */
@Controller
public class WebPageController {

	/**
	 * Render the index page.
	 */
	@GetMapping("/index")
	public String getIndex() {
		return "index";
	}

	/**
	 * Render the ourGoal page.
	 */
	@GetMapping("/ourGoal")
	public String getOurgoal() {
		return "ourGoal";
	}

	/**
	 * Render the report page.
	 */
	@GetMapping("/report")
	public String getReport() {
		return "report";
	}

	/**
	 * Render the welcomeF page.
	 */
	@GetMapping("/welcomeF")
	public String getWelcomeF() {
		return "welcomeF";
	}

	/**
	 * Render the welcomeR page.
	 */
	@GetMapping("/welcomeR")
	public String getWelcomeR() {
		return "welcomeR";
	}
}


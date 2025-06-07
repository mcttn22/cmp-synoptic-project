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
	 * Render the infoF page.
	 */
	@GetMapping("/infoF")
	public String getInfoF() {
		return "infoF";
	}

	/**
	 * Render the infoR page.
	 */
	@GetMapping("/infoR")
	public String getInfoR() {
		return "infoR";
	}

	/**
	 * Render the ourGoalF page.
	 */
	@GetMapping("/ourGoalF")
	public String getOurgoalF() {
		return "ourGoalF";
	}

	/**
	 * Render the ourGoalR page.
	 */
	@GetMapping("/ourGoalR")
	public String getOurgoalR() {
		return "ourGoalR";
	}

	/**
	 * Render the reportF page.
	 */
	@GetMapping("/reportF")
	public String getReportF() {
		return "reportF";
	}

	/**
	 * Render the reportR page.
	 */
	@GetMapping("/reportR")
	public String getReportR() {
		return "reportR";
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


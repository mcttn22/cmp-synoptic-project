package com.cmp.synopticproject;

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
	 * Render the login page.
	 */
	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}

	/**
	 * Render the ourGoal page.
	 */
	@GetMapping("/ourGoal")
	public String getOurgoal() {
		return "ourGoal";
	}
}


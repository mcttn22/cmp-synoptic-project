package com.cmp.synopticproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebPageController {

	@GetMapping("/index")
	public String getIndex() {
		return "index";
	}

	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}

	@GetMapping("/ourGoal")
	public String getOurgoal() {
		return "ourGoal";
	}
}


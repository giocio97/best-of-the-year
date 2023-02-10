package com.corsojava.bestoftheyear.controller;

import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class MainController {

	@GetMapping()

	public String home(Model model) {
		model.addAttribute("mynome", "Giovanni");
		return "index";
	}
}

package com.example.UserFeedback.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.UserFeedback.entities.Feedback;


@Controller
public class TestFormController {

	 @GetMapping("/")
     public String showIndexPage(ModelMap model){  
		 return "index";
     }
	 
	 @GetMapping(value="/testform")
     public String showTestForm(ModelMap model) { 
		 return "testform";
     }
	 
	// @PostMapping("/testform")
	// TODO: implement form submission
	// TODO: add View JSP
	// TODO: Call RestTemplate and make POST json request to localhost:8090/feedback
}
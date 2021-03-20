package com.example.UserFeedback.controllers;

import org.apache.tomcat.util.json.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserFeedback.entities.Feedback;
import com.example.UserFeedback.services.FeedbackService;

@RestController
public class FeedbackController {
	
	@Autowired
	FeedbackService feedbackService;
	 Logger logger = LoggerFactory.getLogger(FeedbackController.class);
	 
	
	@GetMapping("/feedback")
	public @ResponseBody Iterable<Feedback> getAllFeedbacks() {
        // This returns a JSON or XML with the Feedbacks
        return feedbackService.GetAllFeedback();
    }
	
	@PostMapping(value="/feedback", consumes = "application/x-www-form-urlencoded")
	public Feedback addNewFeedback(@RequestParam(value="user", required=false, defaultValue="") String name, @RequestParam(value="rating", required=false, defaultValue="") String rating, @RequestParam(value="comments", required=false, defaultValue="") String comments) {
		// TODO: Do something useful here.  
		// Add the Feedback.
		logger.info(rating);
		logger.info(name);
		logger.info(comments);
		int rate = Integer.parseInt(rating);
		Feedback fb = new Feedback();
		fb.setComments(comments);
		fb.setRating(rate);
		fb.setUser(name);
		if(fb.getComments()!=null&&fb.getRating()!=null&&fb.getUser()!=null) {
			logger.info("Adding New Feedback");
			//return "Feedback was added";  // Change this.
			return (feedbackService.save(fb));
		}
		return fb;
	}
	@PostMapping(value="/feedback", consumes = "application/json")
	public Feedback addNewFeedback2(@RequestBody Feedback fb ) {
		// TODO: Do something useful here.  
		// Add the Feedback.
		if(fb.getComments()!=null&&fb.getRating()!=null&&fb.getUser()!=null) {
			logger.info("Adding New Feedback");
			//return "Feedback was added";  // Change this.
			return (feedbackService.save(fb));
		}
		return fb;
	}

}
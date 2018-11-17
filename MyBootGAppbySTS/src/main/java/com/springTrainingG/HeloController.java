package com.springTrainingG;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HeloController {

	@RequestMapping("/{tax}")
	public ModelAndView index(@PathVariable int tax, ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("tax", tax);
		return mav;
	}
}

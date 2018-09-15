package com.springTrainingG;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HeloController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.addObject("msg", "名前を入力し、Clickを押してください。");
		mav.setViewName("index");
		return mav;
	}

	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(@RequestParam ("text1") String str, ModelAndView mav) {
		mav.addObject("msg",  str + "さんは、えらい！");
		mav.addObject("value", str);
		mav.setViewName("index");
		return mav;
	}
}

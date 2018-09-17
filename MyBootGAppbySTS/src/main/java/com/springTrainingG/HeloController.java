package com.springTrainingG;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HeloController {

	@RequestMapping("/")
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		List<String[]> data = new ArrayList<String[]>();
		data.add(new String[] {"taro", "taro@dokaben", "090-9999-1111"});
		data.add(new String[] {"hanako", "hanako@toilet", "090-2222-3333"});
		data.add(new String[] {"takuro", "takuro@bullet", "999-9999-9999"});
		mav.addObject("data", data);
		return mav;
	}

}

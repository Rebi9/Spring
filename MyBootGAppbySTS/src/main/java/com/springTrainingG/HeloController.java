package com.springTrainingG;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HeloController {

	@RequestMapping("/{num}")
	public ModelAndView index(@PathVariable int num, ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("num", num);
		if(num >= 0) {
			mav.addObject("check", "num >= data.size() ? 0 : num");
		} else {
			mav.addObject("check", "num <= data.size() * -1 ? 0 : num * -1");
		}
		List<DataObject> data = new ArrayList<DataObject>();
		data.add(new DataObject(0, "taro", "taro@okamoto"));
		data.add(new DataObject (1, "fredy", "fredy@queen"));
		data.add(new DataObject (2, "takuro", "takuro@bullet"));
		mav.addObject("data", data);
		return mav;
	}

	class DataObject {
		private int id;
		private String name;
		private String mail;

		public DataObject(int id, String name, String mail) {
			super();
			this.id = id;
			this.name = name;
			this.mail = mail;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getMail() {
			return mail;
		}

		public void setMail(String mail) {
			this.mail = mail;
		}
	}

}

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

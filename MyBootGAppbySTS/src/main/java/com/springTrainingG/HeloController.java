package com.springTrainingG;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springTrainingG.repositories.MyDataRepository;

@Controller
public class HeloController {

	@Autowired
	MyDataRepository repository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(@ModelAttribute("formModel") MyData mydata, ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("msg", "this is sample content.");
		Iterable<MyData> list = repository.findAll();
		mav.addObject("datalist", list);
		return mav;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@Transactional(readOnly=false)
	public ModelAndView form(@ModelAttribute("formModel") @Validated MyData mydata, BindingResult result, ModelAndView mav) {
		ModelAndView res = null;
		if(!result.hasErrors()) {
			repository.saveAndFlush(mydata);
			res = new ModelAndView("redirect:/");
		} else {
			mav.setViewName("index");
			mav.addObject("msg", "sorry, error is occured...");
			Iterable<MyData> list = repository.findAll();
			mav.addObject("datalist", list);
			res = mav;
		}
		return res;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@ModelAttribute MyData mydata,
			@PathVariable int id, ModelAndView mav) {
		mav.setViewName("edit");
		mav.addObject("title", "edit mydata");
		Optional<MyData> data = repository.findById((long) id);
		mav.addObject("formModel", data.get());
		return mav;
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	@Transactional(readOnly=false)
	public ModelAndView update(@ModelAttribute MyData mydata, ModelAndView mav) {
		repository.saveAndFlush(mydata);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id, ModelAndView mav) {
		mav.setViewName("delete");
		mav.addObject("title", "delete mydata.");
		Optional<MyData> data = repository.findById((long) id);
		mav.addObject("formModel", data.get());
		return mav;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView remove(@RequestParam long id, ModelAndView mav) {
		repository.deleteById(id);
		return new ModelAndView("redirect:/");
	}

	/**
	 * 初期値の設定を行うメソッド
	 */
	@PostConstruct
	public void init() {
		// 1つ目のダミーデータ
		MyData d1 = new MyData();
		d1.setName("takuro");
		d1.setAge(30);
		d1.setMail("9@takuro");
		d1.setMemo("999999999");
		repository.saveAndFlush(d1);
		// 2つ目のダミーデータ
		MyData d2 = new MyData();
		d2.setName("fredy");
		d2.setAge(45);
		d2.setMail("fredy@queen");
		d2.setMemo("888888888");
		repository.saveAndFlush(d2);
		// 3つ目のダミーデータ
		MyData d3 = new MyData();
		d3.setName("taisuke");
		d3.setAge(35);
		d3.setMail("taisuke@cat");
		d3.setMemo("777777777");
		repository.saveAndFlush(d3);
	}
}

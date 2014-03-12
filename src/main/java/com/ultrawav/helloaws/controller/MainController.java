package com.ultrawav.helloaws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ultrawav.helloaws.repository.entity.User;
import com.ultrawav.helloaws.service.RepositoryUserService;

@Controller
public class MainController {

	@Autowired
	RepositoryUserService repositoryUserService;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String main(Model model) {

		return "index";
	}
	
	@RequestMapping(value = { "/test" }, method = RequestMethod.GET)
	public String test(Model model) {
		List<User> lst = repositoryUserService.searchUserAll();
		model.addAttribute("lst", lst);
		return "list";
	}

	@RequestMapping(value = { "/test2" }, method = RequestMethod.GET)
	public String test2(Model model) {
		List<User> lst = repositoryUserService.searchUser("ultra");
		model.addAttribute("lst", lst);
		return "list";
	}
	
}

package com.demo.facade.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.common.web.response.WebResponse;
import com.demo.repository.entity.User;
import com.demo.service.UserService;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/web/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/list")
	public WebResponse list(com.demo.common.page.PageInfo pageIn) {
		PageInfo<User> users = userService.findAll();
		return WebResponse.newCorrectResponse(pageIn,users.getList(),(int)users.getTotal());
	}
}

package com.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.demo.repository.dao.UserDao;
import com.demo.repository.entity.User;
import com.demo.service.UserService;
import com.github.pagehelper.PageInfo;

@Service
public class UserServiceImpl implements UserService {
	

	@Autowired
	private UserDao userDao;
	
	public PageInfo<User> findAll(){
		return userDao.findAll();
	}
}

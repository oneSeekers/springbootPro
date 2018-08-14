package com.demo.service;


import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import com.demo.repository.entity.User;
import com.github.pagehelper.PageInfo;

@CacheConfig(cacheNames = "users")
public interface UserService {
	
	@Cacheable(cacheNames="userAll",key="userAll")
	public PageInfo<User> findAll();
}

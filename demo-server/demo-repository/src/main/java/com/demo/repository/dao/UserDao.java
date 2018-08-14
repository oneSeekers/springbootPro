package com.demo.repository.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.repository.entity.User;
import com.demo.repository.mapper.UserMapper;
import com.github.pagehelper.PageInfo;

@Repository
public class UserDao {
	
	@Autowired
	private UserMapper userMapper;
	
	public PageInfo<User> findAll(){
		return new PageInfo<User>(userMapper.selectAll());
	}

}

package com.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.repository.dao.PassSearchDao;
import com.demo.repository.entity.PassSearch;
import com.demo.service.PassSearchService;
import com.github.pagehelper.PageInfo;

@Service
public class PassSearchServiceImpl implements PassSearchService{

	@Autowired
	private PassSearchDao passSearchDao;
	
	public PageInfo<PassSearch> list(){
		return passSearchDao.list();
	}
}

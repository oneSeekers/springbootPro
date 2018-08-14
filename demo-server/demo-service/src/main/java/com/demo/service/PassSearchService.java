package com.demo.service;

import com.demo.repository.entity.PassSearch;
import com.github.pagehelper.PageInfo;

public interface PassSearchService {

	public PageInfo<PassSearch> list();
}

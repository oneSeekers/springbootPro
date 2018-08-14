package com.demo.repository.common.mapper;

import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

public interface DemoMapper<T> extends Mapper<T>
, InsertListMapper<T>{
}
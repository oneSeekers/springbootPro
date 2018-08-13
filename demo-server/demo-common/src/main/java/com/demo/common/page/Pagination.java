package com.demo.common.page;

import java.util.List;

public class Pagination<T> {
	
	/**
	 * 每页记录数
	 */
	private int pageSize;
	
	/**
	 * 总记录数
	 */
	private int count=0;
	/**
	 * 分页返回的数据
	 */
	private List<T> rows;
	
	public Pagination(int pageSize, int count, List<T> rows) {
		super();
		this.pageSize = pageSize;
		this.count = count;
		this.rows = rows;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}

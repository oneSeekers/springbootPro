package com.demo.common.page;

public class PageInfo {

	/**
	 * 当前页
	 */
	private int pageNum=1;
	
	/**
	 * 每页大小
	 */
	private int pageSize=10;

	public PageInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PageInfo(int pageNum, int pageSize) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}

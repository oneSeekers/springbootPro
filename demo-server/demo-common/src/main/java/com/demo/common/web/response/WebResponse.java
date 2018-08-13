package com.demo.common.web.response;

import java.util.List;

import com.demo.common.page.PageInfo;
import com.demo.common.page.Pagination;
import com.demo.common.web.exception.enums.WebErrCode;

public class WebResponse {
	
	public static final String CORRECT_STATUS="succ";
	public static final String ERROR_STATUS="error";
	public static final String CORRECT_CODE="2000";
	public static final String OPERAT_OK="操作成功";
	
	/**
	 * 本次请求状态
	 */
	private String status;
	
	/**
	 * 状态码
	 */
	private String code;
	
	/**
	 * 状态描述
	 */
	private String msg;
	
	/**
	 * 返回数据
	 */
	private Object data;

	public WebResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WebResponse(String status, String code, String msg, Object data) {
		super();
		this.status = status;
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	public static <T>WebResponse newCorrectResponse(PageInfo page,List<T> data,int count) {
		WebResponse response = new WebResponse();
		response.setStatus(CORRECT_STATUS);
		response.setCode(CORRECT_CODE);
		response.setMsg(OPERAT_OK);
		Pagination<T> pageData = new Pagination<T>(page.getPageSize(), count, data); 
		response.setData(pageData);
		return response;
	}
	
	public static WebResponse newCorrectResponse(String msg,Object data) {
		WebResponse response = new WebResponse();
		response.setStatus(CORRECT_STATUS);
		response.setCode(CORRECT_CODE);
		response.setMsg(msg);
		response.setData(data);
		return response;
	}
	
	public static WebResponse newCorrectResponse(Object data) {
		WebResponse response = new WebResponse();
		response.setStatus(CORRECT_STATUS);
		response.setCode(CORRECT_CODE);
		response.setMsg(OPERAT_OK);
		response.setData(data);
		return response;
	}
	
	public static WebResponse newCorrectResponse() {
		WebResponse response = new WebResponse();
		response.setStatus(CORRECT_STATUS);
		response.setCode(CORRECT_CODE);
		response.setMsg(OPERAT_OK);
		return response;
	}
	
	public static WebResponse newErrorResponse(String errCode,String errMsg) {
		WebResponse response = new WebResponse();
		response.setStatus(ERROR_STATUS);
		response.setCode(errCode);
		response.setMsg(errMsg);
		return response;
	}
	
	public static WebResponse newErrorResponse(String errCode) {
		WebResponse response = new WebResponse();
		response.setStatus(ERROR_STATUS);
		response.setCode(errCode);
		return response;
	}
	
	public static WebResponse newErrorResponse() {
		WebResponse response = new WebResponse();
		response.setStatus(ERROR_STATUS);
		response.setCode(WebErrCode.DEMO_COMMON_OPERATION_FAIL.getCode());
		response.setMsg(WebErrCode.DEMO_COMMON_OPERATION_FAIL.getMsg());
		return response;
	}
}

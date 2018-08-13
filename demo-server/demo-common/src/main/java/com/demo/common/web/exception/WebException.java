package com.demo.common.web.exception;

import com.demo.common.web.exception.enums.WebErrCode;

public class WebException extends Exception{

	public static final String DEFAULT_EXCEPTION_CODE="500";
	
	private String errCode;
	
	private String errMsg;

	public WebException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WebException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public WebException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	
	public WebException(WebErrCode errCode) {
		super(errCode.getMsg());
		this.errCode=errCode.getCode();
		this.errMsg=errCode.getMsg();
	}


	public WebException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public WebException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public WebException(String errCode, String errMsg) {
		super();
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
}

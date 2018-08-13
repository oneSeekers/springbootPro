package com.demo.common.web.exception.enums;

public enum WebErrCode {
	
	DEMO_SYS_ERROR("500001","系统异常"),
	DEMO_COMMON_OPERATION_FAIL("400001","操作失败");

	private String code;
	private String msg;

	private WebErrCode(String code, String msg) {
		this.code = code;
		this.msg = msg;
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
	
}

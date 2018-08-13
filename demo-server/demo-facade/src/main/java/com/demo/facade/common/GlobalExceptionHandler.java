package com.demo.facade.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.common.web.exception.WebException;
import com.demo.common.web.exception.enums.WebErrCode;
import com.demo.common.web.response.WebResponse;
/**
 * 全局异常处理
 * @author Administrator
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {


	
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ResponseBody
	@ExceptionHandler(WebException.class)
	public WebResponse exceptionHandler(WebException e) {
		logger.error("invoke api error",e);
		return WebResponse.newErrorResponse(e.getErrCode(),e.getErrMsg());
	}

	@ResponseBody
	@ExceptionHandler(Exception.class)
	public WebResponse exceptionHandler(Exception e) {
		logger.error("invoke api sys error",e);
		return WebResponse.newErrorResponse(WebErrCode.DEMO_SYS_ERROR.getCode(),WebErrCode.DEMO_SYS_ERROR.getMsg());
	}
	

}

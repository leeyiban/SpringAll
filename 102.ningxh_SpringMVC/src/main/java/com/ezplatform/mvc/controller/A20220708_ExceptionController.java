package com.ezplatform.mvc.controller;

import com.ezplatform.mvc.exception.ThrowException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 这个类代替了在xml中配置异常处理的作用,可以视为异常捕捉的配置信息来看
 */
@ControllerAdvice
public class A20220708_ExceptionController {
	//@ExceptionHandler用于设置所标识方法处理的异常
	@ExceptionHandler(ThrowException.class)
	//ex表示当前请求处理中出现的异常对象
	public String handleArithmeticException(Exception ex, Model model){
		model.addAttribute("ex", ex);
		return "B20220708_CatchExceptionSuccess";
	}
}

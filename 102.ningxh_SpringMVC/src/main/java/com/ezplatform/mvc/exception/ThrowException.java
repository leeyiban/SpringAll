package com.ezplatform.mvc.exception;

public class ThrowException extends RuntimeException {


	public ThrowException() {
		super();
		System.out.println("开始创建异常类");
	}

	public ThrowException(String s) {
		super(s);
		System.out.println("开始创建异常类2");

	}
}

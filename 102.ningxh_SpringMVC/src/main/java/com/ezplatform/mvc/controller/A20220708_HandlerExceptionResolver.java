package com.ezplatform.mvc.controller;

import com.ezplatform.mvc.exception.ThrowException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * SpringMVC异常处理机制
 */
@Controller
@RequestMapping("/exception")
public class A20220708_HandlerExceptionResolver {

	/**
	 * SpringMVC提供了一个处理控制器方法执行过程中所出现的异常的接口：HandlerExceptionResolver
	 * <p>
	 * HandlerExceptionResolver接口的实现类有：DefaultHandlerExceptionResolver和SimpleMappingExceptionResolver
	 * <p>
	 * SpringMVC提供了自定义的异常处理器SimpleMappingExceptionResolver，使用方式：
	 * <p>
	 * 先在Springmvc的配置文件中配置以下内容
	 * <bean class="org.springframework.web.servlet.handler.SimpleMappingExceptionResolver">
	 * <property name="exceptionMappings">
	 * <props>
	 * <!--
	 * properties的键表示处理器方法执行过程中出现的异常
	 * properties的值表示若出现指定异常时，设置一个新的视图名称，跳转到指定页面
	 * -->
	 * <prop key="java.lang.ArithmeticException">error</prop>
	 * </props>
	 * </property>
	 * <!--
	 * exceptionAttribute属性设置一个属性名，将出现的异常信息在请求域中进行共享
	 * -->
	 * <property name="exceptionAttribute" value="ex"></property>
	 * </bean>
	 */
	@RequestMapping("/catchException")
	public String catchException() {
		System.out.println("进入方法中");
		try {
			int i = 100 / 0;
		} catch (Exception e) {
			throw new ThrowException();
		}
		return "B20220708_ExceptionSuccess";

	}

}

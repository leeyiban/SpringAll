package com.ezplatform.mvc.controller;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 */
public class A20220630_Interceptor implements HandlerInterceptor {

	/**
	 * web部分有重要的三大组件 servlet, listener, filter  监听器,过滤器
	 * 而拦截器只针对Spring的handler 也就是Controller
	 * 他的执行在 filter=>dispatcherServlet=> Interceptor => controller 中间
	 *
	 */


	/**
	 * 拦截器的配置
	 * SpringMVC中的拦截器用于拦截控制器方法的执行
	 * SpringMVC中的拦截器需要实现HandlerInterceptor
	 * SpringMVC的拦截器必须在SpringMVC的配置文件中进行配置
	 */

	/**
	 * 实现了HandlerInterceptor 重写了其中的三个默认类之后
	 * 去SpringMVC的配置问价中,可以通过三种不同的方式配置Interceptior
	 */

	//其中只有preHandle才有返回值,因为其他的也拦不住
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("进入拦截器方法中");


		//返回false表示拦截,
		//这部分可以看看源码,看视频的过程感觉并不复杂
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

		System.out.println("进入postHandle中");
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		System.out.println("进入afterCompletion中");
	}
/**
	 * SpringMVC中有三个抽象方法
	 * 	 preHandle：控制器方法执行之前执行preHandle()，其boolean类型的返回值表示是否拦截或放行，返回true为放行，即调用控制器方法；返回false表示拦截，即不调用控制器方法
	 *
	 * 	 postHandle：控制器方法执行之后执行postHandle()
	 *
	 * 	 afterComplation：处理完视图和模型数据，渲染视图完毕之后执行afterComplation()
	 */

}

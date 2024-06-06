package com.ezplatform.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * springmvc-Hello,world
 */
@Controller
public class A20220215_SrpingmvcDemo_Start_Controller {
	public A20220215_SrpingmvcDemo_Start_Controller() {
		System.out.println(" ni11ng 开始构造controller");
	}

//	请求和控制器映射关系
	@RequestMapping("/")  //不仅可以通过value的方式进行匹配还可以使用请求方式\请求报文等等方式进行匹配
	public String jumpPage() {
		System.out.println(" ni11ng 进入controller");
//		只需要返回视图名称就可以了,会自动拼接视图前缀和后缀,已经在SPringmvc中配置过的
		return "index";
	}

	@RequestMapping("/target")
	public String target() {
		System.out.println("进入target");
		return "target";
	}
}

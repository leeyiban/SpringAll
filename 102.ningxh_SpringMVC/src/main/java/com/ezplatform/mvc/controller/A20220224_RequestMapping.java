package com.ezplatform.mvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 映射的规则
 */
@Controller
@RequestMapping("/mapping")
public class A20220224_RequestMapping {
	/**
	 * value不匹配报404
	 * method不匹配报405
	 * params匹配不成功:400
	 * 请求头不匹配,报404 资源未找到
	 * @return
	 */
	@RequestMapping(value = {"/requestMapping","/demo"}  //param是数组类型的,满足其中一个条件即可
					,method = {RequestMethod.POST,RequestMethod.GET} //满足其中一个条件即可
					,params = {"username","password=123"} //必须同时满足,必须有个属性名叫useranme,和一个password,值必须为123
//四种表达式  param和header是相同的
// 			Host=localhost:8080 必须有header
//			!header   必须没有
//			head=123  必须有head 且参数必须为123
//			head!=123 必须有head 且参数必须不为123
					,headers = {"Host=localhost:8080"})
	public String test() {
		return "index";
	}


	/**
	 * ant风格  一种模糊匹配value路径的方式
	 * /a?a/testAnt  其中?代表任意一个字符 当然/和?不行,这代表一个路径分隔符和参数分割,其他的都行
	 * *代表0或者多个字符
	 * **代表一层或多层目录
	 * 在使用**时,只能使用/**  /xxx的方式
	 * @return
	 */
	@RequestMapping(value = {"/a?a/testAnt"})
	public String testAnt() {
		return "index";
	}





	/**
	 * SpringMVC支持路径中的额占位符
	 * 原始方式: /deleteUser?Id=1
	 * rest风格 /deleteUser/1
	 *
	 * SpringMVC路径中的占位符常用于RESTful风格中，当请求路径中将某些数据通过路径的方式传输到服务器中，
	 * 就可以在相应的@RequestMapping注解的value属性中通过占位符{xxx}表示传输的数据，
	 * 在通过@PathVariable注解，将占位符所表示的数据赋值给控制器方法的形参
	 *
	 * @return
	 */
	@RequestMapping(value = {"/testPath/{id}"})
	public String testRest(@PathVariable("id")String id) { //
		System.out.println("id = " + id);
		return "index";
	}
}

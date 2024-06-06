package com.ezplatform.mvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.model.IModel;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 如何项域对象中共享数据
 */
@Controller
@RequestMapping("/RequestSetAttribute")
public class A20220302_RequestSetAttribute {

	//三种域对象
	//application===servletContext 整个应用的范围,就是服务器开启到服务器关闭 服务器开启时创建  只创建一次,因为用的对象是同一个,所以能共享数据
	//session 浏览器开启到浏览器关闭 钝化,服务器关闭,浏览器没关闭,session被序列化 session重新读取 session跟服务器关闭没关系,只跟浏览器关闭有关系  因为有钝化和活化
	//request 一次请求  转发是一次请求
	//pagecontext  因为不是jsp,所以在springmvc中用不到了! 他代表的是jsp的页面对象

	@RequestMapping("/index")
	public String index() {
		return "B20220320_域对象index.html";
	}

	/**
	 * 不管你用什么方法封装与数据,但是最终在springmvc中都是使用modelandview去封装的
	 * 无论是request还是map,还是modelandview
	 */


	//通过servletapi获取域数据
	//推荐使用其他四种
	@RequestMapping("testRequestByServletApi")
	public String testRequestByServletApi(HttpServletRequest request) {
		request.setAttribute("test1", "11111111111");
		//返回的字符串就是视图名称
		return "B20220320_域对象success.html";
	}


	//使用modelAndView向request域对象共享数据
	//modelandview 封装的一个是模型数据,一个是视图
	//注意返回值是modelandview!!!!
	@RequestMapping("testModelAndView")
	public ModelAndView testModelAndView() {
		ModelAndView mav = new ModelAndView();
		//处理模型数据,即向请求域requeset共享数据
		mav.addObject("testModelAndView", "hello,modelandview");
		//设置视图
		mav.setViewName("B20220320_域对象success");
		return mav;
	}


	//使用model分享域数据
	@RequestMapping("testModel")
	public String testModel(Model model) {
		model.addAttribute("testModel", "hello,testModel");
		System.out.println(model);
		System.out.println(model.getClass().getName());
		return "B20220320_域对象success";

	}


	//使用map向request域对象共享数据
	//就我感觉 map 和model几乎没有区别!!!!
	@RequestMapping("testmap")
	public String testmap(Map<String, Object> map) {
		map.put("testMap", "hello,map");
		System.out.println(map);
		System.out.println(map.getClass().getName());
		return "B20220320_域对象success";
	}


	//使用Modelmap向request域对象共享数据
	@RequestMapping("testModelmap")
	public String testModelmap(ModelMap modelmap) {
		modelmap.addAttribute("testModelmap", "hello,testModelmap");
		System.out.println(modelmap);
		System.out.println(modelmap.getClass().getName());
		return "B20220320_域对象success";
	}


	/**
	 * Model、ModelMap、Map的关系
	 * 注意:
	 * map,model都是接口,并没有办法直接存储数据,他作为方法的形参,必定接收的是实例化对象
	 * 而且modelmap虽然是类对象,但是有可能是子类传递到父类中的
	 * <p>
	 * 在后三种的方法中sout, 数据的类型是一致的,所以,
	 * 其实是同一个对象   bindingAwareModelMap对象!!!
	 * <p>
	 * public interface Model{}
	 * public class ModelMap extends LinkedHashMap<String, Object> {}
	 * public class ExtendedModelMap extends ModelMap implements Model {}
	 * public class BindingAwareModelMap extends ExtendedModelMap {}
	 */

	//向session域共享数据
	@RequestMapping("testSession")
	public String testSession(HttpSession session) {
		session.setAttribute("sessionData", "jjjjjjj");
		return "success";
	}


	//向application域共享数据
	@RequestMapping("/testApplication")
	public String testApplication(HttpSession session){
		ServletContext application = session.getServletContext();
		application.setAttribute("testApplicationScope", "hello,application");
		return "success";
	}
}
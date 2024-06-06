package com.ezplatform.mvc.controller;

import com.ezplatform.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取请求参数
 */
@Controller
@RequestMapping("/testparam")
public class A20220228_RequestParam {
	@RequestMapping("/")
	public String testParam() {
		System.out.println("11111");
		System.out.println("11111");
		System.out.println("11111");
		System.out.println("11111");
		return "testParam";
	}

	/**
	 * 如果使用  原生api
	 * 将HttpServletRequest作为控制器方法的形参，此时HttpServletRequest类型的参数表示封装了当前请求的请求报文的对象
	 */
	@RequestMapping("/testServletApi")
	public String testParam(HttpServletRequest request){   //这个request在dispatchservlet的底层被实参注入
															//大概的流程应该是,在dispatcherservlet发现你写的方法中,有一个参数的类型是httpservletrequest,并且
															//就会把他所获得到的request赋值给我们写的request中
															//我猜应该就是反射的方式,创建了对象,顺便吧request对象,住进来了
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username:"+username+",password:"+password);
		return "success";
	}

	/**
	 * 通过控制器方法的形参获取请求参数
	 * 在控制器方法的形参位置，设置和请求参数同名的形参，当浏览器发送请求，
	 * 匹配到请求映射时，在DispatcherServlet中就会将请求参数赋值给相应的形参
	 *
	 * 注：
	 *
	 * 若请求所传输的请求参数中有多个同名的请求参数，此时可以在控制器方法的形参中设置字符串数组或者字符串类型的形参接收此请求参数
	 * 若使用字符串数组类型的形参，此参数的数组中包含了每一个数据
	 * 若使用字符串类型的形参，此参数的值为每个数据中间使用逗号拼接的结果
	 */
	@RequestMapping("/testParam")
	public String testParam(String username, String password){
		System.out.println("username:"+username+",password:"+password);
		return "success";
	}


	/**
	 * 当前端发送请求到后端后,如果映射value一致,并且控制器的参数与请求url中传递的url参数名一直,救会自动的对控制器参数赋值
	 * 简单来说就是为了请求参数和控制器参数做映射
	 * 但是当参数不一致时,也可以通过@RequestParam来对参数进行匹配
	 * @RequestParam("user_name")String username
	 * required 默认为true,不给就报错  改为false就是能装配就装配,不能装配,就使用默认值
	 * @RequestParam(value="user_name",required = false,defaultValue = "hhhhh")String username
	 *
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("/differenParamName")
	public String differenParamName(@RequestParam(value="user_name",required = false,defaultValue = "hhhhh")String username, @RequestParam("password")String password){
		System.out.println("username:"+username+",password:"+password);
		return "success";
	}


	/**
	 *
	 * 4、@RequestHeader
	 * @RequestHeader是将请求头信息和控制器方法的形参创建映射关系
	 * @RequestHeader注解一共有三个属性：value、required、defaultValue，用法同@RequestParam
	 * 5、@CookieValue
	 * @CookieValue是将cookie数据和控制器方法的形参创建映射关系
	 * @CookieValue注解一共有三个属性：value、required、defaultValue，用法同@RequestParam
	 */
	@RequestMapping("/differenHeaderName")
	public String differenHeaderName(@RequestHeader(value="user_name",required = false,defaultValue = "hhhhh")String username, @CookieValue("password")String password){
		System.out.println("username:"+username+",password:"+password);
		return "success";
	}


	/**
	 * 控制器能以JavaBean的方式接收参数
	 *
	 * 重点说一下编码问题
	 * 在设置请求编码的时候,如果已经拿到了参数的时候,那么拿到的参数还是乱码
	 * 要在数据访问前设置
	 *
	 * 乱码分为两种,一个是get ,一种是post
	 * 好像只有post才会有乱码??
	 * 因为get请求的乱码是tomcat造成的,解决方法就是在toncat的server.xml
	 * 在设置端口号的地方加上urlencoding=utf-8  如果没有这个属性tomca也是乱码
	 *
	 *
	 * 如果要解决post的请求,就必须在requestdispatch加载之前就解决,因为dispatcherservlet中肯定已经取到过参数了
	 * 所以要找到一个在servlet加载之前就解决编码的问题
	 * servletliscne=>filter=>servlet
	 * 所以解决的方法,就是在web.xml中设置一个charaterencodingfilter
	 */
	@RequestMapping("/receiveBean")
	public String receiveBean(User user){
		System.out.println(user);
		return "success";
	}
}

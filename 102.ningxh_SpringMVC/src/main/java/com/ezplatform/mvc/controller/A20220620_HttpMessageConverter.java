package com.ezplatform.mvc.controller;

import com.ezplatform.mvc.bean.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * 报文转换器
 * HttpMessageConverter，报文信息转换器，将请求报文转换为Java对象，或将Java对象转换为响应报文
 * HttpMessageConverter  提供了两个注解和两个类型：@RequestBody，@ResponseBody，RequestEntity，
 * ResponseEntity
 */
@Controller
public class A20220620_HttpMessageConverter {

	/**
		requestBody
	 @RequestBody可以获取请求体，需要在控制器方法设置一个形参，使用@RequestBody进行标识，当前请求的请求体就会为当前注解所标识的形参赋值
	 */
	@RequestMapping(value = "/testRequestBody", method = RequestMethod.POST)
	public String testRequestBody(@RequestBody String body) {
		System.out.println("body = " + body);
		return "B20220620_RequestBodySuccess";
	}

	/**
	 requestEntity
	 与requestBody 不同的是,直接作为类型,展示在形参上
	 requestBody 作为在注解标注在类型前
	 RequestEntity封装请求报文的一种类型，需要在控制器方法的形参中设置该类型的形参，当前请求的请求报文就会赋值给该形参，可以通过getHeaders()获取请求头信息，通过getBody()获取请求体信息
	 */
	@RequestMapping(value = "/testRequestEntity", method = RequestMethod.POST)
	public String testRequestEntity(RequestEntity<String> entity) {
		HttpMethod method = entity.getMethod();
		System.out.println("method = " + method);
		HttpHeaders headers = entity.getHeaders();
		System.out.println("method = " + headers);

		URI url = entity.getUrl();
		System.out.println("method = " + url);

		String body = entity.getBody();
		System.out.println("method = " + body);
		return "B20220620_RequestBodySuccess";
	}


	/**
	 * @ResponseBody用于标识一个控制器方法，可以将该方法的返回值直接作为响应报文的响应体响应到浏览器
	 * 结果：浏览器页面显示success
	 */
	@RequestMapping("/testResponseBody")
	@ResponseBody
	public String testResponseBody(){
		return "success";
	}
	@RequestMapping("/testResponseBodyList")
	@ResponseBody
	public List testResponseBodyList(){
		List<String> strings = new ArrayList<String>();
		strings.add("11111");
		strings.add("222");
		strings.add("33333");
		strings.add("44444");
		return strings;
	}
	@RequestMapping("/testResponseBodyEntity")
	@ResponseBody
	public User testResponseBodyEntity(){
		/*User user = new User();
		user.setAge("12");
		user.setId("1234");
		user.setPassword("777777");
		user.setUser("zhangsan");*/
		return new User("2016","Tom","123456","12");

	}


	/**
	 * 6、@RestController注解
	 *
	 * @RestController注解是springMVC提供的一个复合注解，
	 * 标识在控制器的类上，
	 * 就相当于为类添加了@Controller注解，
	 * 并且为其中的每个方法添加了@ResponseBody注解
	 *
	 * 因为要特地在类上做测试,我暂时就不测试了
	 * 注意, 是在类上!!加注解
	 * @return
	 */
	@RequestMapping("/testAjax")
	@ResponseBody
	public String testAjax(String username, String password){
		System.out.println("username:"+username+",password:"+password);
		return "hello,ajax";
	}


}

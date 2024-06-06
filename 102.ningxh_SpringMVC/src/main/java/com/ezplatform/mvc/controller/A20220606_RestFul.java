package com.ezplatform.mvc.controller;

import com.ezplatform.mvc.bean.A20220606_RestFulTest_Employee;
import com.ezplatform.mvc.dao.A20220606_RestFulTest_EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * RESTful  (Representational State Transfer，表现层资源状态转移。)
 */
@Controller
@RequestMapping("/restful")
public class A20220606_RestFul {
	/**
	 * RESTful的实现
	 * 具体说，就是 HTTP 协议里面，四个表示操作方式的动词：GET、POST、PUT、DELETE。
	 * 它们分别对应四种基本操作：GET 用来获取资源，POST 用来新建资源，PUT 用来更新资源，DELETE 用来删除资源
	 * REST 风格提倡 URL 地址使用统一的风格设计，从前到后各个单词使用斜杠分开，不使用问号键值对方式携带请求参数，而是将要发送给服务器的数据作为 URL 地址的一部分，以保证整体风格的一致性。
	 *
	 * 操作	     传统方式	             REST风格
	 * 查询操作	getUserById?id=1	user/1-->get请求方式
	 * 保存操作	saveUser	        user-->post请求方式
	 * 删除操作	deleteUser?id=1	    user/1-->delete请求方式
	 * 更新操作	updateUser	        user-->put请求方式
	 */


	/**
	 * HiddenHttpMethodFilter
	 * 由于浏览器只支持发送get和post方式的请求，那么该如何发送put和delete请求呢？
	 * SpringMVC 提供了 HiddenHttpMethodFilter 帮助我们将 POST 请求转换为 DELETE 或 PUT 请求
	 * HiddenHttpMethodFilter 处理put和delete请求的条件：
	 * a>当前请求的请求方式必须为post
	 * b>当前请求必须传输请求参数_method
	 * 满足以上条件，HiddenHttpMethodFilter 过滤器就会将当前请求的请求方式转换为请求参数_method的值，因此请求参数_method的值才是最终的请求方式
	 * 在web.xml中注册HiddenHttpMethodFilter
	 */


	@Autowired
	@Qualifier(value = "empDao")
	private A20220606_RestFulTest_EmployeeDao empDao;

	/**
	 * 功能	            URL地址			请求方式
	 * 访问首页√	        /               GET
	 * 查询全部数据√	        /employee	    GET
	 * 删除√	            /employee/2		DELETE
	 * 跳转到添加数据页面√	/toAdd			GET
	 * 执行保存√	        /employee		POST
	 * 跳转到更新数据页面√	/employee/2		GET
	 * 执行更新√	        /employee		PUT
	 */
	@RequestMapping(value ="/employee", method = RequestMethod.GET)
	public String getemployee(Model model) {
		Collection<A20220606_RestFulTest_Employee> emps = empDao.getAll();
		model.addAttribute("emps", emps);
		return "B20220606_empList";

	}


	/*@RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
	public String deleteEmployee(@PathVariable("id") Integer id){
		empDao.save(id);
		return "redirect:/B20220606_empList";
	}*/

	//添加
	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public String add(A20220606_RestFulTest_Employee employee){
		System.out.println("1111111111");
		empDao.save(employee);
		return "redirect:/restful/employee";
	}

	//删除
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer userId) {
		System.out.println("222222");
		empDao.delete(userId);
		return "redirect:/restful/employee";
	}

	//回显
	@RequestMapping(value = "/toAdd/{id}", method = RequestMethod.GET)
	public String toAdd(@PathVariable("id") Integer userId,Model model) {
		System.out.println("222222");
		A20220606_RestFulTest_Employee user = empDao.get(userId);
		model.addAttribute("user",user);
		return "B20220620_updateEmployee";
	}

	@RequestMapping(value = "/employee", method = RequestMethod.PUT)
	public String update(A20220606_RestFulTest_Employee employee) {
		System.out.println("222222");
		empDao.save(employee);
		return "redirect:/restful/employee";
	}
}

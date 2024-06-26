package com.ezplatform.mvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件下载
 * ResponseEntity作用于方法的返回类型
 * 可以自定义控制器响应类型
 * ResponseEntity用于控制器方法的返回值类型，该控制器方法的返回值就是响应到浏览器的响应报文
 */
@Controller
public class A20220620_ResponseEntity_FileDownload {
	@RequestMapping("/download")
	public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
		//获取ServletContext对象
		ServletContext servletContext = session.getServletContext();
		//获取服务器中文件的真实路径
		String realPath = servletContext.getRealPath("/static/img/sign.png");//src\main\resources\SringMVC配套文件\笔记\SpringMVC笔记.md
		System.out.println("realPath = " + realPath);
		//创建输入流
		InputStream is = new FileInputStream(realPath);
		//创建字节数组
		byte[] bytes = new byte[is.available()];
		//将流读到字节数组中
		is.read(bytes);
		//创建HttpHeaders对象设置响应头信息
		MultiValueMap<String, String> headers = new HttpHeaders();
		//设置要下载方式以及下载文件的名字
		headers.add("Content-Disposition", "attachment;filename=1.jpg");
		//设置响应状态码
		HttpStatus statusCode = HttpStatus.OK;
		//创建ResponseEntity对象
		ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(bytes, headers, statusCode);
		//关闭输入流
		is.close();
		return responseEntity;
	}
}

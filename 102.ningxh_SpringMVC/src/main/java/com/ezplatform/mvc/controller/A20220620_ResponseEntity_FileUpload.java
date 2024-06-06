package com.ezplatform.mvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * 文件上传
 * ResponseEntity作用于方法的返回类型
 * 可以自定义控制器响应类型
 * ResponseEntity用于控制器方法的返回值类型，该控制器方法的返回值就是响应到浏览器的响应报文
 */
@Controller
public class A20220620_ResponseEntity_FileUpload {
	@RequestMapping("/upload1")
	@ResponseBody
	public String  upload(MultipartFile photo, HttpSession session, HttpServletResponse response) throws IOException {
		ServletContext con = session.getServletContext();
		String dirPath = con.getRealPath("photo");
		System.out.println("dirPath = " + dirPath);
		File file = new File(dirPath);
		if (!file.exists()) {
			file.mkdir();
		}
		String uuid = UUID.randomUUID().toString();
		String originalFilename = photo.getOriginalFilename();
		String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
		uuid = uuid.replaceAll("-", "");
		String realPath = dirPath + File.separator + uuid + suffixName;
		System.out.println("realPath = " + realPath);
		file = new File(realPath);
		photo.transferTo(file);

		return "成功了!";
	}
}

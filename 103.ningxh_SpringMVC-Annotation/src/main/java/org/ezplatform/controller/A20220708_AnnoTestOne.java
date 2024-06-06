package org.ezplatform.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/anno")
public class A20220708_AnnoTestOne {
	@RequestMapping("/test")
	@ResponseBody
	public Map test() {
		System.out.println("11111111111");
		Map<Object, Object> map = new HashMap<>();
		map.put("111", "111");
		String jsonString = JSON.toJSONString(map);
		return map;
	}
}

package com.ezplatform.webfluxxiangyingshibiancheng.webflux_注解开发.controller;

import com.ezplatform.webfluxxiangyingshibiancheng.webflux_注解开发.entity.User;
import com.ezplatform.webfluxxiangyingshibiancheng.webflux_注解开发.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
public class UserController {

	@Autowired
	private UserService userService;


	//id查询
	@GetMapping("/user/{id}")
	public Mono<User> getUserId(@PathVariable int id) {
		return userService.getUserById(id);
	}


	//查询所有
	@GetMapping("/user")
	public Flux<User> getUsers() {
		return userService.getAllUser();
	}

	//添加操作
	@GetMapping("/saveUser")
	//用Json形式传递参数
	public Mono<Void> saveUser(@RequestBody User user) {
		Mono<User> userMono = Mono.just(user);
		return userService.saveUserInfo(userMono);
	}

}

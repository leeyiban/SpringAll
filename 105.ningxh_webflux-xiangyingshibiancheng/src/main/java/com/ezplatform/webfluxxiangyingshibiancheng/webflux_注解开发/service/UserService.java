package com.ezplatform.webfluxxiangyingshibiancheng.webflux_注解开发.service;

import com.ezplatform.webfluxxiangyingshibiancheng.webflux_注解开发.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//用户操作接口
public interface UserService {

	//根据id查询用户
	Mono<User> getUserById(int id);

	//查询所有用户
	Flux<User> getAllUser();

	//添加用户
	Mono<Void> saveUserInfo(Mono<User> user);




}

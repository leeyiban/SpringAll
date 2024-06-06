package com.ezplatform.webfluxxiangyingshibiancheng.webflux_函数式编程开发.service.impl;

import com.ezplatform.webfluxxiangyingshibiancheng.webflux_函数式编程开发.entity.User;
import com.ezplatform.webfluxxiangyingshibiancheng.webflux_函数式编程开发.service.UserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * 模拟数据
 */
@Service
public class UserServiceImpl implements UserService {

	//为了模拟,创建Map结合存储数据
	private final Map<Integer, User> users = new HashMap<>();

	public UserServiceImpl() {
		users.put(1, new User("lucy", "nan", 20));
		users.put(1, new User("jack", "nan", 30));
		users.put(1, new User("ljoey", "nan", 40));
	}


	@Override
	public Mono<User> getUserById(int id) {
		return Mono.justOrEmpty(this.users.get(id));
	}

	@Override
	public Flux<User> getAllUser() {
		return Flux.fromIterable(this.users.values());
	}

	@Override
	public Mono<Void> saveUserInfo(Mono<User> userMono) {

		return userMono.doOnNext(person ->{

			//向Map集合中防止
			int id = users.size() + 1;
			users.put(id, person);


			//数据流要结束,就必须要有终止信号,否则就是无限流
			//这个是终止信号
		}).thenEmpty(Mono.empty());
	}
}

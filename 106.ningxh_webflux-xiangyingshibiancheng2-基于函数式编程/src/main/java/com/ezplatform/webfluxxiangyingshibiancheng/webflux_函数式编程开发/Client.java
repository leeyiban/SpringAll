package com.ezplatform.webfluxxiangyingshibiancheng.webflux_函数式编程开发;

import com.ezplatform.webfluxxiangyingshibiancheng.webflux_函数式编程开发.entity.User;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class Client {

	/**
	 * 我练习的时候遇到了一个错误
	 * 现在还不知道是什么原因
	 * java.io.IOException: 远程主机强迫关闭了一个现有的连接。
	 * 等待以后看看
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		WebClient webClient = WebClient.create("http://127.0.0.1:4913");
		String id = "2";
		User user = webClient.get().uri("/users/{id}", id)
				.accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToMono(User.class)
				.block();
		System.out.println(user.getName());


	}
}

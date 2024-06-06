package com.ezplatform.webfluxxiangyingshibiancheng.webflux_函数式编程开发.Handler;

import com.ezplatform.webfluxxiangyingshibiancheng.webflux_函数式编程开发.entity.User;
import com.ezplatform.webfluxxiangyingshibiancheng.webflux_函数式编程开发.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;


/**
 * 函数式编程和注解开发有所不同,因为以注解的方式开发,Springboot会自动初始化Netty服务,
 * 函数式编程需要自己初始化Netty服务器
 */
public class UserHandler {
	private final UserService userService;

	public UserHandler(UserService userService) {
		this.userService = userService;
	}

	//根据id查询
	//ServerResponse和ServerRequest这是Webflux中的两个请求响应对象,和Springmvc不同
	public Mono<ServerResponse> getUserById(ServerRequest request) {
		Integer id = Integer.valueOf(request.pathVariable("id"));
		//构建一个空值处理
		Mono<ServerResponse> notFound = ServerResponse.notFound().build();
		//调用serive方法获得数据
		Mono<User> userMono = this.userService.getUserById(id);
		//我们要将Mono<user>转换为Mono<ServerResponse>以流的形式进行传递
		//userMono现在来看其实是一个对象,我们要将她转为流
		// 把userMono进行转换,再返回
		//使用Reactor操作,flatMap 他可以把对象转为流,把多个流转成一个大流
		//ok表示操作成功,再设置类型是什么样的结构,,以Json类型.进行转换
		return userMono.flatMap(person -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(fromObject(person)))
				//如果响应结果为空,就返回一个notFound对象
				.switchIfEmpty(notFound);
	}


	//查询所有
	//这里getAllusers方法虽然不需要接收参数,但是方法在定义的时候,还是需要在方法的参数中加上ServerRequest request的
	public Mono<ServerResponse> getAllUsers(ServerRequest request) {
		Flux<User> allUser = this.userService.getAllUser();
		//
		return ServerResponse.ok().contentType(MediaType.APPLICATION_STREAM_JSON).body(allUser, User.class);
	}

	//添加
	public Mono<ServerResponse> saveUser(ServerRequest request) {
		//得到user对象
		Mono<User> userMono = request.bodyToMono(User.class);
		//build表示一个订阅,它里面有变化,我要做一些具体操作

		return ServerResponse.ok().build(this.userService.saveUserInfo(userMono));
	}


}

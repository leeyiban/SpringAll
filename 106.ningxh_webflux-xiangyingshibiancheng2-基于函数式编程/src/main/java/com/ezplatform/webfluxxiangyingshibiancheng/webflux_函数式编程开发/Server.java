package com.ezplatform.webfluxxiangyingshibiancheng.webflux_函数式编程开发;

import com.ezplatform.webfluxxiangyingshibiancheng.webflux_函数式编程开发.Handler.UserHandler;
import com.ezplatform.webfluxxiangyingshibiancheng.webflux_函数式编程开发.service.impl.UserServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.netty.http.server.HttpServer;

import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;

public class Server {
	//创建router路由
	public RouterFunction<ServerResponse> routingFunction() {

		UserServiceImpl userService = new UserServiceImpl();
		UserHandler handler = new UserHandler(userService);
		return RouterFunctions.route(
				//这样一来我们就能通过这个请求地址,路由到getUserById的方法
				//请求地址,接收类型,和调用的方法

				GET("/users/{id}").and(accept(APPLICATION_JSON)), handler::getUserById)
				//这里getAllusers方法虽然不需要接收参数,但是方法在定义的时候,还是需要在方法的参数中加上ServerRequest request的
				.andRoute(GET("/users").and(accept(APPLICATION_JSON)), handler::getAllUsers);
	}

	//创建服务器完成适配
	public void createRouterServer() {
		//完成路由和Handler的适配  路由执行具体的方法,这个叫适配
		RouterFunction<ServerResponse> routerFunction = routingFunction();
		//通过httpHandler完成handler的创建
		HttpHandler httpHandler = toHttpHandler(routerFunction);
		//适配器对象
		ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);


		//创建服务器
		HttpServer httpServer = HttpServer.create();
		//现在开始构建
		httpServer.handle(adapter).bindNow();

	}

	//开始调用
	public static void main(String[] args) throws Exception {

		Server server = new Server();
		server.createRouterServer();
		System.out.println("enter  to  exit");
		try	{
			System.in.read();
		}catch(IOException e){
			System.out.println("1111异常");
			return;
		}

	}

}

package com.ezplatform.webfluxxiangyingshibiancheng.reactor8;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestReactor {
	/**
	 * 发送方式
	 * @param args
	 */
	public static void main1(String[] args) {
		//Flux可以发送多个,但是Mono只能发送0或者1哥
		Flux.just(1, 2, 3, 4);
		Mono.just(1);

		/**
		 * 其他的发送方式
		 */
		Integer[] array = {1, 2, 3, 4};
		Flux.fromArray(array);

		List<Integer> list = Arrays.asList(array);
		Flux.fromIterable(list);

		Stream<Integer> stream = list.stream();
		Flux.fromStream(stream);

	}

	/**
	 * 发送加订阅
	 */
	public static void main(String[] args) {
		//Flux可以发送多个,但是Mono只能发送0或者1哥
		//
		/**
		 * 在没有订阅的时候是什么都不会发生的,之后使用了subscribe,进行订阅之后,才会
		 * 只有进行了订阅之后才会触发数据流
		 * 不订阅什么都不会发生
		 */
		Flux.just(1, 2, 3, 4).subscribe(System.out::print);
		Mono.just(1).subscribe(System.out::print);

		/**
		 * 其他的发送方式

		Integer[] array = {1, 2, 3, 4};
		Flux.fromArray(array);

		List<Integer> list = Arrays.asList(array);
		Flux.fromIterable(list);

		Stream<Integer> stream = list.stream();
		Flux.fromStream(stream);*/

	}

}

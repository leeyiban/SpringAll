package com.ezplatform.webfluxxiangyingshibiancheng.reactor8;

import java.util.Observable;


/**
 * 观察者模式的一种实现
 */
public class ObservDemo extends Observable {
	/**
	 * 以下内容基于Java8,但WebFlux基于的Reactor其实内核是基于java9 至以上的,所以应该不要这么写
	 * @param args
	 */
	public static void main(String[] args) {
		ObservDemo observDemo = new ObservDemo();
		//不知观察者
		//观察者发生变化
		observDemo.addObserver((o,arg)->{
			System.out.println("发生变化");
		});

		observDemo.addObserver((o,arg)->{
			System.out.println("发生变化1");
		});

		//这里有点没有弄懂,似乎是手动将状态改变成了"已修改"
		observDemo.setChanged();
		//提醒 已经修改了,是时候做出改变了
		observDemo.notifyObservers();

	}
	/**
	 * java9之后 Observer就被Flow类取代了,Observer只能算是一种伪响应式编程
	 * Reactor就是对Flow类做了封装
	 *
	 * publisher 发布者
	 * subscribe 订阅者
	 */

}

package org.example.configuration;

import org.example.bean.NingxhBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class ThreadPoolAutoConfiguration {

	@Bean(value = "ningxh")
	@ConditionalOnClass(NingxhBean.class)
	public NingxhBean MyThreadPool(){
		//return new ThreadPoolExecutor(10, 10, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));
		return new NingxhBean("ningxh");
	}
}

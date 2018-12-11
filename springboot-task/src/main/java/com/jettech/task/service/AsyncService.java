package com.jettech.task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/*
 * 异步任务
 */

@Service
public class AsyncService {

	/**
	 * 因为有一个3秒的线程存在，所以前端发出请求到service处理时要有3秒的等待时间。
	 *而如果改成多线程的方式太麻烦了，只需要在方法上加上@Async,方法就变成异步的了
	 *这样前端发出请求后会立即返回数据，service的程序该怎么运行还怎么运行
	 */
	@Async	//告诉spring这是一个异步方法，还要在入口处开启异步注解
	public void test() {
		
		long tim1 = System.currentTimeMillis();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("处理书记中……");
		long tim2 = System.currentTimeMillis();
		System.out.println(tim2-tim1+"------------------------------");
	}
}

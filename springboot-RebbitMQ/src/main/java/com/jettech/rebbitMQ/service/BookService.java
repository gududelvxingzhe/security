package com.jettech.rebbitMQ.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.jettech.rebbitMQ.bean.Book;

/*
 * 用来监听book内容的消息
 */
@Service
public class BookService {

	
	@RabbitListener(queues="jettech.news")
	public void receive(Book book) {
		System.out.println("收到消息"+book);
	}
	
	/*
	 * 获取消息头信息
	 */
	@RabbitListener(queues="jettech")
	public void getMsgHeader(Message msg) {
		System.out.println(msg.getBody());
		System.out.println(msg.getMessageProperties());
	}
}

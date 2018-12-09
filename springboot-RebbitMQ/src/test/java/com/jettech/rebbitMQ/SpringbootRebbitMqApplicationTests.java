package com.jettech.rebbitMQ;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jettech.rebbitMQ.bean.Book;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRebbitMqApplicationTests {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	
	@Autowired
	AmqpAdmin amqpAdmin;

	@Test
	public void createExchange(){

//		amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
//		System.out.println("创建完成");

//		amqpAdmin.declareQueue(new Queue("amqpadmin.queue",true));
		//创建绑定规则

//		amqpAdmin.declareBinding(new Binding("amqpadmin.queue", Binding.DestinationType.QUEUE,"amqpadmin.exchange","amqp.haha",null));
	
	}
	@Test
	public void contextLoads() {
		
		//这个方法需要自己构造message，默认message是byte[]类型的，定义消息头和消息体内容
		//rabbitTemplate.send(exchange, routingKey, message);
		
		//这个方法object被默认当成消息体只需要传入要发送的对象，自动序列化给rabbitMQ
		//rabbitTemplate.convertAndSend(routingKey, routingKey, object);
		
		Map<String, Object> message = new HashMap<>();
		message.put("msg", "这是第一个点对点消息，发给routingKey是jettech.emps的Queue");
		message.put("data", Arrays.asList("hello world",123,false));
		//对象默认使用JDK序列化后发送
		//rabbitTemplate.convertAndSend("exchange.direct", "jettech.emps", message);
		
		//发送对象类型的消息
		rabbitTemplate.convertAndSend("exchange.direct", "jettech.emps", new Book("西游记", "吴承恩"));
	}
	
	/*
	 * 要想序列化成json格式，需要写一个配置类
	 */
	@Test
	public void receive() {
		Object msg = rabbitTemplate.receiveAndConvert("jettech.emps");
		System.out.println(msg.getClass());
		System.out.println(msg);
	}

	
	/*
	 * 广播，广播用写routingKey，因为所有queue都能接收到
	 */
	@Test
	public void sendMsg() {
		rabbitTemplate.convertAndSend("exchange.fanout", "", new Book("红楼梦","曹雪芹"));
		
	}
	
}

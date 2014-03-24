package com.tr.ws.utils;

import org.apache.camel.ProducerTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContextBuilder {

	private ApplicationContext context;
	
	static SpringContextBuilder THIS = new SpringContextBuilder();
	static ProducerTemplate template;

	private SpringContextBuilder() {
		
	}

	public static SpringContextBuilder getInstance() {
		return THIS;
	}
	
	public ApplicationContext build() {
		if (context == null) {
			context = new ClassPathXmlApplicationContext("com/tr/ws/beans.xml");
		}
		return context;
	}
}

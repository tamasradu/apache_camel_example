package com.tr.some_tests;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.tr.ws.utils.SpringContextBuilder;

public class TestCase1 extends CamelTestSupport {
	
	protected static CamelContext camelContext;
	protected static ProducerTemplate template;

	@Before()
	public void setup() throws Exception {
		ApplicationContext appContext = SpringContextBuilder.getInstance()
				.build();

		camelContext = (CamelContext) appContext.getBean(CamelContext.class);
		camelContext.start();
		template = camelContext.createProducerTemplate();
	}
	
	
	@Test
	public void testAmqpConnection() {
		template.sendBody("direct:test", "HELLO WORLD");
		System.out.println("---");
	}
}

package com.tr.ws.main;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class HelloWorld {
	
	private final static String CONSUMER_ENDPOINT = "direct:hello_world";
	private final static String PRODUCER_ENDPOINT = "stream:out";

	public static void main(String[] args) throws Exception {
		
		CamelContext camelContext = new DefaultCamelContext();
		camelContext.addRoutes(new RouteBuilder() {
			@Override
			public void configure() throws Exception {
				from(CONSUMER_ENDPOINT)
					.routeId("route_id")
					.setExchangePattern(ExchangePattern.InOnly)
					.process(new Processor() {
						public void process(Exchange ex) throws Exception {
							ex.getIn().setBody("Hello World");
						}
					})
				.to(PRODUCER_ENDPOINT);				
			}
		});
		camelContext.start();
		ProducerTemplate template = camelContext.createProducerTemplate();
		template.sendBody(CONSUMER_ENDPOINT, "");
		Thread.sleep(1000L);
		camelContext.stop();
	}
}

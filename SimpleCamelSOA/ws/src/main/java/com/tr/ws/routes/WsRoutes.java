package com.tr.ws.routes;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.tr.bus.BusRoutes;
import com.tr.ws.constants.RestWsAPI;

/**
 * Web Service Camel Routes
 * 
 * @author radu.tamas
 *
 */
public class WsRoutes {
	
	@Component
	public static class GetUserRoute extends RouteBuilder {
		@Override
		public void configure() throws Exception {
			from(RestWsAPI.REST_USER_GET)
				.setExchangePattern(ExchangePattern.InOut)
				.process(new Processor() {
					public void process(Exchange exchange) throws Exception {
						String user = (String) exchange.getIn().getHeader("userId");
						exchange.getIn().setBody(user);
					}
				})
			.to(BusRoutes.GET_USER_WS_OUT);
		}
	}
	
	// TODO Add other routes 
}

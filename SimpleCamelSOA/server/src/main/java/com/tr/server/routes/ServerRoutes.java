package com.tr.server.routes;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.tr.bus.BusRoutes;
import com.tr.server.beans.MoreLogicProcessor;
import com.tr.server.beans.RegularUserControlPanel;


/**
 * Core Camel Routes
 * 
 * @author radu.tamas
 *
 */
public class ServerRoutes {

	@Component
	public static class GetUserServerRoute extends RouteBuilder {
		@Override
		public void configure() throws Exception {
			from(BusRoutes.GET_USER_SERVER_IN)
			.setExchangePattern(ExchangePattern.InOut)
			.process(new Processor() {
				public void process(Exchange exchange) throws Exception {
					String user = (String) exchange.getIn().getBody();
					if("admin".equals(user)) {
						exchange.getIn().setHeader("is_admin", true);
					}
				}
			})
			.choice()
				.when(header("is_admin").isEqualTo(true))
					.log(LoggingLevel.INFO, "Admin: ${body} logged in ")
					.to("bean:admin_bean?method=doAdminStuff")
				.otherwise()
					.log(LoggingLevel.INFO, "User: ${body} logged in ")
					.bean(RegularUserControlPanel.class, "doRegularUserStuff")
			.endChoice()
			.process(new MoreLogicProcessor());
		}
		
	}
}

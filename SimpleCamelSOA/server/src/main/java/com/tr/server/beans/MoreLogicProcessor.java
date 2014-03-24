package com.tr.server.beans;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MoreLogicProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {
		// TODO do some more logic here
		exchange.getOut().setBody("Done");
	}

}

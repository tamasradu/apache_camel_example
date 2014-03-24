package com.tr.ws.main;

import org.apache.camel.CamelContext;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import com.tr.ws.utils.SpringContextBuilder;

public class StartWs {

	private final static Logger LOG = Logger.getLogger(StartWs.class);
	
	public static void main(String args[]) throws Exception {
		
		LOG.info("Building WS application context !");
		ApplicationContext appContext = SpringContextBuilder
				.getInstance()
				.build();
		
		CamelContext cc = (CamelContext) appContext.getBean(CamelContext.class);
		cc.start();
		
		LOG.info("WS component successfully started !");
		Object obj = new Object();
		synchronized (obj) {
			obj.wait();
		}
	}
}

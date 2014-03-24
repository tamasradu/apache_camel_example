package com.tr.server.main;

import org.apache.camel.CamelContext;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import com.tr.server.main.SpringContextBuilder;

public class StartServer {

	private final static Logger LOG = Logger.getLogger(StartServer.class);
	
	public static void main(String args[]) throws Exception {
		
		LOG.info("Building Server application context !");
		ApplicationContext appContext = SpringContextBuilder
				.getInstance()
				.build();
		
		CamelContext cc = (CamelContext) appContext.getBean(CamelContext.class);
		cc.start();
		
		LOG.info("Server component successfully started !");
		Object obj = new Object();
		synchronized (obj) {
			obj.wait();
		}
	}
}

package com.tr.bus;

public interface BusRoutes {

	String GET_USER_AMQP = "activemq:amqp_queue_user_get";
	String GET_USER_WS_OUT = GET_USER_AMQP;
	String GET_USER_SERVER_IN = GET_USER_AMQP;
}

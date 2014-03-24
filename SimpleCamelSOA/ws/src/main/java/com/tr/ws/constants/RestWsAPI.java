package com.tr.ws.constants;


public interface RestWsAPI {

	String REST_USER_GET = "restlet:http://localhost:18080/user/{userId}?restletMethod=GET";
	
	String REST_USER_POST = "restlet:http://localhost:18080/user/{userId}?restletMethod=POST";
	
	String REST_USER_PUT = "restlet:http://localhost:18080/user/{userId}?restletMethod=PUT";
	
	String REST_USER_DELETE = "restlet:http://localhost:18080/user/{userId}?restletMethod=DELETE";
}


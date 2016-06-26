package com.zhangyingwei.rssreader4j.http;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.log4j.Logger;

public class HttpHandler {
	static Logger logger = Logger.getLogger(HttpHandler.class);
	public static GetMethod doGet(String url){
		logger.info(url);
		Protocol https = new Protocol("https", new HTTPSSecureProtocolSocketFactory(), 443);
		Protocol.registerProtocol("https", https);
		GetMethod get = new GetMethod(url);
		HttpClient client = new HttpClient();
		try {
			client.executeMethod(get);
		} catch (HttpException e) {
			logger.info(e);
		} catch (IOException e) {
			logger.info(e);
		}
		return get;
	}
	
	public static InputStream loadGetResponseBodyAsStream(String url){
		GetMethod get = doGet(url);
		if(get.getStatusCode()==404){
			return null;
		}else{
			try {
				return get.getResponseBodyAsStream();
			} catch (IOException e) {
				return null;
			}
		}
	}
}

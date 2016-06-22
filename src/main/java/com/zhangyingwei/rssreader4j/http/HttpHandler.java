package com.zhangyingwei.rssreader4j.http;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.protocol.Protocol;

import com.zhangyingwei.test.HTTPSSecureProtocolSocketFactory;

public class HttpHandler {
	public static GetMethod doGet(String url){
		Protocol https = new Protocol("https", new HTTPSSecureProtocolSocketFactory(), 443);
		Protocol.registerProtocol("https", https);
		GetMethod get = new GetMethod(url);
		HttpClient client = new HttpClient();
		try {
			client.executeMethod(get);
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return get;
	}
}

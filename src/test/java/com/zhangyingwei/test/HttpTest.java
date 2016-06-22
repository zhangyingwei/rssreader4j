package com.zhangyingwei.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.protocol.Protocol;

import com.zhangyingwei.rssreader4j.http.HttpHandler;


public class HttpTest {
	public static void main(String[] args) throws HttpException, IOException {
//		String result = getStringByHttps("https://luolei.org/rss/");
		GetMethod result = HttpHandler.doGet("https://luolei.org/rss/");
		System.out.println(result.getResponseBodyAsString());
		
    }
}

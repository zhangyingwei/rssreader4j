package com.zhangyingwei.rssreader4j.handler;

import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;

import com.zhangyingwei.rssreader4j.exception.RssAppException;
import com.zhangyingwei.rssreader4j.model.RssEntity;
import com.zhangyingwei.rssreader4j.model.RssHead;
import com.zhangyingwei.rssreader4j.model.RssModel;

public class RssHandler {
	
	static Logger logger = Logger.getLogger(RssHandler.class);
	/**
	 * ����RssModel����
	 * @param url
	 * @return
	 * @throws Exception 
	 */
	public static RssModel buildRssModel(String url) throws Exception{
		return new RssModel(buildRssHead(url), buildRssEntitys(url));
	}
	
	/**
	 * ����RssHead����
	 * @param url
	 * @return
	 * @throws Exception 
	 */
	public static RssHead buildRssHead(String url) throws Exception{
		RssHead rssHead = null;
		Document document = XmlHandler.readDocument(url);
		if(document!=null){
			rssHead = XmlHandler.readRssHead(document.getRootElement());
		}else{
			throw new RssAppException("@:Document is null");
		}
		return rssHead;
	}
	
	/**
	 * ����RssEntitys����
	 * @param url
	 * @return
	 * @throws Exception 
	 */
	public static List<RssEntity> buildRssEntitys(String url) throws Exception{
		List<RssEntity> rssEntitys = null;
		Document document = XmlHandler.readDocument(url);
		if(document!=null){
			rssEntitys = XmlHandler.readRssEneity(document.getRootElement());
		}else{
			logger.info("@:Document is null");
		}
		return rssEntitys;
	}
}

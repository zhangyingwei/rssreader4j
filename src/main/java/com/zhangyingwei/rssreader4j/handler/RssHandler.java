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
	 * 构建RssModel对象
	 * @param url
	 * @return
	 */
	public static RssModel buildRssModel(String url) throws RssAppException{
		return new RssModel(buildRssHead(url), buildRssEntitys(url));
	}
	
	/**
	 * 构建RssHead对象
	 * @param url
	 * @return
	 */
	public static RssHead buildRssHead(String url) throws RssAppException{
		RssHead rssHead = null;
		try {
			Document document = XmlHandler.readDocument(url);
			if(document!=null){
				rssHead = XmlHandler.readRssHead(document.getRootElement());
			}else{
				logger.info("@:Document is null");
			}
		} catch (RssAppException e) {
//			throw new RssAppException("@:build rsshead err", e);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rssHead;
	}
	
	/**
	 * 构建RssEntitys对象
	 * @param url
	 * @return
	 */
	public static List<RssEntity> buildRssEntitys(String url){
		List<RssEntity> rssEntitys = null;
		try {
			Document document = XmlHandler.readDocument(url);
			if(document!=null){
				rssEntitys = XmlHandler.readRssEneity(document.getRootElement());
			}else{
				logger.info("@:Document is null");
			}
		} catch (Exception e) {
			logger.info("@:build rssentity err");
//			throw new RssAppException("@:build rssentity err", e);
		}
		return rssEntitys;
	}
}

/**
 * 
 */
package com.ecrm.mq.topic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yang
 *
 */
public final class Topic {
	/**
	 * 业务系统和事件中心互相同步的Topic
	 */
	public static final String Event_Center_Sync_System="eventcenter-sync-system-topic";
	
	
	/**
	 * 业务系统和事件中心互相同步的Topic
	 */
	public static final String OUter_Center_Sync_System="outer-system-sync-eventcenter-topic";
	
	/**
	 * 同步到数字城管
	 */
	public static final String DataCity_Tag="todatacity";
	/**
	 * 同步到事件中心
	 */
	public static final String EventCenter_Tag="toeventcenter";
	/**
	 * //同步到联调处置
	 */
	public static final String LianDong_Tag="toliandong";//同步到联调处置
	/**
	 * 同步到日常指挥
	 */
	public static final String Zhihui_Tag="tozhihui";
	/**
	 * 同步到应急指挥
	 */
	public static final String Yingji_Tag="toyingji";
	/**
	 * 同步到运行监测
	 */
	public static final String Jiance_Tag="tojiance";
	
	
	private static Map<String,String> TOPIC_TAG=new HashMap<String, String>();
	
	private static Map<String,String> OUTER_TOPIC_TAG=new HashMap<String, String>();
	
	static {
		TOPIC_TAG.put(DataCity_Tag, Event_Center_Sync_System+":"+DataCity_Tag);
		TOPIC_TAG.put(EventCenter_Tag,  Event_Center_Sync_System+":"+EventCenter_Tag);
		TOPIC_TAG.put(LianDong_Tag,  Event_Center_Sync_System+":"+LianDong_Tag);
		TOPIC_TAG.put(Zhihui_Tag,  Event_Center_Sync_System+":"+Zhihui_Tag);
		TOPIC_TAG.put(Yingji_Tag,  Event_Center_Sync_System+":"+Yingji_Tag);
		TOPIC_TAG.put(Jiance_Tag,  Event_Center_Sync_System+":"+Jiance_Tag);
		
	}
	
	
	
	public static String takeTopicAndTag(String tag) {
		if(tag==null||"".equals(tag)) {
			return null;
		}
		return TOPIC_TAG.get(tag);
	}

}

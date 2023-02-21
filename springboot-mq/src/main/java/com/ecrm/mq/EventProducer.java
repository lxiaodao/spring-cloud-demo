/**
 * 
 */
package com.ecrm.mq;

import javax.annotation.Resource;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ecrm.mq.topic.Topic;

/**
 * @author yang
 *
 */

@Service
public class EventProducer {

	@Resource
	private RocketMQTemplate rocketMQTemplate;

	// 消息发送方法
	public void sendMessage(String topic, String msg) {
		String topic_and_tag=Topic.takeTopicAndTag(topic)!=null?Topic.takeTopicAndTag(topic):topic;
		this.rocketMQTemplate.convertAndSend(topic_and_tag, msg);
		//this.rocketMQTemplate.syncSend(destination, messages);
		
	}
}

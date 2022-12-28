/**
 * 
 */
package com.ecrm.mq;

import javax.annotation.Resource;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author yang
 *
 */

@Service
public class DataCityProducer {

	@Resource
	private RocketMQTemplate rocketMQTemplate;

	// 消息发送方法
	public void sendMessage(String topic, String msg) {
		this.rocketMQTemplate.convertAndSend(topic, msg);
	}
}

/**
 * 
 */
package com.ecrm.mq;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author yang
 *
 */
@Service
@RocketMQMessageListener(consumerGroup = "eventConsumerGroup", topic = "event-center-datacity")
public class EventConsumer implements RocketMQListener<String> {

	@Override
	public void onMessage(String message) {
		 System.out.println("=========Recived message: " + message);
		
	}

}

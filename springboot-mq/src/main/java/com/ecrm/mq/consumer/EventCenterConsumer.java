/**
 * 
 */
package com.ecrm.mq.consumer;

import org.apache.rocketmq.client.consumer.listener.MessageListener;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author yang
 *
 */
@Service
@RocketMQMessageListener(consumerGroup = "eventConsumerGroup", topic = "eventcenter-sync-system-topic",
selectorType=SelectorType.TAG,selectorExpression="toeventcenter",consumeMode=ConsumeMode.ORDERLY)
public class EventCenterConsumer implements RocketMQListener<String> {
	//eventcenter-sync-system-topic:toeventcenter    maxReconsumeTimes=5

	@Override
	public void onMessage(String message) {
		
		 System.out.println("=========EventCenterConsumer Recived message: " + message);
		
	}

}

/**
 * 
 */
package com.ecrm.mq;

import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @author yang
 *
 */
@Service
@RocketMQMessageListener(consumerGroup = "datacityConsumerGroup", topic = "eventcenter-sync-system-topic",
selectorType=SelectorType.TAG,selectorExpression="todatacity",consumeMode=ConsumeMode.ORDERLY)
public class DataCityEventConsumer implements RocketMQListener<String> {
    //maxReconsumeTimes=5
	@Override
	public void onMessage(String message) {
		System.out.println("DataCityEventConsumer=========Recived message: " + message);
		
	}
	
	//eventcenter-sync-system-topic:todatacity

}

/**
 * 
 */
package com.ecrm.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yang
 *
 */
@RestController
@RequestMapping("/mq")
public class ProducerController {
	
	@Autowired
	private DataCityProducer dataCityProducer;

	@GetMapping("/sendMessage")
	public String sendMessage(String message) {
		// @RequestParam("message")

		dataCityProducer.sendMessage("TestTopic", "事件消息吗，dong street.");
		return "消息发送完成";
	}

}

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
	private EventProducer eventProducer;

	@GetMapping("/sendMessage")
	public String sendMessage(String tag,String message) {
		// @RequestParam("message")
		eventProducer.sendMessage(tag, message);
		return "消息发送完成";
	}

}

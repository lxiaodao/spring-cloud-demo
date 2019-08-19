/**
 * 
 */
package com.saas.inventory.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangliu
 *
 */
@RestController
public class SimpleController {
	
	@GetMapping("/")
	public String helloWorld() {
		return "Hello World";
	}

}

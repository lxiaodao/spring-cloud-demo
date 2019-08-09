/**
 * 
 */
package com.saas.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.saas.common.Message;
import com.saas.dto.ProductWithTypeName;
import com.saas.inventory.service.InventoryManagerService;

/**
 * @author yangliu
 *
 */
//@RestController
@Controller
public class InventoryManagerController {
	
	@Autowired
	InventoryManagerService inventoryManagerService;
	
	
	@RequestMapping(value="inventory/product",method = RequestMethod.GET)	
	@ResponseBody
	public Message findProduct(String pname,String typeName) {
		
		List<ProductWithTypeName> list=inventoryManagerService.findProduct(pname, typeName);
		
		return Message.success(list);
		
	}
	
	@RequestMapping(value="getme",method = RequestMethod.GET)
	@ResponseBody
	public Message getJson( ){		
		return new Message("8888","recieveJson is success.");
		
	}
	

}

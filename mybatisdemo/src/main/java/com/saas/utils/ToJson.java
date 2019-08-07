/**
 * Copyright (c) 2011-2013 iTel Technology Inc,All Rights Reserved.
 */
	
package com.saas.utils;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.log4j.Log4j2;


/**
 * @ClassName: ToJson
 * @Description: TODO
 * @author Administrator
 * @date 2013年11月20日 下午2:29:43
 */
@Log4j2
public final class ToJson {

	public static String toJson(Object o) {
	
		try {
			return new ObjectMapper().writeValueAsString(o);
		} catch (Exception e) {
			log.error("convert object to json string fail:"+o.toString(),e);
			throw new RuntimeException("toJson error",e);
		}
		
	}
	
	public static <T> T convertJsonToObject(String json,Class<T> aclass){
		try {
			return new ObjectMapper().readValue(json, aclass);
		} catch (IOException e) {
			log.error("convert json to object fail:"+json,e);
			throw new RuntimeException("convertJsonToObject error",e);
		}
		
	}
	public static <T> List<T> convertJsonArrayToList(String jsonArray,Class<T> aclass) {
		
		ObjectMapper mapper=new ObjectMapper();
		try {
			return mapper.readValue(jsonArray, mapper.getTypeFactory().constructCollectionType(List.class, aclass));
		} catch (IOException e) {
			log.error("convert json array to List fail:"+jsonArray,e);
			throw new RuntimeException("convertJsonArrayToList error",e);
		}
	}
	
}

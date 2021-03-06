package com.emarket.util;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;




/**
 * String operations defined here
 * @author Fahreza Tamara
 *
 */
public class StringUtil {
	
	private Logger log = LoggerFactory.getLogger(StringUtil.class);

	/**
	 * Check if the string is empty
	 * @param text
	 * @return true if the string is null or empty string, false otherwise
	 */
	public static boolean isEmpty(Object text) {
		if(text == null || "".equals(text)) {
			return true;
		} 
		return false;
		
	}
	
	/**
	 * Replace the string, if empty or null
	 * @param text
	 * @param replacement
	 * @return replacement string as specified in parameter, if the string is null
	 */
	public static Object replaceEmpty(Object text, String replacement) {
		if(isEmpty(text)) {
			return replacement;
		} 
		return text;		
	}
	
	/**
	 * Change the specified integer into letter, for example 1 => A , 2 => B until 26 => Z
	 * @param i
	 * @return String letter
	 */
	public static String getCharForNumber(int i) {
	    return i > 0 && i < 27 ? String.valueOf((char)(i + 'A' - 1)) : null;
	}
	
	/**
	 * Check the string contains in array
	 * @param text
	 * @param arrayStr
	 * @return true if the string exist, false otherwise
	 */
	public static Boolean inArray (String text, Object[] arrayStr) {
		if(ArrayUtils.contains(arrayStr, text)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Convert collection object into single string with delimiter
	 * @param collection
	 * @param delimiter
	 * @return string with delimiter 
	 */
	public static String joinListDelimited(Collection<?> collection, String delimiter) {
		return StringUtils.join(collection,delimiter);
	}
	
	public static List<String> listStringDelimited (String text, String delimiter) {
		return Stream.of(text.split(delimiter))
        .collect(Collectors.toList());
	}
	
	/**
	 * Convert json string into Java object
	 * @param <T> 
	 * @param json string
	 * @return WebHook Object
	 */
	@SuppressWarnings("unchecked")
	public <T> T convertToObject (String json, Class<?> clazz) {
		try {
			// Replace null values with empty String, it means something changed to empty
			json = json.replaceAll("null", "\"\"");
			log.info("Convert json to object, json string :"+json);
			
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			T jsobObj = (T) mapper.readValue(json, clazz);

			return (T) jsobObj;
		} catch (Exception e) {
			log.debug("ERROR CONVERTING TO OBJECT : "+e.getMessage());
		}
		return null;
	}
	
	
}
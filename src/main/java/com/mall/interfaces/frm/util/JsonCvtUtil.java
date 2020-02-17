package com.mall.interfaces.frm.util;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 복사해옴
 * 
 * @since 2020-01-17
 * @author fixalot@lotte.net
 */
public class JsonCvtUtil {
	private static final Logger logger = LoggerFactory.getLogger(JsonCvtUtil.class);

	private JsonCvtUtil() {}

	public static String objectToJson(Object cvtObject) {
		return objectToJson(cvtObject, Include.NON_NULL);
	}

	/**
	 * 기존 메서드에서 Include 부분만 확장
	 * 
	 * @param cvtObject
	 * @param include
	 * @return
	 * @since 2020-02-11
	 * @author fixalot@lotte.net
	 */
	public static String objectToJson(Object cvtObject, Include include) {
		String cvtJson = null;

		if (cvtObject == null) {
			return null;
		}

		ObjectMapper mapper = new ObjectMapper();

		mapper.setSerializationInclusion(include);
		try {
			// Convert object to JSON string
			cvtJson = mapper.writeValueAsString(cvtObject);
			logger.debug(cvtJson);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		return cvtJson;
	}

	@SuppressWarnings("unchecked")
	public static HashMap<String, String> objectToMap(Object obj) {
		ObjectMapper oMapper = new ObjectMapper();
		HashMap<String, String> map = null;
		try {
			map = oMapper.convertValue(obj, HashMap.class);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return map;
	}

	public static <T> T jsonToObject(Class<T> boundClass, String json, boolean failOnUnknownProperties, boolean failOnUnresolvedObjectIds) throws Exception {
		return jsonToObject(boundClass, json, failOnUnknownProperties, failOnUnresolvedObjectIds, true);
	}

	@SuppressWarnings("unchecked")
	public static <T> T jsonToObject(Class<T> boundClass, String json, boolean failOnUnknownProperties, boolean failOnUnresolvedObjectIds, boolean acceptSingleValueAsArray) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		Object bean = null;
		try {
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, failOnUnknownProperties);
			mapper.configure(DeserializationFeature.FAIL_ON_UNRESOLVED_OBJECT_IDS, failOnUnresolvedObjectIds);
			mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, acceptSingleValueAsArray);
			bean = mapper.readValue(json, boundClass);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return (T) bean;
	}
}
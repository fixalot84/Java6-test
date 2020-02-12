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
			logger.error("Exception[e] :: " + e.toString());
		}

		return cvtJson;
	}

	@SuppressWarnings("unchecked")
	public static <T> T jsonToObject(Class<T> boundClass, String json, boolean ignoreUnknownProperties) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		Object bean = null;
		try {
			if (ignoreUnknownProperties) {
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			}
			bean = mapper.readValue(json, boundClass);

		} catch (Exception e) {
			logger.error("Exception[e] :: " + e.toString());
//            throw e;
		}

		return (T) bean;
	}

	public static <T> T jsonToObject(Class<T> boundClass, String json) throws Exception {
		return jsonToObject(boundClass, json, false);
	}

	@SuppressWarnings("unchecked")
	public static <T> T jsonToObjectCoupang(Class<T> boundClass, String json) throws Exception {

		ObjectMapper mapper = new ObjectMapper();
		Object bean = null;
		try {
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			mapper.configure(DeserializationFeature.FAIL_ON_UNRESOLVED_OBJECT_IDS, false);
			bean = mapper.readValue(json, boundClass);

		} catch (Exception e) {
			logger.error("Exception[e] :: " + e.toString());
//            throw e;
		}

		return (T) bean;
	}

	/**
	 * json => object 변환<br>
	 * FAIL_ON_UNRESOLVED_OBJECT_IDS 조건 추가함.
	 * 
	 * @param <T>
	 * @param boundClass
	 * @param json
	 * @param ignoreUnknownProperties
	 * @param ignoreUnresolvedObjectIds
	 * @return
	 * @throws Exception
	 * @since 2020-01-16
	 * @author fixalot@lotte.net
	 */
	@SuppressWarnings("unchecked")
	public static <T> T jsonToObject(Class<T> boundClass, String json, boolean ignoreUnknownProperties, boolean ignoreUnresolvedObjectIds) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		Object bean = null;
		try {
			if (ignoreUnknownProperties) {
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			}
			if (ignoreUnresolvedObjectIds) {
				mapper.configure(DeserializationFeature.FAIL_ON_UNRESOLVED_OBJECT_IDS, false);
			}
			bean = mapper.readValue(json, boundClass);
		} catch (Exception e) {
			logger.error("Exception[e] :: " + e.toString());
		}
		return (T) bean;
	}

	@SuppressWarnings("unchecked")
	public static HashMap<String, String> objectToMap(Object obj) {

		ObjectMapper oMapper = new ObjectMapper();
		HashMap<String, String> map = null;
		try {
			map = oMapper.convertValue(obj, HashMap.class);
		} catch (Exception e) {
			logger.error("Exception[e] :: " + e.toString());
//            throw e;
		}

		return map;
	}
}
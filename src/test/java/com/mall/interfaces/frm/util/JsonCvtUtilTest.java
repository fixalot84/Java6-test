package com.mall.interfaces.frm.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 복사해온 JsonCvtUtil 테스트 유닛
 * 
 * @since 2020-01-17
 * @author fixalot@lotte.net
 */
public class JsonCvtUtilTest {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(JsonCvtUtilTest.class);

	@Test
	public void testJsonToObject() throws Exception {
		String jsonString = "{}";
		ResponseVO result = JsonCvtUtil.jsonToObject(ResponseVO.class, jsonString, true, true);
		Assert.assertEquals("ResponseVO [returnCode=null, message=null, subMessages=null, dataCount=null, data=null]", result.toString());

		jsonString = "{ \"returnCode\": \"3000\", \"message\": \"조회내역이 없습니다.\", \"subMessages\": null, \"dataCount\": null, \"data\": null }";
		result = JsonCvtUtil.jsonToObject(ResponseVO.class, jsonString, true, true);
		Assert.assertEquals("ResponseVO [returnCode=3000, message=조회내역이 없습니다., subMessages=null, dataCount=null, data=null]", result.toString());

		jsonString
				= "{ \"returnCode\": \"0000\", \"message\": \"정상 처리되었습니다.\", \"subMessages\": null, \"dataCount\": 1, \"data\": [{\"spdNo\": \"LI1001967458\", \"resultCode\": \"8888\", \"resultMessage\": \"상품이 존재하지 않습니다.\"} ] }";
		result = JsonCvtUtil.jsonToObject(ResponseVO.class, jsonString, true, true);
		Assert.assertEquals("ResponseVO [returnCode=0000, message=정상 처리되었습니다., subMessages=null, dataCount=1, data=[{spdNo=LI1001967458, resultCode=8888, resultMessage=상품이 존재하지 않습니다.}]]",
				result.toString());
		Assert.assertEquals(ArrayList.class, result.getData().getClass());
		Assert.assertEquals(LinkedHashMap.class, result.getData().get(0).getClass());
	}

	@Test
	public void shouldBeError() throws Exception {
		JsonCvtUtil.jsonToObject(ResponseVO.class, "");
	}
}

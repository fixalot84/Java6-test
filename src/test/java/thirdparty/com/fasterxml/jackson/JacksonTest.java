package thirdparty.com.fasterxml.jackson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * com.fasterxml.jackson 테스트 유닛
 * 
 * @since 2020-01-17
 * @author fixalot@lotte.net
 */
public class JacksonTest {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(JacksonTest.class);

	private ObjectMapper mapper = new ObjectMapper();

	@Test
	public void testParseArrayOrObject() throws JsonParseException, JsonMappingException, IOException {
		mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(DeserializationFeature.FAIL_ON_UNRESOLVED_OBJECT_IDS, false);
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

		String text = "{\"aaa\": \"Hello world!\", \"bbb\": \"due\"}";
//		String text = "{\"aaa\": \"Hello world!\", \"bbb\": [\"one\", \"two\"]}";

		Vo a = mapper.readValue(text, Vo.class);
		Assert.assertNotNull(a);
		Assert.assertEquals(1, a.getBbb().size());
	}

	/**
	 * JSON 문자열 -> 인스턴스
	 * 
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @author fixalot
	 */
	@Test
	public void testReadValue() throws JsonParseException, JsonMappingException, IOException {
		String jsonText = "[{\"html1\":\"<p>홀홀</p>\",\"html2\":\"<p>ㅗㅎ롷ㄹ</p>\"}]";
		final List<HashMap<String, Object>> collection = mapper.readValue(jsonText, new TypeReference<ArrayList<HashMap<String, Object>>>() {});
		Assert.assertEquals(1, collection.size());
		Assert.assertEquals("<p>홀홀</p>", collection.get(0).get("html1"));
		Assert.assertEquals("<p>ㅗㅎ롷ㄹ</p>", collection.get(0).get("html2"));
		Assert.assertEquals(ArrayList.class, collection.getClass());
		Assert.assertEquals(HashMap.class, collection.get(0).getClass());
	}

	@Test
	public void testReadValueWithAmbiguousTypeDeclare() throws IOException {
		String jsonText = "[{\"html1\":\"<p>홀홀</p>\",\"html2\":\"<p>ㅗㅎ롷ㄹ</p>\"}]";
		final List<Object> collection = mapper.readValue(jsonText, new TypeReference<List<Object>>() {});
		Assert.assertEquals(1, collection.size());
		Assert.assertEquals(ArrayList.class, collection.getClass());
		Assert.assertEquals(LinkedHashMap.class, collection.get(0).getClass());
	}

	/**
	 * 인스턴스 -> JSON 문자열
	 * 
	 * @throws JsonProcessingException
	 * @author fixalot
	 */
	@Test
	public void testWriteValue() throws JsonProcessingException {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("name", "steave");
		map.put("age", "32");
		map.put("job", "baker");
		final String jsonText = mapper.writeValueAsString(map);
		Assert.assertEquals("{\"age\":\"32\",\"name\":\"steave\",\"job\":\"baker\"}", jsonText);
	}

	/**
	 * 컬렉션 -> Plain Object로 변환
	 * 
	 * @author fixalot
	 */
	@Test
	public void testConvertValue() {
		// #1: map -> po
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", "steave");
		map.put("age", "32");
		map.put("dead", "true");

		PlainObject po = mapper.convertValue(map, PlainObject.class);
		Assert.assertEquals("steave", po.getName());
		Assert.assertEquals(Integer.valueOf(32), po.getAge());

		// #2: list<map> -> po
		HashMap<String, Object> map2 = new HashMap<String, Object>();
		map2.put("name", "soap");
		map2.put("age", 43);
		map2.put("dead", true);

		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		list.add(map);
		list.add(map2);

		ArrayList<PlainObject> poList = mapper.convertValue(list, new TypeReference<ArrayList<PlainObject>>() {});
		Assert.assertEquals("soap", poList.get(1).getName());
		Assert.assertEquals(Integer.valueOf(32), poList.get(0).getAge());
		Assert.assertEquals(Integer.valueOf(43), poList.get(1).getAge());
		Assert.assertEquals(true, poList.get(0).isDead());
		Assert.assertEquals(true, poList.get(1).isDead());
	}
}

class Vo {
	private String aaa;
	private List<String> bbb;

	public String getAaa() {
		return aaa;
	}

	public void setAaa(String aaa) {
		this.aaa = aaa;
	}

	public List<String> getBbb() {
		return bbb;
	}

	public void setBbb(List<String> bbb) {
		this.bbb = bbb;
	}
}
package jdk.statement;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 테스트 유닛: 자바 타입 캐스트
 * 
 * @since 2019-12-27
 * @author fixalot@lotte.net
 */
public class CastTest {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(CastTest.class);

	/**
	 * null을 캐스팅해도 당장 NPE가 발생하지는 않는다.
	 * 
	 * @since 2019-12-27
	 * @author fixalot@lotte.net
	 */
	@Test
	public void sholdBeNull() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("k", null);

		String a = (String) map.get("k");
		Assert.assertNull(a);
	}
}

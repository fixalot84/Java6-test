package jdk.java.lang;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * java.lang.Long, long 테스트 유닛
 * 
 * @since 2019-12-26
 * @author fixalot@lotte.net
 */
public class LongTest {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(LongTest.class);

	@Test
	public void testToString() {
		Assert.assertEquals("12", Long.toString(12L));
	}
}

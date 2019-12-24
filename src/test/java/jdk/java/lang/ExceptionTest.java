package jdk.java.lang;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 예외 테스트 유닛
 * 
 * @since 2019-12-23
 * @author fixalot@lotte.net
 */
public class ExceptionTest {
	private static final Logger logger = LoggerFactory.getLogger(ExceptionTest.class);

	@Test
	public void test() {
		try {
			@SuppressWarnings("unused")
			int nan = 1 / 0;
		} catch (Exception e) {
//			logger.debug(e.getMessage()); // 이렇게 하면 예외 메시지만 나옴.
			logger.debug(e.getMessage(), e);
		}
		Assert.assertTrue(true);
	}
}

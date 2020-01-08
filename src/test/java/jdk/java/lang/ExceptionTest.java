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
//			logger.debug(e.toString()); // 이렇게 하면 예외 클래스 + 예외 메시지만 나옴.
			logger.debug(e.getMessage(), e);
//			logger.debug("", null, null, null, null, null, null, null);
		}
		Assert.assertTrue(true);
	}
	
	@Test
	public void testExceptionClass() {
		try {
			@SuppressWarnings("unused")
			int nan = 1 / 0;
		} catch (Exception e) {
			Assert.assertNull(e.getCause());
			Assert.assertEquals(e.getMessage(), e.getLocalizedMessage());
		}
	}
	
	/**
	 * catch문 작성 순서는 매우 중요하며, 아무렇게나 작성하면 컴파일 에러가 발생할 수 있다.<br>
	 * 아래의 경우 catch 우선순위는 RuntimeException, Exception, IllegalArgumentException순이다. 즉, catch 우선순위는 작성 순서를 따른다.<br>
	 * 그리고 try문 바디에서 IllegalArgumentException을 throw 하더라도 'Exception' catch문에서 흡수해버리므로(부모를 잡으라고 작성하면 자식도 잡힘)<br>
	 * 'IllegalArgumentException' catch문은 있으나 마나한 코드가 되는 것이다.
	 * 
	 * @author noritersand
	 */
	@Test
	public void catchOrder() {
		try {
			int a = 0;
			if (a == 0) {
				throw new IllegalArgumentException();
			}
		} catch (RuntimeException e) {
			// do nothing
		} catch (Exception e) {
			// do nothing
//		} catch (IllegalArgumentException e) { // 이 코멘트를 풀면 컴파일 에러 발생함: 
			// Unreachable catch block for IllegalArgumentException. It is already handled by the catch block for Exception
		}
		Assert.assertTrue(true);
	}
}

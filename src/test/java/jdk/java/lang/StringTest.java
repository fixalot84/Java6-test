package jdk.java.lang;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * java.lang.String 테스트 유닛
 * 
 * @since 2019-12-26
 * @author fixalot@lotte.net
 */
public class StringTest {
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(StringTest.class);

	/**
	 * Java6에서 Stiring은 switch 문의 조건으로 사용할 수 없음. (Java7 부터 가능) 
	 * 
	 * @since 2019-12-17
	 * @author fixalot@lotte.net
	 */
	@Test
	public void stringInSwitchCondition() {
		/*
		switch ("야") {
			case "야":
				break;
			default:
				break;
		}
		*/
		// 컴파일 에러:
		// Cannot switch on a value of type String for source level below 1.7. Only convertible int values or enum variables are permitted
		Assert.assertNotEquals(1, 2);
	}
}

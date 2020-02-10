package thirdparty.apache.lang3;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 아파치 랜덤유틸 테스트 유닛
 * 
 * @since 2020-02-07
 * @author fixalot@lotte.net
 */
public class RandomUtilsTest {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(RandomUtilsTest.class);

	/**
	 * <code>RandomUtils.nextLong(min, max)</code>에서 min과 max는 랜덤값의 범위(포함)를 의미함.
	 * 
	 * @since 2020-02-07
	 * @author fixalot@lotte.net
	 */
	@Test
	public void testRange() {
		int max = 999;
		int min = 100;

		// 천만번 돌려서 검증
		for (int i = 0; i < 10000000; ++i) {
			long num = RandomUtils.nextLong(min, max);
			Assert.assertTrue(min <= num && num <= max);
		}
	}
}

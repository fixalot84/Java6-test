package jdk.java.util.regex;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 자바 정규식 테스트 유닛
 * 
 * @since 2020-03-02
 * @author fixalot@lotte.net
 */
public class RegexTest {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(RegexTest.class);

	@Test
	public void shoulBeEquals() {
		Assert.assertEquals("AA1062329819", removeTail("AA1062329819_1"));
		Assert.assertEquals("AA1062329819", removeTail("AA1062329819_2"));
		Assert.assertEquals("AA1062329819", removeTail("AA1062329819_12"));
		Assert.assertEquals("AA1062329819", removeTail("AA1062329819_199"));
		Assert.assertEquals("AA1062329819", removeTail("AA1062329819_199A"));

		Assert.assertEquals("1", extractTail("AA1062329819_1"));
		Assert.assertEquals("2", extractTail("AA1062329819_2"));
		Assert.assertEquals("12", extractTail("AA1062329819_12"));
		Assert.assertEquals("199", extractTail("AA1062329819_199"));
		Assert.assertEquals("199A", extractTail("AA1062329819_199A"));

		Assert.assertEquals("1", extractTailUsingApacheCommons("AA1062329819_1"));
		Assert.assertEquals("2", extractTailUsingApacheCommons("AA1062329819_2"));
		Assert.assertEquals("12", extractTailUsingApacheCommons("AA1062329819_12"));
		Assert.assertEquals("199", extractTailUsingApacheCommons("AA1062329819_199"));
		Assert.assertEquals("12A3", extractTailUsingApacheCommons("AA1062329819_12A3"));
	}

	public static String removeTail(String str) {
		return str.replaceAll("_\\w+", "");
	}

	public static String extractTail(String str) {
		return str.replaceAll("\\w+_", "");
	}

	public static String extractTailUsingApacheCommons(String str) {
		return StringUtils.substringAfter(str, "_");
	}
}

package jdk.java.util;

import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 
 * @since 2020-01-06
 * @author fixalot@lotte.net
 */
public class LocaleTest {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(LocaleTest.class);

	@Test
	public void testLocaleClass() {
		Assert.assertEquals("ko_KR", Locale.KOREA.toString());
		Assert.assertEquals("ko", Locale.KOREA.getLanguage());
		Assert.assertEquals("KR", Locale.KOREA.getCountry());
	}
}

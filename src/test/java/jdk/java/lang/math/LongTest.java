package jdk.java.lang.math;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LongTest {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(LongTest.class);

	@Test
	public void test() {
		Long a = new Long(100);

		BigDecimal b = new BigDecimal(100);
		long c = b.longValue();
		Long d = Long.valueOf(c);

		Assert.assertTrue(a == c);
		Assert.assertTrue(a.equals(c));
		Assert.assertTrue(a != new Long(c));
		Assert.assertTrue(a != d);
		Assert.assertTrue(a.equals(d));
	}
}

package jdk.java.lang.math;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BigDecimalTest {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(BigDecimalTest.class);

	@Test
	public void testPrecision() {
		BigDecimal n = new BigDecimal("2345.52525");
		Assert.assertEquals(9, n.precision());
	}

	@Test
	public void testScale() {
		BigDecimal n = new BigDecimal("2345.52525");
		Assert.assertEquals(5, n.scale());
	}
}

package thirdparty.com.pionnet.servlet;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pionnet.servlet.BaseParameterMap;

public class PionnetCommonsTest {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(PionnetCommonsTest.class);

	@Test
	public void shouldBeEquals() {
		Assert.assertEquals("com.pionnet.servlet.BaseParameterMap", BaseParameterMap.class);
	}

}

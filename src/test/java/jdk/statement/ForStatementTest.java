package jdk.statement;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ForStatementTest {
	private static final Logger logger = LoggerFactory.getLogger(ForStatementTest.class);

	@Test
	public void test() {
		for (int i = 0; i != 0; i++) {
			logger.debug("{}", i);
		}
	}
}

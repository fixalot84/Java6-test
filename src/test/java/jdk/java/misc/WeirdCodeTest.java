package jdk.java.misc;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 이상한 우녕 소스 검증
 * 
 * @since 2020-01-16
 * @author fixalot@lotte.net
 */
public class WeirdCodeTest {
	private static final Logger logger = LoggerFactory.getLogger(WeirdCodeTest.class);

	@Test
	public void wrongEnhancedForLoop() {
		List<Hi> list = new LinkedList<WeirdCodeTest.Hi>();
		list.add(new Hi("yo"));
		list.add(new Hi("ssup"));

		for (Hi ele : list) {
			ele = new Hi("Hello!");
			logger.debug("{}", ele);
		}

		logger.debug("{}", list);
		Assert.assertTrue(list.size() == 2);
		Assert.assertNotEquals(list.get(0), list.get(1));
	}

	private class Hi {
		public String name;

		public Hi(String name) {
			super();
			this.name = name;
		}

		@Override
		public String toString() {
			return "Hi [name=" + name + "]";
		}
	}
}

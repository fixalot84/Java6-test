package jdk.java.misc;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PassByValueTest {
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(PassByValueTest.class);

	@Test
	public void test() {
		String a = "a";
		final String b = "b";
		reassign(a);
		reassign(b);
		Assert.assertEquals("a", a);
		Assert.assertEquals("b", b); // 다른 메서드에서 재할당해봐야 안바뀜.
		
		// String만 그런가?
		
		List<String> list = new LinkedList<String>();
		int hashCode = list.hashCode();
		reassign(list);
		Assert.assertEquals(hashCode, list.hashCode()); // 높. 딴 것도 마찬가지
		
		// 자바는 언제나 'pass by value'이기 때문에 요렇다.
		// 그래서 '파라미터를 재할당하지 말 것'이라는 코딩 규칙이 의미가 있는지 싶다.
		
		mutate(list);
		Assert.assertTrue(list.size() > 0);
		Assert.assertEquals("Grr", list.get(0)); // 이건 좀 얘기가 다름
	}
	
	private void reassign(String arg) {
		arg = "c"; // 이것은 new String("c")와 같다.
	}
	
	private void reassign(List<String> arg) {
		arg = new LinkedList<String>();
	}
	
	private void mutate(List<String> arg) {
		arg.add("Grr");
	}
}

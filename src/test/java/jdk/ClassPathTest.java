package jdk;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JDK8 클래스패스 테스트 유닛
 * 
 * @since 2017-07-27
 * @author fixalot
 */
public class ClassPathTest {
//	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ClassPathTest.class);

	@Test
	public void getClasspaths() {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Assert.assertTrue(loader instanceof URLClassLoader);
		URL[] url = ((URLClassLoader) (Thread.currentThread().getContextClassLoader())).getURLs();
		logger.debug(Arrays.toString(url));
	}

	@Test
	public void accessFileAtClasspath() throws URISyntaxException, IOException {
		ClassLoader loader = ClassPathTest.class.getClassLoader();
		URL url = loader.getResource("test.txt");
		Assert.assertNotNull("파일이 음슴", url);
		File file = new File(url.toURI());
		Assert.assertTrue(file.exists());
	}

	@Test
	public void getResource() {
		URL url = this.getClass().getResource("");
		logger.debug("{}", url); // file:/C:/dev/git/laboratory/target/test-classes/laboratory/jdk/
	}
}

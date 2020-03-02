package misc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 아무거나 해보는 클래스.<br>
 * 주의: 작성한 코드의 행방을 보장하지 않음.
 * 
 * @since 2020-01-15
 * @author fixalot@lotte.net
 */
public class TryEverything {
	private static final Logger logger = LoggerFactory.getLogger(TryEverything.class);

	public static void main(String[] args) {
		try {


		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			System.exit(1);
		}
	}

}

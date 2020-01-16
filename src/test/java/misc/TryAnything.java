package misc;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 아무거나 해보는 클래스.<br>
 * 주의: 코드의 안전을 보장하지 않음.
 * 
 * @since 2020-01-15
 * @author fixalot@lotte.net
 */
public class TryAnything {
	private static final Logger logger = LoggerFactory.getLogger(TryAnything.class);

	public static void main(String[] args) {
		long now = System.currentTimeMillis();
		Date date = new Date(now);
		SimpleDateFormat sdfNOW = new SimpleDateFormat("yyyyMMdd-HHmmss");
		final String date1 = sdfNOW.format(date);

		logger.debug(date1);
	}

}

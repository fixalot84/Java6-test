package jdk.java.lang;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * java.lang.String 테스트 유닛
 * 
 * @since 2019-12-26
 * @author fixalot@lotte.net
 */
public class StringTest {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(StringTest.class);

	/**
	 * Java6에서 Stiring은 switch 문의 조건으로 사용할 수 없음. (Java7 부터 가능) 
	 * 
	 * @since 2019-12-17
	 * @author fixalot@lotte.net
	 */
	@Test
	public void stringInSwitchCondition() {
		/*
		switch ("야") {
			case "야":
				break;
			default:
				break;
		}
		*/
		// 컴파일 에러:
		// Cannot switch on a value of type String for source level below 1.7. Only convertible int values or enum variables are permitted
		Assert.assertNotEquals(1, 2);
	}

	@Test
	public void testReplaceAll() {
		String str = "[롯데온]\r\n\r\n안녕하세요 롯데홈 담당자입니다. \r\n해당 상품은 분실로 인한 미배송으로 불핀드려 죄송합니다. \r\n\r\n배송 원하실 경우 재배송 가능하오니 확인 바랍니다.";
		logger.debug("{}", str);
		str = str.replaceAll("\\r", "").replaceAll("\\n", "");
		Assert.assertEquals("[롯데온]안녕하세요 롯데홈 담당자입니다. 해당 상품은 분실로 인한 미배송으로 불핀드려 죄송합니다. 배송 원하실 경우 재배송 가능하오니 확인 바랍니다.", str);
	}

	@Test
	public void testSplit() {
		String[] a = splitOrderNumber("주문번호1:주문순번1,주문번호2:주문순번2,주문번호3:주문순번3");
		String[] b = splitOrderNumber("주문번호1,주문순번1:주문번호2,주문순번2:주문번호3,주문순번3");
		logger.debug("{}, {}", a[0], a[1]);
		logger.debug("{}, {}", b[0], b[1]);
	}

	private String[] splitOrderNumber(String str) {
		String ordNoList = "";
		String ordSnNoList = "";
		String[] ordDetailArray = str.split("\\:");
		if (ordDetailArray.length == 2) {
			if (!"".equals(ordNoList)) {
				ordNoList += ",";
			}
			ordNoList += ordDetailArray[0];
			if (!"".equals(ordSnNoList)) {
				ordSnNoList += ",";
			}
			ordSnNoList += ordDetailArray[1];
		}
		return new String[] { ordNoList, ordSnNoList };
	}
}

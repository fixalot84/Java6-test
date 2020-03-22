package misc;

import java.util.Scanner;

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
		    int[] numArray = new int[10];
		    int num;

		    for (int i = 0; i < 10; i++) {
		    	System.out.printf("intput : ");
		    	Scanner scan = new Scanner(System.in);
				num = scan.nextInt();
		        numArray[i] = num;
		    }
		    oddCheck(numArray);
		    evenCheck(numArray);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			System.exit(1);
		}
	}

	public static void oddCheck(int[] param) {
		for (int i = 0; i < 10; i++) {
			if (param[i] % 2 == 1) {
				System.out.printf("%d ", param[i]);
			}
		}
		System.out.printf("\n");
	}

	public static void evenCheck(int[] param) {
		for (int i = 0; i < 10; i++) {
			if (param[i] % 2 == 0) {
				System.out.printf("%d ", param[i]);
			}
		}
		System.out.printf("\n");
	}
}

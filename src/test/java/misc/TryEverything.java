package misc;

/**
 * 아무거나 해보는 클래스.<br>
 * 주의: 작성한 코드의 행방을 보장하지 않음.
 * 
 * @since 2020-01-15
 * @author fixalot@lotte.net
 */
public class TryEverything {
	public static void main(String[] args) {
		int n = 10;
		hello: if (n > 0) {
			System.out.println("야");
			if (n == 10) {
				System.out.println("왜");
				break hello;
			}
			System.out.println("호 나는"); // 실행 안함
		}

		char c = 'A';
		yoohoo: {
			if (c == 'A') {
				System.out.println("유후~");
				break yoohoo;
			}
			System.out.println("여기 오면 안돼");
		}

	}
}

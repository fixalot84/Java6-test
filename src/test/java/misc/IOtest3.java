package misc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOtest3 {

	final static String FILE_NAME = ""; // 수정할 Input Text 파일 경로
	final static String FILE_NAME_Out = ""; // Output Text 파일 경로

	IOtest3() {

		FileWriter fw = null;

		BufferedReader br_before = null;
		BufferedWriter bw = null;

		System.out.println("버튼이 클릭되었습니다."); // 버튼 작동 확인용

		String[] geo_para = new String[alpa3.BUTTON_SIZE_1];

		/*
		for (int i=0;i<alpa3.BUTTON_SIZE_1;i++) {
			
			geo_para[i] = alpa3.textField[i].getText();
			System.out.println(geo_para[i]);
			
			}
		*/

		try {
			br_before = new BufferedReader(new FileReader(FILE_NAME));

			fw = new FileWriter(FILE_NAME_Out);
			bw = new BufferedWriter(fw);

			String readLine = null;

			int i = 0;

			while ((readLine = br_before.readLine()) != null) {

				String replaceString = alpa3.textField[i].getText(); // 문제 발생지점
				// String replaceString = geo_para[i];
				String originalString = "Geo" + i;

				if (readLine.contains(originalString)) {

					bw.write(readLine.replaceAll(originalString, replaceString));
					bw.newLine();

					i = i + 1;

				} else {
					bw.write(readLine);
					bw.newLine();
				}
			}

			bw.flush();

		} catch (IOException e) {

			System.out.println(e);

		} finally {
			try {
				br_before.close();
			} catch (IOException e) {
			}

		}

	}
}
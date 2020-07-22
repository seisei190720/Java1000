package jp.co.worksap.ate.bootcamp.java1000.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileContentUtils {

	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	public static String getFileContents(File file, String encode) {
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer();
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file), encode));
			String lineData = null;
			while ((lineData = br.readLine()) != null) {
				sb.append(lineData);
				sb.append(LINE_SEPARATOR);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			ResourceCloser.close(br);
		}
		return sb.toString();
	}

}

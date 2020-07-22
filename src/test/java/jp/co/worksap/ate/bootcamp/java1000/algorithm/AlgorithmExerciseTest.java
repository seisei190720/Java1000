package jp.co.worksap.ate.bootcamp.java1000.algorithm;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class AlgorithmExerciseTest extends TestCase {

	private PrintStream storedStream;
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	@Before
	protected void setUp() throws Exception {
		super.setUp();
		storedStream = System.out;
	}

	@After
	protected void tearDown() throws Exception {
		System.setOut(storedStream);
		super.tearDown();
	}

	@Test
	public void testDisplayNumberHogePiyo() {
		try (
				ByteArrayOutputStream tempOutStream = new ByteArrayOutputStream();
				PrintStream printStream = new PrintStream(tempOutStream);	) {
			System.setOut(printStream);
			new AlgorithmExercise().displayNumberHogePiyo();
			String sysOutStr = tempOutStream.toString();
			String[] sysOutLines = sysOutStr.split(LINE_SEPARATOR);
			assertNotNull("出力結果が正しくありません。", sysOutLines);
			assertThat("出力結果が正しく改行されていないようです。", sysOutLines.length, is(100000));

			for (int i = 0; i < sysOutLines.length; i++) {
				// あえて、よろしくない分岐を書いている
				String tempNumberStr = String.valueOf(i + 1);
				switch ((i + 1) % 15) {
				case 3:
				case 6:
				case 9:
				case 12:
					assertThat(String.format("数字 %s に対する処理が正しくありません。", tempNumberStr), sysOutLines[i], is("hoge"));
					break;
				case 5:
				case 10:
					assertThat(String.format("数字 %s に対する処理が正しくありません。", tempNumberStr), sysOutLines[i], is("piyo"));
					break;
				case 0:
					assertThat(String.format("数字 %s に対する処理が正しくありません。", tempNumberStr), sysOutLines[i], is("hogepiyo"));
					break;
				default:
					assertThat(String.format("数字 %s に対する処理が正しくありません。", tempNumberStr), sysOutLines[i], is(tempNumberStr));
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

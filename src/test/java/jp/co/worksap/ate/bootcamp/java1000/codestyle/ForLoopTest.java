package jp.co.worksap.ate.bootcamp.java1000.codestyle;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class ForLoopTest extends TestCase {

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
	public void test_writeResult() {
		try (ByteArrayOutputStream tempOutStream = new ByteArrayOutputStream();
				PrintStream printStream = new PrintStream(tempOutStream);) {
			System.setOut(printStream);
			List<String> list = Arrays.asList("hoge", "hoge2", "hoge3");
			ForLoop.writeResult(list);
			String sysOutStr = tempOutStream.toString();
			String[] sysOutLines = sysOutStr.split(LINE_SEPARATOR);
			assertNotNull("パラメーターが「List」の場合の出力結果が正しくありません。", sysOutLines);
			assertThat("出力結果が正しく改行されていないようです。", sysOutLines.length, is(3));
			assertEquals("出力結果が正しくありません。",sysOutLines[0],"hoge" );
			assertEquals("出力結果が正しくありません。",sysOutLines[1],"hoge2" );
			assertEquals("出力結果が正しくありません。",sysOutLines[2],"hoge3" );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test_writeResult2() {
		try (ByteArrayOutputStream tempOutStream = new ByteArrayOutputStream();
				PrintStream printStream = new PrintStream(tempOutStream);) {
			System.setOut(printStream);
			Map<String, String> map = new TreeMap<>();
			map.put("a", "hogea");
			map.put("b", "hogeb");
			map.put("c", "hogec");
			ForLoop.writeResult(map);
			String sysOutStr = tempOutStream.toString();
			String[] sysOutLines = sysOutStr.split(LINE_SEPARATOR);
			assertNotNull("パラメーターが「Map」の場合の出力結果が正しくありません。", sysOutLines);
			assertThat("出力結果が正しく改行されていないようです。", sysOutLines.length, is(3));
			assertEquals("出力結果が正しくありません。",sysOutLines[0],"ahogea" );
			assertEquals("出力結果が正しくありません。",sysOutLines[1],"bhogeb" );
			assertEquals("出力結果が正しくありません。",sysOutLines[2],"chogec" );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test_writeResult3() {
		try (ByteArrayOutputStream tempOutStream = new ByteArrayOutputStream();
				PrintStream printStream = new PrintStream(tempOutStream);) {
			System.setOut(printStream);
			Set<String> set = new TreeSet<>();
			set.add("hogea");
			set.add("hogeb");
			set.add("hogec");
			ForLoop.writeResult(set);
			String sysOutStr = tempOutStream.toString();
			String[] sysOutLines = sysOutStr.split(LINE_SEPARATOR);
			assertNotNull("パラメーターが「Set」の場合の出力結果が正しくありません。", sysOutLines);
			assertThat("出力結果が正しく改行されていないようです。", sysOutLines.length, is(3));
			assertEquals("出力結果が正しくありません。",sysOutLines[0],"hogea" );
			assertEquals("出力結果が正しくありません。",sysOutLines[1],"hogeb" );
			assertEquals("出力結果が正しくありません。",sysOutLines[2],"hogec" );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

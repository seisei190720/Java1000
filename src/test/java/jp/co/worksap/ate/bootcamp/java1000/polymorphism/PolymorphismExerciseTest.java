package jp.co.worksap.ate.bootcamp.java1000.polymorphism;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PolymorphismExerciseTest extends TestCase {

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

	/*
	 * 【注意！】
	 * 実際の開発では、下記のような実装に依存しすぎるテストを書くべきではありません。
	 */
	@Test
	public void testImplementationOfMultiplesOf3() {
		MultiplesOf impl = new MultiplesOf(4);
		assertTrue("MultiplesOf.java が正しく実装されていません。", impl.isSatisfiedBy(12));
		assertFalse("MultiplesOf.java が正しく実装されていません。", impl.isSatisfiedBy(14));
	}

	/*
	 * 【注意！】
	 * 実際の開発では、下記のような実装に依存しすぎるテストを書くべきではありません。
	 */
	@Test
	public void testImplementationOfContains() {
		Contains impl = new Contains(2);
		assertTrue("Contains.java が正しく実装されていません。", impl.isSatisfiedBy(22));
		assertTrue("Contains.java が正しく実装されていません。", impl.isSatisfiedBy(2));
		assertTrue("Contains.java が正しく実装されていません。", impl.isSatisfiedBy(20));
		assertFalse("Contains.java が正しく実装されていません。", impl.isSatisfiedBy(14));
	}

	/*
	 * 【注意！】
	 * 実際の開発では、下記のような実装に依存しすぎるテストを書くべきではありません。
	 */
	@Test
	public void testImplementationOfOtherwise() {
		Otherwise impl = new Otherwise();
		assertTrue("Otherwise.java が正しく実装されていません。", impl.isSatisfiedBy(23));
	}

	@Test
	public void testPolymorphismExerciseExecuteCaseMultiplesOf3() {
		try (
				ByteArrayOutputStream tempOutStream = new ByteArrayOutputStream();
				PrintStream printStream = new PrintStream(tempOutStream);	) {
			System.setOut(printStream);

			new PolymorphismExercise().execute(new String[]{"multiplesOf3"});
			String sysOutStr = tempOutStream.toString();
			String[] sysOutLines = sysOutStr.split(LINE_SEPARATOR);
			assertNotNull("「multiplesOf3」の場合の出力結果が正しくありません。", sysOutLines);
			assertThat("「multiplesOf3」の場合の出力結果が正しくありません。", sysOutLines.length, is(10));

			String[] expectedOutLines = {"3", "6", "9", "12", "15", "18", "21", "24", "27", "30"};
			for (int i = 0; i < 10; i++) {
				assertThat(String.format("「multiplesOf3」の場合の出力結果が正しくありません(第 %s 行)。", i + 1), sysOutLines[i], is(expectedOutLines[i]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testPolymorphismExerciseExecuteCaseContains3() {
		try (
				ByteArrayOutputStream tempOutStream = new ByteArrayOutputStream();
				PrintStream printStream = new PrintStream(tempOutStream);	) {
			System.setOut(printStream);

			new PolymorphismExercise().execute(new String[]{"contains3"});
			String sysOutStr = tempOutStream.toString();
			String[] sysOutLines = sysOutStr.split(LINE_SEPARATOR);
			assertNotNull("「contains3」の場合の出力結果が正しくありません。", sysOutLines);
			assertThat("「contains3」の場合の出力結果が正しくありません。", sysOutLines.length, is(4));

			String[] expectedOutLines = {"3", "13", "23", "30"};
			for (int i = 0; i < 4; i++) {
				assertThat(String.format("「contains3」の場合の出力結果が正しくありません(第 %s 行)。", i + 1), sysOutLines[i], is(expectedOutLines[i]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testPolymorphismExerciseExecuteCase7Ate9() {
		try (
				ByteArrayOutputStream tempOutStream = new ByteArrayOutputStream();
				PrintStream printStream = new PrintStream(tempOutStream);	) {
			System.setOut(printStream);

			new PolymorphismExercise().execute(new String[]{"7Ate9"});
			String sysOutStr = tempOutStream.toString();
			String[] sysOutLines = sysOutStr.split(LINE_SEPARATOR);
			assertNotNull("「7Ate9」の場合の出力結果が正しくありません。", sysOutLines);
			assertThat("「7Ate9」の場合の出力結果が正しくありません。", sysOutLines.length, is(27));

			String[] expectedOutLines = {
					"1", "2", "3", "4", "5", "6", "7", "8", "10",
					"11", "12", "13", "14", "15", "16", "17", "18", "20",
					"21", "22", "23", "24", "25", "26", "27", "28", "30"};
			for (int i = 0; i < 27; i++) {
				assertThat(String.format("「7Ate9」の場合の出力結果が正しくありません(第 %s 行)。", i + 1), sysOutLines[i], is(expectedOutLines[i]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testPolymorphismExerciseExecuteCaseOtherwise() {
		try (
				ByteArrayOutputStream tempOutStream = new ByteArrayOutputStream();
				PrintStream printStream = new PrintStream(tempOutStream);	) {
			System.setOut(printStream);

			new PolymorphismExercise().execute(new String[]{"ぬるぽ", "ガッ"});
			String sysOutStr = tempOutStream.toString();
			String[] sysOutLines = sysOutStr.split(LINE_SEPARATOR);
			assertNotNull("出力結果が正しくありません。", sysOutLines);
			assertThat("出力結果が正しくありません。", sysOutLines.length, is(30));

			String[] expectedOutLines = {
					"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
					"11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
					"21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
			for (int i = 0; i < 30; i++) {
				assertThat(String.format("出力結果が正しくありません(第 %s 行)。", i + 1), sysOutLines[i], is(expectedOutLines[i]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testPolymorphismExerciseExecuteCaseNoArgs() {
		try (
				ByteArrayOutputStream tempOutStream = new ByteArrayOutputStream();
				PrintStream printStream = new PrintStream(tempOutStream);	) {
			System.setOut(printStream);

			new PolymorphismExercise().execute(new String[]{});
			String sysOutStr = tempOutStream.toString();
			String[] sysOutLines = sysOutStr.split(LINE_SEPARATOR);
			assertNotNull("出力結果が正しくありません。", sysOutLines);
			assertThat("出力結果が正しくありません。", sysOutLines.length, is(30));

			String[] expectedOutLines = {
					"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
					"11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
					"21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
			for (int i = 0; i < 30; i++) {
				assertThat(String.format("出力結果が正しくありません(第 %s 行)。", i + 1), sysOutLines[i], is(expectedOutLines[i]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

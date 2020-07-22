/*
 * StringExerciseTest.java
 * 更新履歴
 * Copyright 2010- WorksApplications.
 */
package jp.co.worksap.ate.bootcamp.java1000.string;

import java.util.ArrayList;
import java.util.List;

import jp.co.worksap.ate.bootcamp.java1000.string.StringExercise;
import junit.framework.AssertionFailedError;
import junit.framework.TestCase;


public class StringExerciseTest extends TestCase {
	public final void testGetBoolValueString() {
		assertTrue(StringExercise.getBoolValue(StringExercise.KEYWORD_TRUE));
		assertFalse(StringExercise.getBoolValue(StringExercise.KEYWORD_FALSE));
		assertTrue(StringExercise.getBoolValue(StringExercise.KEYWORD_YES));
		assertFalse(StringExercise.getBoolValue(StringExercise.KEYWORD_NO));
		assertTrue(StringExercise.getBoolValue(new String("YES")));
		assertFalse(StringExercise.getBoolValue(null));
	}


	public final void testGetBoolValueStringBoolean() {
		assertTrue(StringExercise.getBoolValue(StringExercise.KEYWORD_TRUE, true));
		assertFalse(StringExercise.getBoolValue(StringExercise.KEYWORD_FALSE, true));
		assertTrue(StringExercise.getBoolValue(StringExercise.KEYWORD_YES, true));
		assertFalse(StringExercise.getBoolValue(StringExercise.KEYWORD_NO, true));
		assertTrue(StringExercise.getBoolValue(new String("YES"), true));
		assertTrue(StringExercise.getBoolValue(new String("yes"), true));
		assertFalse(StringExercise.getBoolValue(new String("yes"), false));
		assertFalse(StringExercise.getBoolValue(new String("yEs"), false));
		assertTrue(StringExercise.getBoolValue(new String("TrUe"), true));
		assertTrue(StringExercise.getBoolValue(new String("YES"), false));
		assertTrue(StringExercise.getBoolValue(new String("TRUE"), false));
		assertFalse(StringExercise.getBoolValue(new String("true"), false));

		try {
			assertFalse(StringExercise.getBoolValue(null, true));
		} catch (AssertionFailedError e) {
			throw e;
		} catch (NullPointerException e) {
			fail("null が渡ってきた時どうなりますか？");
		}
	}


	public final void testAppendStringString() {
		assertEquals("YesWeCan", StringExercise.append("Yes", "WeCan"));
		assertEquals("Hello World", StringExercise.append("Hello ", "World"));
		assertEquals("日本語入力", StringExercise.append("日本語", "入力"));
		assertEquals("After", StringExercise.append(null, "After"));
		assertEquals("Before", StringExercise.append("Before", null));

		try {
			assertEquals(null, StringExercise.append(null, null));
		} catch (AssertionFailedError e) {
			throw e;
		} catch (NullPointerException e) {
			fail("null が渡ってきた時どうなりますか？");
		}
	}


	public final void testAppendList() {
		List<String> list = new ArrayList<>();

		/*
		 * List が空なら空文字列がよいように思う
		 */
		assertEquals("空のリストはどうなりますか？", "", StringExercise.append(list));

		list.add("ABC");
		list.add("def");
		list.add("GHQ");
		list.add("iJkL");
		list.add("MNO");

		assertEquals("ABCdefGHQiJkLMNO", StringExercise.append(list));

		/*
		 * List が null なら null がよいように思う
		 */
		try {
			assertEquals(null, StringExercise.append(null));
		} catch (AssertionFailedError e) {
			throw e;
		} catch (NullPointerException e) {
			fail("null が渡ってきた時どうなりますか？");
		}
	}


	public final void testGetFileName() {
		final String sep = System.getProperty("file.separator");
		final StringBuffer fileName = new StringBuffer("C:");
		fileName.append(sep);
		fileName.append("Program files");
		fileName.append(sep);
		fileName.append("日本語フォルダ");
		fileName.append(sep);
		fileName.append("readme.txt");

		assertEquals("readme", StringExercise.getFileName(fileName.toString()));

		fileName.setLength(0);
		fileName.append("..");
		fileName.append(sep);
		fileName.append("..");
		fileName.append(sep);
		fileName.append("..");
		fileName.append(sep);
		fileName.append("拡張子なし");

		assertEquals("拡張子なし", StringExercise.getFileName(fileName.toString()));

		/*
		 * List が null なら null がよいように思う
		 */
		try {
			assertEquals(null, StringExercise.getFileName(null));
		} catch (AssertionFailedError e) {
			throw e;
		} catch (NullPointerException e) {
			fail("null が渡ってきた時どうなりますか？");
		}
	}
}

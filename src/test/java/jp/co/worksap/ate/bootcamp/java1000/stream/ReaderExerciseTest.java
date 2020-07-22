package jp.co.worksap.ate.bootcamp.java1000.stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import jp.co.worksap.ate.bootcamp.java1000.stream.ReaderExercise;
import junit.framework.TestCase;

public class ReaderExerciseTest extends TestCase {

	private File fileMS932 = new File("testFileReadMS932");
	private File fileUTF8 = new File("testFileReadUTF8");
	private File fileDefEncode = new File("testFileReadDefEncode");
	private static final String FILE_LINE_MESSAGE1="テスト";
	private static final String FILE_LINE_MESSAGE2="①②③④⑤⑥⑦⑧⑨";
	private static final String FILE_LINE_MESSAGE3="―∥－…～￢￠￡";
	private static final String FILE_LINE_MESSAGE4="テスト4行目";
	private static final String FILE_LINE_MESSAGE5="テスト５行目";
	private static final String ENCODE_MS932 = "MS932";
	private static final String ENCODE_UTF8 = "UTF8";
	private static final String ENCODE_DEFAULT = System.getProperty("file.encoding");

	protected void setUp() throws Exception {
		super.setUp();
		setUpFile(fileMS932, ENCODE_MS932);
		setUpFile(fileUTF8, ENCODE_UTF8);
		setUpFile(fileDefEncode, ENCODE_DEFAULT);
	}
	protected void tearDown() throws Exception {
		tearDownFile(fileMS932);
		tearDownFile(fileUTF8);
		tearDownFile(fileDefEncode);
		super.tearDown();
	}

	private void tearDownFile(File file) {
		if (!file.exists()) {
			return;
		}
		if (!file.delete()) {
			file.deleteOnExit();
		}
	}

	private void setUpFile(File file, String encStr) {
		if (file.exists()) {
			file.delete();
		}
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),encStr));
			bw.write(FILE_LINE_MESSAGE1);
			bw.newLine();
			bw.write(FILE_LINE_MESSAGE2);
			bw.newLine();
			bw.write(FILE_LINE_MESSAGE3);
			bw.newLine();
			bw.write(FILE_LINE_MESSAGE4);
			bw.newLine();
			bw.write(FILE_LINE_MESSAGE5);
			bw.newLine();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			ResourceCloser.close(bw);
		}
	}
	public void testOpenFileAsFileReader() {
		Reader rr=null; 
		try {
			rr = ReaderExercise.openFileAsFileReader(null);
			assertNull(rr);
			rr = ReaderExercise.openFileAsFileReader(fileMS932.getAbsolutePath());
			assertNotNull("正しくオブジェクトが作成できていません。", rr);
			assertTrue("FileReaderオブジェクトのインスタンスが作成されていません。",rr instanceof FileReader);
		} catch (NullPointerException e) {
			fail("NullチェックをしてExceptionは発生させないようにしましょう。");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			ResourceCloser.close(rr);
		}
	}

	public void testOpenFileAsBufferedReader() {
		Reader rr=null; 
		try {
			rr = ReaderExercise.openFileAsBufferedReader(null);
			assertNull(rr);
			rr = ReaderExercise.openFileAsBufferedReader(fileMS932.getAbsolutePath());
			assertNotNull("正しくオブジェクトが作成できていません。", rr);
			assertTrue("BufferedReaderオブジェクトのインスタンスが作成されていません。",rr instanceof BufferedReader);
		} catch (NullPointerException e) {
			fail("NullチェックをしてExceptionは発生させないようにしましょう。");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			ResourceCloser.close(rr);
		}
	}

	public void testCloseReader() {
		try {
			ReaderExercise.closeReader(null);
		} catch (NullPointerException e) {
			fail("NullチェックをしてExceptionは発生させないようにしましょう。");
			e.printStackTrace();
		}
		Reader rr = null;
		try {
			rr = new FileReader(fileMS932);
			ReaderExercise.closeReader(rr);
			assertFalse("クローズできていません。",rr.ready());
		} catch (IOException e) {
			assertTrue(e.getLocalizedMessage().indexOf("closed")>-1);
		} finally {
			ResourceCloser.close(rr);
		}

	}

	public void testReadFileFile() throws IOException{
		try {
			List<String> readFile = ReaderExercise.readFile(fileDefEncode);
			assertFile(readFile);
			assertTrue("ファイルが正しくクローズできてない可能性があります。",fileDefEncode.renameTo(new File(fileDefEncode.getName())));
		} catch (NullPointerException e) {
			fail("NullチェックをしてExceptionは発生させないようにしましょう。");
			e.printStackTrace();
		}
	}

	public void testReadFileFileString() throws IOException{
		try {
			List<String> ms932 = ReaderExercise.readFile(fileMS932,ENCODE_MS932);
			assertFile(ms932);
			assertTrue("ファイルが正しくクローズできてない可能性があります。",fileMS932.renameTo(new File(fileMS932.getName())));

			List<String> utf8 = ReaderExercise.readFile(fileUTF8, ENCODE_UTF8);
			assertFile(utf8);
			assertTrue("ファイルが正しくクローズできてない可能性があります。",fileUTF8.renameTo(new File(fileUTF8.getName())));
		} catch (NullPointerException e) {
			fail("NullチェックをしてExceptionは発生させないようにしましょう。");
			e.printStackTrace();
		}
	}

	private void assertFile(List<String> contents) {
		assertEquals("ファイル内容が正しく読み込めていません。",FILE_LINE_MESSAGE1, contents.get(0));
		assertEquals("ファイル内容が正しく読み込めていません。",FILE_LINE_MESSAGE2, contents.get(1));
		assertEquals("ファイル内容が正しく読み込めていません。",FILE_LINE_MESSAGE3, contents.get(2));
		assertEquals("ファイル内容が正しく読み込めていません。",FILE_LINE_MESSAGE4, contents.get(3));
		assertEquals("ファイル内容が正しく読み込めていません。",FILE_LINE_MESSAGE5, contents.get(4));
	}

}

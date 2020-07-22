package jp.co.worksap.ate.bootcamp.java1000.stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import jp.co.worksap.ate.bootcamp.java1000.stream.WriterExercise;
import junit.framework.TestCase;

public class WriterExerciseTest extends TestCase {

	private File fileMS932 = new File("testFileWriteMS932");
	private File fileUTF8 = new File("testFileWriteUTF8");
	private File fileDefEncode = new File("testFileWriteDefEncode");
	private static final String FILE_LINE_MESSAGE1="テスト";
	private static final String FILE_LINE_MESSAGE2="①②③④⑤⑥⑦⑧⑨";
	private static final String FILE_LINE_MESSAGE3="―∥－…～￢￠￡";
	private static final String FILE_LINE_MESSAGE4="テスト4行目";
	private static final String FILE_LINE_MESSAGE5="テスト５行目";
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	private static final String FILE_MESSAGES = FILE_LINE_MESSAGE1+LINE_SEPARATOR
			+FILE_LINE_MESSAGE2+LINE_SEPARATOR
			+FILE_LINE_MESSAGE3+LINE_SEPARATOR
			+FILE_LINE_MESSAGE4+LINE_SEPARATOR
			+FILE_LINE_MESSAGE5+LINE_SEPARATOR;
	private static final String FILE_LINE_MESSAGE6="―∥－…～￢￠￡㈱";
	private static final String FILE_LINE_MESSAGE7="追記テストline2";
	private static final String FILE_MESSAGES_2 = FILE_LINE_MESSAGE6 + LINE_SEPARATOR
			+ FILE_LINE_MESSAGE7 + LINE_SEPARATOR;
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
	private void tearDownFile(File file){
		if(!file.exists()){
			return;
		}
		if(!file.delete()){
			file.deleteOnExit();
		}
	}
	private void setUpFile(File file,String encStr){
		if(file.exists()){
			file.delete();
		}
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),encStr));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			ResourceCloser.close(bw);
		}
	}
	public void testOpenFileAsFileWriter() {
		Writer ww=null;
		try {
			ww = WriterExercise.openFileAsFileWriter(null);
			assertNull(ww);
			ww = WriterExercise.openFileAsFileWriter(fileMS932.getAbsolutePath());
			assertNotNull("正しくオブジェクトが作成できていません。", ww);
			assertTrue("FileWriterオブジェクトのインスタンスが作成されていません。",ww instanceof FileWriter);
		} catch (NullPointerException e) {
			fail("NullチェックをしてNullPointerExceptionは発生させないようにしましょう。");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			ResourceCloser.close(ww);
		}
	}

	public void testOpenFileAsBufferedWriter() {
		Writer ww=null;
		try {
			ww = WriterExercise.openFileAsBufferedWriter(null);
			assertNull(ww);
			ww = WriterExercise.openFileAsBufferedWriter(fileMS932.getAbsolutePath());
			assertNotNull("正しくオブジェクトが作成できていません。", ww);
			assertTrue("BufferedWriterオブジェクトのインスタンスが作成されていません。",ww instanceof BufferedWriter);
		} catch (NullPointerException e) {
			fail("NullチェックをしてExceptionは発生させないようにしましょう。");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			ResourceCloser.close(ww);
		}
	}

	public void testCloseWriter() {
		try {
			WriterExercise.closeWriter(null);
		} catch (NullPointerException e) {
			fail("NullチェックをしてExceptionは発生させないようにしましょう。");
			e.printStackTrace();
		}
		Writer ww = null;
		try {
			ww = new FileWriter(fileMS932);
			WriterExercise.closeWriter(ww);
			ww.flush();
			fail("クローズできていません。");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			assertTrue(e.getLocalizedMessage().indexOf("closed")>-1);
		} finally {
			ResourceCloser.close(ww);
		}
	}

	public void testWriteFileFileString() throws IOException {
		try {
			WriterExercise.writeFile(null, null);
			WriterExercise.writeFile(fileDefEncode, FILE_MESSAGES);
		} catch (NullPointerException e) {
			fail("NullチェックをしてExceptionは発生させないようにしましょう。");
			e.printStackTrace();
		}
		assertEquals("ファイル内容が正しく書き込めていません。",FILE_MESSAGES, FileContentUtils.getFileContents(fileDefEncode,ENCODE_DEFAULT));
		assertTrue("ファイルが正しくクローズできてない可能性があります。",fileDefEncode.renameTo(new File(fileDefEncode.getName())));
	}

	public void testAppendFileFileString() throws IOException {
		try {
			WriterExercise.appendFile(null, null);
			WriterExercise.appendFile(fileDefEncode, FILE_MESSAGES);
			assertThat("ファイル内容が正しく書き込めていません。", FileContentUtils.getFileContents(fileDefEncode, ENCODE_DEFAULT), is(FILE_MESSAGES));
			assertThat("ファイルが正しくクローズできてない可能性があります。", fileDefEncode.renameTo(new File(fileDefEncode.getName())), is(true));
			WriterExercise.appendFile(fileDefEncode, FILE_MESSAGES_2);
			assertThat("ファイル内容が正しく書き込めていません。", FileContentUtils.getFileContents(fileDefEncode, ENCODE_DEFAULT), is(FILE_MESSAGES + FILE_MESSAGES_2));
		} catch (NullPointerException e) {
			fail("NullチェックをしてExceptionは発生させないようにしましょう。");
			e.printStackTrace();
		}
	}

	public void testWriteFileFileStringString() throws IOException {
		try {
			WriterExercise.writeFile(null, null,null);
			WriterExercise.writeFile(fileMS932, FILE_MESSAGES, ENCODE_MS932);
		} catch (NullPointerException e) {
			fail("NullチェックをしてExceptionは発生させないようにしましょう。");
			e.printStackTrace();
		}
		assertEquals("ファイル内容が正しく書き込めていません。",FILE_MESSAGES, FileContentUtils.getFileContents(fileMS932,ENCODE_MS932));
		assertTrue("ファイルが正しくクローズできてない可能性があります。",fileMS932.renameTo(new File(fileMS932.getName())));
		try {
			WriterExercise.writeFile(null, null,null);
			WriterExercise.writeFile(fileUTF8, FILE_MESSAGES, ENCODE_UTF8);
		} catch (NullPointerException e) {
			fail("NullチェックをしてExceptionは発生させないようにしましょう。");
			e.printStackTrace();
		}
		assertEquals("ファイル内容が正しく読み込めていません。",FILE_MESSAGES, FileContentUtils.getFileContents(fileUTF8, ENCODE_UTF8));
		assertTrue("ファイルが正しくクローズできてない可能性があります。",fileUTF8.renameTo(new File(fileUTF8.getName())));
	}
}

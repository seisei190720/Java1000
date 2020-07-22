package jp.co.worksap.ate.bootcamp.java1000.algorithm;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import jp.co.worksap.ate.bootcamp.java1000.algorithm.util.FileOperationUtils;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AlgorithmExercise3Test extends TestCase {

	private static final String ENCODE_DEFAULT = System.getProperty("file.encoding");
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	private static final String SRC_FILE_1_PATH = "srcFile1";
	private static final String SRC_FILE_1_CONTENTS =
			"	㈱ワークスアプリケーションズ" + LINE_SEPARATOR
			+ "①②③④⑤⑥⑦⑧⑨	" + LINE_SEPARATOR
			+ "		―∥－…～￢￠￡" + LINE_SEPARATOR
			+ "テスト4行目" + LINE_SEPARATOR
			+ "テスト５	行目	" + LINE_SEPARATOR;
	private static final String DEST_FILE_1_PATH = "destFile1";
	private static final String EXPECTED_DEST_FILE_1_CONTENTS =
			"    ㈱ワークスアプリケーションズ" + LINE_SEPARATOR
			+ "①②③④⑤⑥⑦⑧⑨    " + LINE_SEPARATOR
			+ "        ―∥－…～￢￠￡" + LINE_SEPARATOR
			+ "テスト4行目" + LINE_SEPARATOR
			+ "テスト５    行目    " + LINE_SEPARATOR;

	private static final String SRC_FILE_2_PATH = "srcFile2";
	private static final String SRC_FILE_2_CONTENTS = "テスト";
	private static final String DEST_FILE_2_PATH = "destFile2";
	private static final String EXPECTED_DEST_FILE_2_CONTENTS = "テスト" + LINE_SEPARATOR;

	private static final String SRC_FILE_3_PATH = "srcFile3";
	private static final String SRC_FILE_3_CONTENTS = "";
	private static final String DEST_FILE_3_PATH = "destFile3";
	private static final String EXPECTED_DEST_FILE_3_CONTENTS = "";

	private static final String SRC_FILE_4_PATH = "srcFile4";
	private static final String DEST_FILE_4_PATH = "destFile4";

	private static final String SRC_FILE_5_PATH = "srcFile5";
	private static final String SRC_FILE_5_CONTENTS = "test";
	private static final String DEST_FILE_5_PATH = "destFile5";
	private static final String DEST_FILE_5_CONTENTS = "hoge";

	private static final String SRC_FILE_6_PATH = "folder";
	private static final String DEST_FILE_6_PATH = "destFile6";

	private static final String SRC_FILE_7_PATH = "srcFile7";
	private static final String SRC_FILE_7_CONTENTS = "test";

	private static final String DEST_FILE_8_PATH = "destFile8";

	@Before
	protected void setUp() throws Exception {
		super.setUp();
		setUpFiles();
	}

	private void setUpFiles() {
		setUpSrcFiles();
		setUpDestFiles();
	}

	private void setUpSrcFiles() {
		try {
			writeContentsToFile(SRC_FILE_1_PATH, SRC_FILE_1_CONTENTS);
			writeContentsToFile(SRC_FILE_2_PATH, SRC_FILE_2_CONTENTS);
			writeContentsToFile(SRC_FILE_3_PATH, SRC_FILE_3_CONTENTS);
			FileOperationUtils.deleteDirRecursivelyIfExists(SRC_FILE_4_PATH);
			writeContentsToFile(SRC_FILE_5_PATH, SRC_FILE_5_CONTENTS);
			FileOperationUtils.deleteDirRecursivelyIfExists(SRC_FILE_6_PATH);
			Files.createDirectory(Paths.get(SRC_FILE_6_PATH));
			writeContentsToFile(SRC_FILE_7_PATH, SRC_FILE_7_CONTENTS);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void setUpDestFiles() {
		try {
			FileOperationUtils.deleteDirRecursivelyIfExists(DEST_FILE_1_PATH);
			FileOperationUtils.deleteDirRecursivelyIfExists(DEST_FILE_2_PATH);
			FileOperationUtils.deleteDirRecursivelyIfExists(DEST_FILE_3_PATH);
			FileOperationUtils.deleteDirRecursivelyIfExists(DEST_FILE_4_PATH);
			writeContentsToFile(DEST_FILE_5_PATH, DEST_FILE_5_CONTENTS);
			FileOperationUtils.deleteDirRecursivelyIfExists(DEST_FILE_6_PATH);
			FileOperationUtils.deleteDirRecursivelyIfExists(DEST_FILE_8_PATH);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void writeContentsToFile(String filePathStr, String fileContents) throws IOException {
		FileOperationUtils.deleteDirRecursivelyIfExists(filePathStr);
		Path filePath = Paths.get(filePathStr);
		Files.createFile(filePath);
		FileOperationUtils.writeContentsToFile(filePath, fileContents, ENCODE_DEFAULT);
	}

	@Test
	public void testReplaceTabsCaseNormal() {
		try {
			new AlgorithmExercise3().replaceTabs(SRC_FILE_1_PATH, DEST_FILE_1_PATH);
		} catch (NullPointerException e) {
			e.printStackTrace();
			fail("NullチェックをしてExceptionは発生させないようにしましょう。");
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertThat("ファイル内容が正しく書き込めていません。", FileOperationUtils.getFileContents(Paths.get(DEST_FILE_1_PATH), ENCODE_DEFAULT), is(EXPECTED_DEST_FILE_1_CONTENTS));
		File destFile = new File(DEST_FILE_1_PATH);
		assertTrue("ファイルが正しくクローズできてない可能性があります。", destFile.renameTo(new File(destFile.getName())));
	}

	@Test
	public void testReplaceTabsCaseNoTab() {
		try {
			new AlgorithmExercise3().replaceTabs(SRC_FILE_2_PATH, DEST_FILE_2_PATH);
		} catch (NullPointerException e) {
			e.printStackTrace();
			fail("NullチェックをしてExceptionは発生させないようにしましょう。");
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertThat("ファイル内容が正しく書き込めていません。", FileOperationUtils.getFileContents(Paths.get(DEST_FILE_2_PATH), ENCODE_DEFAULT), is(EXPECTED_DEST_FILE_2_CONTENTS));
		File destFile = new File(DEST_FILE_2_PATH);
		assertTrue("ファイルが正しくクローズできてない可能性があります。", destFile.renameTo(new File(destFile.getName())));
	}

	@Test
	public void testReplaceTabsCaseEmpty() {
		try {
			new AlgorithmExercise3().replaceTabs(SRC_FILE_3_PATH, DEST_FILE_3_PATH);
		} catch (NullPointerException e) {
			fail("NullチェックをしてExceptionは発生させないようにしましょう。");
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertThat("ファイル内容が正しく書き込めていません。", FileOperationUtils.getFileContents(Paths.get(DEST_FILE_3_PATH), ENCODE_DEFAULT), is(EXPECTED_DEST_FILE_3_CONTENTS));
		File destFile = new File(DEST_FILE_3_PATH);
		assertTrue("ファイルが正しくクローズできてない可能性があります。", destFile.renameTo(new File(destFile.getName())));
	}

	@Test
	public void testReplaceTabsCaseNoSrcFile() {
		try {
			new AlgorithmExercise3().replaceTabs(SRC_FILE_4_PATH, DEST_FILE_4_PATH);
			fail("srcPathで指定されるファイルが存在しない場合の例外処理が仕様に合っていません。");
		} catch (NullPointerException e) {
			e.printStackTrace();
			fail("NullチェックをしてExceptionは発生させないようにしましょう。");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			fail("例外処理を指定どおりに行えていません。");
		}
	}

	@Test
	public void testReplaceTabsCaseExistingDestFile() {
		try {
			new AlgorithmExercise3().replaceTabs(SRC_FILE_5_PATH, DEST_FILE_5_PATH);
			fail("destPathで指定されるファイルが既に存在する場合の例外処理が仕様に合っていません。");
		} catch (NullPointerException e) {
			e.printStackTrace();
			fail("NullチェックをしてExceptionは発生させないようにしましょう。");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testReplaceTabsCaseSrcFolder() {
		try {
			new AlgorithmExercise3().replaceTabs(SRC_FILE_6_PATH, DEST_FILE_6_PATH);
			fail("srcPathの指定が不正な場合の例外処理が仕様に合っていません。");
		} catch (NullPointerException e) {
			e.printStackTrace();
			fail("NullチェックをしてExceptionは発生させないようにしましょう。");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			fail("例外処理を指定どおりに行えていません。");
		}
	}

	@Test
	public void testReplaceTabsCaseNull() {
		try {
			new AlgorithmExercise3().replaceTabs(SRC_FILE_7_PATH, null);
			fail("引数がnullの場合の例外処理が仕様に合っていません。");
		} catch (NullPointerException e) {
			e.printStackTrace();
			fail("NullチェックをしてExceptionは発生させないようにしましょう。");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			fail("例外処理を指定どおりに行えていません。");
		}
		try {
			new AlgorithmExercise3().replaceTabs(null, DEST_FILE_8_PATH);
			fail("引数がnullの場合の例外処理が仕様に合っていません。");
		} catch (NullPointerException e) {
			e.printStackTrace();
			fail("NullチェックをしてExceptionは発生させないようにしましょう。");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			fail("例外処理を指定どおりに行えていません。");
		}
		try {
			new AlgorithmExercise3().replaceTabs(null, null);
			fail("引数がnullの場合の例外処理が仕様に合っていません。");
		} catch (NullPointerException e) {
			e.printStackTrace();
			fail("NullチェックをしてExceptionは発生させないようにしましょう。");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			fail("例外処理を指定どおりに行えていません。");
		}
	}

	@After
	protected void tearDown() throws Exception {
		tearDownFiles();
		super.tearDown();
	}

	private void tearDownFiles() {
		tearDownSrcFiles();
		tearDownDestFiles();
	}

	private void tearDownSrcFiles() {
		try {
			FileOperationUtils.deleteDirRecursivelyIfExists(SRC_FILE_1_PATH);
			FileOperationUtils.deleteDirRecursivelyIfExists(SRC_FILE_2_PATH);
			FileOperationUtils.deleteDirRecursivelyIfExists(SRC_FILE_3_PATH);
			FileOperationUtils.deleteDirRecursivelyIfExists(SRC_FILE_4_PATH);
			FileOperationUtils.deleteDirRecursivelyIfExists(SRC_FILE_5_PATH);
			FileOperationUtils.deleteDirRecursivelyIfExists(SRC_FILE_6_PATH);
			FileOperationUtils.deleteDirRecursivelyIfExists(SRC_FILE_7_PATH);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void tearDownDestFiles() {
		try {
			FileOperationUtils.deleteDirRecursivelyIfExists(DEST_FILE_1_PATH);
			FileOperationUtils.deleteDirRecursivelyIfExists(DEST_FILE_2_PATH);
			FileOperationUtils.deleteDirRecursivelyIfExists(DEST_FILE_3_PATH);
			FileOperationUtils.deleteDirRecursivelyIfExists(DEST_FILE_4_PATH);
			FileOperationUtils.deleteDirRecursivelyIfExists(DEST_FILE_5_PATH);
			FileOperationUtils.deleteDirRecursivelyIfExists(DEST_FILE_6_PATH);
			FileOperationUtils.deleteDirRecursivelyIfExists(DEST_FILE_8_PATH);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

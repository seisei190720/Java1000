package jp.co.worksap.ate.bootcamp.java1000.algorithm;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import jp.co.worksap.ate.bootcamp.java1000.algorithm.util.FileOperationUtils;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AlgorithmExercise4Test extends TestCase {

	private static final String ENCODE_DEFAULT = System.getProperty("file.encoding");
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	private static final String CASE_1_TOP_LEVEL_FOLDER_PATH = "case1TopLevelFolder";
	private static final String CASE_2_TOP_LEVEL_FOLDER_PATH = "case2TopLevelFolder";
	private static final String CASE_2_SECOND_LEVEL_FILE_1_RELATIVE_PATH = "case2SecondLevelFile1";
	private static final String CASE_3_TOP_LEVEL_FOLDER_PATH = "case3TopLevelFolder";
	private static final String CASE_3_SECOND_LEVEL_FILE_1_RELATIVE_PATH = "case3SecondLevelFile1";
	private static final String CASE_3_SECOND_LEVEL_FILE_2_RELATIVE_PATH = "case3SecondLevelFile2";
	private static final String CASE_4_TOP_LEVEL_FOLDER_PATH = "case4TopLevelFolder";
	private static final String CASE_4_SECOND_LEVEL_FILE_1_RELATIVE_PATH = "case4SecondLevelFile1";
	private static final String CASE_4_SECOND_LEVEL_FILE_2_RELATIVE_PATH = "case4SecondLevelFile2";
	private static final String CASE_4_SECOND_LEVEL_FOLDER_1_RELATIVE_PATH = "case4SecondLevelFolder1";
	private static final String CASE_4_THIRD_LEVEL_FILE_1_RELATIVE_PATH = "case4ThirdLevelFile1";
	private static final String CASE_4_THIRD_LEVEL_FILE_2_RELATIVE_PATH = "case4ThirdLevelFile2";
	private static final String CASE_5_TOP_LEVEL_FOLDER_PATH = "case5TopLevelFolder";
	private static final String CASE_5_THIRD_LEVEL_FILE_1_RELATIVE_PATH = "case5ThirdLevelFile1";
	private static final String CASE_5_SECOND_LEVEL_FOLDER_1_RELATIVE_PATH = "case5SecondLevelFolder1";
	private static final String CASE_5_SECOND_LEVEL_FOLDER_2_RELATIVE_PATH = "case5SecondLevelFolder2";
	private static final String CASE_5_THIRD_LEVEL_FOLDER_1_RELATIVE_PATH = "case5ThirdLevelFolder1";
	private static final String CASE_5_FOURTH_LEVEL_FILE_1_RELATIVE_PATH = "case5FourthLevelFile1";
	private static final String CASE_5_FOURTH_LEVEL_FOLDER_1_RELATIVE_PATH = "case5FourthLevelFolder1";
	private static final String CASE_0_TOP_LEVEL_FOLDER_PATH = "case0TopLevelFolder";
	private static final String CASE_0_TOP_LEVEL_FILE_PATH = "case0TopLevelFile";

	private static final String CASE_0_TOP_LEVEL_FILE_CONTENTS =
			"aabca";

	private static final String CASE_2_SECOND_LEVEL_FILE_1_CONTENTS =
			"aabca" + LINE_SEPARATOR
			+ "①②③④⑤⑥⑦⑧⑨" + LINE_SEPARATOR
			+ "―∥－…～￢￠￡" + LINE_SEPARATOR
			+ "テスト" + LINE_SEPARATOR
			+ "―∥－…～￢￠￡" + LINE_SEPARATOR
			+ "￡―∥－…～￢￠" + LINE_SEPARATOR
			+ "￠￡―∥－…～￢" + LINE_SEPARATOR
			+ "￢￠￡―∥－…～" + LINE_SEPARATOR
			+ "～￢￠￡―∥－…" + LINE_SEPARATOR
			+ "㈱hoge" + LINE_SEPARATOR;
	private static final String CASE_3_SECOND_LEVEL_FILE_1_CONTENTS =
			"―∥－…～￢￠￡" + LINE_SEPARATOR
			+ "①②③④⑤⑥⑦⑧⑨" + LINE_SEPARATOR
			+ "⑨①②③④⑤⑥⑦⑧" + LINE_SEPARATOR
			+ "⑧⑨①②③④⑤⑥⑦" + LINE_SEPARATOR
			+ "⑦⑧⑨①②③④⑤⑥" + LINE_SEPARATOR
			+ "⑥⑦⑧⑨①②③④⑤" + LINE_SEPARATOR
			+ "⑤⑥⑦⑧⑨①②③④" + LINE_SEPARATOR
			+ "④⑤⑥⑦⑧⑨①②③" + LINE_SEPARATOR
			+ "③④⑤⑥⑦⑧⑨①②" + LINE_SEPARATOR
			+ "②③④⑤⑥⑦⑧⑨①" + LINE_SEPARATOR
			+ "テスト" + LINE_SEPARATOR
			+ "㈱hoge" + LINE_SEPARATOR;
	private static final String CASE_3_SECOND_LEVEL_FILE_2_CONTENTS =
			"aabca" + LINE_SEPARATOR
			+ "―∥－…～￢￠￡" + LINE_SEPARATOR
			+ "―∥－…～￢￠￡" + LINE_SEPARATOR
			+ "ああああああああああ" + LINE_SEPARATOR;
	private static final String CASE_4_SECOND_LEVEL_FILE_1_CONTENTS =
			"aabca" + LINE_SEPARATOR
			+ "―∥－…～￢￠￡" + LINE_SEPARATOR
			+ "テスト" + LINE_SEPARATOR
			+ "⑧⑨①②③④⑤⑥⑦" + LINE_SEPARATOR
			+ "⑦⑧⑨①②③④⑤⑥" + LINE_SEPARATOR
			+ "⑥⑦⑧⑨①②③④⑤" + LINE_SEPARATOR
			+ "⑤⑥⑦⑧⑨①②③④" + LINE_SEPARATOR
			+ "④⑤⑥⑦⑧⑨①②③" + LINE_SEPARATOR
			+ "㈱hoge" + LINE_SEPARATOR
			+ "㈱h" + LINE_SEPARATOR;
	private static final String CASE_4_SECOND_LEVEL_FILE_2_CONTENTS =
			"aabca" + LINE_SEPARATOR
			+ "①②③④⑤⑥⑦⑧⑨" + LINE_SEPARATOR
			+ "―∥－…～￢￠￡" + LINE_SEPARATOR
			+ "㈱hoge" + LINE_SEPARATOR;
	private static final String CASE_4_THIRD_LEVEL_FILE_1_CONTENTS = "";
	private static final String CASE_4_THIRD_LEVEL_FILE_2_CONTENTS =
			"①②③④⑤⑥⑦⑧⑨" + LINE_SEPARATOR
			+ "―∥－…～￢￠￡" + LINE_SEPARATOR
			+ "テスト" + LINE_SEPARATOR
			+ "⑧⑨①②③④⑤⑥⑦" + LINE_SEPARATOR
			+ "⑦⑧⑨①②③④⑤⑥" + LINE_SEPARATOR
			+ "⑥⑦⑧⑨①②③④⑤" + LINE_SEPARATOR
			+ "aabca" + LINE_SEPARATOR;
	private static final String CASE_5_THIRD_LEVEL_FILE_1_CONTENTS =
			"aabca" + LINE_SEPARATOR
			+ "―∥－…㈱h\\s～￢￠￡" + LINE_SEPARATOR
			+ "―∥－…～￢￠￡" + LINE_SEPARATOR;
	private static final String CASE_5_FOURTH_LEVEL_FILE_1_CONTENTS =
			"aabca" + LINE_SEPARATOR
			+ "①②③④⑤⑥⑦⑧⑨" + LINE_SEPARATOR
			+ "―∥－…～￢￠￡" + LINE_SEPARATOR
			+ "￡―∥－…～￢￠" + LINE_SEPARATOR
			+ "￠￡―∥－…～￢" + LINE_SEPARATOR
			+ "￢￠￡―∥－…～" + LINE_SEPARATOR
			+ "～￢￠￡―∥－…" + LINE_SEPARATOR
			+ "…～￢￠￡―∥－" + LINE_SEPARATOR
			+ "－…～￢￠￡―∥" + LINE_SEPARATOR
			+ "∥－…～￢￠￡―" + LINE_SEPARATOR
			+ "テスト" + LINE_SEPARATOR;

	@Before
	protected void setUp() throws Exception {
		super.setUp();
		setUpFile();
	}

	private void setUpFile() {
		setUpFileForSingleFileTestCase();
		setUpFileForSingleFolderTestCase();
		setUpFileForSingleFolderAndSingleFileTestCase();
		setUpFileForSingleFolderAndMultiFileTestCase();
		setUpFileForMultiFolderAndMultiFileTestCase();
		setUpFileForHighOrderRecursiveTestCase();
	}

	private void setUpFileForSingleFileTestCase() {
		try {
			Path topLevelFilePath = Paths.get(CASE_0_TOP_LEVEL_FILE_PATH);
			Files.createFile(topLevelFilePath);
			FileOperationUtils.writeContentsToFile(topLevelFilePath, CASE_0_TOP_LEVEL_FILE_CONTENTS, ENCODE_DEFAULT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void setUpFileForSingleFolderTestCase() {
		try {
			prepareTopDirectory(CASE_1_TOP_LEVEL_FOLDER_PATH);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void setUpFileForSingleFolderAndSingleFileTestCase() {
		try {
			prepareTopDirectory(CASE_2_TOP_LEVEL_FOLDER_PATH);
			Path secondLevelFile1Path = Paths.get(CASE_2_TOP_LEVEL_FOLDER_PATH, CASE_2_SECOND_LEVEL_FILE_1_RELATIVE_PATH);
			Files.createFile(secondLevelFile1Path);
			FileOperationUtils.writeContentsToFile(secondLevelFile1Path, CASE_2_SECOND_LEVEL_FILE_1_CONTENTS, ENCODE_DEFAULT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void setUpFileForSingleFolderAndMultiFileTestCase() {
		try {
			prepareTopDirectory(CASE_3_TOP_LEVEL_FOLDER_PATH);
			Path secondLevelFile1Path = Paths.get(CASE_3_TOP_LEVEL_FOLDER_PATH, CASE_3_SECOND_LEVEL_FILE_1_RELATIVE_PATH);
			Files.createFile(secondLevelFile1Path);
			FileOperationUtils.writeContentsToFile(secondLevelFile1Path, CASE_3_SECOND_LEVEL_FILE_1_CONTENTS, ENCODE_DEFAULT);
			Path secondLevelFile2Path = Paths.get(CASE_3_TOP_LEVEL_FOLDER_PATH, CASE_3_SECOND_LEVEL_FILE_2_RELATIVE_PATH);
			Files.createFile(secondLevelFile2Path);
			FileOperationUtils.writeContentsToFile(secondLevelFile2Path, CASE_3_SECOND_LEVEL_FILE_2_CONTENTS, ENCODE_DEFAULT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void setUpFileForMultiFolderAndMultiFileTestCase() {
		try {
			prepareTopDirectory(CASE_4_TOP_LEVEL_FOLDER_PATH);
			Path secondLevelFile1Path = Paths.get(CASE_4_TOP_LEVEL_FOLDER_PATH, CASE_4_SECOND_LEVEL_FILE_1_RELATIVE_PATH);
			Files.createFile(secondLevelFile1Path);
			FileOperationUtils.writeContentsToFile(secondLevelFile1Path, CASE_4_SECOND_LEVEL_FILE_1_CONTENTS, ENCODE_DEFAULT);
			Path secondLevelFile2Path = Paths.get(CASE_4_TOP_LEVEL_FOLDER_PATH, CASE_4_SECOND_LEVEL_FILE_2_RELATIVE_PATH);
			Files.createFile(secondLevelFile2Path);
			FileOperationUtils.writeContentsToFile(secondLevelFile2Path, CASE_4_SECOND_LEVEL_FILE_2_CONTENTS, ENCODE_DEFAULT);
			Path secondLevelFolder1Path = Paths.get(CASE_4_TOP_LEVEL_FOLDER_PATH, CASE_4_SECOND_LEVEL_FOLDER_1_RELATIVE_PATH);
			Files.createDirectory(secondLevelFolder1Path);
			Path thirdLevelFile1Path = Paths.get(CASE_4_TOP_LEVEL_FOLDER_PATH, CASE_4_SECOND_LEVEL_FOLDER_1_RELATIVE_PATH,
					CASE_4_THIRD_LEVEL_FILE_1_RELATIVE_PATH);
			Files.createFile(thirdLevelFile1Path);
			FileOperationUtils.writeContentsToFile(thirdLevelFile1Path, CASE_4_THIRD_LEVEL_FILE_1_CONTENTS, ENCODE_DEFAULT);
			Path thirdLevelFile2Path = Paths.get(CASE_4_TOP_LEVEL_FOLDER_PATH, CASE_4_SECOND_LEVEL_FOLDER_1_RELATIVE_PATH,
					CASE_4_THIRD_LEVEL_FILE_2_RELATIVE_PATH);
			Files.createFile(thirdLevelFile2Path);
			FileOperationUtils.writeContentsToFile(thirdLevelFile2Path, CASE_4_THIRD_LEVEL_FILE_2_CONTENTS, ENCODE_DEFAULT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void setUpFileForHighOrderRecursiveTestCase() {
		try {
			prepareTopDirectory(CASE_5_TOP_LEVEL_FOLDER_PATH);
			Path secondLevelFolder1Path = Paths.get(CASE_5_TOP_LEVEL_FOLDER_PATH, CASE_5_SECOND_LEVEL_FOLDER_1_RELATIVE_PATH);
			Files.createDirectory(secondLevelFolder1Path);
			Path thirdLevelFolder1Path = Paths.get(CASE_5_TOP_LEVEL_FOLDER_PATH, CASE_5_SECOND_LEVEL_FOLDER_1_RELATIVE_PATH,
					CASE_5_THIRD_LEVEL_FOLDER_1_RELATIVE_PATH);
			Files.createDirectory(thirdLevelFolder1Path);
			Path fourthLevelFile1Path = Paths.get(CASE_5_TOP_LEVEL_FOLDER_PATH, CASE_5_SECOND_LEVEL_FOLDER_1_RELATIVE_PATH,
					CASE_5_THIRD_LEVEL_FOLDER_1_RELATIVE_PATH, CASE_5_FOURTH_LEVEL_FILE_1_RELATIVE_PATH);
			Files.createFile(fourthLevelFile1Path);
			FileOperationUtils.writeContentsToFile(fourthLevelFile1Path, CASE_5_FOURTH_LEVEL_FILE_1_CONTENTS, ENCODE_DEFAULT);
			Path fourthLevelFolder1Path = Paths.get(CASE_5_TOP_LEVEL_FOLDER_PATH, CASE_5_SECOND_LEVEL_FOLDER_1_RELATIVE_PATH,
					CASE_5_THIRD_LEVEL_FOLDER_1_RELATIVE_PATH, CASE_5_FOURTH_LEVEL_FOLDER_1_RELATIVE_PATH);
			Files.createDirectory(fourthLevelFolder1Path);
			Path secondLevelFolder2Path = Paths.get(CASE_5_TOP_LEVEL_FOLDER_PATH, CASE_5_SECOND_LEVEL_FOLDER_2_RELATIVE_PATH);
			Files.createDirectory(secondLevelFolder2Path);
			Path thirdLevelFile1Path = Paths.get(CASE_5_TOP_LEVEL_FOLDER_PATH, CASE_5_SECOND_LEVEL_FOLDER_2_RELATIVE_PATH, CASE_5_THIRD_LEVEL_FILE_1_RELATIVE_PATH);
			Files.createFile(thirdLevelFile1Path);
			FileOperationUtils.writeContentsToFile(thirdLevelFile1Path, CASE_5_THIRD_LEVEL_FILE_1_CONTENTS, ENCODE_DEFAULT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void prepareTopDirectory(String dirPath) throws IOException {
		FileOperationUtils.deleteDirRecursivelyIfExists(dirPath);
		Files.createDirectory(Paths.get(dirPath));
	}

	@Test
	public void testGrepRecursivelyNull() {
		try {
			new AlgorithmExercise4().grepRecursively(null, "③④⑤⑥");
			fail("引数がnullの場合の例外処理が仕様に合っていません。");
		} catch (NullPointerException e) {
			e.printStackTrace();
			fail("NullチェックをしてExceptionは発生させないようにしましょう。");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			fail("例外を指定どおりに処理できていません。");
		}
		try {
			new AlgorithmExercise4().grepRecursively(CASE_1_TOP_LEVEL_FOLDER_PATH, null);
			fail("引数がnullの場合の例外処理が仕様に合っていません。");
		} catch (NullPointerException e) {
			e.printStackTrace();
			fail("NullチェックをしてExceptionは発生させないようにしましょう。");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			fail("例外を指定どおりに処理できていません。");
		}
	}

	@Test
	public void testGrepRecursivelyCaseFolderNotFound() {
		try {
			new AlgorithmExercise4().grepRecursively(CASE_0_TOP_LEVEL_FOLDER_PATH, "hoge");
			fail("引数が不正な場合の例外処理が仕様に合っていません。");
		} catch (NullPointerException e) {
			e.printStackTrace();
			fail("NullチェックをしてExceptionは発生させないようにしましょう。");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			fail("例外を指定どおりに処理できていません。");
		}
	}

	@Test
	public void testGrepRecursivelyCaseFileDesignated() {
		try {
			new AlgorithmExercise4().grepRecursively(CASE_0_TOP_LEVEL_FILE_PATH, "a");
			fail("引数が不正な場合の例外処理が仕様に合っていません。");
		} catch (NullPointerException e) {
			e.printStackTrace();
			fail("NullチェックをしてExceptionは発生させないようにしましょう。");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			fail("例外を指定どおりに処理できていません。");
		}
	}

	@Test
	public void testGrepRecursivelyCase1() {
		try {
			Map<String, List<String>> grepResult = new AlgorithmExercise4().grepRecursively(CASE_1_TOP_LEVEL_FOLDER_PATH, "test");
			assertNotNull("nullを返しています。仕様を確認しましょう。", grepResult);
			assertTrue(grepResult.isEmpty());
		} catch (NullPointerException e) {
			e.printStackTrace();
			fail("NullチェックをしてExceptionは発生させないようにしましょう。");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGrepRecursivelyCase2() {
		try {
			Map<String, List<String>> grepResult = new AlgorithmExercise4().grepRecursively(CASE_2_TOP_LEVEL_FOLDER_PATH, "③④⑤⑥");
			assertNotNull("nullを返しています。仕様を確認しましょう。", grepResult);
			assertTrue("Mapに含まれるべきkeyが入っていません。仕様を確認しましょう。",  grepResult.containsKey(Paths.get(CASE_2_TOP_LEVEL_FOLDER_PATH, CASE_2_SECOND_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString()));
			List<String> grepContents = grepResult.get(Paths.get(CASE_2_TOP_LEVEL_FOLDER_PATH, CASE_2_SECOND_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString());
			assertNotNull("Mapのvalueにnullが入っています。仕様を確認しましょう。", grepContents);
			assertThat("行を正しく抽出できていません。", grepContents.size(), is(1));
			assertTrue("行を正しく抽出できていません。", grepContents.contains("2:①②③④⑤⑥⑦⑧⑨"));
		} catch (NullPointerException e) {
			e.printStackTrace();
			fail("NullチェックをしてExceptionは発生させないようにしましょう。");
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			Map<String, List<String>> grepResult = new AlgorithmExercise4().grepRecursively(CASE_2_TOP_LEVEL_FOLDER_PATH, "―∥－…～￢￠￡");
			assertNotNull("nullを返しています。仕様を確認しましょう。", grepResult);
			assertTrue("Mapに含まれるべきkeyが入っていません。仕様を確認しましょう。",  grepResult.containsKey(Paths.get(CASE_2_TOP_LEVEL_FOLDER_PATH, CASE_2_SECOND_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString()));
			List<String> grepContents = grepResult.get(Paths.get(CASE_2_TOP_LEVEL_FOLDER_PATH, CASE_2_SECOND_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString());
			assertNotNull("Mapのvalueにnullが入っています。仕様を確認しましょう。", grepContents);
			assertThat("行を正しく抽出できていません。", grepContents.size(), is(2));
			assertTrue("行を正しく抽出できていません。", grepContents.containsAll(Arrays.asList("3:―∥－…～￢￠￡", "5:―∥－…～￢￠￡")));
		} catch (NullPointerException e) {
			e.printStackTrace();
			fail("NullチェックをしてExceptionは発生させないようにしましょう。");
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			Map<String, List<String>> grepResult = new AlgorithmExercise4().grepRecursively(CASE_2_TOP_LEVEL_FOLDER_PATH, "㈱h");
			assertNotNull("nullを返しています。仕様を確認しましょう。", grepResult);
			assertTrue("Mapに含まれるべきkeyが入っていません。仕様を確認しましょう。",  grepResult.containsKey(Paths.get(CASE_2_TOP_LEVEL_FOLDER_PATH, CASE_2_SECOND_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString()));
			List<String> grepContents = grepResult.get(Paths.get(CASE_2_TOP_LEVEL_FOLDER_PATH, CASE_2_SECOND_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString());
			assertNotNull("Mapのvalueにnullが入っています。仕様を確認しましょう。", grepContents);
			assertThat("行を正しく抽出できていません。", grepContents.size(), is(1));
			assertTrue("行を正しく抽出できていません。", grepContents.contains("10:㈱hoge"));
		} catch (NullPointerException e) {
			e.printStackTrace();
			fail("NullチェックをしてExceptionは発生させないようにしましょう。");
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			Map<String, List<String>> grepResult = new AlgorithmExercise4().grepRecursively(CASE_2_TOP_LEVEL_FOLDER_PATH, "AABCA");
			assertNotNull("nullを返しています。仕様を確認しましょう。", grepResult);
			assertTrue("Mapに含まれるべきkeyが入っていません。仕様を確認しましょう。",  grepResult.containsKey(Paths.get(CASE_2_TOP_LEVEL_FOLDER_PATH, CASE_2_SECOND_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString()));
			List<String> grepContents = grepResult.get(Paths.get(CASE_2_TOP_LEVEL_FOLDER_PATH, CASE_2_SECOND_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString());
			assertNotNull("Mapのvalueにnullが入っています。仕様を確認しましょう。", grepContents);
			assertTrue("行を正しく抽出できていません。", grepContents.isEmpty());
		} catch (NullPointerException e) {
			e.printStackTrace();
			fail("NullチェックをしてExceptionは発生させないようにしましょう。");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGrepRecursivelyCase3() {
		try {
			Map<String, List<String>> grepResult = new AlgorithmExercise4().grepRecursively(CASE_3_TOP_LEVEL_FOLDER_PATH, "③④⑤⑥");
			assertNotNull("nullを返しています。仕様を確認しましょう。", grepResult);
			assertTrue("Mapに含まれるべきkeyが入っていません。仕様を確認しましょう。",  grepResult.containsKey(Paths.get(CASE_3_TOP_LEVEL_FOLDER_PATH, CASE_3_SECOND_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString()));
			List<String> grepSecondLevelFile1Contents = grepResult.get(Paths.get(CASE_3_TOP_LEVEL_FOLDER_PATH, CASE_3_SECOND_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString());
			assertNotNull("Mapのvalueにnullが入っています。仕様を確認しましょう。", grepSecondLevelFile1Contents);
			assertThat("行を正しく抽出できていません。", grepSecondLevelFile1Contents.size(), is(6));
			assertTrue("行を正しく抽出できていません。", grepSecondLevelFile1Contents.containsAll(
					Arrays.asList("2:①②③④⑤⑥⑦⑧⑨", "3:⑨①②③④⑤⑥⑦⑧", "4:⑧⑨①②③④⑤⑥⑦", "5:⑦⑧⑨①②③④⑤⑥", "9:③④⑤⑥⑦⑧⑨①②", "10:②③④⑤⑥⑦⑧⑨①")));
			assertTrue("Mapに含まれるべきkeyが入っていません。仕様を確認しましょう。",  grepResult.containsKey(Paths.get(CASE_3_TOP_LEVEL_FOLDER_PATH, CASE_3_SECOND_LEVEL_FILE_2_RELATIVE_PATH).toAbsolutePath().toString()));
			List<String> grepSecondLevelFile2Contents = grepResult.get(Paths.get(CASE_3_TOP_LEVEL_FOLDER_PATH, CASE_3_SECOND_LEVEL_FILE_2_RELATIVE_PATH).toAbsolutePath().toString());
			assertNotNull("Mapのvalueにnullが入っています。仕様を確認しましょう。", grepSecondLevelFile2Contents);
			assertTrue("行を正しく抽出できていません。", grepSecondLevelFile2Contents.isEmpty());
		} catch (NullPointerException e) {
			e.printStackTrace();
			fail("NullチェックをしてExceptionは発生させないようにしましょう。");
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			Map<String, List<String>> grepResult = new AlgorithmExercise4().grepRecursively(CASE_3_TOP_LEVEL_FOLDER_PATH, "…～￢");
			assertNotNull("nullを返しています。仕様を確認しましょう。", grepResult);
			assertTrue("Mapに含まれるべきkeyが入っていません。仕様を確認しましょう。",  grepResult.containsKey(Paths.get(CASE_3_TOP_LEVEL_FOLDER_PATH, CASE_3_SECOND_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString()));
			List<String> grepSecondLevelFile1Contents = grepResult.get(Paths.get(CASE_3_TOP_LEVEL_FOLDER_PATH, CASE_3_SECOND_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString());
			assertNotNull("Mapのvalueにnullが入っています。仕様を確認しましょう。", grepSecondLevelFile1Contents);
			assertThat("行を正しく抽出できていません。", grepSecondLevelFile1Contents.size(), is(1));
			assertTrue("行を正しく抽出できていません。", grepSecondLevelFile1Contents.contains("1:―∥－…～￢￠￡"));
			assertTrue("Mapに含まれるべきkeyが入っていません。仕様を確認しましょう。",  grepResult.containsKey(Paths.get(CASE_3_TOP_LEVEL_FOLDER_PATH, CASE_3_SECOND_LEVEL_FILE_2_RELATIVE_PATH).toAbsolutePath().toString()));
			List<String> grepSecondLevelFile2Contents = grepResult.get(Paths.get(CASE_3_TOP_LEVEL_FOLDER_PATH, CASE_3_SECOND_LEVEL_FILE_2_RELATIVE_PATH).toAbsolutePath().toString());
			assertNotNull("Mapのvalueにnullが入っています。仕様を確認しましょう。", grepSecondLevelFile2Contents);
			assertThat("行を正しく抽出できていません。", grepSecondLevelFile2Contents.size(), is(2));
			assertTrue("行を正しく抽出できていません。", grepSecondLevelFile2Contents.containsAll(Arrays.asList("2:―∥－…～￢￠￡", "3:―∥－…～￢￠￡")));
		} catch (NullPointerException e) {
			e.printStackTrace();
			fail("NullチェックをしてExceptionは発生させないようにしましょう。");
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			Map<String, List<String>> grepResult = new AlgorithmExercise4().grepRecursively(CASE_3_TOP_LEVEL_FOLDER_PATH, "AABCA");
			assertNotNull("nullを返しています。仕様を確認しましょう。", grepResult);
			assertTrue("Mapに含まれるべきkeyが入っていません。仕様を確認しましょう。",  grepResult.containsKey(Paths.get(CASE_3_TOP_LEVEL_FOLDER_PATH, CASE_3_SECOND_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString()));
			List<String> grepSecondLevelFile1Contents = grepResult.get(Paths.get(CASE_3_TOP_LEVEL_FOLDER_PATH, CASE_3_SECOND_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString());
			assertNotNull("Mapのvalueにnullが入っています。仕様を確認しましょう。", grepSecondLevelFile1Contents);
			assertTrue("行を正しく抽出できていません。", grepSecondLevelFile1Contents.isEmpty());
			assertTrue("Mapに含まれるべきkeyが入っていません。仕様を確認しましょう。",  grepResult.containsKey(Paths.get(CASE_3_TOP_LEVEL_FOLDER_PATH, CASE_3_SECOND_LEVEL_FILE_2_RELATIVE_PATH).toAbsolutePath().toString()));
			List<String> grepSecondLevelFile2Contents = grepResult.get(Paths.get(CASE_3_TOP_LEVEL_FOLDER_PATH, CASE_3_SECOND_LEVEL_FILE_2_RELATIVE_PATH).toAbsolutePath().toString());
			assertNotNull("Mapのvalueにnullが入っています。仕様を確認しましょう。", grepSecondLevelFile2Contents);
			assertTrue("行を正しく抽出できていません。", grepSecondLevelFile2Contents.isEmpty());
		} catch (NullPointerException e) {
			e.printStackTrace();
			fail("NullチェックをしてExceptionは発生させないようにしましょう。");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGrepRecursivelyCase4() {
		try {
			Map<String, List<String>> grepResult = new AlgorithmExercise4().grepRecursively(CASE_4_TOP_LEVEL_FOLDER_PATH, "③④⑤⑥");
			assertNotNull("nullを返しています。仕様を確認しましょう。", grepResult);
			assertTrue("Mapに含まれるべきkeyが入っていません。仕様を確認しましょう。",  grepResult.containsKey(Paths.get(CASE_4_TOP_LEVEL_FOLDER_PATH, CASE_4_SECOND_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString()));
			List<String> grepSecondLevelFile1Contents = grepResult.get(Paths.get(CASE_4_TOP_LEVEL_FOLDER_PATH, CASE_4_SECOND_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString());
			assertNotNull("Mapのvalueにnullが入っています。仕様を確認しましょう。", grepSecondLevelFile1Contents);
			assertThat("行を正しく抽出できていません。", grepSecondLevelFile1Contents.size(), is(2));
			assertTrue("行を正しく抽出できていません。", grepSecondLevelFile1Contents.containsAll(Arrays.asList("4:⑧⑨①②③④⑤⑥⑦", "5:⑦⑧⑨①②③④⑤⑥")));
			assertTrue("Mapに含まれるべきkeyが入っていません。仕様を確認しましょう。",  grepResult.containsKey(Paths.get(CASE_4_TOP_LEVEL_FOLDER_PATH, CASE_4_SECOND_LEVEL_FILE_2_RELATIVE_PATH).toAbsolutePath().toString()));
			List<String> grepSecondLevelFile2Contents = grepResult.get(Paths.get(CASE_4_TOP_LEVEL_FOLDER_PATH, CASE_4_SECOND_LEVEL_FILE_2_RELATIVE_PATH).toAbsolutePath().toString());
			assertNotNull("Mapのvalueにnullが入っています。仕様を確認しましょう。", grepSecondLevelFile2Contents);
			assertThat("行を正しく抽出できていません。", grepSecondLevelFile2Contents.size(), is(1));
			assertTrue("行を正しく抽出できていません。", grepSecondLevelFile2Contents.contains("2:①②③④⑤⑥⑦⑧⑨"));
			assertTrue("Mapに含まれるべきkeyが入っていません。仕様を確認しましょう。",  grepResult.containsKey(Paths.get(CASE_4_TOP_LEVEL_FOLDER_PATH, CASE_4_SECOND_LEVEL_FOLDER_1_RELATIVE_PATH, CASE_4_THIRD_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString()));
			List<String> grepThirdLevelFile1Contents = grepResult.get(Paths.get(CASE_4_TOP_LEVEL_FOLDER_PATH, CASE_4_SECOND_LEVEL_FOLDER_1_RELATIVE_PATH, CASE_4_THIRD_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString());
			assertNotNull("Mapのvalueにnullが入っています。仕様を確認しましょう。", grepThirdLevelFile1Contents);
			assertTrue("行を正しく抽出できていません。", grepThirdLevelFile1Contents.isEmpty());
			assertTrue("Mapに含まれるべきkeyが入っていません。仕様を確認しましょう。",  grepResult.containsKey(Paths.get(CASE_4_TOP_LEVEL_FOLDER_PATH, CASE_4_SECOND_LEVEL_FOLDER_1_RELATIVE_PATH, CASE_4_THIRD_LEVEL_FILE_2_RELATIVE_PATH).toAbsolutePath().toString()));
			List<String> grepThirdLevelFile2Contents = grepResult.get(Paths.get(CASE_4_TOP_LEVEL_FOLDER_PATH, CASE_4_SECOND_LEVEL_FOLDER_1_RELATIVE_PATH, CASE_4_THIRD_LEVEL_FILE_2_RELATIVE_PATH).toAbsolutePath().toString());
			assertNotNull("Mapのvalueにnullが入っています。仕様を確認しましょう。", grepThirdLevelFile2Contents);
			assertThat("行を正しく抽出できていません。", grepThirdLevelFile2Contents.size(), is(3));
			assertTrue("行を正しく抽出できていません。", grepThirdLevelFile2Contents.containsAll(Arrays.asList("1:①②③④⑤⑥⑦⑧⑨", "4:⑧⑨①②③④⑤⑥⑦", "5:⑦⑧⑨①②③④⑤⑥")));
		} catch (NullPointerException e) {
			e.printStackTrace();
			fail("NullチェックをしてExceptionは発生させないようにしましょう。");
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			Map<String, List<String>> grepResult = new AlgorithmExercise4().grepRecursively(CASE_4_TOP_LEVEL_FOLDER_PATH, "㈱h");
			assertNotNull("nullを返しています。仕様を確認しましょう。", grepResult);
			assertTrue("Mapに含まれるべきkeyが入っていません。仕様を確認しましょう。",  grepResult.containsKey(Paths.get(CASE_4_TOP_LEVEL_FOLDER_PATH, CASE_4_SECOND_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString()));
			List<String> grepSecondLevelFile1Contents = grepResult.get(Paths.get(CASE_4_TOP_LEVEL_FOLDER_PATH, CASE_4_SECOND_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString());
			assertNotNull("Mapのvalueにnullが入っています。仕様を確認しましょう。", grepSecondLevelFile1Contents);
			assertThat("行を正しく抽出できていません。", grepSecondLevelFile1Contents.size(), is(2));
			assertTrue("行を正しく抽出できていません。", grepSecondLevelFile1Contents.containsAll(Arrays.asList("9:㈱hoge", "10:㈱h")));
			assertTrue("Mapに含まれるべきkeyが入っていません。仕様を確認しましょう。",  grepResult.containsKey(Paths.get(CASE_4_TOP_LEVEL_FOLDER_PATH, CASE_4_SECOND_LEVEL_FILE_2_RELATIVE_PATH).toAbsolutePath().toString()));
			List<String> grepSecondLevelFile2Contents = grepResult.get(Paths.get(CASE_4_TOP_LEVEL_FOLDER_PATH, CASE_4_SECOND_LEVEL_FILE_2_RELATIVE_PATH).toAbsolutePath().toString());
			assertNotNull("Mapのvalueにnullが入っています。仕様を確認しましょう。", grepSecondLevelFile2Contents);
			assertThat("行を正しく抽出できていません。", grepSecondLevelFile2Contents.size(), is(1));
			assertTrue("行を正しく抽出できていません。", grepSecondLevelFile2Contents.contains("4:㈱hoge"));
			assertTrue("Mapに含まれるべきkeyが入っていません。仕様を確認しましょう。",  grepResult.containsKey(Paths.get(CASE_4_TOP_LEVEL_FOLDER_PATH, CASE_4_SECOND_LEVEL_FOLDER_1_RELATIVE_PATH, CASE_4_THIRD_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString()));
			List<String> grepThirdLevelFile1Contents = grepResult.get(Paths.get(CASE_4_TOP_LEVEL_FOLDER_PATH, CASE_4_SECOND_LEVEL_FOLDER_1_RELATIVE_PATH, CASE_4_THIRD_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString());
			assertNotNull("Mapのvalueにnullが入っています。仕様を確認しましょう。", grepThirdLevelFile1Contents);
			assertTrue("行を正しく抽出できていません。", grepThirdLevelFile1Contents.isEmpty());
			assertTrue("Mapに含まれるべきkeyが入っていません。仕様を確認しましょう。",  grepResult.containsKey(Paths.get(CASE_4_TOP_LEVEL_FOLDER_PATH, CASE_4_SECOND_LEVEL_FOLDER_1_RELATIVE_PATH, CASE_4_THIRD_LEVEL_FILE_2_RELATIVE_PATH).toAbsolutePath().toString()));
			List<String> grepThirdLevelFile2Contents = grepResult.get(Paths.get(CASE_4_TOP_LEVEL_FOLDER_PATH, CASE_4_SECOND_LEVEL_FOLDER_1_RELATIVE_PATH, CASE_4_THIRD_LEVEL_FILE_2_RELATIVE_PATH).toAbsolutePath().toString());
			assertNotNull("Mapのvalueにnullが入っています。仕様を確認しましょう。", grepThirdLevelFile2Contents);
			assertTrue("行を正しく抽出できていません。", grepThirdLevelFile2Contents.isEmpty());
		} catch (NullPointerException e) {
			e.printStackTrace();
			fail("NullチェックをしてExceptionは発生させないようにしましょう。");
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			Map<String, List<String>> grepResult = new AlgorithmExercise4().grepRecursively(CASE_4_TOP_LEVEL_FOLDER_PATH, "AABCA");
			assertNotNull("nullを返しています。仕様を確認しましょう。", grepResult);
			assertTrue("Mapに含まれるべきkeyが入っていません。仕様を確認しましょう。",  grepResult.containsKey(Paths.get(CASE_4_TOP_LEVEL_FOLDER_PATH, CASE_4_SECOND_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString()));
			List<String> grepSecondLevelFile1Contents = grepResult.get(Paths.get(CASE_4_TOP_LEVEL_FOLDER_PATH, CASE_4_SECOND_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString());
			assertNotNull("Mapのvalueにnullが入っています。仕様を確認しましょう。", grepSecondLevelFile1Contents);
			assertTrue("行を正しく抽出できていません。", grepSecondLevelFile1Contents.isEmpty());
			assertTrue("Mapに含まれるべきkeyが入っていません。仕様を確認しましょう。",  grepResult.containsKey(Paths.get(CASE_4_TOP_LEVEL_FOLDER_PATH, CASE_4_SECOND_LEVEL_FILE_2_RELATIVE_PATH).toAbsolutePath().toString()));
			List<String> grepSecondLevelFile2Contents = grepResult.get(Paths.get(CASE_4_TOP_LEVEL_FOLDER_PATH, CASE_4_SECOND_LEVEL_FILE_2_RELATIVE_PATH).toAbsolutePath().toString());
			assertNotNull("Mapのvalueにnullが入っています。仕様を確認しましょう。", grepSecondLevelFile2Contents);
			assertTrue("行を正しく抽出できていません。", grepSecondLevelFile2Contents.isEmpty());
			assertTrue("Mapに含まれるべきkeyが入っていません。仕様を確認しましょう。",  grepResult.containsKey(Paths.get(CASE_4_TOP_LEVEL_FOLDER_PATH, CASE_4_SECOND_LEVEL_FOLDER_1_RELATIVE_PATH, CASE_4_THIRD_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString()));
			List<String> grepThirdLevelFile1Contents = grepResult.get(Paths.get(CASE_4_TOP_LEVEL_FOLDER_PATH, CASE_4_SECOND_LEVEL_FOLDER_1_RELATIVE_PATH, CASE_4_THIRD_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString());
			assertNotNull("Mapのvalueにnullが入っています。仕様を確認しましょう。", grepThirdLevelFile1Contents);
			assertTrue("行を正しく抽出できていません。", grepThirdLevelFile1Contents.isEmpty());
			assertTrue("Mapに含まれるべきkeyが入っていません。仕様を確認しましょう。",  grepResult.containsKey(Paths.get(CASE_4_TOP_LEVEL_FOLDER_PATH, CASE_4_SECOND_LEVEL_FOLDER_1_RELATIVE_PATH, CASE_4_THIRD_LEVEL_FILE_2_RELATIVE_PATH).toAbsolutePath().toString()));
			List<String> grepThirdLevelFile2Contents = grepResult.get(Paths.get(CASE_4_TOP_LEVEL_FOLDER_PATH, CASE_4_SECOND_LEVEL_FOLDER_1_RELATIVE_PATH, CASE_4_THIRD_LEVEL_FILE_2_RELATIVE_PATH).toAbsolutePath().toString());
			assertNotNull("Mapのvalueにnullが入っています。仕様を確認しましょう。", grepThirdLevelFile2Contents);
			assertTrue("行を正しく抽出できていません。", grepSecondLevelFile2Contents.isEmpty());
		} catch (NullPointerException e) {
			e.printStackTrace();
			fail("NullチェックをしてExceptionは発生させないようにしましょう。");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGrepRecursivelyCase5() {
		try {
			Map<String, List<String>> grepResult = new AlgorithmExercise4().grepRecursively(CASE_5_TOP_LEVEL_FOLDER_PATH, "③④⑤⑥");
			assertNotNull("nullを返しています。仕様を確認しましょう。", grepResult);
			assertTrue("Mapに含まれるべきkeyが入っていません。仕様を確認しましょう。",  grepResult.containsKey(Paths.get(CASE_5_TOP_LEVEL_FOLDER_PATH, CASE_5_SECOND_LEVEL_FOLDER_2_RELATIVE_PATH,CASE_5_THIRD_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString()));
			List<String> grepThirdLevelFile1Contents = grepResult.get(Paths.get(CASE_5_TOP_LEVEL_FOLDER_PATH, CASE_5_SECOND_LEVEL_FOLDER_2_RELATIVE_PATH,CASE_5_THIRD_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString());
			assertNotNull("Mapのvalueにnullが入っています。仕様を確認しましょう。", grepThirdLevelFile1Contents);
			assertTrue("行を正しく抽出できていません。", grepThirdLevelFile1Contents.isEmpty());
			assertTrue("Mapに含まれるべきkeyが入っていません。仕様を確認しましょう。",  grepResult.containsKey(Paths.get(CASE_5_TOP_LEVEL_FOLDER_PATH, CASE_5_SECOND_LEVEL_FOLDER_1_RELATIVE_PATH,
					CASE_5_THIRD_LEVEL_FOLDER_1_RELATIVE_PATH, CASE_5_FOURTH_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString()));
			List<String> grepFourthLevelFile1Contents = grepResult.get(Paths.get(CASE_5_TOP_LEVEL_FOLDER_PATH, CASE_5_SECOND_LEVEL_FOLDER_1_RELATIVE_PATH,
					CASE_5_THIRD_LEVEL_FOLDER_1_RELATIVE_PATH, CASE_5_FOURTH_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString());
			assertNotNull("Mapのvalueにnullが入っています。仕様を確認しましょう。", grepFourthLevelFile1Contents);
			assertThat("行を正しく抽出できていません。", grepFourthLevelFile1Contents.size(), is(1));
			assertTrue("行を正しく抽出できていません。", grepFourthLevelFile1Contents.contains("2:①②③④⑤⑥⑦⑧⑨"));
		} catch (NullPointerException e) {
			e.printStackTrace();
			fail("NullチェックをしてExceptionは発生させないようにしましょう。");
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			Map<String, List<String>> grepResult = new AlgorithmExercise4().grepRecursively(CASE_5_TOP_LEVEL_FOLDER_PATH, "…～￢");
			assertNotNull("nullを返しています。仕様を確認しましょう。", grepResult);
			assertTrue("Mapに含まれるべきkeyが入っていません。仕様を確認しましょう。",  grepResult.containsKey(Paths.get(CASE_5_TOP_LEVEL_FOLDER_PATH, CASE_5_SECOND_LEVEL_FOLDER_2_RELATIVE_PATH,CASE_5_THIRD_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString()));
			List<String> grepThirdLevelFile1Contents = grepResult.get(Paths.get(CASE_5_TOP_LEVEL_FOLDER_PATH, CASE_5_SECOND_LEVEL_FOLDER_2_RELATIVE_PATH,CASE_5_THIRD_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString());
			assertNotNull("Mapのvalueにnullが入っています。仕様を確認しましょう。", grepThirdLevelFile1Contents);
			assertThat("行を正しく抽出できていません。", grepThirdLevelFile1Contents.size(), is(1));
			assertTrue("行を正しく抽出できていません。", grepThirdLevelFile1Contents.contains("3:―∥－…～￢￠￡"));
			assertTrue("Mapに含まれるべきkeyが入っていません。仕様を確認しましょう。",  grepResult.containsKey(Paths.get(CASE_5_TOP_LEVEL_FOLDER_PATH, CASE_5_SECOND_LEVEL_FOLDER_1_RELATIVE_PATH,
					CASE_5_THIRD_LEVEL_FOLDER_1_RELATIVE_PATH, CASE_5_FOURTH_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString()));
			List<String> grepFourthLevelFile1Contents = grepResult.get(Paths.get(CASE_5_TOP_LEVEL_FOLDER_PATH, CASE_5_SECOND_LEVEL_FOLDER_1_RELATIVE_PATH,
					CASE_5_THIRD_LEVEL_FOLDER_1_RELATIVE_PATH, CASE_5_FOURTH_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString());
			assertNotNull("Mapのvalueにnullが入っています。仕様を確認しましょう。", grepFourthLevelFile1Contents);
			assertThat("行を正しく抽出できていません。", grepFourthLevelFile1Contents.size(), is(6));
			assertTrue("行を正しく抽出できていません。", grepFourthLevelFile1Contents.containsAll(
					Arrays.asList("3:―∥－…～￢￠￡", "4:￡―∥－…～￢￠", "5:￠￡―∥－…～￢", "8:…～￢￠￡―∥－", "9:－…～￢￠￡―∥", "10:∥－…～￢￠￡―")));
		} catch (NullPointerException e) {
			e.printStackTrace();
			fail("NullチェックをしてExceptionは発生させないようにしましょう。");
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			Map<String, List<String>> grepResult = new AlgorithmExercise4().grepRecursively(CASE_5_TOP_LEVEL_FOLDER_PATH, "㈱h");
			assertNotNull("nullを返しています。仕様を確認しましょう。", grepResult);
			assertTrue("Mapに含まれるべきkeyが入っていません。仕様を確認しましょう。",  grepResult.containsKey(Paths.get(CASE_5_TOP_LEVEL_FOLDER_PATH, CASE_5_SECOND_LEVEL_FOLDER_2_RELATIVE_PATH,CASE_5_THIRD_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString()));
			List<String> grepThirdLevelFile1Contents = grepResult.get(Paths.get(CASE_5_TOP_LEVEL_FOLDER_PATH, CASE_5_SECOND_LEVEL_FOLDER_2_RELATIVE_PATH,CASE_5_THIRD_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString());
			assertNotNull("Mapのvalueにnullが入っています。仕様を確認しましょう。", grepThirdLevelFile1Contents);
			assertThat("行を正しく抽出できていません。", grepThirdLevelFile1Contents.size(), is(1));
			assertTrue("行を正しく抽出できていません。", grepThirdLevelFile1Contents.contains("2:―∥－…㈱h\\s～￢￠￡"));
			assertTrue("Mapに含まれるべきkeyが入っていません。仕様を確認しましょう。",  grepResult.containsKey(Paths.get(CASE_5_TOP_LEVEL_FOLDER_PATH, CASE_5_SECOND_LEVEL_FOLDER_1_RELATIVE_PATH,
					CASE_5_THIRD_LEVEL_FOLDER_1_RELATIVE_PATH, CASE_5_FOURTH_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString()));
			List<String> grepFourthLevelFile1Contents = grepResult.get(Paths.get(CASE_5_TOP_LEVEL_FOLDER_PATH, CASE_5_SECOND_LEVEL_FOLDER_1_RELATIVE_PATH,
					CASE_5_THIRD_LEVEL_FOLDER_1_RELATIVE_PATH, CASE_5_FOURTH_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString());
			assertNotNull("Mapのvalueにnullが入っています。仕様を確認しましょう。", grepFourthLevelFile1Contents);
			assertTrue("行を正しく抽出できていません。", grepFourthLevelFile1Contents.isEmpty());
		} catch (NullPointerException e) {
			e.printStackTrace();
			fail("NullチェックをしてExceptionは発生させないようにしましょう。");
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			Map<String, List<String>> grepResult = new AlgorithmExercise4().grepRecursively(CASE_5_TOP_LEVEL_FOLDER_PATH, "AABCA");
			assertNotNull("nullを返しています。仕様を確認しましょう。", grepResult);
			assertTrue("Mapに含まれるべきkeyが入っていません。仕様を確認しましょう。",  grepResult.containsKey(Paths.get(CASE_5_TOP_LEVEL_FOLDER_PATH, CASE_5_SECOND_LEVEL_FOLDER_2_RELATIVE_PATH,CASE_5_THIRD_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString()));
			List<String> grepThirdLevelFile1Contents = grepResult.get(Paths.get(CASE_5_TOP_LEVEL_FOLDER_PATH, CASE_5_SECOND_LEVEL_FOLDER_2_RELATIVE_PATH,CASE_5_THIRD_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString());
			assertNotNull("Mapのvalueにnullが入っています。仕様を確認しましょう。", grepThirdLevelFile1Contents);
			assertTrue("行を正しく抽出できていません。", grepThirdLevelFile1Contents.isEmpty());
			assertTrue("Mapに含まれるべきkeyが入っていません。仕様を確認しましょう。",  grepResult.containsKey(Paths.get(CASE_5_TOP_LEVEL_FOLDER_PATH, CASE_5_SECOND_LEVEL_FOLDER_1_RELATIVE_PATH,
					CASE_5_THIRD_LEVEL_FOLDER_1_RELATIVE_PATH, CASE_5_FOURTH_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString()));
			List<String> grepFourthLevelFile1Contents = grepResult.get(Paths.get(CASE_5_TOP_LEVEL_FOLDER_PATH, CASE_5_SECOND_LEVEL_FOLDER_1_RELATIVE_PATH,
					CASE_5_THIRD_LEVEL_FOLDER_1_RELATIVE_PATH, CASE_5_FOURTH_LEVEL_FILE_1_RELATIVE_PATH).toAbsolutePath().toString());
			assertNotNull("Mapのvalueにnullが入っています。仕様を確認しましょう。", grepFourthLevelFile1Contents);
			assertTrue("行を正しく抽出できていません。", grepFourthLevelFile1Contents.isEmpty());
		} catch (NullPointerException e) {
			e.printStackTrace();
			fail("NullチェックをしてExceptionは発生させないようにしましょう。");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@After
	protected void tearDown() throws Exception {
		tearFoldersDown();
		super.tearDown();
	}

	private void tearFoldersDown() {
		try {
			FileOperationUtils.deleteDirRecursivelyIfExists(CASE_0_TOP_LEVEL_FILE_PATH);
			FileOperationUtils.deleteDirRecursivelyIfExists(CASE_1_TOP_LEVEL_FOLDER_PATH);
			FileOperationUtils.deleteDirRecursivelyIfExists(CASE_2_TOP_LEVEL_FOLDER_PATH);
			FileOperationUtils.deleteDirRecursivelyIfExists(CASE_3_TOP_LEVEL_FOLDER_PATH);
			FileOperationUtils.deleteDirRecursivelyIfExists(CASE_4_TOP_LEVEL_FOLDER_PATH);
			FileOperationUtils.deleteDirRecursivelyIfExists(CASE_5_TOP_LEVEL_FOLDER_PATH);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

package jp.co.worksap.ate.bootcamp.java1000.algorithm;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.Assert.assertThat;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jp.co.worksap.ate.bootcamp.java1000.database.ConnectionGetter;
import jp.co.worksap.ate.bootcamp.java1000.stream.FileContentUtils;
import junit.framework.TestCase;

public class AlgorithmExercise2Test extends TestCase {

	private static final String ENCODE_DEFAULT = System.getProperty("file.encoding");
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	private static final String FILE_INITIAL_CONTENTS = "9:その他のサーバ" + LINE_SEPARATOR + LINE_SEPARATOR;

	private File file;

	private ConnectionGetter connectionGetter;
	private Connection connection;


	@Before
	protected void setUp() throws Exception {
		super.setUp();
		setUpDb();
		setUpFile();
	}

	private void setUpDb() throws ClassNotFoundException, SQLException {
		Class.forName("org.h2.Driver");
		connectionGetter = new ConnectionGetter("jdbc:h2:mem:BootCamp", null, null);
		connection = connectionGetter.getNewConnection();
	}

	private void setUpFile() {
		file = new File("testFileWriteDefEncode");
		if (file.exists()) {
			file.delete();
		}
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), ENCODE_DEFAULT));) {
			Files.write(Paths.get(file.getPath()), FILE_INITIAL_CONTENTS.getBytes(Charset.defaultCharset()));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@After
	protected void tearDown() throws Exception {
		tearDownFile();
		connection.close();
		super.tearDown();
	}

	private void tearDownFile() {
		if (!file.exists()) {
			return;
		}
		if (!file.delete()) {
			file.deleteOnExit();
		}
	}

	@Test
	public void testWriteAllData() {
		Map<Integer, String> testDataMap = prepareTestData();

		try {
			executeSql("create table category (cat_id number(10,0) primary key, cat_nm varchar(255))");
		} catch (SQLException e) {
			fail("致命的エラー");
		}

		try (
				PreparedStatement ps = connection.prepareStatement("insert into category (cat_id, cat_nm) values (?, ?)");	) {
			for (Integer catId : testDataMap.keySet()) {
				ps.setInt(1, catId.intValue());
				ps.setString(2, testDataMap.get(catId));
				ps.addBatch();
			}
			ps.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
			fail("致命的エラー");
		}

		try {
			new AlgorithmExercise2().writeAllData(file.getPath(), connection);
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertThat("DBの内容とファイルの内容が合致していません。",
				FileContentUtils.getFileContents(file, ENCODE_DEFAULT), is(getContentString(testDataMap, FILE_INITIAL_CONTENTS)));

		try {
			executeSql("drop table category");
		} catch (SQLException e) {
			fail("致命的エラー");
		}

		try {
			new AlgorithmExercise2().writeAllData(file.getPath(), connection);
		} catch (Exception e) {
			if (e instanceof SQLException) {
				fail("SQLException を throw してはいけません。");
			}
		}

		File absentFile = new File("absentFile");
		if (absentFile.exists() && !absentFile.delete()) {
			fail("致命的エラー");
		}

		try {
			new AlgorithmExercise2().writeAllData(absentFile.getPath(), connection);
		} catch (NoSuchFileException e) {
			e.printStackTrace();
			fail("書き込み対象ファイルが存在しない場合の例外処理が正しくありません。");
		} catch (FileNotFoundException e) {

		} catch (Exception e) {
			//throws宣言を増やしてもコンパイルエラーにならないようにしている。
			fail("書き込み対象ファイルが存在しない場合の例外処理が正しくありません。");
		}
	}

	private Map<Integer, String> prepareTestData() {
		Map<Integer, String> map = new LinkedHashMap<>();
		map.put(1, "DBサーバ");
		map.put(2, "BATCHサーバ");
		map.put(3, "APサーバ");
		map.put(4, "WEBサーバ");
		return map;
	}

	private int executeSql(String sql) throws SQLException {
		try (
				PreparedStatement ps = connection.prepareStatement(sql);	) {
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	private String getContentString(Map<Integer, String> testDataMap, String initContents) {
		StringBuilder sb = new StringBuilder();
		sb.append(initContents);
		for (Integer key : testDataMap.keySet()) {
			sb.append(AlgorithmExercise2.getRecordCombinedString(Integer.toString(key.intValue()), testDataMap.get(key)));
			sb.append(LINE_SEPARATOR);
		}
		return sb.toString();
	}

}

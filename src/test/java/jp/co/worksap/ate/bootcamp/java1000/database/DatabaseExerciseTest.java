package jp.co.worksap.ate.bootcamp.java1000.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import jp.co.worksap.ate.bootcamp.java1000.database.DatabaseExercise;
import jp.co.worksap.ate.bootcamp.java1000.database.jdbc.MockConnection;
import junit.framework.TestCase;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.ITable;
import org.dbunit.ext.h2.H2DataTypeFactory;

public class DatabaseExerciseTest extends TestCase {

	public DatabaseExerciseTest() {
		// TODO Auto-generated constructor stub
	}

	private ConnectionGetter conGetter = null;
	private Connection connection = null;

	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();

		Class.forName("org.h2.Driver");
		conGetter = new ConnectionGetter("jdbc:h2:mem:BootCamp", null, null);
		connection = conGetter.getNewConnection();
	}

	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		connection.close();
		super.tearDown();
	}

	public void testInsertSyain() throws SQLException {
		executeUpdate("create table syain (" + "sya_id number(10,0) primary key," + "sya_nm varchar(255)" + " )");

		if (!new DatabaseExercise().insertSyain(connection, 1, "hoge")) {
			fail("insert に失敗しました" + 1 + ",hoge");
		}

		assertTrue("PreparedStatementは確実に解放してください", ((MockConnection) connection).isAllPreparedStatementClosed());
		assertFalse("外部から渡ってきたConnectionを勝手にCloseしてはいけません。", connection.isClosed());

		try {
			ITable actual = getConnection().createQueryTable("SYAIN", "select sya_id, sya_nm from syain");
			assertEquals(1, actual.getRowCount());
			assertEquals("1", actual.getValue(0, "sya_id").toString());
			assertEquals("hoge", actual.getValue(0, "sya_nm"));
		} catch (DataSetException e) {
			e.printStackTrace();
			fail("致命的エラー");
		}

		if (new DatabaseExercise().insertSyain(connection, 1, "hogehoge")) {
			fail("プライマリーキーを２重に登録しようとしているのに成功してしまいます。");
		}

		assertTrue("PreparedStatementは確実に解放してください", ((MockConnection) connection).isAllPreparedStatementClosed());
		assertFalse("外部から渡ってきたConnectionを勝手にCloseしてはいけません。", connection.isClosed());

		if (!new DatabaseExercise().insertSyain(connection, 10, "hogehoge2")) {
			fail("insert に失敗しました" + 10 + ",hogehoge2");
		}

		try {
			ITable actual = getConnection().createQueryTable("SYAIN", "select sya_id, sya_nm from syain");
			assertEquals(2, actual.getRowCount());
			assertEquals("1", actual.getValue(0, "sya_id").toString());
			assertEquals("hoge", actual.getValue(0, "sya_nm"));
			assertEquals("10", actual.getValue(1, "sya_id").toString());
			assertEquals("hogehoge2", actual.getValue(1, "sya_nm"));
		} catch (DataSetException e) {
			e.printStackTrace();
			fail("致命的エラー");
		}

		assertTrue("PreparedStatementは確実に解放してください", ((MockConnection) connection).isAllPreparedStatementClosed());
		assertFalse("外部から渡ってきたConnectionを勝手にCloseしてはいけません。", connection.isClosed());

		if (!new DatabaseExercise().insertSyain(connection, 15, null)) {
			fail("insert に失敗しました" + 15 + ",null");
		}

		try {
			ITable actual = getConnection().createQueryTable("SYAIN", "select sya_id, sya_nm from syain");
			assertEquals(3, actual.getRowCount());
			assertEquals("1", actual.getValue(0, "sya_id").toString());
			assertEquals("hoge", actual.getValue(0, "sya_nm"));
			assertEquals("10", actual.getValue(1, "sya_id").toString());
			assertEquals("hogehoge2", actual.getValue(1, "sya_nm"));
			assertEquals("15", actual.getValue(2, "sya_id").toString());
			assertEquals(null, actual.getValue(2, "sya_nm"));
		} catch (DataSetException e) {
			e.printStackTrace();
			fail("致命的エラー");
		}

		assertTrue("PreparedStatementは確実に解放してください", ((MockConnection) connection).isAllPreparedStatementClosed());
		assertFalse("外部から渡ってきたConnectionを勝手にCloseしてはいけません。", connection.isClosed());

		executeUpdate("drop table syain");

	}

	public void testUpdateSyain() {
		PreparedStatement ps = null;
		Date baseDate = new Date(System.currentTimeMillis());
		try {
			executeUpdate("create table syain (" 
					+ "sya_id number(10,0) primary key," 
					+ "sya_nm varchar(255), " 
					+ "deleted number(1,0), " 
					+ "prc_date date" + " )");


			ps = connection.prepareStatement("insert into syain (sya_id, sya_nm, deleted, prc_date) values(?,?,0,?)");
			ps.setInt(1, 1);
			ps.setString(2, "oka");
			ps.setDate(3, new Date(baseDate.getTime() - (9 * 24 * 60 * 60 * 1000)));
			ps.addBatch();

			ps.setInt(1, 2);
			ps.setString(2, "kudo");
			ps.setDate(3, new Date(baseDate.getTime() - (6 * 24 * 60 * 60 * 1000)));
			ps.addBatch();

			ps.setInt(1, 3);
			ps.setString(2, "hattori");
			ps.setDate(3, new Date(baseDate.getTime() - (3 * 24 * 60 * 60 * 1000)));
			ps.addBatch();

			ps.setInt(1, 4);
			ps.setString(2, "kuri");
			ps.setDate(3, baseDate);
			ps.addBatch();

			ps.setInt(1, 5);
			ps.setString(2, "utumi");
			ps.setDate(3, new Date(baseDate.getTime() + (3 * 24 * 60 * 60 * 1000)));
			ps.addBatch();

			ps.setInt(1, 6);
			ps.setString(2, "tanaka");
			ps.setDate(3, new Date(baseDate.getTime() + (6 * 24 * 60 * 60 * 1000)));
			ps.addBatch();

			ps.executeBatch();

		} catch (SQLException e) {
			e.printStackTrace();
			fail("致命的エラー");
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		int updateCount;
		try {
			updateCount = new DatabaseExercise().updateSyain(connection, baseDate);
			assertEquals("更新行数が合いません。where句が間違っていませんか?", 4, updateCount);

			ITable actual = getConnection().createQueryTable("SYAIN", "select sya_id from syain where deleted = 1");

			assertEquals("deletedが1の行の数が合いません。更新する値を間違っていませんか？", 4, actual.getRowCount());

			updateCount = new DatabaseExercise().updateSyain(connection, new Date(baseDate.getTime() + (4 * 24 * 60 * 60 * 1000)));
			assertEquals("更新行数が合いません。where句が間違っていませんか?", 5, updateCount);

			actual = getConnection().createQueryTable("SYAIN", "select sya_id from syain where deleted = 1");

			assertEquals("deletedが1の行の数が合いません。更新する値を間違っていませんか？", 5, actual.getRowCount());

			updateCount = new DatabaseExercise().updateSyain(connection, null);
			assertEquals(0, updateCount);


		} catch (SQLException e1) {
			e1.printStackTrace();
			fail("致命的エラー");
		} catch (DataSetException e) {
			e.printStackTrace();
			fail("致命的エラー");
		}


		try {
			((MockConnection) connection).setThrowExceptionInPreparedStatement(true);
			updateCount = new DatabaseExercise().updateSyain(connection, null);
			fail("executeUpdateが失敗した場合はSQLExceptionを投げ返してください");
		} catch (SQLException e1) {

		} finally {
			((MockConnection) connection).setThrowExceptionInPreparedStatement(false);
		}

		try {
			assertTrue("PreparedStatementは確実に解放してください", ((MockConnection) connection).isAllPreparedStatementClosed());
			assertFalse("外部から渡ってきたConnectionを勝手にCloseしてはいけません。", connection.isClosed());
		} catch (SQLException e1) {
			e1.printStackTrace();
			fail("致命的エラー");
		}



		try {
			executeUpdate("drop table syain");
		} catch (SQLException e) {
			e.printStackTrace();
			fail("致命的エラー");
		}
	}

	public final void testSelectMst() {
		PreparedStatement ps = null;
		try {
			executeUpdate("create table category (" 
					+ "cat_id number(10,0) primary key," 
					+ "cat_nm varchar(255))");
			ps = connection.prepareStatement("insert into category (cat_id, cat_nm) values (?, ?)");
			ps.setInt(1, 1);
			ps.setString(2, "開発");
			ps.addBatch();

			ps.setInt(1, 2);
			ps.setString(2, "コンサル");
			ps.addBatch();

			ps.setInt(1, 3);
			ps.setString(2, "営業");
			ps.addBatch();

			ps.setInt(1, 4);
			ps.setString(2, "管理");
			ps.addBatch();

			ps.executeBatch(); 
		} catch (SQLException e) {
			e.printStackTrace();
			fail("致命的エラー");
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
					fail("致命的エラー");
				}
			}
		}

		try {
			Map<Integer, String> map = new DatabaseExercise().selectMst(connection);
			assertNotNull("nullが返ってきています", map);
			assertEquals("Mapに余計なデータが入力されているか,又はデータが足りません。", 4, map.size());
			assertEquals("データが正しくMapに登録されていません。keyはInteger,valueはStringです。", "開発", map.get(new Integer(1)));
			assertEquals("データが正しくMapに登録されていません。keyはInteger,valueはStringです。", "コンサル", map.get(new Integer(2)));
			assertEquals("データが正しくMapに登録されていません。keyはInteger,valueはStringです。", "営業", map.get(new Integer(3)));
			assertEquals("データが正しくMapに登録されていません。keyはInteger,valueはStringです。", "管理", map.get(new Integer(4)));
		} catch (SQLException e1) {
			e1.printStackTrace();
			fail("致命的エラー");
		}

		assertTrue("PreparedStatementの実行でエラーが記録されました。closeに失敗していませんか？", ((MockConnection) connection).isAllPreparedStatementNotHaveError());
		assertTrue("PreparedStatementは確実に解放してください", ((MockConnection) connection).isAllPreparedStatementClosed());
		assertTrue("ResultSetは確実に解放してください", ((MockConnection) connection).isAllResultSetClosed());


		try {
			((MockConnection) connection).setThrowExceptionInPreparedStatement(true);
			new DatabaseExercise().selectMst(connection);
			fail("executeUpdateが失敗した場合はSQLExceptionを投げ返してください");
		} catch (SQLException e1) {

		} finally {
			((MockConnection) connection).setThrowExceptionInPreparedStatement(false);
		}
		assertTrue("PreparedStatementの実行でエラーが記録されました。closeに失敗していませんか？", ((MockConnection) connection).isAllPreparedStatementNotHaveError());
		assertTrue("ResultSetは確実に解放してください", ((MockConnection) connection).isAllResultSetClosed());
		assertTrue("PreparedStatementは確実に解放してください", ((MockConnection) connection).isAllPreparedStatementClosed());

		try {
			executeUpdate("drop table category");
		} catch (SQLException e) {
			e.printStackTrace();
			fail("致命的エラー");
		}
	}

	// 以下プライベートメソッドなど

	private IDatabaseConnection getConnection() {
		try {
			IDatabaseConnection con = new DatabaseConnection(connection);
			con.getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new H2DataTypeFactory());
			return con;
		} catch (DatabaseUnitException e) {
			e.printStackTrace();
			fail("致命的エラー");
			return null;
		}
	}

	private int executeUpdate(String sql) throws SQLException {

		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement(sql);
			return ps.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}

package jp.co.worksap.ate.bootcamp.java1000.exception;

import java.sql.SQLException;

/*
 * このクラスは変更しないでください。
 *
 */
public class DaoMock {

	static final String CORRECT_SQL = "insert into syain_tbl (sya_id) values (1)";

	/**
	 * SQLを実行するメソッドです。
	 * @param sql
	 * @throws SQLException
	 */
	public static void executeUpdate(String sql) throws SQLException {
		if (sql == null) {
			throw new NullPointerException();
		}

		if (sql.equals(CORRECT_SQL)) {
			return;
		}

		throw new SQLException();
	}

	public static void throwRuntimeException() {
		throw new RuntimeException();
	}


}

package jp.co.worksap.ate.bootcamp.java1000.database.jdbc;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;

public class MockPreparedStatement implements PreparedStatement, IMockStatement{
	private PreparedStatement impl = null;

	private boolean throwExceptionAtExecute = false;

	public MockPreparedStatement(PreparedStatement ps, boolean throwExcept) throws SQLException {
		if (ps == null) {
			throw new SQLException();
		}
		this.throwExceptionAtExecute = throwExcept;
		impl = ps;
		isClosed = false;
	}

	public MockPreparedStatement(PreparedStatement ps) throws SQLException {
		this(ps, false);
	}

	private boolean isClosed;

	/**
	 * クローズされているかどうかを確認
	 * @return
	 */
	@Override
	public boolean isClosed() {
		return isClosed;
	}

	private boolean hasError = false;
	@Override
	public boolean hasError() {
		return hasError;
	}

	public void close() throws SQLException {
		try {
			if (resultSet != null && !((MockResultSet)resultSet).isClosed()) {
				hasError = true;
				throw new SQLException("ResultSetを先にcloseしてください。");
			}

			impl.close();
			isClosed = true;
		} catch (SQLException e) {
			throw e;
		}
	}

	private ResultSet resultSet = null;
	public ResultSet executeQuery() throws SQLException {
		if (throwExceptionAtExecute) {
			throw new SQLException();
		}

		resultSet =  new MockResultSet(impl.executeQuery());
		return resultSet;
	}

	public int executeUpdate() throws SQLException {
		if (throwExceptionAtExecute) {
			throw new SQLException();
		}

		return impl.executeUpdate();
	}

	public ResultSet executeQuery(String sql) throws SQLException {
		if (throwExceptionAtExecute) {
			throw new SQLException();
		}

		return impl.executeQuery(sql);
	}

	public int executeUpdate(String sql) throws SQLException {
		if (throwExceptionAtExecute) {
			throw new SQLException();
		}

		return impl.executeUpdate(sql);
	}

	public boolean execute(String sql) throws SQLException {
		if (throwExceptionAtExecute) {
			throw new SQLException();
		}

		return impl.execute(sql);
	}

	public ResultSet getResultSet() throws SQLException {
		return resultSet;
	}


	// 以下ただの委譲メソッド

	public void setNull(int parameterIndex, int sqlType) throws SQLException {
		impl.setNull(parameterIndex, sqlType);
	}

	public void setBoolean(int parameterIndex, boolean x) throws SQLException {
		impl.setBoolean(parameterIndex, x);
	}

	public int getMaxFieldSize() throws SQLException {
		return impl.getMaxFieldSize();
	}

	public void setByte(int parameterIndex, byte x) throws SQLException {
		impl.setByte(parameterIndex, x);
	}

	public void setShort(int parameterIndex, short x) throws SQLException {
		impl.setShort(parameterIndex, x);
	}

	public void setMaxFieldSize(int max) throws SQLException {
		impl.setMaxFieldSize(max);
	}

	public void setInt(int parameterIndex, int x) throws SQLException {
		impl.setInt(parameterIndex, x);
	}

	public int getMaxRows() throws SQLException {
		return impl.getMaxRows();
	}

	public void setLong(int parameterIndex, long x) throws SQLException {
		impl.setLong(parameterIndex, x);
	}

	public void setFloat(int parameterIndex, float x) throws SQLException {
		impl.setFloat(parameterIndex, x);
	}

	public void setMaxRows(int max) throws SQLException {
		impl.setMaxRows(max);
	}

	public void setDouble(int parameterIndex, double x) throws SQLException {
		impl.setDouble(parameterIndex, x);
	}

	public void setEscapeProcessing(boolean enable) throws SQLException {
		impl.setEscapeProcessing(enable);
	}

	public void setBigDecimal(int parameterIndex, BigDecimal x)
			throws SQLException {
		impl.setBigDecimal(parameterIndex, x);
	}

	public int getQueryTimeout() throws SQLException {
		return impl.getQueryTimeout();
	}

	public void setString(int parameterIndex, String x) throws SQLException {
		impl.setString(parameterIndex, x);
	}

	public void setQueryTimeout(int seconds) throws SQLException {
		impl.setQueryTimeout(seconds);
	}

	public void setBytes(int parameterIndex, byte[] x) throws SQLException {
		impl.setBytes(parameterIndex, x);
	}

	public void cancel() throws SQLException {
		impl.cancel();
	}

	public SQLWarning getWarnings() throws SQLException {
		return impl.getWarnings();
	}

	public void setDate(int parameterIndex, Date x) throws SQLException {
		impl.setDate(parameterIndex, x);
	}

	public void setTime(int parameterIndex, Time x) throws SQLException {
		impl.setTime(parameterIndex, x);
	}

	public void setTimestamp(int parameterIndex, Timestamp x)
			throws SQLException {
		impl.setTimestamp(parameterIndex, x);
	}

	public void clearWarnings() throws SQLException {
		impl.clearWarnings();
	}

	public void setAsciiStream(int parameterIndex, InputStream x, int length)
			throws SQLException {
		impl.setAsciiStream(parameterIndex, x, length);
	}

	public void setCursorName(String name) throws SQLException {
		impl.setCursorName(name);
	}

	@SuppressWarnings("deprecation")
	public void setUnicodeStream(int parameterIndex, InputStream x, int length)
			throws SQLException {
		impl.setUnicodeStream(parameterIndex, x, length);
	}

	public void setBinaryStream(int parameterIndex, InputStream x, int length)
			throws SQLException {
		impl.setBinaryStream(parameterIndex, x, length);
	}


	public int getUpdateCount() throws SQLException {
		return impl.getUpdateCount();
	}

	public void clearParameters() throws SQLException {
		impl.clearParameters();
	}

	public boolean getMoreResults() throws SQLException {
		return impl.getMoreResults();
	}

	public void setObject(int parameterIndex, Object x, int targetSqlType,
			int scale) throws SQLException {
		impl.setObject(parameterIndex, x, targetSqlType, scale);
	}

	public void setFetchDirection(int direction) throws SQLException {
		impl.setFetchDirection(direction);
	}

	public int getFetchDirection() throws SQLException {
		return impl.getFetchDirection();
	}

	public void setObject(int parameterIndex, Object x, int targetSqlType)
			throws SQLException {
		impl.setObject(parameterIndex, x, targetSqlType);
	}

	public void setFetchSize(int rows) throws SQLException {
		impl.setFetchSize(rows);
	}

	public void setObject(int parameterIndex, Object x) throws SQLException {
		impl.setObject(parameterIndex, x);
	}

	public int getFetchSize() throws SQLException {
		return impl.getFetchSize();
	}

	public int getResultSetConcurrency() throws SQLException {
		return impl.getResultSetConcurrency();
	}

	public int getResultSetType() throws SQLException {
		return impl.getResultSetType();
	}

	public boolean execute() throws SQLException {
		return impl.execute();
	}

	public void addBatch(String sql) throws SQLException {
		impl.addBatch(sql);
	}

	public void clearBatch() throws SQLException {
		impl.clearBatch();
	}

	public void addBatch() throws SQLException {
		impl.addBatch();
	}

	public int[] executeBatch() throws SQLException {
		return impl.executeBatch();
	}

	public void setCharacterStream(int parameterIndex, Reader reader, int length)
			throws SQLException {
		impl.setCharacterStream(parameterIndex, reader, length);
	}

	public void setRef(int i, Ref x) throws SQLException {
		impl.setRef(i, x);
	}

	public void setBlob(int i, Blob x) throws SQLException {
		impl.setBlob(i, x);
	}

	public void setClob(int i, Clob x) throws SQLException {
		impl.setClob(i, x);
	}

	public Connection getConnection() throws SQLException {
		return impl.getConnection();
	}

	public void setArray(int i, Array x) throws SQLException {
		impl.setArray(i, x);
	}

	public ResultSetMetaData getMetaData() throws SQLException {
		return impl.getMetaData();
	}

	public void setDate(int parameterIndex, Date x, Calendar cal)
			throws SQLException {
		impl.setDate(parameterIndex, x, cal);
	}

	public boolean getMoreResults(int current) throws SQLException {
		return impl.getMoreResults(current);
	}

	public void setTime(int parameterIndex, Time x, Calendar cal)
			throws SQLException {
		impl.setTime(parameterIndex, x, cal);
	}

	public ResultSet getGeneratedKeys() throws SQLException {
		return impl.getGeneratedKeys();
	}

	public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal)
			throws SQLException {
		impl.setTimestamp(parameterIndex, x, cal);
	}

	public int executeUpdate(String sql, int autoGeneratedKeys)
			throws SQLException {
		return impl.executeUpdate(sql, autoGeneratedKeys);
	}

	public void setNull(int paramIndex, int sqlType, String typeName)
			throws SQLException {
		impl.setNull(paramIndex, sqlType, typeName);
	}

	public int executeUpdate(String sql, int[] columnIndexes)
			throws SQLException {
		return impl.executeUpdate(sql, columnIndexes);
	}

	public void setURL(int parameterIndex, URL x) throws SQLException {
		impl.setURL(parameterIndex, x);
	}

	public int executeUpdate(String sql, String[] columnNames)
			throws SQLException {
		return impl.executeUpdate(sql, columnNames);
	}

	public ParameterMetaData getParameterMetaData() throws SQLException {
		return impl.getParameterMetaData();
	}

	public boolean execute(String sql, int autoGeneratedKeys)
			throws SQLException {
		return impl.execute(sql, autoGeneratedKeys);
	}

	public boolean execute(String sql, int[] columnIndexes) throws SQLException {
		return impl.execute(sql, columnIndexes);
	}

	public boolean execute(String sql, String[] columnNames)
			throws SQLException {
		return impl.execute(sql, columnNames);
	}

	public int getResultSetHoldability() throws SQLException {
		return impl.getResultSetHoldability();
	}

	@Override
	public void setPoolable(boolean poolable) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public boolean isPoolable() throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public void setRowId(int parameterIndex, RowId x) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void setNString(int parameterIndex, String value)
			throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void setNCharacterStream(int parameterIndex, Reader value,
			long length) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void setNClob(int parameterIndex, NClob value) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void setClob(int parameterIndex, Reader reader, long length)
			throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void setBlob(int parameterIndex, InputStream inputStream, long length)
			throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void setNClob(int parameterIndex, Reader reader, long length)
			throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void setSQLXML(int parameterIndex, SQLXML xmlObject)
			throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void setAsciiStream(int parameterIndex, InputStream x, long length)
			throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void setBinaryStream(int parameterIndex, InputStream x, long length)
			throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void setCharacterStream(int parameterIndex, Reader reader,
			long length) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void setAsciiStream(int parameterIndex, InputStream x)
			throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void setBinaryStream(int parameterIndex, InputStream x)
			throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void setCharacterStream(int parameterIndex, Reader reader)
			throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void setNCharacterStream(int parameterIndex, Reader value)
			throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void setClob(int parameterIndex, Reader reader) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void setBlob(int parameterIndex, InputStream inputStream)
			throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void setNClob(int parameterIndex, Reader reader) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void closeOnCompletion() throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public boolean isCloseOnCompletion() throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

}

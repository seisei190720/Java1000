package jp.co.worksap.ate.bootcamp.java1000.database.jdbc;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;


public class MockResultSet implements ResultSet{
	private ResultSet impl = null;

	public MockResultSet(ResultSet rs) throws SQLException {
		if (rs == null) {
			throw new SQLException();
		}
		this.impl = rs;
	}

	public boolean isClosed() {
		return isClosed;
	}

	private boolean isClosed = false;
	public void close() throws SQLException {
		impl.close();
		isClosed = true;
	}

	//以下ただの委譲メソッド

	public boolean next() throws SQLException {
		return impl.next();
	}

	public boolean wasNull() throws SQLException {
		return impl.wasNull();
	}

	public String getString(int columnIndex) throws SQLException {
		return impl.getString(columnIndex);
	}

	public boolean getBoolean(int columnIndex) throws SQLException {
		return impl.getBoolean(columnIndex);
	}

	public byte getByte(int columnIndex) throws SQLException {
		return impl.getByte(columnIndex);
	}

	public short getShort(int columnIndex) throws SQLException {
		return impl.getShort(columnIndex);
	}

	public int getInt(int columnIndex) throws SQLException {
		return impl.getInt(columnIndex);
	}

	public long getLong(int columnIndex) throws SQLException {
		return impl.getLong(columnIndex);
	}

	public float getFloat(int columnIndex) throws SQLException {
		return impl.getFloat(columnIndex);
	}

	public double getDouble(int columnIndex) throws SQLException {
		return impl.getDouble(columnIndex);
	}

	@SuppressWarnings("deprecation")
	public BigDecimal getBigDecimal(int columnIndex, int scale) throws SQLException {
		return impl.getBigDecimal(columnIndex, scale);
	}

	public byte[] getBytes(int columnIndex) throws SQLException {
		return impl.getBytes(columnIndex);
	}

	public Date getDate(int columnIndex) throws SQLException {
		return impl.getDate(columnIndex);
	}

	public Time getTime(int columnIndex) throws SQLException {
		return impl.getTime(columnIndex);
	}

	public Timestamp getTimestamp(int columnIndex) throws SQLException {
		return impl.getTimestamp(columnIndex);
	}

	public InputStream getAsciiStream(int columnIndex) throws SQLException {
		return impl.getAsciiStream(columnIndex);
	}

	@SuppressWarnings("deprecation")
	public InputStream getUnicodeStream(int columnIndex) throws SQLException {
		return impl.getUnicodeStream(columnIndex);
	}

	public InputStream getBinaryStream(int columnIndex) throws SQLException {
		return impl.getBinaryStream(columnIndex);
	}

	public String getString(String columnName) throws SQLException {
		return impl.getString(columnName);
	}

	public boolean getBoolean(String columnName) throws SQLException {
		return impl.getBoolean(columnName);
	}

	public byte getByte(String columnName) throws SQLException {
		return impl.getByte(columnName);
	}

	public short getShort(String columnName) throws SQLException {
		return impl.getShort(columnName);
	}

	public int getInt(String columnName) throws SQLException {
		return impl.getInt(columnName);
	}

	public long getLong(String columnName) throws SQLException {
		return impl.getLong(columnName);
	}

	public float getFloat(String columnName) throws SQLException {
		return impl.getFloat(columnName);
	}

	public double getDouble(String columnName) throws SQLException {
		return impl.getDouble(columnName);
	}

	@SuppressWarnings("deprecation")
	public BigDecimal getBigDecimal(String columnName, int scale) throws SQLException {
		return impl.getBigDecimal(columnName, scale);
	}

	public byte[] getBytes(String columnName) throws SQLException {
		return impl.getBytes(columnName);
	}

	public Date getDate(String columnName) throws SQLException {
		return impl.getDate(columnName);
	}

	public Time getTime(String columnName) throws SQLException {
		return impl.getTime(columnName);
	}

	public Timestamp getTimestamp(String columnName) throws SQLException {
		return impl.getTimestamp(columnName);
	}

	public InputStream getAsciiStream(String columnName) throws SQLException {
		return impl.getAsciiStream(columnName);
	}

	@SuppressWarnings("deprecation")
	public InputStream getUnicodeStream(String columnName) throws SQLException {
		return impl.getUnicodeStream(columnName);
	}

	public InputStream getBinaryStream(String columnName) throws SQLException {
		return impl.getBinaryStream(columnName);
	}

	public SQLWarning getWarnings() throws SQLException {
		return impl.getWarnings();
	}

	public void clearWarnings() throws SQLException {
		impl.clearWarnings();
	}

	public String getCursorName() throws SQLException {
		return impl.getCursorName();
	}

	public ResultSetMetaData getMetaData() throws SQLException {
		return impl.getMetaData();
	}

	public Object getObject(int columnIndex) throws SQLException {
		return impl.getObject(columnIndex);
	}

	public Object getObject(String columnName) throws SQLException {
		return impl.getObject(columnName);
	}

	public int findColumn(String columnName) throws SQLException {
		return impl.findColumn(columnName);
	}

	public Reader getCharacterStream(int columnIndex) throws SQLException {
		return impl.getCharacterStream(columnIndex);
	}

	public Reader getCharacterStream(String columnName) throws SQLException {
		return impl.getCharacterStream(columnName);
	}

	public BigDecimal getBigDecimal(int columnIndex) throws SQLException {
		return impl.getBigDecimal(columnIndex);
	}

	public BigDecimal getBigDecimal(String columnName) throws SQLException {
		return impl.getBigDecimal(columnName);
	}

	public boolean isBeforeFirst() throws SQLException {
		return impl.isBeforeFirst();
	}

	public boolean isAfterLast() throws SQLException {
		return impl.isAfterLast();
	}

	public boolean isFirst() throws SQLException {
		return impl.isFirst();
	}

	public boolean isLast() throws SQLException {
		return impl.isLast();
	}

	public void beforeFirst() throws SQLException {
		impl.beforeFirst();
	}

	public void afterLast() throws SQLException {
		impl.afterLast();
	}

	public boolean first() throws SQLException {
		return impl.first();
	}

	public boolean last() throws SQLException {
		return impl.last();
	}

	public int getRow() throws SQLException {
		return impl.getRow();
	}

	public boolean absolute(int row) throws SQLException {
		return impl.absolute(row);
	}

	public boolean relative(int rows) throws SQLException {
		return impl.relative(rows);
	}

	public boolean previous() throws SQLException {
		return impl.previous();
	}

	public void setFetchDirection(int direction) throws SQLException {
		impl.setFetchDirection(direction);
	}

	public int getFetchDirection() throws SQLException {
		return impl.getFetchDirection();
	}

	public void setFetchSize(int rows) throws SQLException {
		impl.setFetchSize(rows);
	}

	public int getFetchSize() throws SQLException {
		return impl.getFetchSize();
	}

	public int getType() throws SQLException {
		return impl.getType();
	}

	public int getConcurrency() throws SQLException {
		return impl.getConcurrency();
	}

	public boolean rowUpdated() throws SQLException {
		return impl.rowUpdated();
	}

	public boolean rowInserted() throws SQLException {
		return impl.rowInserted();
	}

	public boolean rowDeleted() throws SQLException {
		return impl.rowDeleted();
	}

	public void updateNull(int columnIndex) throws SQLException {
		impl.updateNull(columnIndex);
	}

	public void updateBoolean(int columnIndex, boolean x) throws SQLException {
		impl.updateBoolean(columnIndex, x);
	}

	public void updateByte(int columnIndex, byte x) throws SQLException {
		impl.updateByte(columnIndex, x);
	}

	public void updateShort(int columnIndex, short x) throws SQLException {
		impl.updateShort(columnIndex, x);
	}

	public void updateInt(int columnIndex, int x) throws SQLException {
		impl.updateInt(columnIndex, x);
	}

	public void updateLong(int columnIndex, long x) throws SQLException {
		impl.updateLong(columnIndex, x);
	}

	public void updateFloat(int columnIndex, float x) throws SQLException {
		impl.updateFloat(columnIndex, x);
	}

	public void updateDouble(int columnIndex, double x) throws SQLException {
		impl.updateDouble(columnIndex, x);
	}

	public void updateBigDecimal(int columnIndex, BigDecimal x) throws SQLException {
		impl.updateBigDecimal(columnIndex, x);
	}

	public void updateString(int columnIndex, String x) throws SQLException {
		impl.updateString(columnIndex, x);
	}

	public void updateBytes(int columnIndex, byte[] x) throws SQLException {
		impl.updateBytes(columnIndex, x);
	}

	public void updateDate(int columnIndex, Date x) throws SQLException {
		impl.updateDate(columnIndex, x);
	}

	public void updateTime(int columnIndex, Time x) throws SQLException {
		impl.updateTime(columnIndex, x);
	}

	public void updateTimestamp(int columnIndex, Timestamp x) throws SQLException {
		impl.updateTimestamp(columnIndex, x);
	}

	public void updateAsciiStream(int columnIndex, InputStream x, int length) throws SQLException {
		impl.updateAsciiStream(columnIndex, x, length);
	}

	public void updateBinaryStream(int columnIndex, InputStream x, int length) throws SQLException {
		impl.updateBinaryStream(columnIndex, x, length);
	}

	public void updateCharacterStream(int columnIndex, Reader x, int length) throws SQLException {
		impl.updateCharacterStream(columnIndex, x, length);
	}

	public void updateObject(int columnIndex, Object x, int scale) throws SQLException {
		impl.updateObject(columnIndex, x, scale);
	}

	public void updateObject(int columnIndex, Object x) throws SQLException {
		impl.updateObject(columnIndex, x);
	}

	public void updateNull(String columnName) throws SQLException {
		impl.updateNull(columnName);
	}

	public void updateBoolean(String columnName, boolean x) throws SQLException {
		impl.updateBoolean(columnName, x);
	}

	public void updateByte(String columnName, byte x) throws SQLException {
		impl.updateByte(columnName, x);
	}

	public void updateShort(String columnName, short x) throws SQLException {
		impl.updateShort(columnName, x);
	}

	public void updateInt(String columnName, int x) throws SQLException {
		impl.updateInt(columnName, x);
	}

	public void updateLong(String columnName, long x) throws SQLException {
		impl.updateLong(columnName, x);
	}

	public void updateFloat(String columnName, float x) throws SQLException {
		impl.updateFloat(columnName, x);
	}

	public void updateDouble(String columnName, double x) throws SQLException {
		impl.updateDouble(columnName, x);
	}

	public void updateBigDecimal(String columnName, BigDecimal x) throws SQLException {
		impl.updateBigDecimal(columnName, x);
	}

	public void updateString(String columnName, String x) throws SQLException {
		impl.updateString(columnName, x);
	}

	public void updateBytes(String columnName, byte[] x) throws SQLException {
		impl.updateBytes(columnName, x);
	}

	public void updateDate(String columnName, Date x) throws SQLException {
		impl.updateDate(columnName, x);
	}

	public void updateTime(String columnName, Time x) throws SQLException {
		impl.updateTime(columnName, x);
	}

	public void updateTimestamp(String columnName, Timestamp x) throws SQLException {
		impl.updateTimestamp(columnName, x);
	}

	public void updateAsciiStream(String columnName, InputStream x, int length) throws SQLException {
		impl.updateAsciiStream(columnName, x, length);
	}

	public void updateBinaryStream(String columnName, InputStream x, int length) throws SQLException {
		impl.updateBinaryStream(columnName, x, length);
	}

	public void updateCharacterStream(String columnName, Reader reader, int length) throws SQLException {
		impl.updateCharacterStream(columnName, reader, length);
	}

	public void updateObject(String columnName, Object x, int scale) throws SQLException {
		impl.updateObject(columnName, x, scale);
	}

	public void updateObject(String columnName, Object x) throws SQLException {
		impl.updateObject(columnName, x);
	}

	public void insertRow() throws SQLException {
		impl.insertRow();
	}

	public void updateRow() throws SQLException {
		impl.updateRow();
	}

	public void deleteRow() throws SQLException {
		impl.deleteRow();
	}

	public void refreshRow() throws SQLException {
		impl.refreshRow();
	}

	public void cancelRowUpdates() throws SQLException {
		impl.cancelRowUpdates();
	}

	public void moveToInsertRow() throws SQLException {
		impl.moveToInsertRow();
	}

	public void moveToCurrentRow() throws SQLException {
		impl.moveToCurrentRow();
	}

	public Statement getStatement() throws SQLException {
		return impl.getStatement();
	}

	public Object getObject(int i, Map<String, Class<?>> map) throws SQLException {
		return impl.getObject(i, map);
	}

	public Ref getRef(int i) throws SQLException {
		return impl.getRef(i);
	}

	public Blob getBlob(int i) throws SQLException {
		return impl.getBlob(i);
	}

	public Clob getClob(int i) throws SQLException {
		return impl.getClob(i);
	}

	public Array getArray(int i) throws SQLException {
		return impl.getArray(i);
	}

	public Object getObject(String colName, Map<String, Class<?>> map) throws SQLException {
		return impl.getObject(colName, map);
	}

	public Ref getRef(String colName) throws SQLException {
		return impl.getRef(colName);
	}

	public Blob getBlob(String colName) throws SQLException {
		return impl.getBlob(colName);
	}

	public Clob getClob(String colName) throws SQLException {
		return impl.getClob(colName);
	}

	public Array getArray(String colName) throws SQLException {
		return impl.getArray(colName);
	}

	public Date getDate(int columnIndex, Calendar cal) throws SQLException {
		return impl.getDate(columnIndex, cal);
	}

	public Date getDate(String columnName, Calendar cal) throws SQLException {
		return impl.getDate(columnName, cal);
	}

	public Time getTime(int columnIndex, Calendar cal) throws SQLException {
		return impl.getTime(columnIndex, cal);
	}

	public Time getTime(String columnName, Calendar cal) throws SQLException {
		return impl.getTime(columnName, cal);
	}

	public Timestamp getTimestamp(int columnIndex, Calendar cal) throws SQLException {
		return impl.getTimestamp(columnIndex, cal);
	}

	public Timestamp getTimestamp(String columnName, Calendar cal) throws SQLException {
		return impl.getTimestamp(columnName, cal);
	}

	public URL getURL(int columnIndex) throws SQLException {
		return impl.getURL(columnIndex);
	}

	public URL getURL(String columnName) throws SQLException {
		return impl.getURL(columnName);
	}

	public void updateRef(int columnIndex, Ref x) throws SQLException {
		impl.updateRef(columnIndex, x);
	}

	public void updateRef(String columnName, Ref x) throws SQLException {
		impl.updateRef(columnName, x);
	}

	public void updateBlob(int columnIndex, Blob x) throws SQLException {
		impl.updateBlob(columnIndex, x);
	}

	public void updateBlob(String columnName, Blob x) throws SQLException {
		impl.updateBlob(columnName, x);
	}

	public void updateClob(int columnIndex, Clob x) throws SQLException {
		impl.updateClob(columnIndex, x);
	}

	public void updateClob(String columnName, Clob x) throws SQLException {
		impl.updateClob(columnName, x);
	}

	public void updateArray(int columnIndex, Array x) throws SQLException {
		impl.updateArray(columnIndex, x);
	}

	public void updateArray(String columnName, Array x) throws SQLException {
		impl.updateArray(columnName, x);
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
	public RowId getRowId(int columnIndex) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public RowId getRowId(String columnLabel) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void updateRowId(int columnIndex, RowId x) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void updateRowId(String columnLabel, RowId x) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public int getHoldability() throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public void updateNString(int columnIndex, String nString)
			throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void updateNString(String columnLabel, String nString)
			throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void updateNClob(int columnIndex, NClob nClob) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void updateNClob(String columnLabel, NClob nClob)
			throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public NClob getNClob(int columnIndex) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public NClob getNClob(String columnLabel) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public SQLXML getSQLXML(int columnIndex) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public SQLXML getSQLXML(String columnLabel) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void updateSQLXML(int columnIndex, SQLXML xmlObject)
			throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void updateSQLXML(String columnLabel, SQLXML xmlObject)
			throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public String getNString(int columnIndex) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public String getNString(String columnLabel) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Reader getNCharacterStream(int columnIndex) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Reader getNCharacterStream(String columnLabel) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void updateNCharacterStream(int columnIndex, Reader x, long length)
			throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void updateNCharacterStream(String columnLabel, Reader reader,
			long length) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void updateAsciiStream(int columnIndex, InputStream x, long length)
			throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void updateBinaryStream(int columnIndex, InputStream x, long length)
			throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void updateCharacterStream(int columnIndex, Reader x, long length)
			throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void updateAsciiStream(String columnLabel, InputStream x, long length)
			throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void updateBinaryStream(String columnLabel, InputStream x,
			long length) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void updateCharacterStream(String columnLabel, Reader reader,
			long length) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void updateBlob(int columnIndex, InputStream inputStream, long length)
			throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void updateBlob(String columnLabel, InputStream inputStream,
			long length) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void updateClob(int columnIndex, Reader reader, long length)
			throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void updateClob(String columnLabel, Reader reader, long length)
			throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void updateNClob(int columnIndex, Reader reader, long length)
			throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void updateNClob(String columnLabel, Reader reader, long length)
			throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void updateNCharacterStream(int columnIndex, Reader x)
			throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void updateNCharacterStream(String columnLabel, Reader reader)
			throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void updateAsciiStream(int columnIndex, InputStream x)
			throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void updateBinaryStream(int columnIndex, InputStream x)
			throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void updateCharacterStream(int columnIndex, Reader x)
			throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void updateAsciiStream(String columnLabel, InputStream x)
			throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void updateBinaryStream(String columnLabel, InputStream x)
			throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void updateCharacterStream(String columnLabel, Reader reader)
			throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void updateBlob(int columnIndex, InputStream inputStream)
			throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void updateBlob(String columnLabel, InputStream inputStream)
			throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void updateClob(int columnIndex, Reader reader) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void updateClob(String columnLabel, Reader reader)
			throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void updateNClob(int columnIndex, Reader reader) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void updateNClob(String columnLabel, Reader reader)
			throws SQLException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public <T> T getObject(int columnIndex, Class<T> type) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public <T> T getObject(String columnLabel, Class<T> type)
			throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}



}

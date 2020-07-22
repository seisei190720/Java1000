package jp.co.worksap.ate.bootcamp.java1000.database.jdbc;

import java.sql.Statement;

public interface IMockStatement extends Statement{
	boolean isClosed();
	boolean hasError();
}

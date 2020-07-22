package jp.co.worksap.ate.bootcamp.java1000.exception;

import java.io.IOException;

public interface Resource extends AutoCloseable{
	public void open() throws IOException;
	public void work() throws IOException;
	public void close() throws IOException;
}

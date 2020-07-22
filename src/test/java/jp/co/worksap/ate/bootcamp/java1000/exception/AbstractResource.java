package jp.co.worksap.ate.bootcamp.java1000.exception;

import java.io.IOException;

public class AbstractResource implements Resource{

	protected boolean opend = false;
	protected boolean closed = false;
	protected boolean used = false;

	public void open() throws IOException{
		opend = true;
	}

	public void work() throws IOException {
		used = true;
	}

	public void close() throws IOException {
		closed = true;
	}

	final boolean isUsed() {
		return used;
	}

	final boolean isOpend() {
		return opend;
	}

	public final boolean isClosed() {
		return closed;
	}

}

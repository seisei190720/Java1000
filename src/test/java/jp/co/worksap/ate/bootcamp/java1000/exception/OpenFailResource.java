package jp.co.worksap.ate.bootcamp.java1000.exception;

import java.io.IOException;

public class OpenFailResource extends AbstractResource{

	public void open() throws IOException {
		super.open();
		throw new IOException();
	}

}

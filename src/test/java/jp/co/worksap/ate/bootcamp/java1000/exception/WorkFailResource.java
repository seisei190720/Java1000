package jp.co.worksap.ate.bootcamp.java1000.exception;

import java.io.IOException;

public class WorkFailResource extends AbstractResource{

	public void work() throws IOException{
		super.work();
		throw new IOException();
	}

}

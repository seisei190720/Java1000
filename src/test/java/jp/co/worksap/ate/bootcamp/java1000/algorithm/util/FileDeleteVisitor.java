package jp.co.worksap.ate.bootcamp.java1000.algorithm.util;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FileDeleteVisitor extends SimpleFileVisitor<Path> {

	@Override
	public FileVisitResult visitFile(Path path, BasicFileAttributes attributes) throws IOException {
		Files.delete(path);
		return checkFileNotExist(path);
	}

	@Override
	public FileVisitResult postVisitDirectory(Path path, IOException exception) throws IOException {
		if (exception != null) {
			throw exception;
		}
		Files.delete(path);
		return checkFileNotExist(path);
	}

	private FileVisitResult checkFileNotExist(final Path path) throws IOException {
		if (Files.exists(path)) {
			throw new IOException();
		}
		return FileVisitResult.CONTINUE;
	}

}

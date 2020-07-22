package jp.co.worksap.ate.bootcamp.java1000.algorithm.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileOperationUtils {

	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	public static String getFileContents(Path path, String encode) {
		StringBuilder sb = new StringBuilder();
		try (
				BufferedReader br = new BufferedReader(new InputStreamReader(Files.newInputStream(path), encode))	) {
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line);
				sb.append(LINE_SEPARATOR);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public static void writeContentsToFile(Path path, String contents, String encode) {
		try (
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(path), encode));	) {
			bw.write(contents);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void deleteDirRecursivelyIfExists(String pathStr) throws IOException {
		if (Files.exists(Paths.get(pathStr))) {
			deleteFileRecursively(pathStr);
		}
	}

	private static void deleteFileRecursively(String pathStr) throws IOException {
		Files.walkFileTree(FileSystems.getDefault().getPath(pathStr), new FileDeleteVisitor());
	}

}

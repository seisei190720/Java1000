package jp.co.worksap.ate.bootcamp.java1000.stream;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public final class ReaderExercise {

	/*
	 * 以下の課題に回答するソースコードを記述しなさい。
	 */

	/**
	 * 受け取ったファイル名からFileReaderを作成して返しなさい。
	 *
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static Reader openFileAsFileReader(String fileName) throws IOException {
		return null;
	}

	/**
	 * 受け取ったファイル名からBufferedReaderを作成して返しなさい。
	 *
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static Reader openFileAsBufferedReader(String fileName) throws IOException {
		return null;
	}

	/**
	 * 受け取ったreaderオブジェクトをクローズしなさい。
	 *
	 * @param reader
	 */
	public static void closeReader(Reader reader) {
	}

	/**
	 * 受け取ったfileオブジェクトの内容を読み取りStringのリストにして返しなさい。
	 * 1行をリストの1要素 (空行の場合は空文字列とする。行末の改行文字は含めない) として、先頭行から順番に格納すること。
	 * ただし、fileの文字コードは現在使用しているシステムデフォルトのもので記述されているとします。
	 *
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static List<String> readFile(File file) throws IOException {
		return null;
	}

	/**
	 * 受け取ったfileオブジェクトの内容を読み取りStringのリストにして返しなさい。
	 * 1行をリストの1要素 (空行の場合は空文字列とする。行末の改行文字は含めない) として、先頭行から順番に格納すること。
	 * ただし、fileの文字コードは引数で指定されているものとします。
	 *
	 * @param file
	 * @param charsetName
	 * @return
	 * @throws IOException
	 */
	public static List<String> readFile(File file, String charsetName) throws IOException {
		return null;
	}

}

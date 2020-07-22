package jp.co.worksap.ate.bootcamp.java1000.stream;

import java.io.File;
import java.io.IOException;
import java.io.Writer;

public class WriterExercise {

	/*
	 * 以下の課題に回答するソースコードを記述しなさい。
	 */

	/**
	 * 受け取ったファイル名からFileWriterを作成して返しなさい。
	 * ファイル名がnullの場合は、nullを返すこと。
	 *
	 * @param fileName
	 * @return Writer
	 * @throws IOException
	 */
	public static Writer openFileAsFileWriter(String fileName) throws IOException {
		return null;
	}

	/**
	 * 受け取ったファイル名からBufferedWriterを作成して返しなさい。
	 * ファイル名がnullの場合は、nullを返すこと。
	 *
	 * @param fileName
	 * @return Writer
	 * @throws IOException
	 */
	public static Writer openFileAsBufferedWriter(String fileName) throws IOException {
		return null;
	}

	/**
	 * 受け取ったwriterオブジェクトをクローズしなさい。
	 *
	 * @param writer
	 */
	public static void closeWriter(Writer writer) {
	}

	/**
	 * 第一引数で受け取ったfileオブジェクトに第二引数の内容を書き込みなさい。
	 * ファイルに既に書き込まれている場合は、内容を上書きすること。
	 * また、fileの文字コードは現在使用しているシステムデフォルトのもので記述するとします。
	 *
	 * @param file
	 * @param writeStr
	 * @throws IOException
	 */
	public static void writeFile(File file, String writeStr) throws IOException {
	}

	/**
	 * 第一引数で受け取ったfileオブジェクトに第二引数の内容を書き込みなさい。
	 * ファイルに既に書き込まれている場合は、内容を末尾に追記すること。
	 * また、fileの文字コードは現在使用しているシステムデフォルトのもので記述するとします。
	 *
	 * @param file
	 * @param writeStr
	 * @throws IOException
	 */
	public static void appendFile(File file, String writeStr) throws IOException {
	}

	/**
	 * 第一引数で受け取ったfileオブジェクトに第二引数の内容を書き込みなさい。
	 * ファイルに既に書き込まれている場合は、内容を上書きすること。
	 * また、fileの文字コードは引数で指定されているもので記述するとします。
	 *
	 * @param file
	 * @param writeStr
	 * @param charsetName
	 * @throws IOException
	 */
	public static void writeFile(File file, String writeStr, String charsetName) throws IOException {
	}

}

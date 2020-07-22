package jp.co.worksap.ate.bootcamp.java1000.string;

import java.util.List;


/**
 * 文字・文字列の扱いに慣れましょう
 * @version 1.0
 * @author ATE
 */
public class StringExercise {
	public static final String KEYWORD_YES = "YES";
	public static final String KEYWORD_NO = "NO";
	public static final String KEYWORD_TRUE = "TRUE";
	public static final String KEYWORD_FALSE = "FALSE";


	/**
	 * keyword が "YES" / "TRUE" の場合は true、そうで無い場合は false を返します。<br>
	 * 大文字小文字も厳密に判断します。
	 * @param keyword
	 * @return
	 */
	public static boolean getBoolValue(final String keyword) {
		return false;
	}


	/**
	 * keyword が "YES" / "TRUE" の場合は true、そうで無い場合は false を返します。<br>
	 * ignoreCase が true の場合、大文字小文字を無視します。
	 * @param keyword
	 * @param ignoreCase
	 * @return
	 */
	public static boolean getBoolValue(final String keyword, final boolean ignoreCase) {
		return false;
	}


	/**
	 * 二つの文字列を結合します。<br>
	 * 例）"Hello" と "World" が渡されたら "HelloWorld" を返します
	 * @param a
	 * @param b
	 * @return
	 */
	public static String append(final String a, final String b) {
		return null;
	}


	/**
	 * 全ての文字列を結合します。<br>
	 * 多くの文字列を結合する場合、StringBuilderを使った方が高速です。<br>
	 * ここで使い方を学習しましょう。
	 * @param lines
	 * @return
	 */
	public static String append(final List<String> lines) {
		return null;
	}


	/**
	 * ファイルのフルパスから、拡張子を除いたファイル名を取り出して返します。
	 * 例）"C:\Program Files\Mozilla Firefox\firefox.exe" が渡されたら、
	 * 　　"firefox" を返します。
	 * @param fullPathString
	 * @return
	 */
	public static String getFileName(final String fullPathString) {
		return null;
	}
}

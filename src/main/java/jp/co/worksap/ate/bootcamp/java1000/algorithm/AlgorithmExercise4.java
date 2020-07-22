package jp.co.worksap.ate.bootcamp.java1000.algorithm;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/*
 * ここでは、やや複雑なアルゴリズムを含む応用的なプログラミングの練習をします。
 * 他の問題を解いてから取り組むことを推奨します。
 */
/**
 *
 * @version 1.0
 * @author ATE
 */
public class AlgorithmExercise4 {

	/**
	 * 以下の仕様を満たすようにメソッドを完成させなさい。
	 *
	 * 第1引数で指定された文字列をパスとするフォルダ以下の全てのテキストファイルについて、
	 * 第2引数で指定された文字列を含む行をすべて取得して Map として返す
	 * (アルファベットの大文字・小文字や全角・半角等は区別する)。
	 * 戻り値のMapは、
	 *  ファイルの絶対パス → 該当行の内容のリスト(1要素が1行に対応する。
	 *  各要素は 行番号:行の内容 という文字列にする。該当行が無い場合は空のリストとする)
	 * という対応関係にすること。なお「行の内容」には、行末の改行文字は含めない。
	 *
	 * <pre>
	 * 例:
	 * 第2引数が "abc"、対象となるファイルが C:/test/test.txt のみで、test.txt の内容が
	 *   hogea bca
	 *   bcabca
	 *   abc
	 *   aabbc  		ca
	 * の場合、戻り値のMapは {C:/test/test.txt=[2:bcabca, 3:abc]} となる。
	 * </pre>
	 *
	 * ただし、指定フォルダ以下には、フォルダとテキストファイルしかなく、
	 * 子フォルダ、孫フォルダ、… についても同様とする。
	 * また、テキストファイルの文字コードは現在使用しているシステムデフォルトのもので記述されているとする。
	 *
	 * 指定されたフォルダ以下にファイルが存在しない場合は、空のMapを返すこと。
	 *
	 * 指定されたフォルダが存在しない場合は FileNotFoundException
	 * その他、引数の指定が不正な場合(nullである、dirPathで指定されるのがフォルダではなくファイルである など)は
	 * IllegalArgumentException をスローすること。
	 *
	 */
	public Map<String, List<String>> grepRecursively(String dirPathString, String keyPhrase) throws IOException {
		return null;
	}

}

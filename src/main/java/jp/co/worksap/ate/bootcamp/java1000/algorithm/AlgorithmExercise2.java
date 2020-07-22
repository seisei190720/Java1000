package jp.co.worksap.ate.bootcamp.java1000.algorithm;

import java.io.IOException;
import java.sql.Connection;

/*
 * ここでは、やや複雑なアルゴリズムを含む応用的なプログラミングの練習をします。
 * 他の問題を解いてから取り組むことを推奨します。
 */
/**
 *
 * @version 1.0
 * @author ATE
 */
public class AlgorithmExercise2 {

	/**
	 * 以下の仕様を満たすようにメソッドを完成させなさい。
	 *
	 *  | テーブル名 : category
	 *  | カラム :
	 *  | 	cat_id number(10,0) : カテゴリーID (一意キー)
	 *  | 	cat_nm varchar(255) : カテゴリー名
	 *
	 * 上記のテーブルから、レコードを全件取得し、
	 * 各レコードについて、AlgorithmExercise2.getRecordCombinedString メソッドを使ってカテゴリーIDとカテゴリー名を':'で結合した上で、
	 * 第1引数で指定された文字列をパスとするファイルに追記する。
	 * 1レコードごとに改行を入れること。
	 * 追記対象のファイルが存在しない場合は、FileNotFoundExceptionをスローすること。
	 * DBからのデータ取得時に例外が生じた場合は、その時点で処理を中断すること。このメソッドが SQLException をスローしてはならない。
	 *
	 * なお、実装に当っては、DatabaseExercise クラス および WriterExercise クラスのメソッドを利用してよい。
	 * また、ファイルの文字コードは現在使用しているシステムデフォルトのもので記述するとする。
	 */
	public void writeAllData(String dirPath, Connection con) throws IOException {

	}

	public static String getRecordCombinedString(String id, String data) {
		StringBuilder sb = new StringBuilder();
		sb.append(id).append(":").append(data);
		return sb.toString();
	}

}

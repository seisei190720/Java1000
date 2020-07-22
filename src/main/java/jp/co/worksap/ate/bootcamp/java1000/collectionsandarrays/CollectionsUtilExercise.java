package jp.co.worksap.ate.bootcamp.java1000.collectionsandarrays;

import java.util.List;

/**
 * コレクションの扱いになれましょう。
 *
 * @version 1.0
 * @author ATE
 */
public final class CollectionsUtilExercise {

	/**
	 * 引数で与えられたStringオブジェクトのリストを、
	 * {@link String#compareTo(String)}メソッドでソートし、
	 * 小さい順に並び替えた結果を取得します。<br>
	 * 引数で与えられたリストは変更されません。<br>
	 * 引数で与えられたリストにString以外の要素が格納されていた場合は、
	 * {@link IllegalArgumentException}をスローします。<br>
	 *
	 * @param stringList
	 * @return
	 */
	public static final List<String> sortStringList(List<?> stringList) {
		return null;
	}

	/**
	 * 引数で与えられたStringオブジェクトのリストを、
	 * 辞書式順序の逆順にソートした結果を取得します。<br>
	 * 引数で与えられたリストは変更されません。<br>
	 * 引数で与えられたリストにString以外の要素が格納されていた場合は、
	 * {@link IllegalArgumentException}をスローします。<br>
	 *
	 * @param stringList
	 * @return
	 */
	public static final List<String> sortStringListDesc(List<?> stringList) {
		return null;
	}

	/**
	 * 引数で与えられたEmployeeのリストを、
	 * 社員ID {@link Employee#getId()}の昇順に並び替えたリストを返します。<br>
	 * ただし、引数で与えられたリストは変更しないでください。<br>
	 * また、以下の条件も満たすようにしてください。<br>
	 *
	 * 引数のリストにEmployee以外のインスタンスが入っていた場合、
	 * そのインスタンスは、出力するリストに含めないでください。
	 * （引数のリストにEmployeeのインスタンスが含まれない場合は、
	 * 　空のリストを返してください）<br>
	 *
	 * 同じ社員IDかつ同じ名前のインスタンスがあった場合、
	 * どちらか1つのインスタンスのみを返して下さい。<br>
	 *
	 * 同じ社員IDで違う名前のインスタンスが存在した場合、
	 * その2つのインスタンスの順序は不定で構いません。<br>
	 *
	 * 引数のリストにEmployeeのインスタンスが含まれない場合、
	 * 空のリストを返すようにして下さい。
	 *
	 * @param empList
	 * @return
	 */
	public static final List<Employee> sortUniqueEmployeeList(List<?> empList) {
		return null;
	}
}

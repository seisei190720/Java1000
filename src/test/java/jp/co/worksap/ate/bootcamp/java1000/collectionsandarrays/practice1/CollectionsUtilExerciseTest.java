package jp.co.worksap.ate.bootcamp.java1000.collectionsandarrays.practice1;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import jp.co.worksap.ate.bootcamp.java1000.collectionsandarrays.practice1.CollectionsUtilExercise;
import jp.co.worksap.ate.bootcamp.java1000.collectionsandarrays.practice1.Employee;
import junit.framework.TestCase;

public class CollectionsUtilExerciseTest extends TestCase {

	private static final String[] ORIGINAL_STRING_LIST_DATA = new String[]{"AP","a","A","b","1"};
	private static final List<String> ORDERED_STRING_LIST = Arrays.asList(new String[]{"1","A","AP","a","b"});
	private static final List<String> ORDERED_STRING_LIST_DESC = Arrays.asList(new String[]{"b","a","AP","A","1"});
	private static final Employee[] ORIGINAL_EMP_DATA = new Employee[]{
		new Employee(Integer.MAX_VALUE, "huga"),
		new Employee(Integer.MAX_VALUE / 2, "muga"),
		new Employee(1, "hoge"),
		new Employee(Integer.MIN_VALUE, "deha"),
		new Employee(1, "hoge")
	};
	private static final List<Employee> ORDERED_EMP_LIST = Arrays.asList(
			new Employee[]{
					new Employee(Integer.MIN_VALUE, "deha"),
					new Employee(1, "hoge"),
					new Employee(Integer.MAX_VALUE / 2, "muga"),
					new Employee(Integer.MAX_VALUE, "huga")
			});

	public void testSortStringList1() {
		List<String> originalList = Collections.unmodifiableList(Arrays.asList(ORIGINAL_STRING_LIST_DATA));
		try {
			assertThat("正しくソートされていません。", CollectionsUtilExercise.sortStringList(originalList), is(ORDERED_STRING_LIST));
		} catch (UnsupportedOperationException e) {
			fail("引数のリストを変更してはいけません。");
		} catch (Exception e) {
			fail("例外処理が不十分です。");
		}
	}

	public void testSortStringList2() {
		List<Integer> originalList = Arrays.asList(new Integer[]{new Integer(1)});
		try {
			CollectionsUtilExercise.sortStringList(originalList);
			fail("例外処理が不十分です。");
		} catch (IllegalArgumentException e) {

		} catch (Exception e) {
			fail("例外処理が不十分です。");
		}
	}

	public void testSortStringListDesc1() {
		List<String> originalList = Collections.unmodifiableList(Arrays.asList(ORIGINAL_STRING_LIST_DATA));
		try {
			assertThat("正しくソートされていません。", CollectionsUtilExercise.sortStringListDesc(originalList), is(ORDERED_STRING_LIST_DESC));
		} catch (UnsupportedOperationException e) {
			fail("引数のリストを変更してはいけません。");
		} catch (Exception e) {
			fail("例外処理が不十分です。");
		}
	}

	public void testSortStringListDesc2() {
		List<Integer> originalList = Arrays.asList(new Integer[]{new Integer(1)});
		try {
			CollectionsUtilExercise.sortStringListDesc(originalList);
			fail("例外処理が不十分です。");
		} catch (IllegalArgumentException e) {

		} catch (Exception e) {
			fail("例外処理が不十分です。");
		}
	}

	public void testSortUniqueEmployeeList() {
		List<Employee> str = Collections.unmodifiableList(Arrays.asList(ORIGINAL_EMP_DATA));
		try {
			assertThat("正しくソートされていません。", CollectionsUtilExercise.sortUniqueEmployeeList(str), is(ORDERED_EMP_LIST));
		} catch (UnsupportedOperationException e) {
			fail("引数のリストを変更してはいけません。");
		} catch (Exception e) {
			fail("例外処理が不十分です。");
		}
	}

}

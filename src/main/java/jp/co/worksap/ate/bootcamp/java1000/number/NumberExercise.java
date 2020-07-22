/*
 * NumberExercise.java
 * Copyright 2010- WorksApplications.
 */
package jp.co.worksap.ate.bootcamp.java1000.number;

import java.math.BigDecimal;


/**
 * 数値の扱いに慣れましょう
 * @version 1.0
 * @author ATE
 */
public final class NumberExercise {
	/**
	 * 入力された値を合算して返します
	 * @param a
	 * @param b
	 * @return
	 */
	public static long addition(final int a, final int b) {
		return 0;
	}


	/**
	 * 入力された値を合算して返します
	 * @param a
	 * @param b
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static Long addition(final Integer a, final Integer b) throws IllegalArgumentException {
		return null;
	}


	/**
	 * 最初の入力値から２つ目の入力値を引いて結果を返します
	 * @param a
	 * @param b
	 * @return
	 */
	public static long subtraction(final int a, final int b) {
		return 0;
	}


	/**
	 * 最初の入力値から２つ目の入力値を引いて結果を返します
	 * @param a
	 * @param b
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static Long subtraction(final Integer a, final Integer b) throws IllegalArgumentException {
		return null;
	}


	/**
	 * 入力された値を掛け合わせて返します
	 * @param a
	 * @param b
	 * @return
	 */
	public static long multiplication(final int a, final int b) {
		return 0;
	}


	/**
	 * 入力された値を掛け合わせて返します
	 * @param a
	 * @param b
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static Long multiplication(final Integer a, final Integer b) throws IllegalArgumentException {
		return null;
	}


	/**
	 * 最初の入力値を２つ目の入力値で割って結果を返します。<br>
	 * なお、実際の業務では小数を扱う可能性のある数字を double で扱ってはいけません。<br>
	 * 浮動小数点型はある程度の精度が確保できればいい（＝誤差が許される）場合のみ使えます。<br>
	 * そうでない局面で double を使うのは間違いの元ですので、止めましょう。
	 * @param a
	 * @param b
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static double division(final int a, final int b) throws IllegalArgumentException {
		return 0;
	}


	/**
	 * 最初の入力値を２つ目の入力値で割って結果を返します
	 * なお、実際の業務では小数を扱う可能性のある数字を Double で扱ってはいけません。<br>
	 * 浮動小数点型はある程度の精度が確保できればいい（＝誤差が許される）場合のみ使えます。<br>
	 * そうでない局面で Double を使うのは間違いの元ですので、止めましょう。
	 * @param a
	 * @param b
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static Double division(final Integer a, final Integer b) throws IllegalArgumentException {
		return null;
	}


	/**
	 * 最初の入力値を２つ目の入力値で割って結果を返します。<br>
	 * 小数部は COBOL 由来のデータに備えて 8 桁の精度を保証して下さい。<br>
	 * （実際の業務で利用する事が多くなる BigDecimal を使った演算に慣れて下さい）
	 * @param a
	 * @param b
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static BigDecimal division(final BigDecimal a, final BigDecimal b) throws IllegalArgumentException {
		return null;
	}


	/**
	 * 最初の入力値を２つ目の入力値で割った余りを返します。<br>
	 * 四則演算以外の演算にも慣れましょう。<br>
	 * @param a
	 * @param b
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static int calcResidue(final int a, final int b) throws IllegalArgumentException {
		return 0;
	}


	/**
	 * ある銀行口座（複利）に預けたお金を引き出す時の額を計算し、返します。<br>
	 * 　＝　（預けた額） * (1 + (利率 / 100)) ^ (年 + 月 / 12)<br>
	 * 端数は切り捨てます。<br>
	 * 年の途中で解約した場合には、解約日前月まで複利で利息が付きます。<br>
	 * @param initialValue 預けた額
	 * @param rate 利率（年利）
	 * @param year 預けた年数
	 * @param month 預けた月数
	 * @return
	 */
	public static long calcAccountValue(final int initialValue, final double rate,
			final int year, final int month) throws IllegalArgumentException {
		return 0;
	}
}

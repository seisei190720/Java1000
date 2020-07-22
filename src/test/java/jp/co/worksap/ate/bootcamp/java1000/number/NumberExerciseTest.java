/*
 * NumberExerciseTest.java
 * 更新履歴
 * Copyright 2010- WorksApplications.
 */
package jp.co.worksap.ate.bootcamp.java1000.number;

import java.math.BigDecimal;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;


/**
 * 数値のテスト
 * @version 1.0
 */
public class NumberExerciseTest extends TestCase {
	private static final Double RES_HARF = new Double((double) 1 / 2);

	private static final Integer VALUE_M4 = new Integer(-4);
	private static final Integer VALUE_M3 = new Integer(-3);
	private static final Integer VALUE_M2 = new Integer(-2);
	private static final Integer VALUE_M1 = new Integer(-1);
	private static final Integer VALUE_0 = new Integer(0);
	private static final Integer VALUE_1 = new Integer(1);
	private static final Integer VALUE_2 = new Integer(2);
	private static final Integer VALUE_3 = new Integer(3);
	private static final Integer VALUE_4 = new Integer(4);
	private static final Integer VALUE_MIN = new Integer(Integer.MIN_VALUE);
	private static final Integer VALUE_MAX = new Integer(Integer.MAX_VALUE);

	private static final BigDecimal BD_RES_HARF = new BigDecimal("0.5");
	private static final BigDecimal BD_VALUE_M4 = new BigDecimal("-4");
	private static final BigDecimal BD_VALUE_M3 = new BigDecimal("-3");
	private static final BigDecimal BD_VALUE_M2 = new BigDecimal("-2");
	private static final BigDecimal BD_VALUE_M1 = new BigDecimal("-1");
	private static final BigDecimal BD_VALUE_0 = new BigDecimal("0");
	private static final BigDecimal BD_VALUE_1 = new BigDecimal("1");
	private static final BigDecimal BD_VALUE_2 = new BigDecimal("2");
	private static final BigDecimal BD_VALUE_3 = new BigDecimal("3");
	private static final BigDecimal BD_VALUE_4 = new BigDecimal("4");

	private static final Long RES_INTMAX_2 = new Long((((long)Integer.MAX_VALUE) + Integer.MAX_VALUE));
	private static final Long RES_INTMAXMAX = new Long((((long)Integer.MAX_VALUE) * Integer.MAX_VALUE));
	private static final Long RES_INTMIN_2 = new Long((((long)Integer.MIN_VALUE) + Integer.MIN_VALUE));
	private static final Long RES_INTMINMAX = new Long((((long)Integer.MAX_VALUE) * Integer.MIN_VALUE));


	/**
	 * Test method for {@link jp.co.worksap.ate.bootcamp.java1000.number.NumberExercise#addition(int, int)}.
	 */
	public final void testAdditionIntInt() {
		assertEquals(VALUE_3.intValue(), NumberExercise.addition(VALUE_1.intValue(), VALUE_2.intValue()));
		assertEquals(VALUE_1.intValue(), NumberExercise.addition(VALUE_M3.intValue(), VALUE_4.intValue()));
		assertEquals(VALUE_1.intValue(), NumberExercise.addition(VALUE_4.intValue(), VALUE_M3.intValue()));
		assertEquals(VALUE_M3.intValue(), NumberExercise.addition(VALUE_M1.intValue(), VALUE_M2.intValue()));
		assertEquals("引数が int の最大値の時におかしくなりませんか？", RES_INTMAX_2.longValue(), NumberExercise.addition(VALUE_MAX.intValue(), VALUE_MAX.intValue()));
		assertEquals("引数が int の最小値の時におかしくなりませんか？", RES_INTMIN_2.longValue(), NumberExercise.addition(VALUE_MIN.intValue(), VALUE_MIN.intValue()));
	}


	/**
	 * Test method for {@link jp.co.worksap.ate.bootcamp.java1000.number.NumberExercise#addition(java.lang.Integer, java.lang.Integer)}.
	 */
	public final void testAdditionIntegerInteger() {
		try {
			assertEquals(VALUE_3.longValue(), NumberExercise.addition(VALUE_1, VALUE_2).longValue());
			assertEquals(VALUE_1.longValue(), NumberExercise.addition(VALUE_M3, VALUE_4).longValue());
			assertEquals(VALUE_1.longValue(), NumberExercise.addition(VALUE_4, VALUE_M3).longValue());
			assertEquals(VALUE_M3.longValue(), NumberExercise.addition(VALUE_M1, VALUE_M2).longValue());
			assertEquals("引数が int の最大値の時におかしくなりませんか？", RES_INTMAX_2.longValue(), NumberExercise.addition(VALUE_MAX, VALUE_MAX).longValue());
			assertEquals("引数が int の最小値の時におかしくなりませんか？", RES_INTMIN_2.longValue(), NumberExercise.addition(VALUE_MIN, VALUE_MIN).longValue());
		} catch (AssertionFailedError e) {
			throw e;
		} catch (NullPointerException e) {
			fail();
		}

		try {
			NumberExercise.addition(null, VALUE_0);
			fail("null との計算はどうなるのが正しいですか？");
		} catch (Throwable e) {
			assertEquals("引数が null の時におかしくなりませんか？", IllegalArgumentException.class, e.getClass());
		}

		try {
			NumberExercise.addition(VALUE_M4, null);
			fail("null との計算はどうなるのが正しいですか？");
		} catch (Throwable e) {
			assertEquals("引数が null の時におかしくなりませんか？", IllegalArgumentException.class, e.getClass());
		}
	}


	/**
	 * Test method for {@link jp.co.worksap.ate.bootcamp.java1000.number.NumberExercise#subtraction(int, int)}.
	 */
	public final void testSubtractionIntInt() {
		assertEquals(VALUE_M1.intValue(), NumberExercise.subtraction(VALUE_1.intValue(), VALUE_2.intValue()));
		assertEquals(VALUE_M3.intValue(), NumberExercise.subtraction(VALUE_M1.intValue(), VALUE_2.intValue()));
		assertEquals(VALUE_4.intValue(), NumberExercise.subtraction(VALUE_1.intValue(), VALUE_M3.intValue()));
		assertEquals(VALUE_1.intValue(), NumberExercise.subtraction(VALUE_M1.intValue(), VALUE_M2.intValue()));
		assertEquals("最小値 - 最大値の時におかしくなりませんか？", RES_INTMIN_2.longValue() + 1, NumberExercise.subtraction(VALUE_MIN.intValue(), VALUE_MAX.intValue()));
	}


	/**
	 * Test method for {@link jp.co.worksap.ate.bootcamp.java1000.number.NumberExercise#subtraction(java.lang.Integer, java.lang.Integer)}.
	 */
	public final void testSubtractionIntegerInteger() {
		try {
			assertEquals(VALUE_M1.longValue(), NumberExercise.subtraction(VALUE_1, VALUE_2).longValue());
			assertEquals(VALUE_M3.longValue(), NumberExercise.subtraction(VALUE_M1, VALUE_2).longValue());
			assertEquals(VALUE_4.longValue(), NumberExercise.subtraction(VALUE_1, VALUE_M3).longValue());
			assertEquals(VALUE_1.longValue(), NumberExercise.subtraction(VALUE_M1, VALUE_M2).longValue());
			assertEquals("最小値 - 最大値の時におかしくなりませんか？", RES_INTMIN_2.longValue() + 1, NumberExercise.subtraction(VALUE_MIN, VALUE_MAX).longValue());
		} catch (AssertionFailedError e) {
			throw e;
		} catch (NullPointerException e) {
			fail();
		}

		try {
			NumberExercise.subtraction(null, VALUE_0);
			fail("null との計算はどうなるのが正しいですか？");
		} catch (Throwable e) {
			assertEquals("引数が null の時におかしくなりませんか？", IllegalArgumentException.class, e.getClass());
		}

		try {
			NumberExercise.subtraction(VALUE_M4, null);
			fail("null との計算はどうなるのが正しいですか？");
		} catch (Throwable e) {
			assertEquals("引数が null の時におかしくなりませんか？", IllegalArgumentException.class, e.getClass());
		}
	}


	/**
	 * Test method for {@link jp.co.worksap.ate.bootcamp.java1000.number.NumberExercise#multiplication(int, int)}.
	 */
	public final void testMultiplicationIntInt() {
		assertEquals(VALUE_2.intValue(), NumberExercise.multiplication(VALUE_1.intValue(), VALUE_2.intValue()));
		assertEquals(VALUE_M2.intValue(), NumberExercise.multiplication(VALUE_M1.intValue(), VALUE_2.intValue()));
		assertEquals(VALUE_M3.intValue(), NumberExercise.multiplication(VALUE_1.intValue(), VALUE_M3.intValue()));
		assertEquals(VALUE_2.intValue(), NumberExercise.multiplication(VALUE_M1.intValue(), VALUE_M2.intValue()));
		assertEquals(VALUE_0.intValue(), NumberExercise.multiplication(VALUE_0.intValue(), VALUE_M2.intValue()));
		assertEquals(VALUE_0.intValue(), NumberExercise.multiplication(VALUE_4.intValue(), VALUE_0.intValue()));
		assertEquals("引数が int の最大値の時におかしくなりませんか？", RES_INTMAXMAX.longValue(), NumberExercise.multiplication(VALUE_MAX.intValue(), VALUE_MAX.intValue()));
		assertEquals("引数が int の最小値に向かうとおかしくなりませんか？", RES_INTMINMAX.longValue(), NumberExercise.multiplication(VALUE_MAX.intValue(), VALUE_MIN.intValue()));
	}


	/**
	 * Test method for {@link jp.co.worksap.ate.bootcamp.java1000.number.NumberExercise#multiplication(java.lang.Integer, java.lang.Integer)}.
	 */
	public final void testMultiplicationIntegerInteger() {
		try {
			assertEquals(VALUE_2.longValue(), NumberExercise.multiplication(VALUE_1, VALUE_2).longValue());
			assertEquals(VALUE_M2.longValue(), NumberExercise.multiplication(VALUE_M1, VALUE_2).longValue());
			assertEquals(VALUE_M3.longValue(), NumberExercise.multiplication(VALUE_1, VALUE_M3).longValue());
			assertEquals(VALUE_2.longValue(), NumberExercise.multiplication(VALUE_M1, VALUE_M2).longValue());
			assertEquals(VALUE_0.longValue(), NumberExercise.multiplication(VALUE_0, VALUE_M2).longValue());
			assertEquals(VALUE_0.longValue(), NumberExercise.multiplication(VALUE_4, VALUE_0).longValue());
			assertEquals("引数が int の最大値の時におかしくなりませんか？", RES_INTMAXMAX.longValue(), NumberExercise.multiplication(VALUE_MAX, VALUE_MAX).longValue());
			assertEquals("引数が int の最小値に向かうとおかしくなりませんか？", RES_INTMINMAX.longValue(), NumberExercise.multiplication(VALUE_MAX, VALUE_MIN).longValue());
		} catch (AssertionFailedError e) {
			throw e;
		} catch (NullPointerException e) {
			fail();
		}

		try {
			NumberExercise.multiplication(null, VALUE_0);
			fail("null との計算はどうなるのが正しいですか？");
		} catch (Throwable e) {
			assertEquals("引数が null の時におかしくなりませんか？", IllegalArgumentException.class, e.getClass());
		}

		try {
			NumberExercise.multiplication(VALUE_M4, null);
			fail("null との計算はどうなるのが正しいですか？");
		} catch (Throwable e) {
			assertEquals("引数が null の時におかしくなりませんか？", IllegalArgumentException.class, e.getClass());
		}
	}


	/**
	 * Test method for {@link jp.co.worksap.ate.bootcamp.java1000.number.NumberExercise#division(int, int)}.
	 */
	public final void testDivisionIntInt() {
		assertEquals(VALUE_2.doubleValue(), NumberExercise.division(VALUE_4.intValue(), VALUE_2.intValue()), 0.0);
		assertEquals(VALUE_M2.doubleValue(), NumberExercise.division(VALUE_M4.intValue(), VALUE_2.intValue()), 0.0);
		assertEquals(VALUE_M3.doubleValue(), NumberExercise.division(VALUE_3.intValue(), VALUE_M1.intValue()), 0.0);
		assertEquals(VALUE_2.doubleValue(), NumberExercise.division(VALUE_M2.intValue(), VALUE_M1.intValue()), 0.0);
		assertEquals(VALUE_0.doubleValue(), NumberExercise.division(VALUE_0.intValue(), VALUE_M2.intValue()), 0.0);
		assertEquals(RES_HARF.doubleValue(), NumberExercise.division(VALUE_1.intValue(), VALUE_2.intValue()), 0.0);

		try {
			assertEquals(0.0, NumberExercise.division(VALUE_4.intValue(), VALUE_0.intValue()), 0.0);
		} catch (Throwable e) {
			assertEquals("0 で割ったらおかしくなりませんか？", IllegalArgumentException.class, e.getClass());
		}
	}

	/**
	 * Test method for {@link jp.co.worksap.ate.bootcamp.java1000.number.NumberExercise#division(java.lang.Integer, java.lang.Integer)}.
	 */
	public final void testDivisionIntegerInteger() {
		try {
			assertEquals(VALUE_2.doubleValue(), NumberExercise.division(VALUE_4, VALUE_2).doubleValue(), 0.0);
			assertEquals(VALUE_M2.doubleValue(), NumberExercise.division(VALUE_M4, VALUE_2).doubleValue(), 0.0);
			assertEquals(VALUE_M3.doubleValue(), NumberExercise.division(VALUE_3, VALUE_M1).doubleValue(), 0.0);
			assertEquals(VALUE_2.doubleValue(), NumberExercise.division(VALUE_M2, VALUE_M1).doubleValue(), 0.0);
			assertEquals(VALUE_0.doubleValue(), NumberExercise.division(VALUE_0, VALUE_M2).doubleValue(), 0.0);
			assertEquals(RES_HARF.doubleValue(), NumberExercise.division(VALUE_1, VALUE_2).doubleValue(), 0.0);
		} catch (AssertionFailedError e) {
			throw e;
		} catch (NullPointerException e) {
			fail();
		}

		try {
			NumberExercise.division(VALUE_4, VALUE_0);
			fail("0 で割ったらおかしくなりませんか？");
		} catch (Throwable e) {
			assertEquals("0 で割ったらおかしくなりませんか？", IllegalArgumentException.class, e.getClass());
		}

		try {
			NumberExercise.division(null, VALUE_1);
			fail("null との計算はどうなるのが正しいですか？");
		} catch (Throwable e) {
			assertEquals("引数が null の時におかしくなりませんか？", IllegalArgumentException.class, e.getClass());
		}

		try {
			NumberExercise.division(VALUE_M4, null);
			fail("null との計算はどうなるのが正しいですか？");
		} catch (Throwable e) {
			assertEquals("引数が null の時におかしくなりませんか？", IllegalArgumentException.class, e.getClass());
		}
	}


	/**
	 * Test method for {@link jp.co.worksap.ate.bootcamp.java1000.number.NumberExercise#division(java.math.BigDecimal, java.math.BigDecimal)}.
	 */
	public final void testDivisionBigDecimalBigDecimal() {
		try {
			assertEquals(BD_VALUE_2.setScale(8), NumberExercise.division(BD_VALUE_4, BD_VALUE_2));
			assertEquals(BD_VALUE_M2.setScale(8), NumberExercise.division(BD_VALUE_M4, BD_VALUE_2));
			assertEquals(BD_VALUE_M3.setScale(8), NumberExercise.division(BD_VALUE_3, BD_VALUE_M1));
			assertEquals(BD_VALUE_2.setScale(8), NumberExercise.division(BD_VALUE_M4, BD_VALUE_M2));
			assertEquals(BD_VALUE_0.setScale(8), NumberExercise.division(BD_VALUE_0, BD_VALUE_M2));
			assertEquals(BD_RES_HARF.setScale(8), NumberExercise.division(BD_VALUE_1, BD_VALUE_2));
		} catch (AssertionFailedError e) {
			throw e;
		} catch (NullPointerException e) {
			fail();
		}

		try {
			assertEquals(BD_VALUE_0.setScale(8), NumberExercise.division(BD_VALUE_4, BD_VALUE_0));
		} catch (Throwable e) {
			assertEquals("0 で割ったらおかしくなりませんか？", IllegalArgumentException.class, e.getClass());
		}

		try {
			NumberExercise.division(null, BD_VALUE_1);
			fail("null との計算はどうなるのが正しいですか？");
		} catch (Throwable e) {
			assertEquals("引数が null の時におかしくなりませんか？", IllegalArgumentException.class, e.getClass());
		}

		try {
			NumberExercise.division(BD_VALUE_M4, null);
			fail("null との計算はどうなるのが正しいですか？");
		} catch (Throwable e) {
			assertEquals("引数が null の時におかしくなりませんか？", IllegalArgumentException.class, e.getClass());
		}
	}


	/**
	 * Test method for {@link jp.co.worksap.ate.bootcamp.java1000.number.NumberExercise#calcResidue(int, int)}.
	 */
	public final void testCalcResidue() {
		assertEquals(VALUE_0.intValue(), NumberExercise.calcResidue(VALUE_4.intValue(), VALUE_2.intValue()));
		assertEquals(VALUE_M1.intValue(), NumberExercise.calcResidue(VALUE_M4.intValue(), VALUE_3.intValue()));
		assertEquals(VALUE_1.intValue(), NumberExercise.calcResidue(VALUE_3.intValue(), VALUE_M2.intValue()));
		assertEquals(VALUE_M1.intValue(), NumberExercise.calcResidue(VALUE_M3.intValue(), VALUE_M2.intValue()));
		assertEquals(VALUE_0.intValue(), NumberExercise.calcResidue(VALUE_0.intValue(), VALUE_M2.intValue()));

		try {
			assertEquals(0, NumberExercise.calcResidue(VALUE_4.intValue(), VALUE_0.intValue()));
		} catch (Throwable e) {
			assertEquals("0 で割ったらおかしくなりませんか？", IllegalArgumentException.class, e.getClass());
		}
	}


	/**
	 * Test method for {@link jp.co.worksap.ate.bootcamp.java1000.number.NumberExercise#calcAccountValue(long, double, int, int)}.
	 */
	public final void testCalcAccountValue() {
		assertEquals(calcAccountValue(1000, 2, 5, 6), NumberExercise.calcAccountValue(1000, 2, 5, 6));
		assertEquals(calcAccountValue(-1000, 3, 4, 9), NumberExercise.calcAccountValue(-1000, 3, 4, 9));
		assertEquals(calcAccountValue(Integer.MAX_VALUE, 5, 20, 4),
				NumberExercise.calcAccountValue(Integer.MAX_VALUE, 5, 20, 4));

		try {
			assertEquals(1000, NumberExercise.calcAccountValue(1000, -3, 2, 3));
		} catch (Throwable e) {
			assertEquals("利率がマイナスなのはおかしくありませんか？", IllegalArgumentException.class, e.getClass());
		}

		try {
			assertEquals(1000, NumberExercise.calcAccountValue(1000, 3, -1, 1));
		} catch (Throwable e) {
			assertEquals("年数がマイナスなのはおかしくありませんか？", IllegalArgumentException.class, e.getClass());
		}

		try {
			assertEquals(1000, NumberExercise.calcAccountValue(1000, 3, 5, -1));
		} catch (Throwable e) {
			assertEquals("月数がマイナスなのはおかしくありませんか？", IllegalArgumentException.class, e.getClass());
		}

		try {
			assertEquals(1000, NumberExercise.calcAccountValue(1000, 3, 5, 12));
		} catch (Throwable e) {
			assertEquals("月数が12以上なのはおかしくありませんか？", IllegalArgumentException.class, e.getClass());
		}
	}


	/*
	 * （預けた額） * (1 + (利率 / 100)) ^ (年 + 月 / 12)
	 */
	private long calcAccountValue(final int initialValue, final double rate,
			final int year, final int month) {
		return (long) (initialValue * Math.pow((100 + rate) / 100, year + month / 12.0));
	}
}

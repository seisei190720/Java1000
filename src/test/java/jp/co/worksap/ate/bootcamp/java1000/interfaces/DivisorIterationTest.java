package jp.co.worksap.ate.bootcamp.java1000.interfaces;

import java.util.Iterator;
import java.util.NoSuchElementException;

import junit.framework.TestCase;

public class DivisorIterationTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testDevisorIteratorImplements() {
		DivisorIteration pe = new DivisorIteration(30);
		if (!(pe instanceof Iterator)) {
			fail("DevisorIterator クラスに Iterator インターフェースが実装されていません。");
		}
	}

	public void testArgUnderZero() {
		try {
			new DivisorIteration(0);
			fail("コンストラクターの引数をチェックし,適切な例外を返しましょう");
		} catch (IllegalArgumentException e) {
		} catch (Exception e) {
			fail("コンストラクターの引数をチェックし,適切な例外を返しましょう");
		}
	}

	public void testHasNext() {
		int number = 30;
		Iterator<Integer> pe = new DivisorIteration(number);
		while (pe.hasNext()) {
			if (pe.next() > number) {
				fail("入力値 に到達する前にhasNext() が false を返しました。");
			}
		}
	}

	public void testNext() {
		String comment = "計算が違います";
		int number = 30;
		Iterator<Integer> pe = new DivisorIteration(number);
		assertEquals(comment, 1, (int) pe.next());
		assertEquals(comment, 2, (int) pe.next());
		assertEquals(comment, 3, (int) pe.next());
		assertEquals(comment, 5, (int) pe.next());
		assertEquals(comment, 6, (int) pe.next());
		assertEquals(comment, 10, (int) pe.next());
		assertEquals(comment, 15, (int) pe.next());
		assertEquals(comment, 30, (int) pe.next());
		try {
			pe.next();
			fail("最後の値を返した後の挙動が間違っています。");
		} catch (NoSuchElementException e) {
		} catch (Exception e) {
			fail("最後の値を返した後の挙動が間違っています。");
		}
	}

}

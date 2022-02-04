package jp.co.worksap.ate.bootcamp.java1000.interfaces.practice6;

import java.util.Iterator;
import java.util.NoSuchElementException;

import jp.co.worksap.ate.bootcamp.java1000.interfaces.practice6.NumberIteration;
import junit.framework.TestCase;

public class NumberIterationTest extends TestCase {
	private static final int MAX = 1024;

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testNumberIteratorImplements() {
		NumberIteration ne = new NumberIteration();
		if (!(ne instanceof Iterator)) {
			fail("NumberIterator クラスに Iterator インターフェースが実装されていません。");
		}
	}

	public void testHasNext() {
		Iterator<Integer> ne = null;
		try {
			ne = new NumberIteration();
		} catch (ClassCastException e) {
			fail("NumberIterator クラスに Iterator インターフェースが実装されていません。");
		}

		for (int i = 0; i <= MAX; i++, ne.next()) {
			if (!ne.hasNext()) {
				fail(MAX + " に達する前に NumberIterator#hasNext() が false を返しました。");
			}
		}
		if (ne.hasNext()) {
			fail(MAX + " に達した後も NumberIterator#hasNext() が true を返しました。");
		}
	}

	public void testNext() {
		Iterator<Integer> ne = null;
		try {
			ne = new NumberIteration();
		} catch (ClassCastException e) {
			fail("NumberIterator クラスに Iterator インターフェースが実装されていません。");
		}

		for (int i = 0; i <= MAX; i++) {
			try {
				int value = ne.next();
				if (value != i) {
					fail("NumberIterator#next() が正しい値を返していません。");
				}
			} catch (NoSuchElementException e) {
				fail("Integer#MAX_VALUE に到達する前に NumberIterator#next() が NoSuchElementException 例外を投げてしまっています。");
			}
		}
		try {
			int result = ne.next();
			fail("Integer#MAX_VALUE に到達した後も値 " + result + " を返してしまっています。");
		} catch (NoSuchElementException e) {
			// 正しい動作です。
		}
	}
}

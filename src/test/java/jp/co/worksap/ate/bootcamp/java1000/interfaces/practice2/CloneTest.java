package jp.co.worksap.ate.bootcamp.java1000.interfaces.practice2;

import jp.co.worksap.ate.bootcamp.java1000.interfaces.practice2.Clone;
import junit.framework.TestCase;

public class CloneTest extends TestCase {
	Clone clone = new Clone();

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testClone() {
		clone.clone();
	}

	public void testCloneInstanceof() {
		if (!(clone instanceof Cloneable)) {
			fail("Cloneable インターフェースが実装されていません。");
		}
	}
}

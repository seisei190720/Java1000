package jp.co.worksap.ate.bootcamp.java1000.interfaces;

import jp.co.worksap.ate.bootcamp.java1000.interfaces.Clone;
import junit.framework.TestCase;

public class CloneTest extends TestCase {
	Clone clone = new Clone();

	protected void setUp() throws Exception {
		super.setUp();
	}

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

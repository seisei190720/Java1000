package jp.co.worksap.ate.bootcamp.java1000.interfaces;

import jp.co.worksap.ate.bootcamp.java1000.interfaces.Executable;
import jp.co.worksap.ate.bootcamp.java1000.interfaces.FirstImplement;
import junit.framework.TestCase;

public class FirstImplementTest extends TestCase {
	public void testImplement() {
		FirstImplement fi = new FirstImplement();
		if (!(fi instanceof Executable)) {
			fail("FirstImplement クラスにインターフェース Executable が実装されていません。");
		}
	}
}

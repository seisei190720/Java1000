package jp.co.worksap.ate.bootcamp.java1000.interfaces.practice1;

import jp.co.worksap.ate.bootcamp.java1000.interfaces.practice1.Executable;
import jp.co.worksap.ate.bootcamp.java1000.interfaces.practice1.FirstImplement;
import junit.framework.TestCase;

public class FirstImplementTest extends TestCase {
	public void testImplement() {
		FirstImplement fi = new FirstImplement();
		if (!(fi instanceof Executable)) {
			fail("FirstImplement クラスにインターフェース Executable が実装されていません。");
		}
	}
}

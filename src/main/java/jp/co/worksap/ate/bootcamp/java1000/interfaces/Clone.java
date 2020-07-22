package jp.co.worksap.ate.bootcamp.java1000.interfaces;

/**
 * インターフェースを実装しましょう。
 * 
 * 問題。
 * {@link Clone#clone()} メソッドを {@link AssertionError} 例外が飛ばないように実装しなさい。
 * 
 * @author ATE
 *
 */
public class Clone {
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			throw new AssertionError("clone に失敗しました。");
		}
	}
}

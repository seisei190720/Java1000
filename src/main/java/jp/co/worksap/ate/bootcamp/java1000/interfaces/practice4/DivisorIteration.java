package jp.co.worksap.ate.bootcamp.java1000.interfaces.practice4;

import java.util.Iterator;

/**
 * インターフェースを実装しましょう。
 * 
 * 問題。 {@link Iterator<Integer>} インターフェースを実装して、
 * {@link DivisorIteration#next()} を呼び出すごとに コンストラクタで与えた自然数の正の約数を
 * 小さいものから返していくクラスを作りなさい。
 * next()が最後に返す数は、コンストラクタで与えた数になる。
 * next()はInteger型を返す。
 * 
 * @author ATE
 *
 */
public class DivisorIteration implements Iterator<Integer> {
	private int number;
	private int currentNum;

	public DivisorIteration(int number) {
		if (number <= 0) {
			throw new IllegalArgumentException("コンストラクタに与える整数は 0 以上でなければなりません。");
		}
		this.number = number;
		this.currentNum = 0;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer next() {
		// TODO Auto-generated method stub
		return null;
	}

}

package jp.co.worksap.ate.bootcamp.java1000.interfaces;

import java.util.Iterator;

/**
 * インターフェースを実装しましょう。
 *
 * 問題。 {@link Iterator<Integer>} インターフェースを実装して、
 * 1 回目の {@link PrimeIteration#next()} の呼び出しでは 2 を、
 * 2 回目の {@link PrimeIteration#next()} の呼び出しでは 3 を、
 * と素数を小さいものから返していくクラスを作りなさい。
 * 素数は Integer オブジェクトの形で返してください。
 * ある一定個数の素数のみ返すような仕様にしても構いませんが、
 * 最低でも1000個の素数を返すようにしてください。
 *
 * @see NumberIteration
 * @author ATE
 *
 */
public class PrimeIteration implements Iterator<Integer> {

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

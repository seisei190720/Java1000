package jp.co.worksap.ate.bootcamp.java1000.interfaces;

import java.util.Iterator;

/**
 * インターフェースを実装しましょう。
 *
 * 問題。 {@link Iterator<Integer>} インターフェースを実装して、
 * 1 回目の {@link NumberIteration#next()} の呼び出しでは 0 を表す Integer オブジェクトを、
 * 2 回目の {@link NumberIteration#next()} の呼び出しでは 1 を表す Integer オブジェクトを、
 * と 0 以上の整数を 1024 まで {@link Integer} オブジェクトの形で小さいものから返していくクラスを作りなさい。
 * {@link NumberIteration#next()} で 1024 を表す {@link Integer} オブジェクトを返した後は
 * {@link NoSuchElementException()} を投げるように実装しなさい。
 *
 * @author ATE
 *
 */
public class NumberIteration implements Iterator<Integer> {

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

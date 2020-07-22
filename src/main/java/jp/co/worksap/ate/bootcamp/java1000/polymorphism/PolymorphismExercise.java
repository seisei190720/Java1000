package jp.co.worksap.ate.bootcamp.java1000.polymorphism;

/**
 *
 * @version 1.0
 * @author ATE
 */
/**
 * 下記の仕様を満たすようにプログラムを完成させなさい。
 *
 *   | 引数(args[0])が
 *   | 「multiplesOf3」の場合、1～30 の間で 3 の倍数のものを標準出力する。
 *   | 「contains3」の場合、1～30 の間で 数字「3」を含むものを標準出力する。
 *   | 「7Ate9」の場合、1～30 の間で 1の位が9のもの以外 を標準出力する。
 *   | それ以外の場合、1～30 の数をすべて標準出力する。
 *   |
 *   | 以下のように、数を1つ出力するごとに改行すること。
 *   |  1
 *   |  2
 *   |  3
 *   |  4
 *   |  ...
 *
 * MultiplesOf.java, Contains.java, Otherwise.java も合わせて実装すること。
 * また、必要に応じて新たにクラスを作成してもよい。
 *
 */
public final class PolymorphismExercise {

	public void execute(String[] args) {
		Predicate pred = parseArgs(args);
		for (int i = 1; i <= 30; i++) {
			// TODO
		}
	}

	private static Predicate parseArgs(String[] args) {
		// TODO 必要に応じて、このメソッドにも処理を追加すること
		if (args == null || args.length < 1) {
			return new Otherwise();
		}
		if (args[0].equals("multiplesOf3")) {
			return new MultiplesOf(3);
		}
		if (args[0].equals("contains3")) {
			return new Contains(3);
		}
		return new Otherwise();
	}

}

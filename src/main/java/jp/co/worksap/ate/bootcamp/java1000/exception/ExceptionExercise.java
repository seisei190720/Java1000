package jp.co.worksap.ate.bootcamp.java1000.exception;


public class ExceptionExercise {

	public ExceptionExercise() {
	}

	/*
	 * 以下の問題に答えなさい。
	 *
	 * 但し、メソッドの定義を変更してはいけません。
	 */

	/**
	 * 問題
	 *
	 * throwRuntimeException() が発生させる
	 * RuntimeExceptionをキャッチしなさい。
	 */
	public void problemCatchRuntimeException() {
		throwRuntimeException();
	}

	// このメソッドは変更してはいけません。
	private static void throwRuntimeException() {
		throw new RuntimeException();
	}

	/**
	 * 問題
	 *
	 * 以下のメソッドの引数に渡ってくるvalueが負の数の場合に、
	 * IllegalArgumentExceptionを発生させなさい。
	 */
	public void problemThrowIllegalArgumentException(int value) throws IllegalArgumentException{
		
		
	}

	/**
	 * 問題
	 *
	 * 以下のメソッドの引数に渡ってくるvalueが正の場合は標準出力し、
	 * 0以下の場合は、IllegalArgumentException例外を発生させなさい。
	 */
	public void problemPrintOrThrowIllegalArgumentException(int value) throws IllegalArgumentException{
		
		
	}

	/**
	 * 問題
	 *
	 * 以下のメソッドの第一引数に渡ってくるStringを
	 * intに変換して返すメソッドを実装しなさい。
	 * 不正な文字が渡ってきた場合はdefaultValueの値を返しなさい。
	 */
	public int problemStringToInt(String number, int defaultValue) {
		return 0;
	}

	/**
	 * 問題
	 *
	 * 以下のメソッドの引数に渡ってくるvalueが正の場合は、文字列として標準出力しなさい。
	 *
	 * 0以下の場合は、 {@link jp.co.worksap.ate.bootcamp.java1000.exception.MyException} を発生させなさい。
	 * その際、valueの値を {@link Throwable#getMessage()} で確認できるようにすること。
	 */
	public void problemPrintValue(int value) throws MyException {
		
		
	}

	/**
	 * 問題
	 *
	 * 以下のメソッドの第一引数にはSQLが渡ってきます。
	 * この問題では、実際にDB操作を行う替わりに、DaoMockというモックオブジェクトを利用して実装します。
	 * SQLの実行が成功した場合はtrue、失敗した場合はfalseが返るメソッドを実装しなさい。
	 *
	 * ※ メソッド中のコメントアウトされているラインのコメントをはずしてその行を使用しなさい。
	 */
	public boolean problemCatchSQLException(String sql) {
		//DaoMock.executeUpdate(sql);
		
		return false;
	}

	/**
	 * 問題
	 *
	 * 以下のメソッドの第一引数に入ってくる
	 * ObjectをIntegerにキャストしてintを取り出して返すメソッドを実装しなさい。
	 */
	public int problemCastObject(Object base) throws IllegalArgumentException {
		
		return 0;
	}


	/**
	 * 問題
	 * 以下のメソッドに渡ってくるResourceオブジェクトに対して、
	 * open→work→closeの処理を実行するメソッドを実装しなさい。
	 * 
	 * ※ メソッド中のコメントアウトされているラインのコメントをはずしてその行を使用しなさい。
	 */
	public void problemUseResource(Resource resource) throws IllegalArgumentException {
		
//		resource.open();
//		resource.work();
//		resource.close();
		
	}
}

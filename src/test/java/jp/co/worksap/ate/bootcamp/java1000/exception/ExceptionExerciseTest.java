package jp.co.worksap.ate.bootcamp.java1000.exception;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;

import jp.co.worksap.ate.bootcamp.java1000.exception.AbstractResource;
import junit.framework.TestCase;

public final class ExceptionExerciseTest extends TestCase {

	private ExceptionExercise problem1 = null;

	public ExceptionExerciseTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();

		problem1 = new ExceptionExercise();
	}

	protected void tearDown() throws Exception {
		problem1 = null;

		super.tearDown();
	}

	@Test
	public final void testProblemCatchRuntimeException() {
		try {
			problem1.problemCatchRuntimeException();
		} catch(RuntimeException e) {
			fail("Exceptionがキャッチできていません！！");
		}
	}

	@Test
	public final void testProblemThrowIllegalArgumentException() {
		try {
			problem1.problemThrowIllegalArgumentException(0);
		} catch (Exception e) {
			fail("予期せぬ例外が発生しました！");
		}

		try {
			problem1.problemThrowIllegalArgumentException(10);
		} catch (Exception e) {
			fail("予期せぬ例外が発生しました！");
		}

		try {
			problem1.problemThrowIllegalArgumentException(234);
		} catch (Exception e) {
			fail("予期せぬ例外が発生しました！");
		}

		try {
			problem1.problemThrowIllegalArgumentException(-1);
			fail("負の数の場合をチェックしましょう");
		} catch (IllegalArgumentException e){

		} catch (Exception e) {
			fail("予期せぬ例外が発生しました！");
		}

		try {
			problem1.problemThrowIllegalArgumentException(-234);
			fail("負の数の場合をチェックしましょう");
		} catch (IllegalArgumentException e){

		} catch (Exception e) {
			fail("予期せぬ例外が発生しました！");
		}

	}

	@Test
	public final void testProblemPrintOrThrowIllegalArgumentException() {
		PrintStream storedStream = System.out;

		try (
				ByteArrayOutputStream tempOutStream = new ByteArrayOutputStream();
				PrintStream printStream = new PrintStream(tempOutStream);
				) {
			System.setOut(printStream);
			problem1.problemPrintOrThrowIllegalArgumentException(1);
			assertThat("正の数の場合の処理が正しくありません。", tempOutStream.toString(), is("1" + System.getProperty("line.separator")));
		} catch (IllegalArgumentException e){
			e.printStackTrace();
			fail("正の数の場合の処理が正しくありません。");
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (
				ByteArrayOutputStream tempOutStream = new ByteArrayOutputStream();
				PrintStream printStream = new PrintStream(tempOutStream);
				) {
			System.setOut(printStream);
			problem1.problemPrintOrThrowIllegalArgumentException(10);
			assertThat("正の数の場合の処理が正しくありません。", tempOutStream.toString(), is("10" + System.getProperty("line.separator")));
		} catch (IllegalArgumentException e){
			e.printStackTrace();
			fail("正の数の場合の処理が正しくありません。");
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.setOut(storedStream);

		try {
			problem1.problemPrintOrThrowIllegalArgumentException(0);
			fail("0以下の数の場合をチェックしましょう");
		} catch (IllegalArgumentException e){

		} catch (Exception e) {
			fail("予期せぬ例外が発生しました！");
		}

		try {
			problem1.problemPrintOrThrowIllegalArgumentException(-234);
			fail("0以下の数の場合をチェックしましょう");
		} catch (IllegalArgumentException e){

		} catch (Exception e) {
			fail("予期せぬ例外が発生しました！");
		}

	}

	@Test
	public final void testProblemStringToInt() {
		try {
			assertEquals(100, problem1.problemStringToInt("100", 10));
			assertEquals(105, problem1.problemStringToInt("105", 10));
			assertEquals(-1, problem1.problemStringToInt("9000000000000000000000", -1));
			assertEquals(-1, problem1.problemStringToInt("100.5", -1));
			assertEquals(100, problem1.problemStringToInt("aaa", 100));
		} catch (Exception e) {
			e.printStackTrace();
			fail("例外が発生しました");
		}
	}

	@Test
	public final void testProblemPrintValue() {
		PrintStream storedStream = System.out;

		try (
				ByteArrayOutputStream tempOutStream = new ByteArrayOutputStream();
				PrintStream printStream = new PrintStream(tempOutStream);
				) {
			System.setOut(printStream);
			problem1.problemPrintValue(1);
			assertThat("正の数の場合の処理が正しくありません。", tempOutStream.toString(), is("1" + System.getProperty("line.separator")));
		} catch (MyException e) {
			e.printStackTrace();
			fail("正の数の場合の処理が正しくありません。");
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (
				ByteArrayOutputStream tempOutStream = new ByteArrayOutputStream();
				PrintStream printStream = new PrintStream(tempOutStream);
				) {
			System.setOut(printStream);
			problem1.problemPrintValue(10);
			assertThat("正の数の場合の処理が正しくありません。", tempOutStream.toString(), is("10" + System.getProperty("line.separator")));
		} catch (MyException e) {
			e.printStackTrace();
			fail("正の数の場合の処理が正しくありません。");
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.setOut(storedStream);

		try {
			problem1.problemPrintValue(0);
			fail("0以下の数の場合をチェックしましょう");
		} catch (MyException e){

		} catch(Exception t) {
			fail("予期せぬ例外が発生しました！");
		}

		try {
			problem1.problemPrintValue(-234);
			fail("0以下の数の場合をチェックしましょう");
		} catch (MyException e){

		} catch(Exception t) {
			fail("予期せぬ例外が発生しました！");
		}

	}

	@Test
	public final void testProblemCatchSQLException() {
		assertTrue(problem1.problemCatchSQLException(DaoMock.CORRECT_SQL));
		assertFalse(problem1.problemCatchSQLException("error sql"));

		try {
			assertFalse(problem1.problemCatchSQLException(null));
		} catch (Throwable e) {
			e.printStackTrace();
			fail("例外が発生しました");
		}
	}

	@Test
	public final void testProblemCastObject() {
		assertEquals(100, problem1.problemCastObject(new Integer(100)));
		assertEquals(500, problem1.problemCastObject(new Integer(500)));
		assertEquals(300, problem1.problemCastObject(new Integer(300)));

		try {
			problem1.problemCastObject("100");
			fail("異常な状態は例外で呼び出し元に通知しましょう");
		} catch (IllegalArgumentException e) {

		} catch (ClassCastException e) {
			fail("メソッドになInteger以外のオブジェクトが入ってくる可能性もあります");
		} catch (Exception e) {
			e.printStackTrace();
			fail("予期せぬ例外が発生しました！");
		}

	}

	@Test
	public final void testProblemUseResource()  throws IOException {
		AbstractResource resource = new AbstractResource();
		problem1.problemUseResource(resource);

		assertTrue(resource.isOpend());
		assertTrue(resource.isUsed());
		assertTrue(resource.isClosed());

		resource = new OpenFailResource();

		try {
			problem1.problemUseResource(resource);
			assertTrue(resource.isOpend());
			assertFalse(resource.isUsed());
			assertTrue(resource.isClosed());
		} catch (Exception e) {
			e.printStackTrace();
			fail("予期しない例外が発生しています");
		}


		resource = new WorkFailResource();

		try {
			problem1.problemUseResource(resource);
			assertTrue(resource.isOpend());
			assertTrue(resource.isUsed());
			assertTrue(resource.isClosed());
		} catch (Exception e) {
			e.printStackTrace();
			fail("予期しない例外が発生しています");
		}

		try {
			problem1.problemUseResource(null);
			fail("不正な引数がわたってきている場合をきちんと想定しましょう");
		} catch (IllegalArgumentException e) {
		} catch (NullPointerException e) {
			fail("不正な引数がわたってきている場合をきちんと想定しましょう");
		} catch (Exception e) {
			fail("予期せぬ例外が発生しました！");
		}

	}

}

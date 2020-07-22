package jp.co.worksap.ate.bootcamp.java1000;

import java.util.Enumeration;

import jp.co.worksap.ate.bootcamp.java1000.algorithm.AlgorithmExercise2Test;
import jp.co.worksap.ate.bootcamp.java1000.algorithm.AlgorithmExercise3Test;
import jp.co.worksap.ate.bootcamp.java1000.algorithm.AlgorithmExercise4Test;
import jp.co.worksap.ate.bootcamp.java1000.algorithm.AlgorithmExerciseTest;
import jp.co.worksap.ate.bootcamp.java1000.codestyle.ForLoopTest;
import jp.co.worksap.ate.bootcamp.java1000.collectionsandarrays.CollectionsUtilExerciseTest;
import jp.co.worksap.ate.bootcamp.java1000.collectionsandarrays.ListExerciseTest;
import jp.co.worksap.ate.bootcamp.java1000.collectionsandarrays.MapExerciseTest;
import jp.co.worksap.ate.bootcamp.java1000.collectionsandarrays.SetExerciseTest;
import jp.co.worksap.ate.bootcamp.java1000.database.DatabaseExerciseTest;
import jp.co.worksap.ate.bootcamp.java1000.enums.EnumExerciseTest;
import jp.co.worksap.ate.bootcamp.java1000.exception.ExceptionExerciseTest;
import jp.co.worksap.ate.bootcamp.java1000.interfaces.CloneTest;
import jp.co.worksap.ate.bootcamp.java1000.interfaces.ComparableMonsterTest;
import jp.co.worksap.ate.bootcamp.java1000.interfaces.DivisorIterationTest;
import jp.co.worksap.ate.bootcamp.java1000.interfaces.FirstImplementTest;
import jp.co.worksap.ate.bootcamp.java1000.interfaces.NumberIterationTest;
import jp.co.worksap.ate.bootcamp.java1000.interfaces.PrimeIterationTest;
import jp.co.worksap.ate.bootcamp.java1000.interfaces.SingerSongWriterTest;
import jp.co.worksap.ate.bootcamp.java1000.number.NumberExerciseTest;
import jp.co.worksap.ate.bootcamp.java1000.polymorphism.PolymorphismExerciseTest;
import jp.co.worksap.ate.bootcamp.java1000.stream.ReaderExerciseTest;
import jp.co.worksap.ate.bootcamp.java1000.stream.WriterExerciseTest;
import jp.co.worksap.ate.bootcamp.java1000.string.StringExerciseTest;
import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Test for jp.co.worksap.ate.bootcamp.java1000.test");
		//$JUnit-BEGIN$

		suite.addTestSuite(AlgorithmExerciseTest.class);
		suite.addTestSuite(AlgorithmExercise2Test.class);
		suite.addTestSuite(AlgorithmExercise3Test.class);
		suite.addTestSuite(AlgorithmExercise4Test.class);

		suite.addTestSuite(ForLoopTest.class);

		suite.addTestSuite(CollectionsUtilExerciseTest.class);
		suite.addTestSuite(ListExerciseTest.class);
		suite.addTestSuite(MapExerciseTest.class);
		suite.addTestSuite(SetExerciseTest.class);

		suite.addTestSuite(DatabaseExerciseTest.class);

		suite.addTestSuite(EnumExerciseTest.class);

		suite.addTestSuite(ExceptionExerciseTest.class);

		suite.addTestSuite(CloneTest.class);
		suite.addTestSuite(ComparableMonsterTest.class);
		suite.addTestSuite(DivisorIterationTest.class);
		suite.addTestSuite(FirstImplementTest.class);
		suite.addTestSuite(NumberIterationTest.class);
		suite.addTestSuite(PrimeIterationTest.class);
		suite.addTestSuite(SingerSongWriterTest.class);

		suite.addTestSuite(NumberExerciseTest.class);

		suite.addTestSuite(PolymorphismExerciseTest.class);

		suite.addTestSuite(ReaderExerciseTest.class);
		suite.addTestSuite(WriterExerciseTest.class);

		suite.addTestSuite(StringExerciseTest.class);

		System.out.println("【java 1000 本ノック】");

		@SuppressWarnings("rawtypes")
		Enumeration en = suite.tests();
		int testNo = 1;

		while (en.hasMoreElements()) {
			System.out.println(" Test @" + testNo + " : " + ((Test) en.nextElement()).toString());
			testNo++;
		}

		//$JUnit-END$
		return suite;
	}

}

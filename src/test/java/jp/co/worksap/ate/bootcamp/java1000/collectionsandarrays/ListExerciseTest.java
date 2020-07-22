package jp.co.worksap.ate.bootcamp.java1000.collectionsandarrays;

import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

public class ListExerciseTest extends TestCase {

	public void testConvertToString() {
		List<String> testList = Arrays.asList("1","2");
		assertEquals("12", ListExercise.convertToString(testList));
	}

}

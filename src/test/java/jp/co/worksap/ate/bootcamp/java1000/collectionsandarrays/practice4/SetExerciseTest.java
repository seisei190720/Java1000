package jp.co.worksap.ate.bootcamp.java1000.collectionsandarrays.practice4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jp.co.worksap.ate.bootcamp.java1000.collectionsandarrays.practice4.SetExercise;
import junit.framework.TestCase;

public class SetExerciseTest  extends TestCase{

	public void testConvertToSet() {

		Set<String> testTarget = SetExercise.convertToSet("1","2","3");
		assertTrue(testTarget.contains("1"));
		assertTrue(testTarget.contains("2"));
		assertTrue(testTarget.contains("3"));
	}

	public void testIsExist() {
		Set<String> testSet = new HashSet<>(Arrays.asList("1","2","3"));
		assertTrue(SetExercise.isExist(testSet, "1"));
		assertFalse(SetExercise.isExist(testSet, "4"));
	}

	public void testConvertToList() {
		Set<String> testSet = new HashSet<>(Arrays.asList("1","2","3"));
		List<String> testList = SetExercise.convertToList(testSet);
		assertTrue(testList.contains("1"));
		assertTrue(testList.contains("2"));
		assertTrue(testList.contains("3"));
		assertFalse(testList.contains("4"));
	}

	public void testConcatenateList() {
		List<String> lists1 = Arrays.asList("1","2");
		List<String> lists2 = Arrays.asList("3","4");
		Set<String> testSet = SetExercise.concatenateList(lists1, lists2);
		assertTrue(testSet.contains("1"));
		assertTrue(testSet.contains("2"));
		assertTrue(testSet.contains("3"));
		assertTrue(testSet.contains("4"));
	}

}

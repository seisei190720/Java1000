package jp.co.worksap.ate.bootcamp.java1000.collectionsandarrays.practice3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.worksap.ate.bootcamp.java1000.collectionsandarrays.practice3.MapExercise;
import junit.framework.TestCase;

public class MapExerciseTest extends TestCase {

	public void testConvertToMap() {
		Map<String,String> testMap = MapExercise.convertToMap("1","value");
		assertEquals("value",testMap.get("1"));
	}

	public void testGetValue() {
		Map<String,String> testMap = new HashMap<>();
		testMap.put("1", "value");
		assertEquals("value",MapExercise.getValue(testMap, "1"));
	}

	public void testIsExist() {
		Map<String,String> testMap = new HashMap<>();
		testMap.put("1", "value");
		assertTrue(MapExercise.isExist(testMap, "1"));
		assertFalse(MapExercise.isExist(testMap, "2"));
	}

	public void testConvertToList() {
		Map<String,String> testMap = new HashMap<>();
		testMap.put("1", "value");
		List<String> testList = MapExercise.convertToList(testMap);
		assertTrue(testList.contains("value"));
	}

	public void testMergeAdd() {
		Map<String,List<String>> testMap = new HashMap<>();
		List<String> list = new ArrayList<>();
		list.add("value");
		testMap.put("1", list);
		MapExercise.mergeAdd(testMap, "1", "value");
		MapExercise.mergeAdd(testMap, "2", "value2");
		List<String> testList = testMap.get("1");
		assertTrue(testList.size()==2);
		assertEquals(Arrays.asList("value2"),testMap.get("2"));
	}

}

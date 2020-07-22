package jp.co.worksap.ate.bootcamp.java1000.enums;

import junit.framework.TestCase;

public class EnumExerciseTest extends TestCase {

	public void testGetZooEnumByName() {
		assertEquals(AnimalEnum.ELEPHANT, EnumExercise.getAnimalEnumByName(AnimalEnum.ELEPHANT.toString().toLowerCase()));
		assertEquals(AnimalEnum.LION, EnumExercise.getAnimalEnumByName(AnimalEnum.LION.toString()));
		assertEquals(AnimalEnum.GIRAFFE, EnumExercise.getAnimalEnumByName(AnimalEnum.GIRAFFE.toString()));
		assertEquals(null, EnumExercise.getAnimalEnumByName(null));
		assertEquals(null, EnumExercise.getAnimalEnumByName("Hoge"));
	}

	public void testGenerateZooKindName() {
		assertEquals("象",EnumExercise.generateAnimalKindName(AnimalEnum.ELEPHANT));
		assertEquals("ライオン",EnumExercise.generateAnimalKindName(AnimalEnum.LION));
		assertEquals("キリン",EnumExercise.generateAnimalKindName(AnimalEnum.GIRAFFE));
		assertEquals(null, EnumExercise.generateAnimalKindName(null));
	}

	public void testIsElefant() {
		assertTrue(EnumExercise.isElefant(AnimalEnum.ELEPHANT));
		assertFalse(EnumExercise.isElefant(AnimalEnum.LION));
		assertFalse(EnumExercise.isElefant(AnimalEnum.GIRAFFE));
		assertFalse(EnumExercise.isElefant(null));
	}

}

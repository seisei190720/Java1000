package jp.co.worksap.ate.bootcamp.java1000.interfaces.practice7;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jp.co.worksap.ate.bootcamp.java1000.interfaces.practice7.ComparableMonster;
import jp.co.worksap.ate.bootcamp.java1000.interfaces.practice7.Type;
import junit.framework.TestCase;

public class ComparableMonsterTest extends TestCase {
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testMonsterComparisonImplements() {
		ComparableMonster mc = new ComparableMonster("FIRE タイプ", 0, 0, Type.FIRE);
		if (!(mc instanceof Comparable<?>)) {
			fail("MonsterComparison クラスに Comparable インターフェースが実装されていません。");
		}
	}

	public void testWhenExistNull() {
		testMonsterComparisonImplements();
		ComparableMonster monster0 = new ComparableMonster("FIRE タイプ", 0, 0, Type.FIRE);
		ComparableMonster monster1 = new ComparableMonster("GRASS タイプ", 0, 0, Type.GRASS);
		ComparableMonster monster2 = new ComparableMonster("BUG タイプ", 0, 0, Type.BUG);
		ComparableMonster monster3 = new ComparableMonster("BUG タイプ", 0, 0, Type.BUG);
		ComparableMonster monster4 = null;
		ComparableMonster[] monsters = new ComparableMonster[] { monster0, monster1, monster2, monster3, monster4 };

		try {
			for (int i = 0; i < monsters.length; i++) {
				for (int j = i + 1; j < monsters.length; j++) {
					monsters[i].compareTo(monsters[j]);
				}
			}
		} catch (IllegalArgumentException e) {
			// handled null object correctly
		} catch (NullPointerException e) {
			fail("null が含まれる場合は、IllegalArgumentException を投げましょう。");
		}
	}

	public void testType() {
		testMonsterComparisonImplements();

		ComparableMonster fire = new ComparableMonster("FIRE タイプ", 0, 0, Type.FIRE);
		ComparableMonster bug = new ComparableMonster("BUG タイプ", 1, 0, Type.BUG);
		ComparableMonster grass = new ComparableMonster("GRASS タイプ", 2, 0, Type.GRASS);
		ComparableMonster[] array = new ComparableMonster[] { grass, bug, fire };

		Arrays.sort(array);

		if (array[0].equals(grass) && array[1].equals(bug) && array[2].equals(fire)) {
			// succeeded
		} else {
			fail("タイプによる強さの比較がうまくいっていません。");
		}
	}

	public void testAttack() {
		testMonsterComparisonImplements();

		ComparableMonster weekest = new ComparableMonster("attackStat 0", 0, 0, Type.FIRE);
		ComparableMonster marginal = new ComparableMonster("attackStat 1", 1, 0, Type.FIRE);
		ComparableMonster strongest = new ComparableMonster("attackStat 2", 2, 0, Type.FIRE);
		ComparableMonster[] array = new ComparableMonster[] { strongest, marginal, weekest };
		Arrays.sort(array);
		if (array[0] == weekest && array[1] == marginal && array[2] == strongest) {
			// succeeded
		} else {
			fail("attackStat による強さの比較がうまくいっていません。");
		}
	}

	public void testDefence() {
		testMonsterComparisonImplements();

		ComparableMonster weekest = new ComparableMonster("defenceStat -2147483648", 0, Integer.MIN_VALUE, Type.BUG);
		ComparableMonster marginal = new ComparableMonster("defenceStat 0", 0, 0, Type.BUG);
		ComparableMonster strongest = new ComparableMonster("defenceStat 2147483647", 0, Integer.MAX_VALUE, Type.BUG);
		ComparableMonster[] array = new ComparableMonster[] { strongest, marginal, weekest };
		Arrays.sort(array);
		if (array[0] == weekest && array[1] == marginal && array[2] == strongest) {
			// succeeded
		} else {
			fail("defenceStat による強さの比較がうまくいっていません。");
		}
	}

	public void testAttackAndDeffence() {
		testMonsterComparisonImplements();

		// arrange
		ComparableMonster monster0 = new ComparableMonster("(5,0)", 5, 0, Type.BUG);
		ComparableMonster monster1 = new ComparableMonster("(2,6)", 2, 6, Type.BUG);
		ComparableMonster monster2 = new ComparableMonster("(3,5)", 3, 5, Type.BUG);
		ComparableMonster monster3 = new ComparableMonster("(4,4)", 4, 4, Type.BUG);
		ComparableMonster monster4 = new ComparableMonster("(7,1)", 7, 1, Type.BUG);
		ComparableMonster[] monsters = new ComparableMonster[] { monster0, monster1, monster2, monster3, monster4 };

		// act
		Arrays.sort(monsters);

		// assert
		Map<Integer, ComparableMonster> monsterMap = new LinkedHashMap<>();
		int cnt = 0;
		monsterMap.put(cnt++, monster0);
		monsterMap.put(cnt++, monster1);
		monsterMap.put(cnt++, monster2);
		monsterMap.put(cnt++, monster3);
		monsterMap.put(cnt++, monster4);

		int index = 0;
		for (ComparableMonster monster : monsterMap.values()) {
			if (!monsters[index++].equals(monster)) {
				fail("比較がうまくいっていません。");
			}
		}
	}

	public void testWhenExistTie() {
		testMonsterComparisonImplements();

		ComparableMonster monster00 = new ComparableMonster("0", 0, -1, Type.GRASS);
		ComparableMonster monster01 = new ComparableMonster("1", 0, 0, Type.GRASS);
		ComparableMonster monster02 = new ComparableMonster("2", 0, 0, Type.GRASS);
		ComparableMonster monster03 = new ComparableMonster("3", 0, 0, Type.GRASS);
		ComparableMonster monster04 = new ComparableMonster("4", 0, 0, Type.BUG);
		ComparableMonster[] monsters = new ComparableMonster[] { monster04, monster03, monster02, monster01, monster00 };

		Arrays.sort(monsters);

		if (!monsters[0].equals(monster00)) {
			fail("比較がうまくいっていません。");
		}
		if (!monsters[4].equals(monster04)) {
			fail("比較がうまくいっていません。");
		}
		List<ComparableMonster> monsterList = Arrays.asList(monsters);
		if (!monsterList.contains(monster01) || !monsterList.contains(monster02) || !monsterList.contains(monster03)) {
			fail("比較がうまくいっていません。");
		}

	}

	public void testLargeCase() {
		testMonsterComparisonImplements();

		// arrange
		ComparableMonster monster19 = new ComparableMonster("ヒュウ", Integer.MAX_VALUE, Integer.MAX_VALUE, Type.FIRE);
		ComparableMonster monster18 = new ComparableMonster("ヒュウツー", 9999999, 888888, Type.FIRE);
		ComparableMonster monster17 = new ComparableMonster("ヒューディン", 102, 102, Type.BUG);
		ComparableMonster monster16 = new ComparableMonster("ヒュンゲラー", 102, 101, Type.BUG);
		ComparableMonster monster15 = new ComparableMonster("ピカヒュー", 101, 102, Type.BUG);
		ComparableMonster monster14 = new ComparableMonster("ライヒュー", 101, 101, Type.BUG);
		ComparableMonster monster13 = new ComparableMonster("ヒューシィ", 101, 100, Type.BUG);
		ComparableMonster monster12 = new ComparableMonster("ヒュリーザー", 99, 102, Type.BUG);
		ComparableMonster monster11 = new ComparableMonster("ヒュンダー", 100, 100, Type.BUG);
		ComparableMonster monster10 = new ComparableMonster("ヒュイアー", 99, 100, Type.BUG);
		ComparableMonster monster09 = new ComparableMonster("ヒュビゴン", Integer.MAX_VALUE, 1000, Type.GRASS);
		ComparableMonster monster08 = new ComparableMonster("ヒュシギダネ", Integer.MAX_VALUE, 0, Type.GRASS);
		ComparableMonster monster07 = new ComparableMonster("ヒュシギソウ", Integer.MAX_VALUE, Integer.MIN_VALUE, Type.GRASS);
		ComparableMonster monster06 = new ComparableMonster("ヒュシギバナ", 100, 100, Type.GRASS);
		ComparableMonster monster05 = new ComparableMonster("ヒュトカゲ", 100, 99, Type.GRASS);
		ComparableMonster monster04 = new ComparableMonster("ヒュザード", 100, 98, Type.GRASS);
		ComparableMonster monster03 = new ComparableMonster("ヒュザードン", -3, 250, Type.GRASS);
		ComparableMonster monster02 = new ComparableMonster("ヒュニガメ", 0, 0, Type.GRASS);
		ComparableMonster monster01 = new ComparableMonster("ヒュメール", -100, -100, Type.GRASS);
		ComparableMonster monster00 = new ComparableMonster("ヒュメックス", Integer.MIN_VALUE, Integer.MIN_VALUE, Type.GRASS);

		ComparableMonster[] monsters = new ComparableMonster[] { monster09, monster08, monster07, monster06, monster05, monster00, monster01, monster02, monster03, monster04, monster10, monster11,
				monster12, monster13, monster14, monster19, monster18, monster17, monster16, monster15 };

		// act
		Arrays.sort(monsters);

		// assert
		Map<Integer, ComparableMonster> monsterMap = new LinkedHashMap<>();
		int cnt = 0;
		monsterMap.put(cnt++, monster00);
		monsterMap.put(cnt++, monster01);
		monsterMap.put(cnt++, monster02);
		monsterMap.put(cnt++, monster03);
		monsterMap.put(cnt++, monster04);
		monsterMap.put(cnt++, monster05);
		monsterMap.put(cnt++, monster06);
		monsterMap.put(cnt++, monster07);
		monsterMap.put(cnt++, monster08);
		monsterMap.put(cnt++, monster09);
		monsterMap.put(cnt++, monster10);
		monsterMap.put(cnt++, monster11);
		monsterMap.put(cnt++, monster12);
		monsterMap.put(cnt++, monster13);
		monsterMap.put(cnt++, monster14);
		monsterMap.put(cnt++, monster15);
		monsterMap.put(cnt++, monster16);
		monsterMap.put(cnt++, monster17);
		monsterMap.put(cnt++, monster18);
		monsterMap.put(cnt++, monster19);

		int index = 0;
		for (ComparableMonster monster : monsterMap.values()) {
			if (!monsters[index++].equals(monster)) {
				fail("比較がうまくいっていません。");
			}
		}

	}

}

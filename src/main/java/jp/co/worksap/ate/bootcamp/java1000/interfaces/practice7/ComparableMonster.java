package jp.co.worksap.ate.bootcamp.java1000.interfaces.practice7;

/**
 * インターフェースを実装しましょう。
 *
 * 問題。 {@link Comparable<MonsterComparison>} を実装した
 * {@link ComparableMonster} クラスを作ってください。
 *  だたし、以下を満たすような実装にしてくだい。
 * ・FIRE タイプは BUG, GRASS タイプより強く（大きく）、
 *  　BUG タイプは GRASS タイプより強い（大きい）
 * ・同じタイプ同士では、(3*attackStat + 2* defenseStat) が大きい方が強い（大きい）
 * （type は常に null でないと仮定してかまいません）
 *
 * @author ATE
 *
 */
public class ComparableMonster implements Comparable<ComparableMonster> {
	private String name;
	private int attackStat;
	private int defenseStat;
	private Type type;

	public ComparableMonster(String name, int attackStat, int defenseStat, Type type) {
		super();
		this.name = name;
		this.attackStat = attackStat;
		this.defenseStat = defenseStat;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public int getAttackStat() {
		return attackStat;
	}

	public int getDefenseStat() {
		return defenseStat;
	}

	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		return "MonsterComparison [name=" + getName() + "]";
	}

	@Override
	public int compareTo(ComparableMonster enemy) {
		return 0;
	}

}

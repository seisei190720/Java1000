package jp.co.worksap.ate.bootcamp.java1000.polymorphism;

public class OtherThan implements Predicate {

	private final String val;
	public OtherThan(int val) {
		super();
		this.val = String.valueOf(val);
	}

	@Override
	public boolean isSatisfiedBy(int a) {
		String target = String.valueOf(a);
		return target.lastIndexOf(val) != target.length() - 1;
	}

}

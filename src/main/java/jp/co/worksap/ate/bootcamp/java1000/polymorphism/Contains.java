package jp.co.worksap.ate.bootcamp.java1000.polymorphism;

public class Contains implements Predicate {

	private final String val;
	public Contains(int val) {
		super();
		this.val = String.valueOf(val);
	}

	@Override
	public boolean isSatisfiedBy(int a) {
		// TODO
		return false;
	}

}

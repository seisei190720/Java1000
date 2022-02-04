package jp.co.worksap.ate.bootcamp.java1000.collectionsandarrays;

import java.util.ArrayList;
import java.util.List;

import jp.co.worksap.ate.bootcamp.java1000.collectionsandarrays.practice1.Employee;

/**
 * Collectionテスト用のDepartmentクラスだが、
 * 今回は利用しない
 *
 * @version 1.0
 * @author ATE
 */
public class Department {

	private List<Employee> employees = new ArrayList<Employee>();

	private final String departmentName;

	public Department(String departmentName) {
		super();
		this.departmentName = departmentName;
	}

	public void addEmployee(Employee emp) {
		employees.add(emp);
	}

	public String getDepartmentName() {
		return departmentName;
	}
}

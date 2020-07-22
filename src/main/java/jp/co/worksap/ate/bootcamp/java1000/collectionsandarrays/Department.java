package jp.co.worksap.ate.bootcamp.java1000.collectionsandarrays;

import java.util.ArrayList;
import java.util.List;

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

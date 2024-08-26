package org.hypnos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 690. 员工的重要性
 */
public class GetImportance {

	public static class Employee {
		public int id;
		public int importance;
		public List<Integer> subordinates;
	}

	public int getImportance(List<Employee> employees, int id) {
		Map<Integer, Employee> map = new HashMap<>();
		for (Employee employee : employees) {
			map.put(employee.id, employee);
		}
		for (Employee employee : employees) {
			if (employee.id == id) {
				return getImp(map, employee.subordinates) + employee.importance;
			} else if (employee.subordinates != null && !employee.subordinates.isEmpty()) {
				Employee e = findById(map, employee.subordinates, id);
				if (e != null)
					return getImp(map,e.subordinates) + e.importance;
			}
		}
		return -1;
	}

	private Employee findById(Map<Integer, Employee> map, List<Integer> subordinates, int id) {
		if (subordinates == null || subordinates.isEmpty())
			return null;
		for (Integer subordinate : subordinates) {
			Employee employee = map.get(subordinate);
			if (employee.id == id) {
				return employee;
			} else {
				Employee e = findById(map, employee.subordinates, id);
				if (e != null)
					return e;
			}
		}
		return null;
	}

	private int getImp(Map<Integer, Employee> map, List<Integer> subordinates) {
		if (subordinates == null || subordinates.isEmpty())
			return 0;
		int ans = 0;
		for (Integer subordinate : subordinates) {
			Employee employee = map.get(subordinate);
			ans += employee.importance + getImp(map, employee.subordinates);
		}
		return ans;
	}
}

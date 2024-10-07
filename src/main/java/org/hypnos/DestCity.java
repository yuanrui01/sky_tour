package org.hypnos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * c
 */
public class DestCity {

	public String destCity(List<List<String>> paths) {
		Set<String> citys = new HashSet<>();
		for (List<String> path : paths) {
			String s = path.get(0);
			citys.add(s);
		}
		for (List<String> path : paths) {
			if (!citys.contains(path.get(1)))
				return path.get(1);
		}
		return "";
	}
}

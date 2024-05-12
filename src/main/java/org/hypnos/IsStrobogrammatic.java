package org.hypnos;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yuanrui
 */
public class IsStrobogrammatic {

	private static Map<Character, Character> map;
	static {
		map = new HashMap<>();
		map.put('1', '1');
		map.put('2', '5');
		map.put('5', '2');
		map.put('6', '9');
		map.put('8', '8');
		map.put('9', '6');
		map.put('0', '0');
	}
	public boolean isStrobogrammatic(String num) {
		char[] charArray = num.toCharArray();
		int length = charArray.length;
		int middle = charArray.length / 2;
		for (int i = 0; i <= middle; i += 1) {
			Character c = map.get(charArray[i]);
			if (charArray[length - 1 - i] != c)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {

		IsStrobogrammatic isStrobogrammatic = new IsStrobogrammatic();
		System.out.println(isStrobogrammatic.isStrobogrammatic("3"));
	}
}

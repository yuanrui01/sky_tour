package org.contest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: yuanrui
 */
public class Case2024092201 {

	public boolean reportSpam(String[] message, String[] bannedWords) {
		Set<String> bannedSet = new HashSet<>(Arrays.asList(bannedWords));
		int count = 0;
		for (String word : message) {
			if (bannedSet.contains(word)) {
				count++;
				if (count >= 2) {
					return true;
				}
			}
		}
		return false;
	}


	public static void main(String[] args) {
		Case2024092201 case2024092201 = new Case2024092201();

	}
}

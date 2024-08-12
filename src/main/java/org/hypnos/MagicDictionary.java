package org.hypnos;

/**
 * 676. 实现一个魔法字典
 */
class MagicDictionary {

	private String[] dictionary;

	public MagicDictionary() {

	}

	public void buildDict(String[] dictionary) {
		this.dictionary = dictionary;
	}

	public boolean search(String searchWord) {
		char[] arr = searchWord.toCharArray();
		int n  = arr.length;
		for (String s : dictionary) {
			if (s.length() != n)
				continue;
			char[] chars = s.toCharArray();
			int diff = 0;
			for (int i = 0; i < n; ++i) {
				if (arr[i] != chars[i])
					diff++;
			}
			if (diff == 2)
				return true;
		}
		return false;
	}
}
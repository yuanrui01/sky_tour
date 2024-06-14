package org.hypnos;

/**
 * 2266. 统计打字方案数
 */
public class CountTexts {

	static class Node {
		int[] cache;
		int length;
		int loop;

		public Node(int loop) {
			this.cache = new int[MX];
			length = 1;
			this.loop = loop;
		}
	}

	private static final int MX = 100_001;
    private static final int LIMIT = 1_000_000_007;
    // 丐版缓存
	private static final Node THREE_CHAR_CACHE = new Node(3);
	private static final Node FOUR_CHAR_CACHE = new Node(4);

	static {
		THREE_CHAR_CACHE.cache[0] = 1;
		FOUR_CHAR_CACHE.cache[0] = 1;
	}

    public int countTexts(String pressedKeys) {
        long ans = 1L;
        int charTotal = pressedKeys.length();
        int i = 0;
        while (i < charTotal) {
            int processNum = pressedKeys.charAt(i) - '0';
            int count = 1;
            while (i + 1 < charTotal && (pressedKeys.charAt(i + 1) - '0') == processNum) {
                i++;
                count++;
            }
            ans = (ans * (processNum == 7 || processNum == 9 ? dp(count, FOUR_CHAR_CACHE) : dp(count, THREE_CHAR_CACHE))) % LIMIT;
            ++i;
        }
		
        return (int) ans;
    }

	private int dp(int count, Node cache) {
		int[] globalCache = cache.cache;
		int length = cache.length;
		if (length > count + 1)
			return globalCache[count];
		int loop = cache.loop;
		int i = length;
		while (i <= count) {
			int res = 0;
			for (int j = 1; j <= loop; ++j) {
				if (i - j >= 0) {
					res = (res + globalCache[i - j]) % LIMIT;
				}
			}
			globalCache[i] = res;
			++i;
		}
		cache.length = count + 1;
		return globalCache[count];
	}


    public static void main(String[] args) {
        String processKeys = "222222222222222222222222222222222222";
        CountTexts countTexts = new CountTexts();
        System.out.println(countTexts.countTexts(processKeys));
    }
}

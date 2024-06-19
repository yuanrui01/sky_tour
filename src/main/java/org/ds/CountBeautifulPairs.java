package org.ds;

/**
 * 2748. 美丽下标对的数目
 */
public class CountBeautifulPairs {
	public int countBeautifulPairs (int[] nums) {
		int ans = 0;
		int[] hash = new int[10];
		hash[firstN(nums[0])]++;
		for (int i = 1; i < nums.length; ++i) {
			ans += count(hash, nums[i]);
			hash[firstN(nums[i])]++;
		}
		return ans;
	}

	private int count(int[] hash, int num) {
		int count = 0;
		int b = lastN(num);
		for (int i = 1; i < hash.length; ++i) {
			if (hash[i] > 0 && gcd(i, b) == 1)
				count += hash[i];
		}
		return count;
	}

	private int lastN(int num) {
		return num % 10;
	}

	private int firstN(int num) {
		while (num > 0) {
			if (num / 10 == 0)
				return num;
			num /= 10;
		}
		return 0;
	}

	private int gcd(int a, int b) {
		while (b != 0) {
			int t = b;
			b = a % b;
			a = t;
		}
		return a;
	}

	public static void main(String[] args) {

		CountBeautifulPairs countBeautifulPairs = new CountBeautifulPairs();
		countBeautifulPairs.gcd(36, 24);
	}

}

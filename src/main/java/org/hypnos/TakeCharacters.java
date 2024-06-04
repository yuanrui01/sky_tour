package org.hypnos;


/**
 * 2516. 每种字符至少取 K 个
 */
public class TakeCharacters {

    public int takeCharacters(String s, int k) {
        int[] sMode = new int[3];
        char[] arr = s.toCharArray();
        int n = arr.length;
        for (char c : arr) {
            sMode[c - 'a']++;
        }

        for (int i = 0; i < sMode.length; ++i) {
            sMode[i] -= k;
            if (sMode[i] < 0)
                return -1;
        }

        int left = 0;
        int right = 0;
        int ans = -1;
        int[] tMode = new int[3];

        while (right < n) {
            int rIndex = arr[right] - 'a';
            tMode[rIndex]++;
            while (tMode[rIndex] > sMode[rIndex]) {
                tMode[arr[left] - 'a']--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans == -1 ? -1 : (n - ans);
    }

    public static void main(String[] args) {
        String s = "a";
        int k = 2;
        TakeCharacters takeCharacters = new TakeCharacters();
        System.out.println(takeCharacters.takeCharacters(s, k));
    }
}

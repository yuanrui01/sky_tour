package org.slide;


/**
 * 2516. 每种字符至少取 K 个
 */
public class TakeCharacters {


    public int takeCharacters(String s, int k) {
        int[] sm = new int[3];
        int[] tm = new int[3];
        int[] cm = new int[3];
        char[] arr = s.toCharArray();
        for (char c : arr) {
            sm[c - 'a']++;
        }
        for (int i = 0; i < 3; ++i) {
            if (sm[i] < k) {
                return -1;
            }
            tm[i] = sm[i] - k;
        }
        int ans = Integer.MIN_VALUE;
        int n = arr.length;
        int left = 0;
        int right = 0;
        while (right < n) {
            cm[arr[right] - 'a']++;
            while (check(cm, tm)) {
                cm[arr[left] - 'a']--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return arr.length - ans;
    }

    private boolean check(int[] cm, int[] tm) {
        for (int i = 0; i < 3; ++i) {
            if (cm[i] > tm[i])
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TakeCharacters takeCharacters = new TakeCharacters();
        String s = "aabaaaacaabc"; // aabaaaacaabc    aaaacaa bc
        int k = 2;
        System.out.println(takeCharacters.takeCharacters(s,k));
    }
}

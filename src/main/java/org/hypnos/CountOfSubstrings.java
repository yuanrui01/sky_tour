package org.hypnos;


/**
 * 3305. 元音辅音字符串计数 I
 */
public class CountOfSubstrings {

    public int countOfSubstrings(String word, int k) {
        char[] s = word.toCharArray();
        int n = s.length;
        int[][] ch = new int[n+1][6];
        int ac = 0;
        int ec = 0;
        int ic = 0;
        int oc = 0;
        int uc = 0;
        int fc = 0;
        for (int i = 0; i < n; ++i) {
            if (s[i] == 'a') {
                ++ac;
            } else if (s[i] == 'e') {
                ++ec;
            } else if (s[i] == 'i') {
                ++ic;
            } else if (s[i] == 'o') {
                ++oc;
            } else if (s[i] == 'u') {
                ++uc;
            } else {
                ++fc;
            }
            ch[i+1][0] = ac;
            ch[i+1][1] = ec;
            ch[i+1][2] = ic;
            ch[i+1][3] = oc;
            ch[i+1][4] = uc;
            ch[i+1][5] = fc;
        }

        int ans = 0;
        for (int w = k + 5; w <= n; ++w) {
            for (int i = 0; i <= n - w; ++i) {
                if (check(ch, i, i+w, k)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean check(int[][] ch, int left, int right, int k) {
        int[] l = ch[left];
        int[] r = ch[right];
        for (int i = 0; i < 5; ++i) {
            if (r[i]-l[i] == 0) {
                return false;
            }
        }
        return r[5]-l[5] == k;
    }

    public static void main(String[] args) {
        CountOfSubstrings countOfSubstrings = new CountOfSubstrings();
        String word = "eauiuo";
        int k = 0;
        System.out.println(countOfSubstrings.countOfSubstrings(word, k));
    }
}

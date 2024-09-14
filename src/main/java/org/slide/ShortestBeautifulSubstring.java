package org.slide;


/**
 * 2904. 最短且字典序最小的美丽子字符串
 */
public class ShortestBeautifulSubstring {


    public String shortestBeautifulSubstring(String s, int k) {
        int[] ans = new int[]{-1,-1};
        int left = 0;
        int right = 0;
        char[] arr = s.toCharArray();
        int ones = 0;
        int n = arr.length;
        while (right < n) {
            if (arr[right] == '1')
                ones++;
            while (ones > k) {
                if (arr[left] == '1') {
                    ones--;
                }
                left++;
            }
            if (ones == k) {
                while (arr[left] == '0') left++;
                setAns(ans, s, left, right);
            }
            right++;
        }
        if (ans[0] == -1) {
            return "";
        } else {
            return s.substring(ans[0], ans[1] + 1);
        }
    }


    private void setAns(int[] ans, String s, int left, int right) {
        if (ans[0] == -1) {
            ans[0] = left;
            ans[1] = right;
        } else if (ans[1] - ans[0] > right - left || (ans[1] - ans[0] == right - left && s.substring(left, right + 1).compareTo(s.substring(ans[0], ans[1] + 1)) < 0)){
            ans[0] = left;
            ans[1] = right;
        }
    }

    public static void main(String[] args) {
        String s = "1100100101011001001";
        int k = 7;
        ShortestBeautifulSubstring shortestBeautifulSubstring = new ShortestBeautifulSubstring();

        System.out.println(shortestBeautifulSubstring.shortestBeautifulSubstring(s, k));
    }
}

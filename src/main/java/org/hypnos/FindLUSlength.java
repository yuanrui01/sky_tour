package org.hypnos;


/**
 * 522. Longest Uncommon Subsequence II
 */
public class FindLUSlength {

    public int findLUSlength(String[] strs) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < strs.length; ++i) {
            int strLen = strs[i].length();
            if (strLen < ans)
                continue;
            boolean uncommon = true;
            for (int j = 0; j < strs.length; ++j)
                if (i != j && match(strs[j], strs[i]))
                    uncommon = false;
            if (uncommon)
                ans = strLen;
        }
        return ans == Integer.MIN_VALUE ? -1 : ans;
    }

    /**
     * 判断s2是否为s1的子序列
     */
    private boolean match(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        int i = 0;
        int j = 0;
        while (i < s1Len && j < s2Len) {
            char c2 = s2.charAt(j);
            while(i < s1Len && s1.charAt(i) != c2)
                i++;
            if (i == s1Len)
                break;
            ++i;++j;
        }
        return j == s2Len;
    }

    public static void main(String[] args) {
        String[] strs = {"aaaaa","aaaaa","aaa","aaa","aaaaaa"};
        FindLUSlength findLUSlength = new FindLUSlength();
        System.out.println(findLUSlength.findLUSlength(strs));
    }
}

package org.hypnos;


/**
 * 2156. 查找给定哈希值的子串
 */
public class SubStrHash {

    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        long curHashValue = 0;
        int n = s.length();
        char[] sArr = s.toCharArray();
        long pk = 1;
        for (int i = 0; i < k; ++i) {
            curHashValue = (curHashValue + (sArr[n - k + i] & 31) * pk) % modulo;
            pk = pk * power % modulo;
        }
        int ans = curHashValue == hashValue ? n - k : 0;
        for (int i = n - k - 1; i >= 0; --i) {
            curHashValue = (curHashValue * power + (sArr[i] & 31) - ((sArr[i + k] & 31) * pk) % modulo + modulo) % modulo;
            if (curHashValue == hashValue) {
                ans = i;
            }
        }
        return s.substring(ans, ans + k);
    }

    //fjrejytcgflrnnxxsxowqbteycujnr
    public static void main(String[] args) {
        String s = "leetcode";
        int power = 7;
        int modulo = 20;
        int k = 2;
        int hashValue = 0;

        SubStrHash subStrHash = new SubStrHash();
        System.out.println(subStrHash.subStrHash(s, power, modulo, k , hashValue));
    }
}

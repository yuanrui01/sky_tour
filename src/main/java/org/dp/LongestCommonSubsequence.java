package org.dp;

/**
 * 1143. Longest Common Subsequence
 * 
 * Problem: Given two strings text1 and text2, return the length of their longest common subsequence.
 * A subsequence of a string is a new string generated from the original string with some characters
 * deleted (can be none) without changing the relative order of the remaining characters.
 * 
 * Example:
 * Input: text1 = "abcde", text2 = "ace" 
 * Output: 3  
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 */
public class LongestCommonSubsequence {
    
    /**
     * Bottom-up dynamic programming approach.
     * Time Complexity: O(m * n) where m and n are the lengths of the input strings
     * Space Complexity: O(m * n)
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        
        // Create a 2D DP table
        // dp[i][j] represents the length of LCS of text1[0...i-1] and text2[0...j-1]
        int[][] dp = new int[m + 1][n + 1];
        
        // Fill the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If current characters match, add 1 to the LCS of the strings without these characters
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // If characters don't match, take the maximum LCS by either:
                    // 1. Excluding the current character from text1
                    // 2. Excluding the current character from text2
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // The bottom-right cell contains the length of LCS for the entire strings
        return dp[m][n];
    }
    
    /**
     * Space-optimized bottom-up approach.
     * Time Complexity: O(m * n)
     * Space Complexity: O(min(m, n))
     */
    public int longestCommonSubsequenceOptimized(String text1, String text2) {
        // Ensure text1 is the shorter string for space optimization
        if (text1.length() > text2.length()) {
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }
        
        int m = text1.length();
        int n = text2.length();
        
        // We only need two rows of the DP table at any time
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + 1;
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            // Swap rows for next iteration
            int[] temp = prev;
            prev = curr;
            curr = temp;
            
            // Reset current row for next iteration
            for (int j = 0; j <= n; j++) {
                curr[j] = 0;
            }
        }
        
        return prev[n];
    }
    
    /**
     * Recursive approach with memoization (top-down).
     */
    public int longestCommonSubsequenceTopDown(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        Integer[][] memo = new Integer[m + 1][n + 1];
        return lcsHelper(text1, text2, m, n, memo);
    }
    
    private int lcsHelper(String text1, String text2, int i, int j, Integer[][] memo) {
        // Base case: if either string is empty, LCS is 0
        if (i == 0 || j == 0) {
            return 0;
        }
        
        // If we've already computed this subproblem, return the cached result
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        
        // If current characters match, include them in LCS
        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
            memo[i][j] = 1 + lcsHelper(text1, text2, i - 1, j - 1, memo);
        } else {
            // If they don't match, take the maximum by excluding one character
            memo[i][j] = Math.max(
                lcsHelper(text1, text2, i - 1, j, memo),
                lcsHelper(text1, text2, i, j - 1, memo)
            );
        }
        
        return memo[i][j];
    }
    
    /**
     * Print the actual longest common subsequence.
     */
    public String printLCS(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        // Fill the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // Backtrack to find the LCS
        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                lcs.append(text1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        
        // Reverse the result since we built it backwards
        return lcs.reverse().toString();
    }
    
    public static void main(String[] args) {
        LongestCommonSubsequence solution = new LongestCommonSubsequence();
        
        // Test case 1
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println("Text1: " + text1);
        System.out.println("Text2: " + text2);
        System.out.println("Bottom-up approach: " + solution.longestCommonSubsequence(text1, text2));
        System.out.println("Space-optimized approach: " + solution.longestCommonSubsequenceOptimized(text1, text2));
        System.out.println("Top-down approach: " + solution.longestCommonSubsequenceTopDown(text1, text2));
        System.out.println("Longest Common Subsequence: " + solution.printLCS(text1, text2));
        
        // Test case 2
        text1 = "abc";
        text2 = "def";
        System.out.println("\nText1: " + text1);
        System.out.println("Text2: " + text2);
        System.out.println("Bottom-up approach: " + solution.longestCommonSubsequence(text1, text2));
        System.out.println("Space-optimized approach: " + solution.longestCommonSubsequenceOptimized(text1, text2));
        System.out.println("Top-down approach: " + solution.longestCommonSubsequenceTopDown(text1, text2));
        System.out.println("Longest Common Subsequence: " + solution.printLCS(text1, text2));
        
        // Test case 3
        text1 = "AGGTAB";
        text2 = "GXTXAYB";
        System.out.println("\nText1: " + text1);
        System.out.println("Text2: " + text2);
        System.out.println("Bottom-up approach: " + solution.longestCommonSubsequence(text1, text2));
        System.out.println("Space-optimized approach: " + solution.longestCommonSubsequenceOptimized(text1, text2));
        System.out.println("Top-down approach: " + solution.longestCommonSubsequenceTopDown(text1, text2));
        System.out.println("Longest Common Subsequence: " + solution.printLCS(text1, text2));
    }
}
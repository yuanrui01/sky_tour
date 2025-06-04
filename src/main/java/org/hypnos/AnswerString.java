package org.hypnos;


/**
 * 3403. 从盒子中找出字典序最大的字符串 I
 */
public class AnswerString {

    public String answerString(String word, int numFriends) {
        if (numFriends == 1) return word;
        int n = word.length();
        int len = n - numFriends + 1;
        String ans = "";
        for (int i = 0; i < n; ++i) {
            String sub = word.substring(i, Math.min(i + len, n));
            if (sub.compareTo(ans) > 0) {
                ans = sub;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        AnswerString answerString = new AnswerString();
        String word = "gh";
        int numFriends = 1;
        System.out.println(answerString.answerString(word, numFriends));
    }
}

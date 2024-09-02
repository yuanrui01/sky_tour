package org.slide;


/**
 * 2024. 考试的最大困扰度
 */
public class MaxConsecutiveAnswers {



    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] cArr = answerKey.toCharArray();
        int right = 0;
        int tLeft = 0;
        int tCount = 0;
        int fLeft = 0;
        int fCount = 0;
        int ans = 0;
        while (right <=  cArr.length) {
            if (cArr[right] == 'T') {
                tCount++;
            } else {
                fCount++;
            }
            while (tCount > k) {
                if (cArr[tLeft] == 'T') {
                    tCount--;
                }
                tLeft++;
            }
            while (fCount > k) {
                if (cArr[fLeft] == 'F') {
                    fCount--;
                }
                fLeft++;
            }
            ans = Math.max(ans, Math.max(right - tLeft + 1, right - fLeft + 1));
            right++;
        }
        return ans;
    }
}

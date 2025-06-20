package org.hypnos;


/**
 * 3443. K 次修改后的最大曼哈顿距离
 */
public class MaxDistance3443 {

    public int maxDistance(String s, int k) {
        int nN = 0;
        int nS = 0;
        int nE = 0;
        int nW = 0;
        int ans = 0;
        char[] dirs = s.toCharArray();
        for (char dir : dirs) {
            if (dir == 'N') {
                nN++;
            } else if (dir == 'S') {
                nS++;
            } else if (dir == 'E') {
                nE++;
            } else {
                nW++;
            }
            int absV = Math.abs(nN - nS);
            int absH = Math.abs(nE - nW);
            int c = Math.min(nN, nS) + Math.min(nE, nW);
            int ck = Math.min(c, k);
            ans = Math.max(ans, absH + absV + ck*2);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxDistance3443 maxDistance3443 = new MaxDistance3443();
        System.out.println(maxDistance3443.maxDistance("NSWWEW", 3));
    }
}

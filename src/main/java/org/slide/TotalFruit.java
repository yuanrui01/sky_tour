package org.slide;

import java.util.HashMap;
import java.util.Map;


/**
 * 904. 水果成篮
 */
public class TotalFruit {

    public int totalFruit(int[] fruits) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int n = fruits.length;
        while (right < n) {
            map.merge(fruits[right], 1, Integer::sum);
            while (map.size() > 2) {
                Integer lc = map.get(fruits[left]);
                if (lc == 1)
                    map.remove(fruits[left]);
                else
                    map.put(fruits[left], lc - 1);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        TotalFruit totalFruit = new TotalFruit();
        int[] fruits = {1,0,1,4,1,4,1,2,3};
        System.out.println(totalFruit.totalFruit(fruits));
    }
}

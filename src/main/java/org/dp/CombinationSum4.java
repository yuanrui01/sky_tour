package org.dp;

import java.util.Arrays;


/**
 * 377. 组合总和 Ⅳ
 */
public class CombinationSum4 {

    public int combinationSum4(int[] nums, int target) {
        int[] cache = new int[1001];
        Arrays.fill(cache, -1);
        return dfs(nums, cache, target);
    }

    private int dfs(int[] nums, int[] cache, int target) {
        if (target == 0) return 1;
        if (cache[target] != -1) return cache[target];
        int ans = 0;
        for (int num : nums) {
            if (target - num >= 0) {
                ans += dfs(nums, cache, target - num);
            }
        }
        return cache[target] = ans;
    }

    public static void main(String[] args) {
        int[] nums = {10,20,30,40,50,60,70,80,90,100,110,120,130,140,150,160,170,180,190,200,210,220,230,240,250,260,270,280,290,300,310,320,330,340,350,360,370,380,390,400,410,420,430,440,450,460,470,480,490,500,510,520,530,540,550,560,570,580,590,600,610,620,630,640,650,660,670,680,690,700,710,720,730,740,750,760,770,780,790,800,810,820,830,840,850,860,870,880,890,900,910,920,930,940,950,960,970,980,990,111};
        int target = 999;
        CombinationSum4 combinationSum4 = new CombinationSum4();
        System.out.println(combinationSum4.combinationSum4(nums, target));
    }
}

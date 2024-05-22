package org.hypnos;

import java.util.*;


/**
 * 2225. 找出输掉零场或一场比赛的玩家
 */
public class FindWinners {

    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> loseAns = new ArrayList<>();
        List<Integer> winAns = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] match : matches) {
            map.merge(match[0], 0, Integer::sum);
            map.merge(match[1], 1, Integer::sum);
        }

        for (Map.Entry<Integer, Integer> participant : map.entrySet()) {
            Integer value = participant.getValue();
            Integer key = participant.getKey();
            if (value == 0)
                winAns.add(key);
            else if (value == 1)
                loseAns.add(key);
        }
        loseAns.sort(Comparator.comparingInt(i->i));
        winAns.sort(Comparator.comparingInt(i->i));
        ans.add(winAns);
        ans.add(loseAns);
        return ans;
    }
}

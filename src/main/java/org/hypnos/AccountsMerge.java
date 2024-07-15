package org.hypnos;

import java.util.*;


/**
 * 721. 账户合并
 */
public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<Integer>> emailToIdx = new HashMap<>();
        for (int i = 0; i < accounts.size(); ++i)
            for (int j = 0; j < accounts.get(i).size(); ++j)
                emailToIdx.computeIfAbsent(accounts.get(i).get(j), x -> new ArrayList<>()).add(i);
        List<List<String>> result = new ArrayList<>();
        boolean[] vis = new boolean[accounts.size()];
        Set<String> emailSet = new HashSet<>();

        for (int i = 0; i < accounts.size(); ++i) {
            if (vis[i])
                continue;
            emailSet.clear();
            dfs(i, accounts, emailToIdx, vis, emailSet);
            List<String> res = new ArrayList<>(emailSet);
            Collections.sort(res);
            res.add(0, accounts.get(i).get(0));
            result.add(res);
        }
        return result;
    }

    private void dfs(int i, List<List<String>> accounts, Map<String, List<Integer>> emailToIdx, boolean[] vis, Set<String> emailSet) {
        vis[i] = true;
        for (int j = 1; j < accounts.get(i).size(); ++j) {
            String email = accounts.get(i).get(j);
            if (emailSet.contains(email))
                continue;
            emailSet.add(email);
            for (int k : emailToIdx.get(email)) {
                if (!vis[k])
                    dfs(k, accounts, emailToIdx, vis, emailSet);
            }
        }
    }


    public static void main(String[] args) {
        List<List<String>> input = List.of(
                List.of("David","David0@m.co","David1@m.co"),
                List.of("David","David3@m.co","David4@m.co"),
                List.of("David","David4@m.co","David5@m.co"),
                List.of("David","David2@m.co","David3@m.co"),
                List.of("David","David1@m.co","David2@m.co")
        );
        AccountsMerge accountsMerge = new AccountsMerge();

        System.out.println(accountsMerge.accountsMerge(input));
    }
}

package org.hypnos;

import java.util.ArrayList;
import java.util.List;


/**
 * 131. 分割回文串
 */
public class Partition {

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<>(), 0, 0, s);
        return ans;
    }

    private void dfs(List<List<String>> ans, List<String> path, int index, int start, String s) {
        if (s.length()-1 == index) {
            if (isPalindrome(s, start, index)) {
                path.add(s.substring(start, index+1));
                ans.add(new ArrayList<>(path));
                path.remove(path.size()-1);
            }
            return;
        }
        if (isPalindrome(s, start, index)) {
            path.add(s.substring(start, index+1));
            dfs(ans, path, index+1, index+1, s);
            path.remove(path.size()-1);
        }
        dfs(ans, path, index+1, start, s);
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "aab";
        Partition partition = new Partition();
        System.out.println(partition.partition(s));
    }
}

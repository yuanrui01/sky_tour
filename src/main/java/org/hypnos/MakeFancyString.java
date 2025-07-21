package org.hypnos;


/**
 * 1957. 删除字符使字符串变好
 */
public class MakeFancyString {

    public String makeFancyString(String s) {
        StringBuilder ans = new StringBuilder();
        int len = s.length();
        int i = 0;
        while (i < len) {
            char c = s.charAt(i);
            ans.append(c);
            int cnt = 1;
            while (i + 1 < len && s.charAt(i + 1) == c) {
                i++;
                cnt++;
                if (cnt < 3) {
                    ans.append(c);
                }
            }
            i++;
        }
        return ans.toString();
    }


    public static void main(String[] args) {
        String s = "leeetcode";
        MakeFancyString makeFancyString = new MakeFancyString();
        System.out.println(makeFancyString.makeFancyString(s));
    }
}

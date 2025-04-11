//package org.test;
//
//import org.openjdk.jmh.annotations.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//@BenchmarkMode(Mode.AverageTime)
//@OutputTimeUnit(TimeUnit.MILLISECONDS)
//@State(Scope.Thread)
//public class BenchmarkTest {
//
//    private String[] queries;
//    private String[] dictionary;
//
//    @Setup
//    public void setUp() {
//        queries = new String[]{"word","note","ants","wood"};
//        dictionary = new String[]{"wood","joke","moat"};
//    }
//
//    @Benchmark
//    public List<String> testMethod1() {
//        return twoEditWords1(queries, dictionary);
//    }
//
//    @Benchmark
//    public List<String> testMethod2() {
//        return twoEditWords2(queries, dictionary);
//    }
//
//    public List<String> twoEditWords1(String[] queries, String[] dictionary) {
//        ArrayList<String> ans = new ArrayList<>();
//        for (String s : queries) {
//            if (isValid(s, dictionary)) {
//                ans.add(s);
//            }
//        }
//        return ans;
//    }
//
//    private boolean isValid(String s, String[] dictionary) {
//        for (String word : dictionary) {
//            int count = 0;
//            for (int i = 0; i < word.length(); i++) {
//                if (s.charAt(i) != word.charAt(i)) {
//                    count++;
//                    if (count > 2) {
//                        break;
//                    }
//                }
//            }
//            if (count <= 2) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public List<String> twoEditWords2(String[] queries, String[] dictionary) {
//        List<String> list = new ArrayList<>();
//        for (String query : queries) {
//            for (String word : dictionary) {
//                if (query.length() != word.length()) {
//                    continue;
//                }
//                int n = word.length();
//                int diffCount = 0;
//                for (int i = 0; i < n; i++) {
//                    if (query.charAt(i) != word.charAt(i)) {
//                        diffCount++;
//                        if (diffCount == 3) {
//                            break;
//                        }
//                    }
//                }
//                if (diffCount <= 2) {
//                    list.add(query);
//                    break;
//                }
//            }
//        }
//        return list;
//    }
//
//    public static void main(String[] args) throws Exception {
//        org.openjdk.jmh.Main.main(args);
//    }
//
//}
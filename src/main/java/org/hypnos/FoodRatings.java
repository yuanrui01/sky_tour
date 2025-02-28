package org.hypnos;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2353. 设计食物评分系统
 */
public class FoodRatings {

    private static final class Node {
        String food;
        int rating;

        public Node(){}
        public Node(String food, int rating){
            this.food = food;
            this.rating = rating;
        }
    }

    private int n;
    private Map<String, Integer> fr;
    private Map<String, String> fc;
    private Map<String, List<Node>> cr;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.n = foods.length;
        cr = new HashMap<>();
        fc = new HashMap<>();
        fr = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];
            fr.put(food, rating);
            fc.put(food, cuisine);
            cr.computeIfAbsent(cuisine, k -> new ArrayList<>()).add(new Node(food, rating));
        }
        for (Map.Entry<String, List<Node>> entry : cr.entrySet()) {
            List<Node> nodes = entry.getValue();
            nodes.sort((o1, o2) -> {
                if (o1.rating == o2.rating) {
                    return o1.food.compareTo(o2.food);
                }
                return o1.rating - o2.rating;
            });
        }

        System.out.println(1);
    }

    public void changeRating(String food, int newRating) {
        // 二分找到对应的元素
        Integer oldRating = fr.get(food);
        String cuisine = fc.get(food);
        List<Node> nodes = cr.get(cuisine);
        int left = 0;
        int right = nodes.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            Node mNode = nodes.get(mid);
            if (mNode.rating > oldRating) {
                right = mid - 1;
            } else if (mNode.rating < oldRating) {
                left = mid + 1;
            } else {
                int cmp = mNode.food.compareTo(food);
                if (cmp > 0) {
                    right = mid - 1;
                } else if (cmp < 0) {
                    left = mid + 1;
                } else {
                    left = mid;
                    break;
                }
            }
        }
        Node updateNode = nodes.get(left);
        nodes.remove(left);
        updateNode.rating = newRating;

        left = 0;
        right = nodes.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            Node mNode = nodes.get(mid);
            if (mNode.rating > newRating) {
                right = mid - 1;
            } else if (mNode.rating < newRating) {
                left = mid + 1;
            } else {
                int cmp = mNode.food.compareTo(food);
                if (cmp > 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        if (left == nodes.size()) {
            nodes.add(updateNode);
        } else {
            nodes.add(left, updateNode);
        }
        fr.put(food, newRating);
    }

    public String highestRated(String cuisine) {
        List<Node> list = cr.get(cuisine);
        if (list.size() == 1) {
            return list.get(0).food;
        } else {
            int n = list.size();
            int maxRating = list.get(n-1).rating;
            if (list.get(n-2).rating != maxRating) {
                return list.get(n-1).food;
            } else {
                int left = 0;
                int right = n-1;
                int target = maxRating-1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    Node mNode = list.get(mid);
                    if (mNode.rating <= target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                return list.get(left).food;
            }
        }
    }

    public static void main(String[] args) {
        FoodRatings fr = new FoodRatings(
                new String[]{"tjokfmxg","xmiuwozpmj","uqklk","mnij","iwntdyqxi","cduc","cm","mzwfjk"},
                new String[]{"waxlau","ldpiabqb","ldpiabqb","waxlau","ldpiabqb","waxlau","waxlau","waxlau"},
                new int[]{9,13,7,16,10,17,16,17});
        fr.changeRating("tjokfmxg", 19);
        System.out.println(fr.highestRated("waxlau"));
        fr.changeRating("uqklk", 7);
        System.out.println(fr.highestRated("waxlau"));
        System.out.println(fr.highestRated("waxlau"));
        fr.changeRating("tjokfmxg", 14);
        System.out.println(fr.highestRated("waxlau"));
        System.out.println(fr.highestRated("waxlau"));
        fr.changeRating("tjokfmxg", 4);
        System.out.println(fr.highestRated("waxlau"));
        fr.changeRating("mnij", 18);
        System.out.println(fr.highestRated("waxlau"));

    }
}

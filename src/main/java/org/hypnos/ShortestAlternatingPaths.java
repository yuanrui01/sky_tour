package org.hypnos;

import java.util.*;

public class ShortestAlternatingPaths {

    private static final int RED = 0;
    private static final int BLUE = 1;

    class Node {
        int preColor;
        int curColor;
        int v;
        public Node(int preColor, int curColor, int v) {
            this.curColor = curColor;
            this.preColor = preColor;
            this.v = v;
        }
    }

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer>[] rRoad = new List[n];
        List<Integer>[] bRoad = new List[n];
        Arrays.setAll(rRoad, e -> new ArrayList<>());
        Arrays.setAll(bRoad, e -> new ArrayList<>());
        for (int[] redEdge : redEdges) {
            rRoad[redEdge[0]].add(redEdge[1]);
        }
        for (int[] blueEdge : blueEdges) {
            bRoad[blueEdge[0]].add(blueEdge[1]);
        }
        int[] ans = new int[n];
        boolean[] vis = new boolean[n];
        Arrays.fill(ans, -1);

        int depth = 0;
        ans[0] = 0;
        vis[0] = true;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(2, 2, 0));
        while (!q.isEmpty()) {
            Node p = q.poll();
            List<Node> levelList = new ArrayList<>();

            if (p.curColor != RED) {
                for (Integer y : rRoad[p.v]) {
                    if (!vis[y]) {
                        vis[y] = true;
                        Node rNode = new Node(p.curColor, RED, y);
                        q.add(rNode);
                        levelList.add(rNode);
                    }
                }
            }
            if (p.curColor != BLUE) {
                for (Integer y : bRoad[p.v]) {
                    if (!vis[y]) {
                        vis[y] = true;
                        Node bNode = new Node(p.curColor, BLUE, y);
                        q.add(bNode);
                        levelList.add(bNode);
                    }
                }
            }
            depth++;
            for (Node node: levelList)
                ans[node.v] = depth;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] redEdges = {{0,1},{1,2},{2,3},{3,4}};
        int[][] blueEdges = {{1,2},{2,3},{3,1}};

        ShortestAlternatingPaths shortestAlternatingPaths = new ShortestAlternatingPaths();
        int[] ans = shortestAlternatingPaths.shortestAlternatingPaths(n, redEdges, blueEdges);
        System.out.println(Arrays.toString(ans));
    }
}

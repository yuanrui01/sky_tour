package org.grid;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 1926. 迷宫中离入口最近的出口
 */
public class NearestExit {

    private int[][] ds = {{0,1},{1,0},{0,-1},{-1,0}};

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int initX = entrance[0];
        int initY = entrance[1];
        queue.add(new int[] {initX, initY, 0});
        vis[entrance[0]][entrance[1]] = true;
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int i = p[0];
            int j = p[1];
            int z = p[2];
            for (int[] d : ds) {
                int x = i + d[0];
                int y = j + d[1];
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    if (maze[x][y] == '.' && !vis[x][y]) {
                        queue.add(new int[]{x, y, z + 1});
                        vis[x][y] = true;
                    }
                } else if (i != initX || j != initY){
                    return z + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        NearestExit nearestExit = new NearestExit();
        char[][] maze = {{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}};
        int[] entrance = {1,2};
        System.out.println(nearestExit.nearestExit(maze, entrance));
    }
}

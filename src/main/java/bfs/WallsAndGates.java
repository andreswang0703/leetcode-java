package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * No.286 Walls and gates.
 *
 * You are given an m x n grid rooms initialized with these three possible values.
 *
 * -1 A wall or an obstacle.
 * 0 A gate.
 *
 * INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 *
 * Date: 04/21/2021
 *
 */
public class WallsAndGates {

    public void wallsAndGates(int[][] rooms) {
        int empty = 2147483647;
        Queue<int[]> queue = new LinkedList<>();
        int r = rooms.length, c = rooms[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            while (size > 0) {
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];
                for (int[] dir : directions) {
                    int x = row + dir[0];
                    int y = col + dir[1];
                    if (x < 0 || y < 0 || x >= r || y >= c || rooms[x][y] != empty) {
                        continue;
                    }
                    queue.offer(new int[]{x, y});
                    rooms[x][y] = level;
                }
                size--;
            }
        }
    }
}
